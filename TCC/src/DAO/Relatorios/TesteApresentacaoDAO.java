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
import modelo.Caixa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class TesteApresentacaoDAO implements Serializable{
    
    
    static Mensagens m;
    EntityManager em;
    Session session;
    
    public TesteApresentacaoDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }
    
    public List<Object[]> exemploApresentação() {
        
        //tabelas à serem consultadas (cláusulas FROM e INNER JOIN)
        Criteria criteria = session.createCriteria(Caixa.class, "caixa");
        criteria.createCriteria("caixa.aberturaCaixaList",      "aberturaCaixa");
        criteria.createCriteria("caixa.movimentoList",          "movimento");
        criteria.createCriteria("aberturaCaixa.usuarioId",      "usuario");
        criteria.createCriteria("movimento.vendaId",            "venda");
        criteria.createCriteria("venda.tipoPagamentoId",        "tipoPagamento");
        criteria.createCriteria("venda.itemvendaList",          "itemVenda");
        criteria.createCriteria("itemVenda.produtoId",          "produto");

        // restrições da consutla (cláusulas WHERE e AND)
        criteria.add(Restrictions.eq("caixa.deleted", "f"));
        criteria.add(Restrictions.eq("venda.deleted", "f"));

        ProjectionList p = Projections.projectionList();

        //colunas à serem projetadas
        p.add(Projections.groupProperty("caixa.caixaDesc"));
        
        p.add(Projections.groupProperty("aberturaCaixa.aberturaCaixa"));
        p.add(Projections.groupProperty("aberturaCaixa.saldoCaixa"));
        p.add(Projections.groupProperty("aberturaCaixa.fechamentoCaixa"));
        p.add(Projections.groupProperty("aberturaCaixa.saldoFechamento"));

        p.add(Projections.groupProperty("movimento.movimentoHorario"));
        
        p.add(Projections.groupProperty("usuario.usuarioName"));
        
        p.add(Projections.groupProperty("venda.valorTotal"));
        p.add(Projections.groupProperty("venda.totalPago"));
        p.add(Projections.groupProperty("venda.dataVenda"));
        
        p.add(Projections.groupProperty("tipoPagamento.tipoPagamentoDesc"));
        
        p.add(Projections.groupProperty("itemVenda.quantidade"));
        p.add(Projections.groupProperty("itemVenda.valorItemVenda"));
        
        p.add(Projections.groupProperty("produto.produtoNome"));
        p.add(Projections.groupProperty("produto.valor"));
        p.add(Projections.groupProperty("produto.produtoCodigoBarras"));
        
        criteria.setProjection(p);

        return criteria.list();
    }
}
