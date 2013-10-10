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
public class FuncionarioDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public FuncionarioDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Funcionario gravar(Funcionario funcionario) {
        em.getTransaction().begin();
        funcionario = em.merge(funcionario);
        em.getTransaction().commit();
        return funcionario;
    }

    public Funcionario atualizar(Funcionario funcionario) {
        em.getTransaction().begin();
        funcionario = em.merge(funcionario);
        em.getTransaction().commit();
        return funcionario;
    }

    public void apagar(Funcionario funcionario) {
        em.getTransaction().begin();
        funcionario = em.getReference(Funcionario.class, funcionario.getIdFuncionario());
        em.remove(funcionario);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Funcionario> consultarTodos() {
        select = session.createCriteria(Funcionario.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> buscarTodos() {
        Criteria criteria = session.createCriteria(Funcionario.class, "funcionario");
        criteria.createCriteria("funcionario.idUsuario", "usuario", Criteria.LEFT_JOIN);
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("funcionario.idFuncionario"));
        p.add(Projections.groupProperty("funcionario.nome"));
        p.add(Projections.groupProperty("funcionario.cpfCnpj"));
        p.add(Projections.groupProperty("usuario.usuarioName"));
        criteria.setProjection(p);
        criteria.add(Restrictions.or(Restrictions.isNull("usuario.usuarioId"),
                                    (Restrictions.eq("usuario.deleted", "f"))));
        criteria.add(Restrictions.eq("funcionario.deleted", "f"));
        
        return  criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Object[]> consultarFuncionario(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("funcionario.idFuncionario"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Funcionario.class, "funcionario");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Funcionario buscarFuncionario(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Funcionario.class, "funcionario");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("funcionario.deleted", "f"));

        return (Funcionario) criteria.uniqueResult();
    }
    
    public Integer checaFuncionarioExiste(Funcionario funcionario) {
        Criteria criteria = session.createCriteria(Funcionario.class, "funcionario");

        criteria.add(Restrictions.eq("funcionario.cpfCnpj", funcionario.getCpfCnpj()));
        criteria.add(Restrictions.eq("funcionario.deleted", "f"));
        
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
    
}
