/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
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
public class VendaDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public VendaDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Venda gravar(Venda venda) {
        em.getTransaction().begin();
        venda = em.merge(venda);
        em.getTransaction().commit();
        return venda;
    }

    public Venda atualizar(Venda venda) {
        em.getTransaction().begin();
        venda = em.merge(venda);
        em.getTransaction().commit();
        return venda;
    }

    public void apagar(Venda venda) {
        em.getTransaction().begin();
        venda = em.getReference(Venda.class, venda.getVendaId());
        em.remove(venda);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Venda> consultarTodos() {
       Criteria criteria = session.createCriteria(Venda.class, "venda");
        criteria.createCriteria("venda.tipoPagamentoId", "prd");
        return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public Venda consultarCompra(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Venda) criteria.uniqueResult();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Venda.class, "venda");
        
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
