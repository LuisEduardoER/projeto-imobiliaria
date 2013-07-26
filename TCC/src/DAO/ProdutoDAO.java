/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.EntityManagerFactoryCreator;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Produto;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class ProdutoDAO implements Serializable{
     
    static Mensagens m;

    public ProdutoDAO(EntityManagerFactory emf) {
        this.emf = EntityManagerFactoryCreator.getEMF();
    }
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static boolean create(Produto produto) {
     EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao gravar Funcionario! \n ERRO: | FabricanteDAO | gravar() | " + e);
            return false;
        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
                return false;
            }
        }
    }

    public static void edit(Produto produto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produto = em.merge(produto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produto.getProdutoId();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("O produto " + id + " não existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto produto;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getProdutoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("O produto " + id + " não existe.", enfe);
            }
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static Produto findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }
    
    public static List<Produto> buscaByField(String field, String value){
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
            Root<Produto> p = cq.from(Produto.class);
            cq.where(cb.equal(p.get(field), cb.parameter(String.class, field)));

            TypedQuery<Produto> query = em.createQuery(cq);
            query.setParameter(field, value);
            return query.getResultList();
            
        } finally {
            em.close();  
        }
    }
    
    /**
     * 
     * @param all         - Buscar todos (true para todos)
     * @param maxResults  - maior numero de resultados (-1 para todos)
     * @param firstResult - a partir deste resultado (-1 para todos)
     * @return List de produtos
     */
    private List<Produto> findProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    //////////////////////////////////////////////////////original
    
    
//    public Session abreSessao() {
//        sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();
//        tr = session.beginTransaction();
//        return session;
//    }
//
//    public boolean gravar(Produto p) {
//        Session session = abreSessao();
//        try {
//            session.save(p);
//            tr.commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao gravar Produto! \n ERRO: | ProdutoDAO | gravar() | " + e);
//            session.close();
//            return false;
//        } finally {
//            session.getTransaction().rollback(); // ---- criar metodo
//            return false;
//        }
//    }
//
//    public boolean alterar(Produto p) {
//        Session session = abreSessao();
//        try {
//            session.update(p);
//            tr.commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao atualizar Produto! \n ERRO: | ProdutoDAO | alterar() | " + e);
//            session.close();
//            return false;
//        } finally {
//            session.close();
//            return false;
//        }
//    }
//
//    public boolean remover(Produto p) {
//        Session session = abreSessao();
//        try {
//            session.delete(p);
//            tr.commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao remover Produto! \n ERRO: | ProdutoDAO | remover() | " + e);
//            session.close();
//            return false;
//        } finally {
//            session.close();
//            return false;
//        }
//    }
//
//    public List getListaProdutosByField(String field, String value) {
//        Session session = abreSessao();
//        Criteria criteria = session.createCriteria(Produto.class);
//
//        if (!field.equals("") || !value.equals("")) {
//            criteria.add(Restrictions.eq(field, value));
//        }
//        return criteria.list();
//    }
//    
//    public List getListaProduto() {
//        Session session = abreSessao();
//        Criteria criteria = session.createCriteria(Produto.class);
//        return criteria.list();
//    }
}
