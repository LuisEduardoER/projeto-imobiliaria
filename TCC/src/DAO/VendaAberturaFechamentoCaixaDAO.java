/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Caixa;
import modelo.AberturaCaixa;
import modelo.Pais;
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
public class VendaAberturaFechamentoCaixaDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public VendaAberturaFechamentoCaixaDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    public AberturaCaixa gravar(AberturaCaixa caixamovimento) {
        em.getTransaction().begin();
        caixamovimento = em.merge(caixamovimento);
        em.getTransaction().commit();
        return caixamovimento;
    }

    public AberturaCaixa atualizar(AberturaCaixa caixamovimento) {
        em.getTransaction().begin();
        caixamovimento = em.merge(caixamovimento);
        em.getTransaction().commit();
        return caixamovimento;
    }

    public void apagar(AberturaCaixa caixamovimento) {
        em.getTransaction().begin();
        caixamovimento = em.getReference(AberturaCaixa.class, caixamovimento.getCaixaId());
        em.remove(caixamovimento);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<AberturaCaixa> consultarTodos() {
//        Session session = (Session) em.getDelegate();
        select = session.createCriteria(AberturaCaixa.class);
        return select.list();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> consultarCaixamovimento(String searchField, String searchString) {
        Criteria criteria = montarCriteria(searchField, searchString);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("aberturaCaixa.aberturaCaixaId"));
        p.add(Projections.groupProperty("aberturaCaixa.caixaDesc"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(String searchField, String searchString) {
        Criteria criteria = session.createCriteria(AberturaCaixa.class, "aberturaCaixa");

        if (searchField != null && !searchField.equals("") && searchString != null && !searchString.equals("")) {
            criteria.add(Restrictions.ilike(searchField, searchString, MatchMode.ANYWHERE));
        }

        return criteria;
    }

    public AberturaCaixa buscarCaixamovimento(Integer caixaId) {
        Criteria criteria = session.createCriteria(AberturaCaixa.class, "aberturaCaixa");
        
        criteria.createCriteria("aberturaCaixa.caixaId", "caixa");
        criteria.add(Restrictions.eq("caixa.caixaId", caixaId));
        

        return (AberturaCaixa) criteria.uniqueResult();
    }

    public Integer rowCountCaixasAbertos(Integer caixaId) {
        Criteria criteria = session.createCriteria(AberturaCaixa.class, "aberturaCaixa");
        criteria.createCriteria("aberturaCaixa.caixaId", "caixa");
        
        criteria.add(Restrictions.eq("caixa.caixaId", caixaId));
        
        criteria.setProjection(Projections.rowCount());
        
        return ((Integer) criteria.uniqueResult()).intValue();
    }
}
