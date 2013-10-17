/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.PerfisPermissoes.Perfil;
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
public class PerfilDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public PerfilDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Perfil gravar(Perfil perfil) {
        em.getTransaction().begin();
        perfil = em.merge(perfil);
        em.getTransaction().commit();
        return perfil;
    }

    public Perfil atualizar(Perfil perfil) {
        em.getTransaction().begin();
        perfil = em.merge(perfil);
        em.getTransaction().commit();
        return perfil;
    }

    public void apagar(Perfil perfil) {
        em.getTransaction().begin();
        perfil = em.getReference(Perfil.class, perfil.getPerfilID());
        em.remove(perfil);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Perfil> consultarTodos() {
        select = session.createCriteria(Perfil.class);
        select.add(Restrictions.eq("perfil.deleted", "f"));
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Perfil> buscarTodos() {
        Criteria criteria = session.createCriteria(Perfil.class, "perfil");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("perfil.perfilId"));
        p.add(Projections.groupProperty("perfil.perfilDesc"));
        criteria.setProjection(p);
//        criteria.add(Restrictions.or(Restrictions.isNull("usuario.usuarioId"),
//                (Restrictions.eq("usuario.deleted", "f"))));
        criteria.add(Restrictions.eq("perfil.deleted", "f"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarPerfil(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("perfil.perfilId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Perfil.class, "perfil");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Perfil buscarPerfil(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Perfil.class, "perfil");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.eq(searchField, searchString));
        }
        criteria.add(Restrictions.eq("perfil.deleted", "f"));

        return (Perfil) criteria.uniqueResult();
    }

    public Perfil buscarPerfilById(Integer id) {
        Criteria criteria = session.createCriteria(Perfil.class, "perfil");

        criteria.add(Restrictions.eq("perfil.perfilId", id));
        criteria.add(Restrictions.eq("perfil.deleted", "f"));

        return (Perfil) criteria.uniqueResult();
    }

    public Integer checaPerfilExiste(Perfil perfil) {
        Criteria criteria = session.createCriteria(Perfil.class, "perfil");

        criteria.add(Restrictions.eq("perfil.perfilDesc", perfil.getPerfilDesc()));
        criteria.add(Restrictions.eq("perfil.deleted", "f"));

        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
