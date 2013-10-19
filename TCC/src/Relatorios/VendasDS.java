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
public class VendasDS implements JRDataSource {

    private final Iterator<Venda> iterator;
    private Venda selecionado;

    public VendasDS(ArrayList<Venda> lista) {
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

//        if ("numero".equals(jrf.getName())) {
//            return selecionado.getNumero();
//        }
//        if ("rua".equals(jrf.getName())) {
//            return selecionado.getRua();
//        }
//        if ("bairro".equals(jrf.getName())) {
//            return selecionado.getBairro();
//        }
//        if ("cidade".equals(jrf.getName())) {
//            return selecionado.getCidade();
//        }
//        if ("valor".equals(jrf.getName())) {
//            return selecionado.getValor();
//        }
//        if ("tamanho".equals(jrf.getName())) {
//            return selecionado.getTamanho();
//        }
        return "Erro ao Gerar Relatório!";

    }
}
