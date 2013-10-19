/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Estoque;
import modelo.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class EstoqueDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;
    
    public EstoqueDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Estoque gravar(Estoque estoque) {
        em.getTransaction().begin();
        estoque = em.merge(estoque);
        em.getTransaction().commit();
        return estoque;
    }

    public Estoque atualizar(Estoque estoque) {
        em.getTransaction().begin();
        estoque = em.merge(estoque);
    //    em.getTransaction().commit();
        return estoque;
    }

    public void apagar(Estoque estoque) {
        em.getTransaction().begin();
        estoque = em.getReference(Estoque.class, estoque.getEstoqueId());
        em.remove(estoque);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Estoque> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Estoque.class);
        return select.list();
    }
    
    @SuppressWarnings("unchecked")
    public Estoque consultarEstoqueByProduto(Produto produto) {
//        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Estoque.class, "estoque");
        criteria.createCriteria("estoque.estqprodutoId", "produto");
        
        criteria.add(Restrictions.eq("produto.produto_id", produto.getProduto_id()));
        
        return  (Estoque) criteria.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public Estoque consultarEstoque(String searchField, String searchString) {
//        Session session = (Session) em.getDelegate();
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Estoque) criteria.uniqueResult();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Estoque.class, "estoque");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.like("estoque."+searchField, searchString));
        }
        
        return criteria;
    }    
    
    public Integer rowCount(String searchField, Integer searchString) {
//        Criteria criteria = montarCriteria(searchField, searchString);
        Criteria criteria = session.createCriteria(Estoque.class, "estoque");
        criteria.add(Restrictions.eq("estoque.estqprodutoId.produto_id", searchString));
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
    
//    public EstoqueDAO(EntityManagerFactory emf) {
//        this.emf = EntityManagerFactoryCreator.getEMF();
//    }
//    private static EntityManagerFactory emf = null;
//
//    public static EntityManager getEntityManager() {
//        emf = EntityManagerFactoryCreator.getEMF();
//        return emf.createEntityManager();
//    }
//
//    public static boolean gravar(Estoque estoque) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(estoque);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao gravar Estoque! \n ERRO: | EstoqueDAO | gravar() | " + e);
//            return false;
//        } finally {
////            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
////                return true;
//            }
//        }
//    }
//
//    public static boolean edit(Estoque estoque) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            estoque = em.merge(estoque);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = estoque.getEstoqueId();
//                if (findProduto(id) == null) {
//                    throw new NonexistentEntityException("Estoque  " + id + " não existe.");
//                }
//            }
//            throw ex;
////            return false;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public static void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            Estoque estoque;
//            try {
//                estoque = em.getReference(Estoque.class, id);
//                estoque.getEstoqueId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Estoque  " + id + " não existe.", enfe);
//            }
//            em.remove(estoque);
//            em.getTransaction().commit();
//        } finally {
//            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public static Estoque buscaNome(String nome) {
//        EntityManager em = getEntityManager();
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Estoque> cq = cb.createQuery(Estoque.class);
//            Root<Estoque> estoque = cq.from(Estoque.class);
//
//            cq.where(cb.equal(estoque.get("estoqueNome"), cb.parameter(String.class, "estoqueNome")),
//                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Estoque> query = em.createQuery(cq);
//            query.setParameter("estoqueNome", nome);
//            query.setParameter("deleted", "f");
//            return query.getSingleResult();
//
//        } finally {
//            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public static Estoque buscaByField(String field, String value) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Estoque> cq = cb.createQuery(Estoque.class);
//            Root<Estoque> estoque = cq.from(Estoque.class);
//            cq.where(cb.equal(estoque.get(field), cb.parameter(String.class, field)),
//                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Estoque> query = em.createQuery(cq);
//            query.setParameter(field, value);
//            query.setParameter("deleted", "f");
//            return query.getSingleResult();
//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public static List<Estoque> listByField(String field, String value) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Estoque> cq = cb.createQuery(Estoque.class);
//            Root<Estoque> estoque = cq.from(Estoque.class);
//
//            cq.where(cb.equal(estoque.get(field), cb.parameter(String.class, field)),
//                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Estoque> query = em.createQuery(cq);
//            query.setParameter(field, value);
//            query.setParameter("deleted", "f");
//            //implementar rowCount
//
////            query.getSingleResult();
////            query.getResultList().isEmpty()
//            if (query.getSingleResult() == null) {
//                return null;
//            } else {
//                return query.getResultList();
//            }
//        } catch (Exception e) {
//            return null;
//        } finally {
//            em.close();
//        }
//    }
//
//    public static int rowCount(String field, String value) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery cq = cb.createQuery(Estoque.class);
//
////            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
//            Root<Estoque> estoque = cq.from(Estoque.class);
//            cq.select(em.getCriteriaBuilder().count(estoque));
//
//            cq.where(cb.equal(estoque.get(field), cb.parameter(String.class, field)),
//                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            em.close();
//        }
//    }
//
//    public static Estoque findProduto(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Estoque.class, id);
//        } finally {
//            em.close();
//        }
//    }
}
