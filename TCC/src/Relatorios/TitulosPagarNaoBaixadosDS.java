/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
public class TitulosPagarNaoBaixadosDS implements JRDataSource {

    private final Iterator<Object[]> iterator;
    private Object[] selecionado;

    public TitulosPagarNaoBaixadosDS(List<Object[]> lista) {
        this.iterator = lista.iterator();
    }

    @Override
    public boolean next() throws JRException {
        if (iterator.hasNext()) {
            selecionado = iterator.next();
            return true;

        } else {
            return false;
        }
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
//
/*        
        p.add(Projections.groupProperty("produto.produtoNome"));
        p.add(Projections.groupProperty("caixa.caixaDesc"));
        p.add(Projections.groupProperty("venda.dataVenda"));
        p.add(Projections.groupProperty("venda.valorTotal"));
        p.add(Projections.groupProperty("venda.totalPago"));
*/        
        if ("titulo".equals(jrf.getName())) {
            return selecionado[0];
        }
        if ("dataCompra".equals(jrf.getName())) {
            LocalDateTime data = (LocalDateTime) selecionado[1];
            String d = data.toLocalDate().toString("dd/MM/YYYY");
            return d;
        }
        if ("fornecedor".equals(jrf.getName())) {
             return selecionado[2];
        }
        if ("cnpj".equals(jrf.getName())) {
            return selecionado[3];
        }
//        
        return "Erro ao Gerar Relatório!";
//
    }
}
