/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroEmbutidos.java
 *
 * Created on 13/01/2012, 19:57:40
 */
package Visao;

/**
 *
 * @author Bruno
 */
public class CadastroTelhado extends javax.swing.JFrame {

    /** Creates new form CadastroEmbutidos */
    public CadastroTelhado() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCadastroTelhado = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbConcluir = new javax.swing.JButton();
        jpNome = new javax.swing.JPanel();
        jtfNome = new javax.swing.JTextField();
        jlNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Telhado");

        jpCadastroTelhado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro De Telhados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jbCancelar.setText("Cancelar");

        jbConcluir.setText("Concluir");

        jpNome.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlNome.setText("Nome:");

        javax.swing.GroupLayout jpNomeLayout = new javax.swing.GroupLayout(jpNome);
        jpNome.setLayout(jpNomeLayout);
        jpNomeLayout.setHorizontalGroup(
            jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpNomeLayout.setVerticalGroup(
            jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlNome))
        );

        javax.swing.GroupLayout jpCadastroTelhadoLayout = new javax.swing.GroupLayout(jpCadastroTelhado);
        jpCadastroTelhado.setLayout(jpCadastroTelhadoLayout);
        jpCadastroTelhadoLayout.setHorizontalGroup(
            jpCadastroTelhadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroTelhadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroTelhadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCadastroTelhadoLayout.createSequentialGroup()
                        .addComponent(jbConcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbCancelar)))
                .addContainerGap())
        );
        jpCadastroTelhadoLayout.setVerticalGroup(
            jpCadastroTelhadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroTelhadoLayout.createSequentialGroup()
                .addComponent(jpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jpCadastroTelhadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbConcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastroTelhado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastroTelhado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroTelhado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTelhado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTelhado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTelhado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroTelhado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConcluir;
    private javax.swing.JLabel jlNome;
    private javax.swing.JPanel jpCadastroTelhado;
    private javax.swing.JPanel jpNome;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables
}
