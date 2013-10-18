/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Cadastro.Endereco;

import Componentes.Componentes;
import controller.Cadastro.Endereco.BairroController;
import controller.Cadastro.Endereco.CidadeController;
import controller.Cadastro.Endereco.EstadoController;
import controller.Cadastro.Endereco.PaisController;
import controller.Mensagens;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Endereco.Bairro;
import modelo.Endereco.Cidade;
import modelo.Endereco.Estado;
import modelo.Endereco.Pais;

/**
 *
 * @author Bruno
 */
public class CadastroBairro extends javax.swing.JDialog {

    /**
     * Creates new form CadastroBairro
     */
    Componentes c = new Componentes();
    Mensagens m;
    JButton jbGravar = c.criaBotaoGravar();
    JButton jbExcluir = c.criaBotaoExcluir();
    EstadoController estadoController;
    PaisController paisController;
    CidadeController cidadeController;
    BairroController bairroController;
    Pais p;
    Estado estado;
    Cidade cidade;
    Bairro bairro;

    public CadastroBairro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jtfBairro.requestFocus();
        paisController = new PaisController();
        estadoController = new EstadoController();
        bairroController = new BairroController();
        jbGravar = c.criaBotaoGravar();
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

        jcbPais.setModel(paisController.listPaises());
        jcbPais.updateUI();

        jcbEstados.setModel(estadoController.listEstados());
        jcbEstados.updateUI();

        if ((Estado) jcbEstados.getSelectedItem() != null) {
            cidadeController = new CidadeController();
            jcbCidade.setModel(cidadeController.listCidadesByEstado(((Estado) jcbEstados.getSelectedItem()).getEstadoId()));
            jcbCidade.updateUI();
        }
        
        if ((Cidade) jcbCidade.getSelectedItem() != null) {
            cidade = (Cidade) jcbCidade.getSelectedItem();
            jcbCidade.setModel(cidadeController.listCidadesByEstado(cidade.getCidade()));
            jcbCidade.updateUI();
        }
        
        jpControles.add(jbExcluir);
        jpControles.add(jbGravar);

    }

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (estado != null) {
            if (estado.getEstadoId() != 0) {
                if (m.jopDeletar("Deseja realmente excluir este Estado ?") == JOptionPane.YES_OPTION) {
//                    acaoRemover();
                }
            } else {
                m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
            }
        } else {
            m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcbPais = new javax.swing.JComboBox();
        jcbEstados = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox();
        jtfBairro = new javax.swing.JTextField();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Pais:");

        jLabel2.setText("Estado:");

        jLabel3.setText("Cidade:");

        jLabel4.setText("Bairro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPaisItemStateChanged(evt);
            }
        });

        jcbEstados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPais, 0, 297, Short.MAX_VALUE)
                    .addComponent(jcbEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfBairro)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jpControles.setLayout(new java.awt.GridLayout(1, 0, 2, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-430)/2, (screenSize.height-272)/2, 430, 272);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEstadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadosItemStateChanged
        estado = (Estado) jcbEstados.getSelectedItem();
        jcbCidade.setModel(cidadeController.listCidadesByEstado(estado.getEstadoId()));
        jcbCidade.updateUI();
    }//GEN-LAST:event_jcbEstadosItemStateChanged

    private void jcbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPaisItemStateChanged
        p = (Pais) jcbPais.getSelectedItem();
        jcbEstados.setModel(estadoController.listEstadosByPais(p.getPaisID()));
        jcbEstados.updateUI();
    }//GEN-LAST:event_jcbPaisItemStateChanged

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
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroBairro dialog = new CadastroBairro(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbEstados;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JPanel jpControles;
    private javax.swing.JTextField jtfBairro;
    // End of variables declaration//GEN-END:variables

    private void acaoGravar() {
        String avisos = "";
        Pais p = (Pais) jcbPais.getSelectedItem();
        estado = (Estado) jcbEstados.getSelectedItem();
        cidade = (Cidade) jcbCidade.getSelectedItem();

        if (p.getPaisID() == null) {
            avisos = avisos + "\n Pais não pode ser vazio";
        }

        if (estado == null || estado.getEstadoId() == null) {
            avisos = avisos + "\n Estado não pode ser vazio";
        }

        if (cidade == null || cidade.getCidade() == null) {
            avisos = avisos + "\n Cidade não pode ser vazio";
        }

        if (jtfBairro.getText().equals("")) {
            avisos = avisos + "\n Nome do bairro não pode ser vazio";
        }

        if (avisos.equals("")) {
            bairroController = new BairroController();
            bairro = new Bairro();

            estado.setPaisId(p);
            cidade.setEstadoId(estado);
            bairro.setCidadeId(cidade);

            bairro.setBairroNome(jtfBairro.getText());
            bairro = bairroController.gravar(bairro);

            if (bairro.getBairroId() != null) {
                m = new Mensagens();
                m.jopAviso("Bairro " + bairro.getBairroNome() + " - ID: " + bairro.getBairroId() + " gravado com sucesso!");
            }
        } else {
            m = new Mensagens();
            m.jopAlerta("Verifique: " + avisos);
            jtfBairro.requestFocus();
        }
    }
}
