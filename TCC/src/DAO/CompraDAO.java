/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Compra;
import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class CompraDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public CompraDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Compra gravar(Compra compra) {
        em.getTransaction().begin();
        compra = em.merge(compra);
        em.getTransaction().commit();
        return compra;
    }

    public Compra atualizar(Compra compra) {
        em.getTransaction().begin();
        compra = em.merge(compra);
        em.getTransaction().commit();
        return compra;
    }

    public void apagar(Compra compra) {
        em.getTransaction().begin();
        compra = em.getReference(Compra.class, compra.getCompraId());
        em.remove(compra);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Compra> consultarTodos() {
       Criteria criteria = session.createCriteria(Compra.class, "compra");
        criteria.createCriteria("compra.fornecedorId", "frn");
        criteria.createCriteria("compra.produtoId", "prd");
        return select.list();
    }
    
    @SuppressWarnings("unchecked")
    public Compra consultarCompra(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Compra) criteria.uniqueResult();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Compra.class, "compra");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        
        return criteria;
    }    
    
    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
