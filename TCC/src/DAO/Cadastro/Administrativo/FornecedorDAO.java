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
import modelo.Cadastro.Adminsitrativo.Fornecedor;
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
    public List<Object[]> consultarFornecedor(String searchField, String searchString) {
       Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();
        
        p.add(Projections.groupProperty("fornecedor.fornecedorId"));
        p.add(Projections.groupProperty("fornecedor.fornecedorNome"));
        p.add(Projections.groupProperty("fornecedor.fornecedorCNPJ"));
        p.add(Projections.groupProperty("fornecedor.inserted"));
        p.add(Projections.groupProperty("fornecedor.updated"));
        p.add(Projections.groupProperty("fornecedor.deleted"));
        criteria.setProjection(p);
        
        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Fornecedor.class, "fornecedor");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        
        return criteria;
    }  
    
    public Fornecedor buscarFornecedor(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Fornecedor.class, "fornecedor");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
            criteria.add(Restrictions.eq("fornecedor.deleted", "f"));
        
        return (Fornecedor) criteria.uniqueResult();
    }    
    
    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
