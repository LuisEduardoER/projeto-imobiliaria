/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Titulopagar;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class TituloPagarDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public TituloPagarDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Titulopagar gravar(Titulopagar tituloPagar) {
        em.getTransaction().begin();
        tituloPagar = em.merge(tituloPagar);
        em.getTransaction().commit();
        return tituloPagar;
    }

    public Titulopagar atualizar(Titulopagar tituloPagar) {
        em.getTransaction().begin();
        tituloPagar = em.merge(tituloPagar);
        em.getTransaction().commit();
        return tituloPagar;
    }

    public void apagar(Titulopagar tituloPagar) {
        em.getTransaction().begin();
        tituloPagar = em.getReference(Titulopagar.class, tituloPagar.getCompraId());
        em.remove(tituloPagar);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Titulopagar> consultarTodos() {
       Criteria criteria = session.createCriteria(Titulopagar.class, "compra");
        criteria.createCriteria("compra.fornecedorId", "frn");
        criteria.createCriteria("compra.produtoId", "prd");
        return select.list();
    }
    
    @SuppressWarnings("unchecked")
    public Titulopagar consultarTituloPagar(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Titulopagar) criteria.uniqueResult();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Titulopagar.class, "tituloPagar");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.EXACT));
        }
            criteria.add(Restrictions.eq("tituloPagar.deleted", "f"));
        
        return criteria;
    }    
    
    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
