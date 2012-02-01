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

    public void jopAlerta(String mensagen) {
        JOptionPane.showMessageDialog(null, mensagen, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    public void jopError(String mensagen) {
        JOptionPane.showMessageDialog(null, mensagen, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public void jopAviso(String mensagen) {
        JOptionPane.showMessageDialog(null, mensagen, "Aviso do sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    public int jopDeletar(String mensagen) {
        int resposta = JOptionPane.showConfirmDialog(null, mensagen, "Deseja realmente apargar?", JOptionPane.YES_NO_OPTION);
        return resposta;
    }
    
    

    public static void main(String args[]) {
        String teste = "minha nossa senhora";
        Mensagens app = new Mensagens();
        app.jopAlerta(teste);
        app.jopError(teste);
        app.jopAviso(teste);
        int x = app.jopDeletar(teste);
        System.out.println(x);
    }
}
