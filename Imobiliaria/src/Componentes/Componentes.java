package Componentes;


import javax.swing.JButton;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Bruno
 */
public class Componentes {

    public JButton criaBotaoGravar() {
        JButton jbGravar = new JButton();
        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/save_16x16.png"))); 
        jbGravar.setText("Gravar");
        jbGravar.setToolTipText("Insere um novo embutido! (F3)");
        return jbGravar;
    }
}
