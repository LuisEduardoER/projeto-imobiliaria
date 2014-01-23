/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cadastro.Administrativo;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Cadastro.Adminsitrativo.Grupoproduto;
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
public class GrupoProdutoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public GrupoProdutoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Grupoproduto gravar(Grupoproduto grupoProduto) {
        em.getTransaction().begin();
        grupoProduto = em.merge(grupoProduto);
        em.getTransaction().commit();
        return grupoProduto;
    }

    public Grupoproduto atualizar(Grupoproduto grupoProduto) {
        em.getTransaction().begin();
        grupoProduto = em.merge(grupoProduto);
        em.getTransaction().commit();
        return grupoProduto;
    }

    public void apagar(Grupoproduto grupoProduto) {
        em.getTransaction().begin();
        grupoProduto = em.getReference(Grupoproduto.class, grupoProduto.getGrupoProdutoId());
        em.remove(grupoProduto);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Grupoproduto> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Grupoproduto.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarGrupoproduto(String searchField, String searchString) {
//        Session session = (Session) em.getDelegate();
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("grupoProtudo.grupoProdutoId"));
        p.add(Projections.groupProperty("grupoProtudo.grupoDescricao"));
        p.add(Projections.groupProperty("grupoProtudo.grupoIsSugereValor"));
        p.add(Projections.groupProperty("grupoProtudo.grupoValor"));
        p.add(Projections.groupProperty("grupoProtudo.inserted"));
        p.add(Projections.groupProperty("grupoProtudo.updated"));
        p.add(Projections.groupProperty("grupoProtudo.deleted"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Grupoproduto.class, "grupoProtudo");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.like(searchField, searchString, MatchMode.ANYWHERE));
            criteria.add(Restrictions.eq("grupoProtudo.deleted", "f"));
        }

        return criteria;
    }

    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
