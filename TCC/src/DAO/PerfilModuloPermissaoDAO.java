/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.PerfisPermissoes.PerfilModulopermissao;
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
public class PerfilModuloPermissaoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public PerfilModuloPermissaoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public PerfilModulopermissao gravar(PerfilModulopermissao perfilModulopermissao ){
        em.getTransaction().begin();
        perfilModulopermissao = em.merge(perfilModulopermissao);
        em.getTransaction().commit();
        return perfilModulopermissao;
    }

    public PerfilModulopermissao atualizar(PerfilModulopermissao perfilModulopermissao) {
        em.getTransaction().begin();
        perfilModulopermissao = em.merge(perfilModulopermissao);
        em.getTransaction().commit();
        return perfilModulopermissao;
    }

    public void apagar(PerfilModulopermissao perfilModulopermissao) {
        em.getTransaction().begin();
        perfilModulopermissao = em.getReference(PerfilModulopermissao.class, perfilModulopermissao.getPerfilmoduloPermissaoId());
        em.remove(perfilModulopermissao);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<PerfilModulopermissao> consultarTodos() {
        select = session.createCriteria(PerfilModulopermissao.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> buscarTodos() {
        Criteria criteria = session.createCriteria(PerfilModulopermissao.class, "perfilModulopermissao");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("PerfilModulopermissao.PerfilModulopermissaoId"));
        p.add(Projections.groupProperty("PerfilModulopermissao.permissaoDesc"));
        criteria.setProjection(p);
//        criteria.add(Restrictions.or(Restrictions.isNull("usuario.usuarioId"),
//                (Restrictions.eq("usuario.deleted", "f"))));
        criteria.add(Restrictions.eq("perfilModulopermissao.deleted", "f"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarPerfilModulopermissao(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("perfilModulopermissao.perfilModulopermissaoId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(PerfilModulopermissao.class, "perfilModulopermissao");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public PerfilModulopermissao buscarPerfilModulopermissao(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(PerfilModulopermissao.class, "perfilModulopermissao");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.eq(searchField, searchString));
        }
        criteria.add(Restrictions.eq("perfilModulopermissao.deleted", "f"));

        return (PerfilModulopermissao) criteria.uniqueResult();
    }

    public PerfilModulopermissao buscarPerfilModulopermissaoById(Integer id) {
        Criteria criteria = session.createCriteria(PerfilModulopermissao.class, "perfilModulopermissao");

        criteria.add(Restrictions.eq("perfilModulopermissao.perfilModulopermissaoId", id));
        criteria.add(Restrictions.eq("perfilModulopermissao.deleted", "f"));

        return (PerfilModulopermissao) criteria.uniqueResult();
    }

    public Integer checaPerfilModulopermissaoExiste(PerfilModulopermissao perfilModulopermissao) {
        Criteria criteria = session.createCriteria(PerfilModulopermissao.class, "perfilModulopermissao");

        criteria.add(Restrictions.eq("perfilModulopermissao.perfilModulopermissaoId", perfilModulopermissao.getPerfilmoduloPermissaoId()));
        criteria.add(Restrictions.eq("perfilModulopermissao.deleted", "f"));

        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
