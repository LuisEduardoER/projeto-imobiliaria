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
import modelo.Funcionario;
import modelo.Usuario;
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
public class UsuarioDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria criteria;
    Session session;

    public UsuarioDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Usuario gravar(Usuario usuario) {
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    public Usuario atualizar(Usuario usuario) {
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    public void apagar(Usuario usuario) {
        em.getTransaction().begin();
        usuario = em.getReference(Usuario.class, usuario.getUsuarioId());
        em.remove(usuario);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> consultarTodos() {
        criteria = session.createCriteria(Usuario.class, "usuario");
        criteria.add(Restrictions.eq("usuario.deleted", "f"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarUsuario(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("usuario.usuarioId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Usuario.class, "usuario");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Usuario buscarUsuario(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Usuario.class, "usuario");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("usuario.deleted", "f"));

        return (Usuario) criteria.uniqueResult();
    }
    
    public Usuario loadUsuarioByLogin(Usuario usuario) {
        Criteria criteria = session.createCriteria(Usuario.class, "usuario");

        criteria.add(Restrictions.eq("usuario.usuarioSenha", usuario.getUsuarioSenha()));
        criteria.add(Restrictions.eq("usuario.usuarioName", usuario.getUsuarioName()));
        
        criteria.add(Restrictions.eq("usuario.ativo", "t"));
        criteria.add(Restrictions.eq("usuario.deleted", "f"));

        return (Usuario) criteria.uniqueResult();
    }
    
    public Usuario loadUsuarioById(Usuario usuario) {
        Criteria criteria = session.createCriteria(Usuario.class, "usuario");

        criteria.add(Restrictions.eq("usuario.usuarioId", usuario.getUsuarioId()));
        criteria.add(Restrictions.eq("usuario.deleted", "f"));

        return (Usuario) criteria.uniqueResult();
    }
    
    public Integer checaUsuarioExiste(Usuario usuario) {
        Criteria criteria = session.createCriteria(Usuario.class, "usuario");

        criteria.add(Restrictions.eq("usuario.usuarioName", usuario.getUsuarioName()));
        criteria.add(Restrictions.eq("usuario.deleted", "f"));
        
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
