/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Movimento;
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
public class MovimentoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public MovimentoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Movimento gravar(Movimento movimento) {
        em.getTransaction().begin();
        em.persist(movimento);
        em.getTransaction().commit();
        return movimento;
    }

    public Movimento atualizar(Movimento movimento) {
        em.getTransaction().begin();
        movimento = em.merge(movimento);
        em.getTransaction().commit();
        return movimento;
    }

    public void apagar(Movimento movimento) {
        em.getTransaction().begin();
        movimento = em.getReference(Movimento.class, movimento.getMovimentoId());
        em.remove(movimento);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Movimento> consultarTodos() {
        select = session.createCriteria(Movimento.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Movimento> buscarTodos() {
        Criteria criteria = session.createCriteria(Movimento.class, "movimento");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("movimento.moduloId"));
        criteria.setProjection(p);

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarMovimento(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("movimento.movimentoId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Movimento.class, "movimento");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Movimento buscarMovimento(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Movimento.class, "movimento");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.eq(searchField, searchString));
        }

        return (Movimento) criteria.uniqueResult();
    }

    public Movimento buscarMovimentoById(Integer id) {
        Criteria criteria = session.createCriteria(Movimento.class, "movimento");

        criteria.add(Restrictions.eq("movimento.movimentoId", id));

        return (Movimento) criteria.uniqueResult();
    }
}
