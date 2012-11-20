/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.JOptionPane;

/**
 *
 * @author Cleber
 */
public class Mensagens {


    public void jopAlerta(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void jopError(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void jopAviso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso do sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    public int jopDeletar(String mensagem) {
        int resposta = JOptionPane.showConfirmDialog(null, mensagem, "Cuidado", JOptionPane.YES_NO_OPTION);
        return resposta;
    }
   }
