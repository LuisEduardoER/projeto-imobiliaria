/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Embutido;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class Pesquisas {

    Mensagens mensagem;

    public DefaultComboBoxModel pesquisaEmbutido(Embutido e) {
        mensagem = new Mensagens();
        ControladorPesquisarBanco controladorPesquisar = new ControladorPesquisarBanco();

        DefaultComboBoxModel resultado = controladorPesquisar.pesquisarEmbutido(e);

        if (resultado != null) {
            return resultado;
        } else {
            int x = JOptionPane.showConfirmDialog(null, "Nenhum registro foi encontrado,\nDeseja cadastrar um novo embutido com este nome?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (x == JOptionPane.YES_OPTION) {  //verificar, caso responda não gera exceção!
                ControladorIncluirBanco gravar = new ControladorIncluirBanco();
                if (gravar.gravarEmbutido(e)) {
                    mensagem.jopAviso("Embutido " + e.getDescricao() + " incluído com sucesso!");
                    e.setDescricao("%");
                    pesquisaEmbutido(e);
                    return resultado;
                }
                return resultado;
            } else {
                e.setDescricao("%");
                resultado = controladorPesquisar.pesquisarEmbutido(e);
                return resultado;
            }
        }

    }

    public DefaultComboBoxModel carregaTelaPesq(Embutido e) {
        ControladorPesquisarBanco controladorPesquisar = new ControladorPesquisarBanco();
        DefaultComboBoxModel resultado = controladorPesquisar.pesquisarEmbutido(e);

        return resultado;
    }
}
