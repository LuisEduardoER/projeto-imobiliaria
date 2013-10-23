/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Relatorios;

import DAO.EntityManagerFactory;
import controller.Mensagens;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Titulopagar;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class RelatorioTitulosAPagarDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public RelatorioTitulosAPagarDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> relatorioTitulosPagarNaoBaixados() {
        Criteria criteria = montarCriteria();
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("tituloPagar.tituloId"));
        p.add(Projections.groupProperty("compra.dataCompra"));
        
        p.add(Projections.groupProperty("fornecedor.fornecedorNome"));
        p.add(Projections.groupProperty("fornecedor.fornecedorCNPJ"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria() {
        Criteria criteria = session.createCriteria(Titulopagar.class, "tituloPagar");
        criteria.createCriteria("tituloPagar.compraId", "compra");
        criteria.createCriteria("compra.fornecedorId", "fornecedor");

        criteria.add(Restrictions.eq("tituloPagar.baixado", "f"));
        criteria.add(Restrictions.eq("tituloPagar.deleted", "f"));
        criteria.add(Restrictions.eq("compra.deleted", "f"));

        return criteria;
    }
}
