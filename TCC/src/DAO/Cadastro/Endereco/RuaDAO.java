/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cadastro.Endereco;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Rua;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class RuaDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public RuaDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public Rua gravar(Rua rua) {
        em.getTransaction().begin();
        rua = em.merge(rua);
        em.getTransaction().commit();
        return rua;
    }

    public Rua atualizar(Rua rua) {
        em.getTransaction().begin();
        rua = em.merge(rua);
        em.getTransaction().commit();
        return rua;
    }

    public void apagar(Rua rua) {
        em.getTransaction().begin();
        rua = em.getReference(Rua.class, rua.getRuaId());
        em.remove(rua);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Rua> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(Rua.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarRua(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("rua.ruaId"));
        p.add(Projections.groupProperty("rua.ruaNome"));
        
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Rua.class, "rua");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public Rua buscarRua(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(Rua.class, "rua");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }
        criteria.add(Restrictions.eq("rua.deleted", "f"));

        return (Rua) criteria.uniqueResult();
    }

    public List<Rua> buscarRuaByBairro(Integer bairroId) {
        Criteria criteria = session.createCriteria(Rua.class, "rua");
        criteria.createCriteria("rua.bairroId", "bairro");

        criteria.add(Restrictions.eq("bairro.bairroId", bairroId));
        criteria.add(Restrictions.eq("bairro.deleted", "f"));
        criteria.add(Restrictions.eq("rua.deleted", "f"));

        return criteria.list();
    }
    
    public Integer checaRuaExiste(Rua rua) {
        Criteria criteria = session.createCriteria(Rua.class, "rua");
        criteria.createCriteria("rua.bairroId", "bairro");

        criteria.add(Restrictions.eq("rua.ruaNome", rua.getRuaNome()));
        criteria.add(Restrictions.eq("bairro.bairroId",   rua.getBairroID().getBairroId()));
        criteria.add(Restrictions.eq("bairro.deleted", "f"));
        
        criteria.setProjection(Projections.rowCount());
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
