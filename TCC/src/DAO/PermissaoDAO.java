///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import controller.EntityManagerFactoryCreator;
//import controller.Mensagens;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityNotFoundException;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import modelo.Permissao;
//import persistencia.exceptions.NonexistentEntityException;
//
///**
// *
// * @author Bruno
// */
//public class PermissaoDAO {
//    static Mensagens m;
//
//    public PermissaoDAO(EntityManagerFactory emf) {
//        this.emf = EntityManagerFactoryCreator.getEMF();
//    }
//    private static EntityManagerFactory emf = null;
//
//    public static EntityManager getEntityManager() {
//        emf = EntityManagerFactoryCreator.getEMF();
//        return emf.createEntityManager();
//    }
//
//    public static boolean gravar(Permissao p) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            em.persist(p);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao gravar Permissao! \n ERRO: | PermissaoDAO | gravar() | " + e);
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
//    public static boolean edit(Permissao permissao) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            em.getTransaction().begin();
//            permissao = em.merge(permissao);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = permissao.getPermissaoId();
//                if (findProduto(id) == null) {
//                    throw new NonexistentEntityException("Permissao  " + id + " não existe.");
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
//            Permissao permissao;
//            try {
//                permissao = em.getReference(Permissao.class, id);
//                permissao.getPermissaoId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Permissao  " + id + " não existe.", enfe);
//            }
//            em.remove(permissao);
//            em.getTransaction().commit();
//        } finally {
//            em.getTransaction().rollback();
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
//
//    public static Permissao buscaNome(String nome) {
//        EntityManager em = getEntityManager();
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Permissao> cq = cb.createQuery(Permissao.class);
//            Root<Permissao> permissao = cq.from(Permissao.class);
//
//            cq.where(cb.equal(permissao.get("PermissaoDesc"), cb.parameter(String.class, "PermissaoDesc")),
//                    cb.equal(permissao.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Permissao> query = em.createQuery(cq);
//            query.setParameter("PermissaoDesc", nome);
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
//    public static Permissao buscaByField(String field, String value) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Permissao> cq = cb.createQuery(Permissao.class);
//            Root<Permissao> permissao = cq.from(Permissao.class);
//            cq.where(cb.equal(permissao.get(field), cb.parameter(String.class, field)),
//                    cb.equal(permissao.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Permissao> query = em.createQuery(cq);
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
//    public static List<Permissao> listByField(String field, String value) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Permissao> cq = cb.createQuery(Permissao.class);
//            Root<Permissao> m = cq.from(Permissao.class);
//
//            cq.where(cb.equal(m.get(field), cb.parameter(String.class, field)),
//                    cb.equal(m.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Permissao> query = em.createQuery(cq);
//            query.setParameter(field, value);
//            query.setParameter("deleted", "f");
//            return query.getResultList();
//        } finally {
//            em.close();
//        }
//    }
//
//    public static Permissao findProduto(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Permissao.class, id);
//        } finally {
//            em.close();
//        }
//    }
//}
