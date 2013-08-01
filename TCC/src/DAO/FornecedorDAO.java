/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.EntityManagerFactoryCreator;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Fabricante;
import modelo.Fornecedor;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class FornecedorDAO implements Serializable {

    static Mensagens m;

    public FornecedorDAO(EntityManagerFactory emf) {
        this.emf = EntityManagerFactoryCreator.getEMF();
    }
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        emf = EntityManagerFactoryCreator.getEMF();
        return emf.createEntityManager();
    }

    public static boolean gravar(Fornecedor f) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao gravar Fornecedor! \n ERRO: | FornecedorAO | gravar() | " + e);
            return false;
        } finally {
//            em.getTransaction().rollback();
            if (em != null) {
                em.close();
//                return true;
            }
        }
    }

    public static boolean edit(Fornecedor f) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            f = em.merge(f);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = f.getFornecedorId();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("Fornecedor  " + id + " não existe.");
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
            Fornecedor fornecedor;
            try {
                fornecedor = em.getReference(Fornecedor.class, id);
                fornecedor.setDeleted('t');
                fornecedor.setUpdated(Datas.dataAtual());
                fornecedor.getFornecedorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Fornecedor  " + id + " não existe.", enfe);
            }
            try {
                edit(fornecedor);
            } catch (Exception ex) {
                Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            em.getTransaction().commit();
        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }

    public static Fornecedor buscaNome(String nome) {
        EntityManager em = getEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fornecedor> cq = cb.createQuery(Fornecedor.class);
            Root<Fornecedor> f = cq.from(Fornecedor.class);

            cq.where(cb.equal(f.get("fornecedorNome"), cb.parameter(String.class, "fornecedorNome")),
                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Fornecedor> query = em.createQuery(cq);
            query.setParameter("fornecedorNome", nome);
            query.setParameter("deleted", "f");
            return query.getSingleResult();

        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }

    public static Fornecedor buscaByField(String field, String value) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fornecedor> cq = cb.createQuery(Fornecedor.class);
            Root<Fornecedor> f = cq.from(Fornecedor.class);
            cq.where(cb.equal(f.get(field), cb.parameter(String.class, field)),
                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Fornecedor> query = em.createQuery(cq);
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

    public static List<Fornecedor> listByField(String field, String value) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fornecedor> cq = cb.createQuery(Fornecedor.class);
            Root<Fornecedor> f = cq.from(Fornecedor.class);

            cq.where(cb.equal(f.get(field), cb.parameter(String.class, field)),
                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Fornecedor> query = em.createQuery(cq);
            query.setParameter(field, value);
            query.setParameter("deleted", "f");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static Fabricante findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fabricante.class, id);
        } finally {
            em.close();
        }
    }
}
