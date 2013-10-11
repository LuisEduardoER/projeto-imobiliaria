/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.ModuloPermissao;
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
public class ModuloPermissaoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public ModuloPermissaoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public ModuloPermissao gravar(ModuloPermissao moduloPermissao) {
        em.getTransaction().begin();
        moduloPermissao = em.merge(moduloPermissao);
        em.getTransaction().commit();
        return moduloPermissao;
    }

    public ModuloPermissao atualizar(ModuloPermissao moduloPermissao) {
        em.getTransaction().begin();
        moduloPermissao = em.merge(moduloPermissao);
        em.getTransaction().commit();
        return moduloPermissao;
    }

    public void apagar(ModuloPermissao moduloPermissao) {
        em.getTransaction().begin();
        moduloPermissao = em.getReference(ModuloPermissao.class, moduloPermissao.getModuloPermissaoId());
        em.remove(moduloPermissao);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<ModuloPermissaoDAO> consultarTodos() {
        select = session.createCriteria(ModuloPermissao.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> buscarTodos() {
        Criteria criteria = session.createCriteria(ModuloPermissao.class, "moduloPermissao");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("moduloPermissao.moduloPermissaoId"));
//        p.add(Projections.groupProperty("moduloPermissao.moduloDesc"));
        criteria.setProjection(p);
//        criteria.add(Restrictions.or(Restrictions.isNull("usuario.usuarioId"),
//                (Restrictions.eq("usuario.deleted", "f"))));
        criteria.add(Restrictions.eq("modulo.deleted", "f"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarModuloPermissao(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("moduloPermissao.moduloPermissaoId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(ModuloPermissao.class, "moduloPermissao");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public ModuloPermissao buscarModuloPermissao(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(ModuloPermissao.class, "moduloPermissao");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.eq(searchField, searchString));
        }
        criteria.add(Restrictions.eq("moduloPermissao.deleted", "f"));

        return (ModuloPermissao) criteria.uniqueResult();
    }

    public ModuloPermissao buscarModuloPermissaoById(Integer id) {
        Criteria criteria = session.createCriteria(ModuloPermissao.class, "moduloPermissao");

        criteria.add(Restrictions.eq("moduloPermissao.moduloPermissaoId", id));
        criteria.add(Restrictions.eq("moduloPermissao.deleted", "f"));

        return (ModuloPermissao) criteria.uniqueResult();
    }

    public Integer checaModuloPermissaoExiste(ModuloPermissao moduloPermissao) {
        Criteria criteria = session.createCriteria(ModuloPermissao.class, "moduloPermissao");

        criteria.add(Restrictions.eq("moduloPermissao.moduloPermissaoId", moduloPermissao.getModuloId()));
        criteria.add(Restrictions.eq("moduloPermissao.deleted", "f"));

        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
