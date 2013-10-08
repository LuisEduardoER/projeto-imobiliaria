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
import modelo.Pais;
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
public class PaisDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public PaisDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Pais gravar(Pais pais) {
        em.getTransaction().begin();
        pais = em.merge(pais);
        em.getTransaction().commit();
        return pais;
    }

    public Pais atualizar(Pais pais) {
        em.getTransaction().begin();
        pais = em.merge(pais);
        em.getTransaction().commit();
        return pais;
    }

    public void apagar(Pais pais) {
        em.getTransaction().begin();
        pais = em.getReference(Pais.class, pais.getPaisID());
        em.remove(pais);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Pais> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Pais.class);
        return select.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Object[]> consultarPais(String searchField, String searchString) {
       Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();
        
        p.add(Projections.groupProperty("pais.paisId"));
        p.add(Projections.groupProperty("pais.paisNome"));
        p.add(Projections.groupProperty("pais.paisCod"));
        criteria.setProjection(p);
        
        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Pais.class, "pais");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        
        return criteria;
    }  
    
    public Pais buscarPais(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Pais.class, "pais");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
            criteria.add(Restrictions.eq("pais.deleted", "f"));
        
        return (Pais) criteria.uniqueResult();
    }    
    
    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
