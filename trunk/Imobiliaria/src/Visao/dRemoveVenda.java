/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorVenda;
import Controlador.Mensagens;
import DAO.VendaDAO;
import Modelo.Venda;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class dRemoveVenda extends javax.swing.JDialog {

    /**
     * Creates new form dRemoveVenda
     */
    Componentes c;
    JButton jbRemover;
    ControladorVenda controladorVenda;
    Mensagens m;
    Venda venda;

    public dRemoveVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        c = new Componentes();
        jbRemover = c.criaBotaoRemover();



        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jpComponentes.add(jbRemover);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jcbBuscarNumero = new javax.swing.JComboBox();
        jlBuscarRua = new javax.swing.JLabel();
        jlBuscarCidade = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpComponentes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Imóvel"));

        jPanel2.setLayout(new java.awt.GridLayout(3, 1, 8, 8));

        jcbBuscarNumero.setEditable(true);
        jcbBuscarNumero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBuscarNumeroItemStateChanged(evt);
            }
        });
        jPanel2.add(jcbBuscarNumero);

        jlBuscarRua.setText("Rua");
        jPanel2.add(jlBuscarRua);

        jlBuscarCidade.setText("Cidade");
        jPanel2.add(jlBuscarCidade);

        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 8, 8));

        jLabel1.setText("Numero:");
        jPanel1.add(jLabel1);

        jLabel2.setText("Rua:");
        jPanel1.add(jLabel2);

        jLabel3.setText("Cidade:");
        jPanel1.add(jLabel3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jpComponentes.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpComponentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-189)/2, 416, 189);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbBuscarNumeroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBuscarNumeroItemStateChanged
        acaoBuscar();
    }//GEN-LAST:event_jcbBuscarNumeroItemStateChanged

    /**
     * @param args the command line arguments
     */
    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (m.jopDeletar("Deseja realmente excluir este imovel") == JOptionPane.YES_OPTION) {
            acaoRemover();
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dRemoveVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dRemoveVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dRemoveVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dRemoveVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dRemoveVenda dialog = new dRemoveVenda(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox jcbBuscarNumero;
    private javax.swing.JLabel jlBuscarCidade;
    private javax.swing.JLabel jlBuscarRua;
    private javax.swing.JPanel jpComponentes;
    // End of variables declaration//GEN-END:variables

    private void acaoRemover() {

        if (acaoBuscar()) {
            controladorVenda = new VendaDAO();
            venda = (Venda) jcbBuscarNumero.getSelectedItem();
            controladorVenda.removeVenda(venda);
            m.jopAviso("Venda removida.");
        }
        limparTela();
    }

    private void limparTela() {
        jcbBuscarNumero.setSelectedIndex(-1);
        jlBuscarCidade.setText("");
        jlBuscarRua.setText("");
    }

    private boolean acaoBuscar() {
        venda = new Venda();
//        reabilita = (ReabilitaImovelModel) jcbNumero.getSelectedItem();
        venda.setImovelNumero(Integer.parseInt(jcbBuscarNumero.getSelectedItem().toString()));
        controladorVenda = new VendaDAO();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        dcbm = controladorVenda.buscaVenda(venda);

        if (dcbm.getSize() > 0) {
            jcbBuscarNumero.setModel(dcbm);
            montarTela((Venda) jcbBuscarNumero.getSelectedItem());
            return true;
        } else {
            m = new Mensagens();
            m.jopAviso("Nenhum imóvel vendido com este número encontrado. \n"
                    + "Número informado: " + jcbBuscarNumero.getSelectedItem().toString());
            return false;
        }
    }

    public void montarTela(Venda venda) {
        jlBuscarCidade.setText(venda.getCidade());
        jlBuscarRua.setText(venda.getRua());
    }
}
