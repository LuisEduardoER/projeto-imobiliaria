/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Itemvenda;
import modelo.Venda;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class ItemVendaDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public ItemVendaDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Itemvenda gravar(Itemvenda itemVenda) {
        em.getTransaction().begin();
        itemVenda = em.merge(itemVenda);
        em.getTransaction().commit();
        return itemVenda;
    }

    public Itemvenda atualizar(Itemvenda itemVenda) {
        em.getTransaction().begin();
        itemVenda = em.merge(itemVenda);
        em.getTransaction().commit();
        return itemVenda;
    }

    public void apagar(Itemvenda itemVenda) {
        em.getTransaction().begin();
        itemVenda = em.getReference(Itemvenda.class, itemVenda.getItemVendaId());
        em.remove(itemVenda);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Itemvenda> consultarTodos() {
       Criteria criteria = session.createCriteria(Itemvenda.class, "venda");
        criteria.createCriteria("venda.vendaId", "venda");
        return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public Itemvenda consultarItemVenda(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Itemvenda) criteria.uniqueResult();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Itemvenda.class, "itemVenda");
        
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
