/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.EntityManagerFactoryCreator;
import controller.Mensagens;
import java.io.Serializable;
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

/**
 *
 * @author Bruno
 */
public class FornecedorDAO implements Serializable{

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
            m.jopError("Erro ao gravar Fornecedor! \n ERRO: | FornecedorDAO | gravar() | " + e);
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
                fornecedor.getFornecedorId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("Fornecedor  " + id + " não existe.", enfe);
            }
            em.remove(fornecedor);
            em.getTransaction().commit();
        } finally {
            em.getTransaction().rollback();
            if (em != null) {
                em.close();
            }
        }
    }
    
     public static Fornecedor buscaNome(String nome){
        EntityManager em = getEntityManager();
        
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fornecedor> cq = cb.createQuery(Fornecedor.class);
            Root<Fornecedor> f = cq.from(Fornecedor.class);
            cq.where(cb.equal(f.get("fornecedorNome"), cb.parameter(String.class, "fornecedorNome")));
            
            TypedQuery<Fornecedor> query = em.createQuery(cq);
            query.setParameter("fornecedorNome", nome);

            query.setParameter("deleted", 'f');
            return query.getSingleResult();
            
        } finally {
            em.close();  
        }
    }
     
     public static Fornecedor buscaByField(String field, String value){
        EntityManager em = getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Fornecedor> cq = cb.createQuery(Fornecedor.class);
            Root<Fornecedor> f = cq.from(Fornecedor.class);
            cq.where(cb.equal(f.get(field), cb.parameter(String.class, field)));

            TypedQuery<Fornecedor> query = em.createQuery(cq);
            query.setParameter(field, value);
            return query.getSingleResult();
            
        } finally {
            em.close();  
        }
    }
    
//    public boolean alterar(Fabricante f) {
////        Session session = abreSessao();
//        try {
//            em.getTransaction().begin();
//            em.merge(f);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao atualizar Funcionario! \n ERRO: | FuncionarioDAO | alterar() | " + e);
//            return false;
//        } finally {
//            rollbackTransaction();
//            return false;
//        }
//    }

//    public boolean remover(Fabricante f) {
////        Session session = abreSessao();
//        try {
//            em.getTransaction().begin();
//            em.remove(f);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao remover Fabricante! \n ERRO: | FabricanteDAO | remover() | " + e);
//            return false;
//        } finally {
//            rollbackTransaction();
//            return false;
//        }
//    }

    public static Fornecedor findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
    }
    
//    public List getListaFuncionarioByField(String field, String value) {
////        Session session = abreSessao();
//        Criteria criteria = session.createCriteria(Fabricante.class);
//
//        if (!field.equals("") || !value.equals("")) {
//            criteria.add(Restrictions.eq(field, value));
//        }
//        return criteria.list();
//    }
//
//    public Fabricante loadById(int id) {
//        Criteria criteria = session.createCriteria(Fabricante.class);
//        criteria.add(Restrictions.eq("idFuncionario", id));
//        return (Fabricante) criteria.uniqueResult();
//    }

//    public List<Fabricante> listar() {
//        EntityManager em = getEntityManager();
//         CriteriaBuilder cb;
//        try {
//            cb = em.getCriteriaBuilder();
//            CriteriaQuery<Fabricante> cq = cb.createQuery(Fabricante.class);
//            cq.select(cq.from(Fabricante.class));
//            TypedQuery<Fabricante> query = em.createQuery(cq);
//            List<Fabricante> produtos = query.getResultList();
//            return produtos;
//
//        } finally {
//            em.close();
//        }
//    }

    //busca por id com criteria
//    public Produto buscaId(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
//            Root<Produto> prod = cq.from(Produto.class);
//            cq.where(cb.equal(prod.get("id"), cb.parameter(Integer.class, "id")));
//
//            TypedQuery<Produto> query = em.createQuery(cq);
//            query.setParameter("id", id);
//            return query.getSingleResult();
//
//        } finally {
//            em.close();
//        }
//    }

//    public Produto buscaNome(String descricao) {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
//            Root<Produto> prod = cq.from(Produto.class);
//            cq.where(cb.equal(prod.get("descricao"), cb.parameter(String.class, "descricao")));
//
//            TypedQuery<Produto> query = em.createQuery(cq);
//            query.setParameter("descricao", descricao);
//            return query.getSingleResult();
//
//        } finally {
//            em.close();
//        }
//    }
}
