/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Fabricante;
import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class FabricanteDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public FabricanteDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Fabricante gravar(Fabricante fabricante) {
        em.getTransaction().begin();
        fabricante = em.merge(fabricante);
        em.getTransaction().commit();
        return fabricante;
    }

    public Fabricante atualizar(Fabricante fabricante) {
        em.getTransaction().begin();
        fabricante = em.merge(fabricante);
        em.getTransaction().commit();
        return fabricante;
    }

    public void apagar(Fabricante fabricante) {
        em.getTransaction().begin();
        fabricante = em.getReference(Fabricante.class, fabricante.getFabricanteId());
        em.remove(fabricante);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Fabricante> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Fabricante.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarFabricante(String searchField, String searchString) {
//        Session session = (Session) em.getDelegate();
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();
        
        p.add(Projections.groupProperty("fabricante.fabricanteId"));
        p.add(Projections.groupProperty("fabricante.fabricanteNome"));
        p.add(Projections.groupProperty("fabricante.fabricanteCNPJ"));
        p.add(Projections.groupProperty("fabricante.inserted"));
        p.add(Projections.groupProperty("fabricante.updated"));
        p.add(Projections.groupProperty("fabricante.deleted"));
        criteria.setProjection(p);
        
        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Fabricante.class, "fabricante");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            if (searchField.toLowerCase().contains("cnpj")) {
                criteria.add(Restrictions.eq("fabricante."+searchField, searchString));
            } else {
                criteria.add(Restrictions.like(searchField, searchString, MatchMode.ANYWHERE));
            }
            criteria.add(Restrictions.eq("fabricante.deleted", "f"));
        }

        return criteria;
    }

    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
