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
import modelo.Endereco.Cep;
import modelo.Endereco.Estado;
import modelo.Endereco.Pais;
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
public class EstadoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public EstadoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Estado gravar(Estado estado) {
        em.getTransaction().begin();
        estado = em.merge(estado);
        em.getTransaction().commit();
        return estado;
    }

    public Estado atualizar(Estado estado) {
        em.getTransaction().begin();
        estado = em.merge(estado);
        em.getTransaction().commit();
        return estado;
    }

    public void apagar(Estado estado) {
        em.getTransaction().begin();
        estado = em.getReference(Estado.class, estado.getEstadoId());
        em.remove(estado);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Estado> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Estado.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarEstado(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("estado.estadoId"));
        p.add(Projections.groupProperty("estado.estadoNome"));
        p.add(Projections.groupProperty("estado.estadoUF"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Estado.class, "estado");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public List<Estado> buscarEstadoByPais(Integer paisId) {
        Criteria criteria = session.createCriteria(Estado.class, "estado");
        criteria.createCriteria("estado.paisId", "pais");

        criteria.add(Restrictions.eq("pais.paisID", paisId));
        criteria.add(Restrictions.eq("pais.deleted", "f"));
        criteria.add(Restrictions.eq("estado.deleted", "f"));

        return criteria.list();
    }

    public Estado buscarEstadoById(Integer estadoId) {
        Criteria criteria = session.createCriteria(Estado.class, "estado");

        if (estadoId != null) {
            criteria.add(Restrictions.eq("estado.estadoId", estadoId));
        }
        criteria.add(Restrictions.eq("estado.deleted", "f"));

        return (Estado) criteria.uniqueResult();
    }

    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Estado.class, "estado");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.EXACT));
        }
        criteria.add(Restrictions.eq("estado.deleted", "f"));
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
