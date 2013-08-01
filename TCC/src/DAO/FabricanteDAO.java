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
import modelo.Fabricante;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class FabricanteDAO implements Serializable {

    static Mensagens m;

    public FabricanteDAO(EntityManagerFactory emf) {
        this.emf = EntityManagerFactoryCreator.getEMF();
    }
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        emf = EntityManagerFactoryCreator.getEMF();
        return emf.createEntityManager();
    }

    public static boolean gravar(Fabricante f) {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao gravar Fabricante! \n ERRO: | FabricanteDAO | gravar() | " + e);
            return false;
        } finally {
//            em.getTransaction().rollback();
        }
    }

    public static boolean edit(Fabricante f) throws NonexistentEntityException, Exception {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            f = em.merge(f);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = f.getFabricanteId();
                if (findFabricante(id) == null) {
                    throw new NonexistentEntityException("Fabricante  " + id + " não existe.");
                }
            }
            throw ex;
//            return false;

        }
    }

    public static void destroy(Integer id) throws NonexistentEntityException {
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            Fabricante fabricante;
            try {
                fabricante = em.getReference(Fabricante.class, id);
                fabricante.getFabricanteId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Fabricante  " + id + " não existe.", enfe);
            }
            em.remove(fabricante);
            em.getTransaction().commit();
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao remover Fabricante! \n ERRO: | FabricanteDAO | destroy() | " + e);
        }
    }

    public static Fabricante buscaNome(String nome) {
        EntityManager em = getEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fabricante> cq = cb.createQuery(Fabricante.class);
            Root<Fabricante> f = cq.from(Fabricante.class);

            cq.where(cb.equal(f.get("fabricanteNome"), cb.parameter(String.class, "fabricanteNome")),
                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Fabricante> query = em.createQuery(cq);
            query.setParameter("fabricanteNome", nome);
            query.setParameter("deleted", "f");
            return query.getSingleResult();

        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao buscar Fabricante! \n ERRO: | FabricanteDAO | buscaNome() | " + e);
            return null;
        }

    }

    public static Fabricante buscaByField(String field, String value) {
        try {
            EntityManager em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fabricante> cq = cb.createQuery(Fabricante.class);
            Root<Fabricante> f = cq.from(Fabricante.class);
            cq.where(cb.equal(f.get(field), cb.parameter(String.class, field)),
                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Fabricante> query = em.createQuery(cq);
            query.setParameter(field, value);
            query.setParameter("deleted", "f");
            return query.getSingleResult();
        } catch (Exception e) {
            m.jopAviso("Não foram encontrados fabricantes com este cnpj!");
            System.out.println(e);
            return null;
        }
    }

    public static List<Fabricante> listByField(String field, String value) {
        try {
            EntityManager em = getEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fabricante> cq = cb.createQuery(Fabricante.class);
            Root<Fabricante> f = cq.from(Fabricante.class);

            cq.where(cb.equal(f.get(field), cb.parameter(String.class, field)),
                    cb.equal(f.get("deleted"), cb.parameter(String.class, "deleted")));

            TypedQuery<Fabricante> query = em.createQuery(cq);
            query.setParameter(field, value);
            query.setParameter("deleted", "f");
            return query.getResultList();
        }catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao buscar Fabricante! \n ERRO: | FabricanteDAO | listByField() | " + e);
            return null;
        }
    }

    public static Fabricante findFabricante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fabricante.class, id);
        } catch (Exception e) {
            m = new Mensagens();
            m.jopError("Erro ao buscar Fabricante! \n ERRO: | FabricanteDAO | findFabricante() | " + e);
            return null;
        }
    }
}
