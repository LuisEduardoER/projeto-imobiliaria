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
import modelo.Endereco.Bairro;
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
public class BairroDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public BairroDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Bairro gravar(Bairro bairro) {
        em.getTransaction().begin();
        bairro = em.merge(bairro);
        em.getTransaction().commit();
        return bairro;
    }

    public Bairro atualizar(Bairro bairro) {
        em.getTransaction().begin();
        bairro = em.merge(bairro);
        em.getTransaction().commit();
        return bairro;
    }

    public void apagar(Bairro bairro) {
        em.getTransaction().begin();
        bairro = em.getReference(Bairro.class, bairro.getCidadeId());
        em.remove(bairro);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Bairro> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Bairro.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarBairro(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("bairro.bairroId"));
        p.add(Projections.groupProperty("bairro.bairroNome"));
        
        criteria.setProjection(p);

        return criteria.list();
    }

    public List<Bairro> buscarCidadeByEstado(Integer cidadeId) {
        Criteria criteria = session.createCriteria(Bairro.class, "bairro");
        criteria.createCriteria("bairro.cidadeId", "cidade");

        criteria.add(Restrictions.eq("cidade.cidade", cidadeId));
        criteria.add(Restrictions.eq("cidade.deleted", "f"));
        criteria.add(Restrictions.eq("bairro.deleted", "f"));

        return criteria.list();
    }
    
    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Bairro.class, "bairro");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Bairro buscarBairro(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Bairro.class, "bairro");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("bairro.deleted", "f"));

        return (Bairro) criteria.uniqueResult();
    }

    public Integer checaBairroExiste(Bairro bairro) {
        Criteria criteria = session.createCriteria(Bairro.class, "bairro");
        criteria.createCriteria("bairro.cidadeId", "cidade");

        criteria.add(Restrictions.eq("bairro.bairroNome", bairro.getBairroNome()));
        criteria.add(Restrictions.eq("cidade.cidade",   bairro.getCidadeId().getCidade()));
        criteria.add(Restrictions.eq("bairro.deleted", "f"));
        
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
