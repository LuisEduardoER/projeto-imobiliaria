/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cadastro;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import modelo.Produto;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class ProdutoDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session; 
    
    public ProdutoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Produto gravar(Produto produto) {
        em.getTransaction().begin();
        produto = em.merge(produto);
        em.getTransaction().commit();
        return produto;
    }

    public Produto atualizar(Produto produto) {
        em.getTransaction().begin();
        produto = em.merge(produto);
        em.getTransaction().commit();
        return produto;
    }

    public void apagar(Produto produto) {
        em.getTransaction().begin();
        produto = em.getReference(Produto.class, produto.getProduto_id());
        em.remove(produto);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Produto> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Produto.class);
        return select.list();
    }
    
    @SuppressWarnings("unchecked")
    public Produto consultarProduto(String searchField, String searchString) {
//        Session session = (Session) em.getDelegate();
        Criteria criteria = montarCriteria(searchField, searchString);
        
        return  (Produto) criteria.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public Produto consultarProdutoCodigoBarra(String codigoBarras) {
        Criteria criteria = session.createCriteria(Produto.class, "produto");
        
        criteria.add(Restrictions.eq("produto.produtoCodigoBarras", codigoBarras));
        
        return  (Produto) criteria.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Produto> buscarTodos() {
        Criteria criteria = session.createCriteria(Produto.class, "produto");
        criteria.createCriteria("produto.fornecedorId", "frn");
        criteria.createCriteria("produto.fabricanteId", "fbr");
        
        ProjectionList p = Projections.projectionList();
        p.add(Projections.groupProperty("frn.fornecedorNome"));
        p.add(Projections.groupProperty("fbr.fabricanteNome"));
        
        criteria.add(Restrictions.eq("produto.deleted", "f"));
        
        return  criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Produto.class, "produto");
        
        if(searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")){
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        
        return criteria;
    }    
    
    public Integer rowCount(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
//    
//    public static boolean edit(Produto produto) {
//        try {
//            EntityManager em = getEntityManager();
//            em.getTransaction().begin();
//            produto = em.merge(produto);
//            em.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            Integer id = produto.getProdutoId();
//            if (findProduto(id) == null) {
//                m = new Mensagens();
//                m.jopError("Erro ao alterar Produto! \n ERRO: | ProdutoDAO | edit() | " + e);
//                return false;
//            }
//            return false;
//        }
//    }
//
//    public static void destroy(Integer id) throws NonexistentEntityException {
//        try {
//            EntityManager em = getEntityManager();
//            em.getTransaction().begin();
//            Produto produto;
//            try {
//                produto = em.getReference(Produto.class, id);
//                produto.getProdutoId();
//            } catch (EntityNotFoundException enfe) {
//                throw new NonexistentEntityException("Produto  " + id + " não existe.", enfe);
//            }
//            em.remove(produto);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e);
//            m = new Mensagens();
//            m.jopError("Erro ao deletar Produto! \n ERRO: | ProdutoDAO | destroy() | " + e);
//        }
//    }
//
//    public static Produto buscaNome(String nome) {
//        EntityManager em = getEntityManager();
//
//        try {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
//            Root<Produto> produto = cq.from(Produto.class);
//
//            cq.where(cb.equal(produto.get("produtoNome"), cb.parameter(String.class, "produtoNome")),
//                    cb.equal(produto.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Produto> query = em.createQuery(cq);
//            query.setParameter("produtoNome", nome);
//            query.setParameter("deleted", "f");
//            return query.getSingleResult();
//
//        } catch (Exception e) {
//            System.out.println(e);
//            m = new Mensagens();
//            m.jopError("Erro ao buscar Produto! \n ERRO: | ProdutoDAO | buscaNome() | " + e);
//            return null;
//        }
//    }
//
//    public static Produto buscaByField(String field, String value) {
//        try {
//            EntityManager em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
//            Root<Produto> produto = cq.from(Produto.class);
//            cq.where(cb.equal(produto.get(field), cb.parameter(String.class, field)),
//                    cb.equal(produto.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Produto> query = em.createQuery(cq);
//            query.setParameter(field, value);
//            query.setParameter("deleted", "f");
//            return query.getSingleResult();
//        } catch (Exception e) {
//            System.out.println(e);
//            m = new Mensagens();
//            m.jopError("Erro ao buscar Produto! \n ERRO: | ProdutoDAO | buscaByField() | " + e);
//            return null;
//        }
//    }
//
//    public static List<Produto> listByField(String field, String value) {
//        try {
//            EntityManager em = getEntityManager();
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
//            Root<Produto> produto = cq.from(Produto.class);
//
//            cq.where(cb.equal(produto.get(field), cb.parameter(String.class, field)),
//                    cb.equal(produto.get("deleted"), cb.parameter(String.class, "deleted")));
//
//            TypedQuery<Produto> query = em.createQuery(cq);
//            query.setParameter(field, value);
//            query.setParameter("deleted", "f");
//            return query.getResultList();
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao buscar Produto! \n ERRO: | ProdutoDAO | listByField() | " + e);
//            return null;
//        }
//    }
//
//    public static Produto findProduto(Integer id) {
//        EntityManager em = getEntityManager();
//        try {
//            return em.find(Produto.class, id);
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao buscar Produto! \n ERRO: | ProdutoDAO | findProduto() | " + e);
//            return null;
//        }
//    }
}
