/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import modelo.Modulo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class ModuloDAO implements Serializable {

    static Mensagens m;

//    public ModuloDAO(EntityManagerFactory emf) {
//        this.emf = EntityManagerFactoryCreator.getEMF();
//    }
//    private static EntityManagerFactory emf = null;
//
//    public static EntityManager getEntityManager() {
//        emf = EntityManagerFactoryCreator.getEMF();
//        return emf.createEntityManager();
//    }

    public static boolean gravar(Modulo f) {
//        EntityManager em = null;
//        try {
////            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(f);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao gravar Modulo! \n ERRO: | ModuloDAO | gravar() | " + e);
//            return false;
//        } finally {
////            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
////                return true;
//            }
//        }
        return false;
    }

    public static boolean edit(Modulo f) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
////            em = getEntityManager();
//            em.getTransaction().begin();
//            f = em.merge(f);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = f.getModuloId();
//                if (findProduto(id) == null) {
//                    throw new NonexistentEntityException("Modulo  " + id + " não existe.");
//                }
//            }
//            throw ex;
////            return false;
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
        return false;
    }

    public static void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = null;
//        try {
////            em = getEntityManager();
//            em.getTransaction().begin();
//            Modulo modulo;
//            try {
//                modulo = em.getReference(Modulo.class, id);
//                modulo.getModuloId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Modulo  " + id + " não existe.", enfe);
//            }
//            em.remove(modulo);
//            em.getTransaction().commit();
//        } finally {
//            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public static Modulo buscaNome(String nome) {
//        EntityManager em = getEntityManager();

//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Modulo> cq = cb.createQuery(Modulo.class);
//            Root<Modulo> f = cq.from(Modulo.class);
//
//            cq.where(cb.equal(f.get("moduloDesc"), cb.parameter(String.class, "moduloDesc")),
//                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

//            TypedQuery<Modulo> query = em.createQuery(cq);
//            query.setParameter("moduloDesc", nome);
//            query.setParameter("deleted", "f");
//            return query.getSingleResult();

//        } finally {
//            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
//            }
//        }
        return null;
    }

    public static Modulo buscaByField(String field, String value) {
//        EntityManager em = null;
//        try {
////            em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Modulo> cq = cb.createQuery(Modulo.class);
//            Root<Modulo> m = cq.from(Modulo.class);
//            cq.where(cb.equal(m.get(field), cb.parameter(String.class, field)),
//                    cb.equal(m.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Modulo> query = em.createQuery(cq);
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
        return null;
    }

    public static List<Modulo> listByField(String field, String value) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Modulo> cq = cb.createQuery(Modulo.class);
//            Root<Modulo> m = cq.from(Modulo.class);
//
//            cq.where(cb.equal(m.get(field), cb.parameter(String.class, field)),
//                    cb.equal(m.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Modulo> query = em.createQuery(cq);
//            query.setParameter(field, value);
//            query.setParameter("deleted", "f");
//            return query.getResultList();
//        } finally {
//            em.close();
//        }
        return null;
    }

    public static Modulo findProduto(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Modulo.class, id);
//        } finally {
//            em.close();
//        }
        return null;
    }
}



