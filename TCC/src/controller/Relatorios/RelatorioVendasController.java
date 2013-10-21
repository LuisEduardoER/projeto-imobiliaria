/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Relatorios;

import DAO.Relatorios.RelatorioVendasDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.AberturaCaixa;
import modelo.Caixa;
import modelo.Produto;
import modelo.Venda;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
public class RelatorioVendasController {

    RelatorioVendasDAO dao = new RelatorioVendasDAO();

    public List<Object[]> relatorioVendasProdutoCaixaData(Integer produtoId, Integer caixaId, LocalDateTime dataInicial, LocalDateTime dataFinal) {

        List<Object[]> vendas = dao.relatorioVendasProdutoCaixaData(produtoId, caixaId, dataInicial, dataFinal);

        
//        p.add(Projections.groupProperty("produto.produtoNome"));
//        p.add(Projections.groupProperty("caixa.caixaDesc"));
//        p.add(Projections.groupProperty("venda.dataVenda"));
//        p.add(Projections.groupProperty("venda.valorTotal"));
//        p.add(Projections.groupProperty("venda.totalPago"));
            
            
        
        return vendas;
    }

    public DefaultComboBoxModel<Caixa> listaCaixas() {
        Caixa caixa = new Caixa();
        DefaultComboBoxModel<Caixa> dcbm = new DefaultComboBoxModel<>();

        List<Caixa> caixas = dao.listaCaixas();
        
        for (int i = 0; i < caixas.size(); i++) {
            dcbm.addElement(caixas.get(i));
        }
        
        return dcbm;
    }
    
    public DefaultComboBoxModel<Produto> listaProdutos() {
        Produto produto = new Produto();
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();

        List<Produto> produtos = dao.listaProdutos();
        
        for (int i = 0; i < produtos.size(); i++) {
            dcbm.addElement(produtos.get(i));
        }
        
        return dcbm;
    }
}
