/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import Modelo.ImovelN;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Bruno
 */
public class ImovelNDS implements JRDataSource{
         private final Iterator<ImovelN> iterator;
    private ImovelN selecionado;

    public ImovelNDS(ArrayList<ImovelN> lista) {
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

        if ("fNumero".equals(jrf.getName())) {
            return selecionado.getNumero();
        }
        if ("fTamnho".equals(jrf.getName())) {
            return selecionado.getTamanho();
        }
        if ("fValor".equals(jrf.getName())) {
            return selecionado.getValor();
        }
        if ("fRua".equals(jrf.getName())) {
            return selecionado.getRua();
        }
        if ("fBairro".equals(jrf.getName())) {
            return selecionado.getBairro();
        }
        if ("fCidade".equals(jrf.getName())) {
            return selecionado.getCidade();
        }
            return "Erro ao Gerar Relatório!";
        
    }
}
