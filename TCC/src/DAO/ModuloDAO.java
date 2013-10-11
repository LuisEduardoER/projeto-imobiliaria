/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.PerfisPermissoes.Modulo;
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
public class ModuloDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public ModuloDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Modulo gravar(Modulo modulo) {
        em.getTransaction().begin();
        modulo = em.merge(modulo);
        em.getTransaction().commit();
        return modulo;
    }

    public Modulo atualizar(Modulo modulo) {
        em.getTransaction().begin();
        modulo = em.merge(modulo);
        em.getTransaction().commit();
        return modulo;
    }

    public void apagar(Modulo modulo) {
        em.getTransaction().begin();
        modulo = em.getReference(Modulo.class, modulo.getModuloId());
        em.remove(modulo);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Modulo> consultarTodos() {
        select = session.createCriteria(Modulo.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Modulo> buscarTodos() {
        Criteria criteria = session.createCriteria(Modulo.class, "modulo");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("modulo.moduloId"));
        p.add(Projections.groupProperty("modulo.moduloDesc"));
        criteria.setProjection(p);
//        criteria.add(Restrictions.or(Restrictions.isNull("usuario.usuarioId"),
//                (Restrictions.eq("usuario.deleted", "f"))));
        criteria.add(Restrictions.eq("modulo.deleted", "f"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarModulo(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("modulo.moduloId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Modulo.class, "modulo");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Modulo buscarModulo(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Modulo.class, "modulo");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.eq(searchField, searchString));
        }
        criteria.add(Restrictions.eq("modulo.deleted", "f"));

        return (Modulo) criteria.uniqueResult();
    }

    public Modulo buscarModuloById(Integer id) {
        Criteria criteria = session.createCriteria(Modulo.class, "modulo");

        criteria.add(Restrictions.eq("modulo.moduloId", id));
        criteria.add(Restrictions.eq("modulo.deleted", "f"));

        return (Modulo) criteria.uniqueResult();
    }

    public Integer checaModuloExiste(Modulo modulo) {
        Criteria criteria = session.createCriteria(Modulo.class, "modulo");

        criteria.add(Restrictions.eq("modulo.moduloDesc", modulo.getModuloDesc()));
        criteria.add(Restrictions.eq("modulo.deleted", "f"));

        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
