/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import Componentes.Componentes;
import controller.FornecedorController;
import controller.Mensagens;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Fornecedor;
import persistencia.exceptions.NonexistentEntityException;
import util.ValidaCNPJ;

/**
 *
 * @author Bruno
 */
public class CadastroFornecedor extends javax.swing.JDialog {

    /**
     * Creates new form CadastroFornecedor
     */
    Componentes c = new Componentes();
    JButton jbGravar;
    JButton jbBuscar;
    JButton jbExcluir;
    Mensagens m;
    FornecedorController fornecedorController;
    String cnpj;
    Fornecedor fornecedor;

    public CadastroFornecedor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jbGravar = c.criaBotaoGravar();
        jbBuscar = c.criaBotaoBuscar();
        jbExcluir = c.criaBotaoExcluir();

        jbGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGravarActionPerformed(evt);
            }
        });

        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jpControles.add(jbBuscar);
        jpControles.add(jbExcluir);
        jpControles.add(jbGravar);
//jcbCNPJ.getToolkit().

    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtfFornecedorNome = new javax.swing.JTextField();
        jcbFornecedorCNPJ = new javax.swing.JComboBox();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Fornecedores");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Fornecedor"));

        jPanel2.setLayout(new java.awt.GridLayout(2, 1, 2, 13));

        jLabel1.setText("Nome:");
        jPanel2.add(jLabel1);

        jLabel2.setText("CNPJ:");
        jPanel2.add(jLabel2);

        jPanel3.setLayout(new java.awt.GridLayout(2, 0, 3, 8));
        jPanel3.add(jtfFornecedorNome);

        jcbFornecedorCNPJ.setEditable(true);
        jcbFornecedorCNPJ.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFornecedorCNPJItemStateChanged(evt);
            }
        });
        jPanel3.add(jcbFornecedorCNPJ);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpControles.setLayout(new java.awt.GridLayout(1, 3, 3, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-167)/2, 416, 167);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbFornecedorCNPJItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFornecedorCNPJItemStateChanged
        try {
            Fornecedor f = (Fornecedor) jcbFornecedorCNPJ.getSelectedItem();
            if (null != f) {
                jtfFornecedorNome.setText(f.getFornecedorNome());
            }
        } catch (ClassCastException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jcbFornecedorCNPJItemStateChanged

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (fornecedor != null) {
            if (fornecedor.getFornecedorId() != 0) {
                if (m.jopDeletar("Deseja realmente excluir este fornecedor ?") == JOptionPane.YES_OPTION) {
                    acaoRemover();
                }
            } else {
                m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
            }
        } else {
            m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
        }
    }

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoBuscar();
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroFornecedor dialog = new CadastroFornecedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox jcbFornecedorCNPJ;
    private javax.swing.JPanel jpControles;
    private javax.swing.JTextField jtfFornecedorNome;
    // End of variables declaration//GEN-END:variables

    private void acaoGravar() {
        m = new Mensagens();
        if (null != jcbFornecedorCNPJ.getSelectedItem() && !jtfFornecedorNome.getText().equals("")) {
            String cnpj = jcbFornecedorCNPJ.getSelectedItem().toString();
            ValidaCNPJ validador = new ValidaCNPJ();
            if (validador.isCNPJ(cnpj)) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setFornecedorCNPJ(cnpj);
                fornecedor.setFornecedorNome(jtfFornecedorNome.getText());
                fornecedorController = new FornecedorController();
                if (fornecedorController.gravar(fornecedor) != null) {
                    m.jopAviso("Gravado com sucesso!");
                    limparTela();
                }
            } else {
                m.jopAviso("CNPJ inválido.");
            }
        } else {
            m.jopAlerta("Todos os campos são obrigatórios.");
        }
    }

    private void limparTela() {
        jtfFornecedorNome.setText("");
        jcbFornecedorCNPJ.removeAll();
    }

    private boolean acaoBuscar() {
        try {
            if (jcbFornecedorCNPJ.getSelectedItem() != null) {
                if (!jcbFornecedorCNPJ.getSelectedItem().toString().equals("")) {


                    fornecedorController = new FornecedorController();
                    String s = jcbFornecedorCNPJ.getSelectedItem().toString();
                    DefaultComboBoxModel dcbm = fornecedorController.buscar("fornecedorCNPJ", s);

                    if (dcbm != null) {
                        jcbFornecedorCNPJ.setModel(dcbm);

                        if (jcbFornecedorCNPJ.getItemCount() >= 1) {
                            jcbFornecedorCNPJ.setSelectedIndex(-1);
                            jcbFornecedorCNPJ.setSelectedIndex(0);
                            fornecedor = (Fornecedor) jcbFornecedorCNPJ.getSelectedItem();
                            return true;
                        } else {
                            m = new Mensagens();
                            m.jopAviso("Nenhum fabricante encontrado.");
                            return false;
                        }
                    } else {
                        m = new Mensagens();
                        m.jopAviso("Nenhum fabricante encontrado.");
                        return false;
                    }
                } else if (!jtfFornecedorNome.getText().equals("")) {
                    fornecedorController = new FornecedorController();

                    DefaultComboBoxModel dcbm = fornecedorController.buscar("fornecedorNome", jtfFornecedorNome.getText());

                    if (dcbm != null) {
                        jcbFornecedorCNPJ.setModel(dcbm);

                        if (jcbFornecedorCNPJ.getItemCount() >= 1) {
                            jcbFornecedorCNPJ.setSelectedIndex(-1);
                            jcbFornecedorCNPJ.setSelectedIndex(0);
                            fornecedor = (Fornecedor) jcbFornecedorCNPJ.getSelectedItem();
                            return true;
                        } else {
                            m = new Mensagens();
                            m.jopAviso("Nenhum fornecedor encontrado.");
                            fornecedor = null;
                            fornecedorController = null;
                            return false;
                        }

                    } else {
                        m = new Mensagens();
                        m.jopAviso("É nescessário informar o CNPJ ou o nome do fornecedor para efetuar uma busca.");
                        fornecedor = null;
                        fornecedorController = null;
                        return false;
                    }
                } else {
                    m = new Mensagens();
                    m.jopAviso("É nescessário informar o CNPJ ou o nome do fornecedor para efetuar uma busca.");
                    fornecedor = null;
                    fornecedorController = null;
                    return false;
                }
            } else if (!jtfFornecedorNome.getText().equals("")) {
                fornecedorController = new FornecedorController();

                DefaultComboBoxModel dcbm = fornecedorController.listByField("fornecedorNome", jtfFornecedorNome.getText());

                if (dcbm != null) {
                    jcbFornecedorCNPJ.setModel(dcbm);

                    if (jcbFornecedorCNPJ.getItemCount() >= 1) {
                        jcbFornecedorCNPJ.setSelectedIndex(-1);
                        jcbFornecedorCNPJ.setSelectedIndex(0);
                        fornecedor = (Fornecedor) jcbFornecedorCNPJ.getSelectedItem();
                        return true;
                    } else {
                        m = new Mensagens();
                        m.jopAviso("Nenhum fornecedor encontrado.");
                        fornecedor = null;
                        fornecedorController = null;
                        return false;
                    }

                } else {
                    m = new Mensagens();
                    m.jopAviso("É nescessário informar o CNPJ ou o nome do fornecedor para efetuar uma busca.");
                    fornecedor = null;
                    fornecedorController = null;
                    return false;
                }
            } else {
                m = new Mensagens();
                m.jopAviso("É nescessário informar o CNPJ ou o nome do fornecedor para efetuar uma busca.");
                fornecedor = null;
                fornecedorController = null;
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroFabricante.class.getName()).log(Level.SEVERE, null, ex + "\n É nescessário informar o CNPJ ou o nome do fornecedor para efetuar uma busca.");
            m = new Mensagens();
            m.jopAlerta("É nescessário informar o CNPJ ou o nome do fornecedor para efetuar uma busca.");
            return false;
        }
    }

    private void acaoRemover() {
        fornecedorController = new FornecedorController();

        if (fornecedor != null) {
            if (fornecedor.getFornecedorId() != 0) {
                try {
                    fornecedorController.setDeleted(fornecedor);
                    fornecedor = null;
                    limparTela();
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(CadastroFabricante.class.getName()).log(Level.SEVERE, null, ex + "\n Este registro não existe mais em sua base de dados.\n");
                    m.jopAlerta("Este registro não existe mais em sua base de dados.");
                } catch (Exception ex) {
                    Logger.getLogger(CadastroFabricante.class.getName()).log(Level.SEVERE, null, "\n" + ex);
                    m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
                }
            } else {
                m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
            }
        } else {
            m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
        }
    }
}
