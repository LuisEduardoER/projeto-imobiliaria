/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Permissao;
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
public class PermissaoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public PermissaoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Permissao gravar(Permissao permissao ){
        em.getTransaction().begin();
        permissao = em.merge(permissao);
        em.getTransaction().commit();
        return permissao;
    }

    public Permissao atualizar(Permissao permissao) {
        em.getTransaction().begin();
        permissao = em.merge(permissao);
        em.getTransaction().commit();
        return permissao;
    }

    public void apagar(Permissao permissao) {
        em.getTransaction().begin();
        permissao = em.getReference(Permissao.class, permissao.getPermissaoId());
        em.remove(permissao);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Permissao> consultarTodos() {
        select = session.createCriteria(Permissao.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> buscarTodos() {
        Criteria criteria = session.createCriteria(Permissao.class, "permissao");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("Permissao.permissaoId"));
        p.add(Projections.groupProperty("Permissao.permissaoDesc"));
        criteria.setProjection(p);
//        criteria.add(Restrictions.or(Restrictions.isNull("usuario.usuarioId"),
//                (Restrictions.eq("usuario.deleted", "f"))));
        criteria.add(Restrictions.eq("Permissao.deleted", "f"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarPermissao(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("Permissao.permissaoId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Permissao.class, "permissao");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Permissao buscarPermissao(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Permissao.class, "permissao");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.eq(searchField, searchString));
        }
        criteria.add(Restrictions.eq("permissao.deleted", "f"));

        return (Permissao) criteria.uniqueResult();
    }

    public Permissao buscarPermissaoById(Integer id) {
        Criteria criteria = session.createCriteria(Permissao.class, "permissao");

        criteria.add(Restrictions.eq("permissao.permissaoId", id));
        criteria.add(Restrictions.eq("permissao.deleted", "f"));

        return (Permissao) criteria.uniqueResult();
    }

    public Integer checaPermissaoExiste(Permissao permissao) {
        Criteria criteria = session.createCriteria(Permissao.class, "permissao");

        criteria.add(Restrictions.eq("permissao.permissaoId", permissao.getPermissaoId()));
        criteria.add(Restrictions.eq("permissao.deleted", "f"));

        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
