/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Modelo.ImovelN;
import Modelo.Venda;
import java.util.ArrayList;
import java.util.Iterator;
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

        if ("numero".equals(jrf.getName())) {
            return selecionado.getImovelNumero();
        }
        if ("rua".equals(jrf.getName())) {
            return selecionado.getRua();
        }
        if ("bairro".equals(jrf.getName())) {
            return selecionado.getRua();
        }
        if ("cidade".equals(jrf.getName())) {
            return selecionado.getCidade();
        }
        if ("valor".equals(jrf.getName())) {
            return selecionado.getValorVenda();
        }
        
        return "Erro ao Gerar Relatório!";

    }
}
