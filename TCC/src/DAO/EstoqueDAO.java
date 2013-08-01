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
import modelo.Estoque;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class EstoqueDAO implements Serializable {

    static Mensagens m;

    public EstoqueDAO(EntityManagerFactory emf) {
        this.emf = EntityManagerFactoryCreator.getEMF();
    }
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        emf = EntityManagerFactoryCreator.getEMF();
        return emf.createEntityManager();
    }

    public static boolean gravar(Estoque estoque) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estoque);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao gravar Estoque! \n ERRO: | EstoqueDAO | gravar() | " + e);
            return false;
        } finally {
//            em.getTransaction().rollback();
            if (em != null) {
                em.close();
//                return true;
            }
        }
    }

    public static boolean edit(Estoque estoque) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estoque = em.merge(estoque);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estoque.getEstoqueId();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("Estoque  " + id + " não existe.");
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
            Estoque estoque;
            try {
                estoque = em.getReference(Estoque.class, id);
                estoque.getEstoqueId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Estoque  " + id + " não existe.", enfe);
            }
            em.remove(estoque);
            em.getTransaction().commit();
        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }

    public static Estoque buscaNome(String nome) {
        EntityManager em = getEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Estoque> cq = cb.createQuery(Estoque.class);
            Root<Estoque> estoque = cq.from(Estoque.class);

            cq.where(cb.equal(estoque.get("estoqueNome"), cb.parameter(String.class, "estoqueNome")),
                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Estoque> query = em.createQuery(cq);
            query.setParameter("estoqueNome", nome);
            query.setParameter("deleted", "f");
            return query.getSingleResult();

        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }

    public static Estoque buscaByField(String field, String value) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Estoque> cq = cb.createQuery(Estoque.class);
            Root<Estoque> estoque = cq.from(Estoque.class);
            cq.where(cb.equal(estoque.get(field), cb.parameter(String.class, field)),
                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Estoque> query = em.createQuery(cq);
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

    public static List<Estoque> listByField(String field, String value) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Estoque> cq = cb.createQuery(Estoque.class);
            Root<Estoque> estoque = cq.from(Estoque.class);

            cq.where(cb.equal(estoque.get(field), cb.parameter(String.class, field)),
                    cb.equal(estoque.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Estoque> query = em.createQuery(cq);
            query.setParameter(field, value);
            query.setParameter("deleted", "f");
            //implementar rowCount
            if (query.getResultList().isEmpty()) {
                return null;
            } else {
                return query.getResultList();
            }
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Estoque findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estoque.class, id);
        } finally {
            em.close();
        }
    }
}
