/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cadastro;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Caixa;
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
public class CaixaDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public CaixaDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Caixa gravar(Caixa caixa) {
        em.getTransaction().begin();
        caixa = em.merge(caixa);
        em.getTransaction().commit();
        return caixa;
    }

    public Caixa atualizar(Caixa caixa) {
        em.getTransaction().begin();
        caixa = em.merge(caixa);
        em.getTransaction().commit();
        return caixa;
    }

    public void apagar(Caixa caixa) {
        em.getTransaction().begin();
        caixa = em.getReference(Caixa.class, caixa.getCaixaId());
        em.remove(caixa);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Caixa> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Caixa.class,"caixa");
        select.createCriteria("caixa.usuarioRespId","usuario");
        
        Restrictions.eq("caixa.deleted", "f");
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarCaixa(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("caixa.caixaId"));
        p.add(Projections.groupProperty("caixa.caixaDesc"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Caixa.class, "caixa");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Caixa buscarCaixa(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Caixa.class, "caixa");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("caixa.deleted", "f"));

        return (Caixa) criteria.uniqueResult();
    }

    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Caixa.class, "caixa");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.EXACT));
        }
        criteria.add(Restrictions.eq("caixa.deleted", "f"));
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
