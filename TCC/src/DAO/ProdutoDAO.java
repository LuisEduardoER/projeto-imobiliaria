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
        emf = EntityManagerFactoryCreator.getEMF();
        return emf.createEntityManager();
    }

    public static boolean gravar(Produto p) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao gravar Produto! \n ERRO: | ProdutoDAO | gravar() | " + e);
            return false;
        } finally {
//            em.getTransaction().rollback();
            if (em != null) {
                em.close();
//                return true;
            }
        }
    }

    public static boolean edit(Produto produto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produto = em.merge(produto);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produto.getProdutoId();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("Produto  " + id + " não existe.");
                }
            }
            throw ex;
//            return false;
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
                throw new NonexistentEntityException("Produto  " + id + " não existe.", enfe);
            }
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }

    public static Produto buscaNome(String nome) {
        EntityManager em = getEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
            Root<Produto> produto = cq.from(Produto.class);

            cq.where(cb.equal(produto.get("produtoNome"), cb.parameter(String.class, "produtoNome")),
                    cb.equal(produto.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Produto> query = em.createQuery(cq);
            query.setParameter("produtoNome", nome);
            query.setParameter("deleted", "f");
            return query.getSingleResult();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static Produto buscaByField(String field, String value) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
            Root<Produto> produto = cq.from(Produto.class);
            cq.where(cb.equal(produto.get(field), cb.parameter(String.class, field)),
                    cb.equal(produto.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Produto> query = em.createQuery(cq);
            query.setParameter(field, value);
            query.setParameter("deleted", "f");
            return query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public static List<Produto> listByField(String field, String value) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
            Root<Produto> produto = cq.from(Produto.class);

            cq.where(cb.equal(produto.get(field), cb.parameter(String.class, field)),
                    cb.equal(produto.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Produto> query = em.createQuery(cq);
            query.setParameter(field, value);
            query.setParameter("deleted", "f");
            return query.getResultList();
        } finally {
            em.close();
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
}
