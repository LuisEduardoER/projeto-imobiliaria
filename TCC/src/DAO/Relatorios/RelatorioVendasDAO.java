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
import modelo.Produto;
import modelo.Venda;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
public class RelatorioVendasDAO implements Serializable {

    static Mensagens m;
    EntityManager em;
    private Criteria select;
    Session session;

    public RelatorioVendasDAO() {
        em = new EntityManagerFactory().getEntityManager();
        session = (Session) em.getDelegate();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> relatorioVendasProdutoCaixaData(Integer produtoId, Integer caixaId, LocalDateTime dataInicial, LocalDateTime dataFinal) {
        Criteria criteria = montarCriteria(produtoId, caixaId, dataInicial, dataFinal);
        ProjectionList p = Projections.projectionList();

        p.add(Projections.groupProperty("produto.produtoNome"));
        p.add(Projections.groupProperty("caixa.caixaDesc"));
        p.add(Projections.groupProperty("venda.dataVenda"));
        p.add(Projections.groupProperty("venda.valorTotal"));
        p.add(Projections.groupProperty("venda.totalPago"));
        criteria.setProjection(p);

        return criteria.list();
    }

    private Criteria montarCriteria(Integer produtoId, Integer caixaId, LocalDateTime dataInicial, LocalDateTime dataFinal) {
        Criteria criteria = session.createCriteria(Venda.class, "venda");
        criteria.createCriteria("venda.movimentoList", "movimento");
        criteria.createCriteria("movimento.caixaId", "caixa");

        criteria.createCriteria("venda.itemvendaList", "itemVenda");
        criteria.createCriteria("itemVenda.produtoId", "produto");


        if (produtoId != null) {
            criteria.add(Restrictions.eq("produto.produto_id", produtoId));
        }

        if (caixaId != null) {
            criteria.add(Restrictions.eq("caixa.caixaId", caixaId));
        }

        if (dataInicial != null) {
            criteria.add(Restrictions.gt("venda.dataVenda", dataInicial));
        }

        if (dataFinal != null) {
            criteria.add(Restrictions.le("venda.dataVenda", dataFinal));
        }

        return criteria;
    }

    @SuppressWarnings("unchecked")
    public List<Caixa> listaCaixas() {
        Criteria criteria = session.createCriteria(Caixa.class, "caixa");
        criteria.add(Restrictions.eq("caixa.deleted", "f"));
        return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Produto> listaProdutos() {
        Criteria criteria = session.createCriteria(Produto.class, "produto");
        criteria.add(Restrictions.eq("produto.deleted", "f"));
        return criteria.list();
    }
}
