/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cadastro.Endereco;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Cep;
import modelo.Pais;
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
public class CepDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public CepDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Cep gravar(Cep cep) {
        em.getTransaction().begin();
        cep = em.merge(cep);
        em.getTransaction().commit();
        return cep;
    }

    public Cep atualizar(Cep cep) {
        em.getTransaction().begin();
        cep = em.merge(cep);
        em.getTransaction().commit();
        return cep;
    }

    public void apagar(Cep cep) {
        em.getTransaction().begin();
        cep = em.getReference(Cep.class, cep.getCepID());
        em.remove(cep);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Cep> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Cep.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarCep(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("cep.cepId"));
        p.add(Projections.groupProperty("cep.cep"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Cep.class, "cep");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Cep buscarCep(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Cep.class, "cep");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("cep.deleted", "f"));

        return (Cep) criteria.uniqueResult();
    }

    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Cep.class, "cep");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.EXACT));
        }
        criteria.add(Restrictions.eq("cep.deleted", "f"));
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
    
    public Integer checaCepExiste(Cep cep) {
        Criteria criteria = session.createCriteria(Cep.class, "cep");
        criteria.createCriteria("cep.ruaID", "rua");

        criteria.add(Restrictions.eq("cep.cep", cep.getCep()));
        criteria.add(Restrictions.eq("rua.ruaId",   cep.getRuaID().getRuaId()));
        criteria.add(Restrictions.eq("cep.deleted", "f"));
        
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
    
}
