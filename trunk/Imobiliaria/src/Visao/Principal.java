/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Bruno
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        jmCadastro.setVerticalTextPosition(SwingConstants.BOTTOM);
        jmCadastro.setHorizontalTextPosition(SwingConstants.CENTER);

        jmConfiguracoes.setVerticalTextPosition(SwingConstants.BOTTOM);
        jmConfiguracoes.setHorizontalTextPosition(SwingConstants.CENTER);
    }        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmbBarraMenu = new javax.swing.JMenuBar();
        jmCadastro = new javax.swing.JMenu();
        jmiImovel = new javax.swing.JMenuItem();
        jmComplementares = new javax.swing.JMenu();
        jmiEmbutidos = new javax.swing.JMenuItem();
        jmConfiguracoes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Imob");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jmCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/Cadastro_64x64.png"))); // NOI18N
        jmCadastro.setText("Cadastro");

        jmiImovel.setText("Imóvel");
        jmiImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImovelActionPerformed(evt);
            }
        });
        jmCadastro.add(jmiImovel);

        jmComplementares.setText("Complementares");

        jmiEmbutidos.setText("Embutidos");
        jmiEmbutidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmbutidosActionPerformed(evt);
            }
        });
        jmComplementares.add(jmiEmbutidos);

        jmCadastro.add(jmComplementares);

        jmbBarraMenu.add(jmCadastro);

        jmConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/Cofigure_64x64.png"))); // NOI18N
        jmConfiguracoes.setText("Configurações");

        jMenuItem1.setText("Conexão");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmConfiguracoes.add(jMenuItem1);

        jmbBarraMenu.add(jmConfiguracoes);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 704, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-720)/2, (screenSize.height-338)/2, 720, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImovelActionPerformed
        CadastroImovel cI = new CadastroImovel();
        cI.setVisible(true);
    }//GEN-LAST:event_jmiImovelActionPerformed

    private void jmiEmbutidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmbutidosActionPerformed
        dCadastroEmbutido cE = new dCadastroEmbutido(this, rootPaneCheckingEnabled);
        cE.setVisible(true);

    }//GEN-LAST:event_jmiEmbutidosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ConexaoTela c = new ConexaoTela();
        c.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmCadastro;
    private javax.swing.JMenu jmComplementares;
    private javax.swing.JMenu jmConfiguracoes;
    private javax.swing.JMenuBar jmbBarraMenu;
    private javax.swing.JMenuItem jmiEmbutidos;
    private javax.swing.JMenuItem jmiImovel;
    // End of variables declaration//GEN-END:variables


}
