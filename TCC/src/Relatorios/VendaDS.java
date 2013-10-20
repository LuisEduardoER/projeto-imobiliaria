/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import java.util.ArrayList;
import java.util.Iterator;
import modelo.Venda;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Bruno
 */
public class VendaDS implements JRDataSource {

    private final Iterator<Venda> iterator;
    private Venda selecionado;

    public VendaDS(ArrayList<Venda> lista) {
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
//        if ("produto".equals(jrf.getName())) {
//            return selecionado.;
//        }
//        if ("comprador".equals(jrf.getName())) {
//            return selecionado.getComprador();
//        }
//        if ("cidade".equals(jrf.getName())) {
//            return selecionado.getCidade();
//        }
//        if ("valorImovel".equals(jrf.getName())) {
//            return selecionado.getValorImovel();
//        }
//        if ("valorVenda".equals(jrf.getName())) {
//            return selecionado.getValorVenda();
//        }
//        
        return "Erro ao Gerar Relatório!";
//
    }
}
