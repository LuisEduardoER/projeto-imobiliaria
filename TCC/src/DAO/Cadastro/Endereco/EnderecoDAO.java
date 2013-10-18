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
import modelo.Endereco.Endereco;
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
public class EnderecoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public EnderecoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Endereco gravar(Endereco endereco) {
        em.getTransaction().begin();
        endereco = em.merge(endereco);
        em.getTransaction().commit();
        return endereco;
    }

    public Endereco atualizar(Endereco endereco) {
        em.getTransaction().begin();
        endereco = em.merge(endereco);
        em.getTransaction().commit();
        return endereco;
    }

    public void apagar(Endereco endereco) {
        em.getTransaction().begin();
        endereco = em.getReference(Endereco.class, endereco.getEnderecoID());
        em.remove(endereco);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Endereco> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Endereco.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarEndereco(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("endereco.enderecoId"));

        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Endereco.class, "endereco");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Endereco buscarEndereco(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Endereco.class, "endereco");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("endereco.deleted", "f"));

        return (Endereco) criteria.uniqueResult();
    }
}
