/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Fornecedor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author Bruno
 */
public class FornecedorDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public FornecedorDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Fornecedor gravar(Fornecedor fornecedor) {
        em.getTransaction().begin();
        fornecedor = em.merge(fornecedor);
        em.getTransaction().commit();
        return fornecedor;
    }

    public Fornecedor atualizar(Fornecedor fornecedor) {
        em.getTransaction().begin();
        fornecedor = em.merge(fornecedor);
        em.getTransaction().commit();
        return fornecedor;
    }

    public void apagar(Fornecedor fornecedor) {
        em.getTransaction().begin();
        fornecedor = em.getReference(Fornecedor.class, fornecedor.getFornecedorId());
        em.remove(fornecedor);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Fornecedor> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Fornecedor.class);
        return select.list();
    }
    
    @SuppressWarnings("unchecked")
    public Fornecedor consultarFornecedor(String searchField, String searchString) {
//        Session session = (Session) em.getDelegate();
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Fornecedor) criteria.uniqueResult();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Fornecedor.class, "fornecedor");
        
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
