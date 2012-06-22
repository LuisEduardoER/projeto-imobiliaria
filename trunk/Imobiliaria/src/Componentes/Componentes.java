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
    
        public JButton criaBotaoExcluir() {
        JButton jbExcluir = new JButton();
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/delete_16x16.png"))); 
        jbExcluir.setText("Excluir");
        jbExcluir.setToolTipText("Remove um cadastro que não esteja sendo utilizado! (F5)");
        return jbExcluir;
    }
        public JButton criaBotaoBuscar() {
        JButton jbBuscar = new JButton();
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search_16x16.png"))); 
        jbBuscar.setText("Procurar");
        jbBuscar.setToolTipText("Localiza um cadastro com base nas informações do campo buscar! (F2)");
        return jbBuscar;
    }
    
}
