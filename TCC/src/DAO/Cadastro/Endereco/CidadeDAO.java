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
import modelo.Endereco.Cidade;
import modelo.Endereco.Estado;
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
public class CidadeDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public CidadeDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Cidade gravar(Cidade cidade) {
        em.getTransaction().begin();
        cidade = em.merge(cidade);
        em.getTransaction().commit();
        return cidade;
    }

    public Cidade atualizar(Cidade estado) {
        em.getTransaction().begin();
        estado = em.merge(estado);
        em.getTransaction().commit();
        return estado;
    }

    public void apagar(Cidade estado) {
        em.getTransaction().begin();
        estado = em.getReference(Cidade.class, estado.getEstadoId());
        em.remove(estado);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Cidade> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Cidade.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarCidade(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("cidade.cidade"));
        p.add(Projections.groupProperty("cidade.cidadeNome"));
        
        criteria.setProjection(p);

        return criteria.list();
    }

    public List<Cidade> buscarCidadeByEstado(Integer estadoId) {
        Criteria criteria = session.createCriteria(Cidade.class, "cidade");
        criteria.createCriteria("cidade.estadoId", "estado");

        criteria.add(Restrictions.eq("estado.estadoId", estadoId));
        criteria.add(Restrictions.eq("estado.deleted", "f"));
        criteria.add(Restrictions.eq("cidade.deleted", "f"));

        return criteria.list();
    }
    
    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Cidade.class, "cidade");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Cidade buscarCidade(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Cidade.class, "cidade");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("cidade.deleted", "f"));

        return (Cidade) criteria.uniqueResult();
    }

    public Integer checaCidadeExiste(Cidade cidade) {
        Criteria criteria = session.createCriteria(Cidade.class, "cidade");
        criteria.createCriteria("cidade.estadoId", "estado");

        criteria.add(Restrictions.eq("cidade.cidadeNome", cidade.getCidadeNome()));
        criteria.add(Restrictions.eq("estado.estadoId",   cidade.getEstadoId().getEstadoId()));
        criteria.add(Restrictions.eq("cidade.deleted", "f"));
        
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
