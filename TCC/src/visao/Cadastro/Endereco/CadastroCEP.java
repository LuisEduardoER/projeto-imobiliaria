/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Cadastro.Endereco;

import Componentes.Componentes;
import controller.Cadastro.Endereco.BairroController;
import controller.Cadastro.Endereco.CepController;
import controller.Cadastro.Endereco.CidadeController;
import controller.Cadastro.Endereco.EstadoController;
import controller.Cadastro.Endereco.PaisController;
import controller.Cadastro.Endereco.RuaController;
import controller.Mensagens;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Endereco.Bairro;
import modelo.Endereco.Cep;
import modelo.Endereco.Cidade;
import modelo.Endereco.Estado;
import modelo.Endereco.Pais;
import modelo.Endereco.Rua;

/**
 *
 * @author Bruno
 */
public class CadastroCEP extends javax.swing.JDialog {

    /**
     * Creates new form CadastroCEP
     */
    Componentes c = new Componentes();
    Mensagens m;
    JButton jbGravar = c.criaBotaoGravar();
    JButton jbExcluir = c.criaBotaoExcluir();
    EstadoController estadoController;
    PaisController paisController;
    CidadeController cidadeController;
    BairroController bairroController;
    CepController cepController;
    RuaController ruaController;
    Pais p;
    Estado estado;
    Cidade cidade;
    Bairro bairro;
    Cep cep;

    public CadastroCEP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jtfCEP.requestFocus();
        paisController = new PaisController();
        estadoController = new EstadoController();
        bairroController = new BairroController();
        ruaController = new RuaController();
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
            jcbBairro.setModel(bairroController.listBairroByCidade(cidade.getCidade()));
            jcbBairro.updateUI();
        }
        
        if ((Bairro) jcbBairro.getSelectedItem() != null) {
            bairro = (Bairro) jcbBairro.getSelectedItem();
            jcbRua.setModel(ruaController.listRuaByBairro(bairro.getBairroId()));
            jcbRua.updateUI();
        }

        jpControles.add(jbExcluir);
        jpControles.add(jbGravar);

    }

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (p != null) {
            if (p.getPaisID() != 0) {
                if (m.jopDeletar("Deseja realmente excluir este Pais ?") == JOptionPane.YES_OPTION) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcbPais = new javax.swing.JComboBox();
        jcbEstados = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox();
        jcbBairro = new javax.swing.JComboBox();
        jcbRua = new javax.swing.JComboBox();
        jtfCEP = new javax.swing.JTextField();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de CEP");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Pais:");

        jLabel2.setText("Estado:");

        jLabel3.setText("Cidade:");

        jLabel4.setText("Bairro:");

        jLabel5.setText("Rua:");

        jLabel6.setText("CEP:");

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
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbRua, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbBairro, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbEstados, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbPais, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE)
                    .addComponent(jtfCEP))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpControles.setLayout(new java.awt.GridLayout(1, 0, 2, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(214, 214, 214)
                    .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-430)/2, (screenSize.height-317)/2, 430, 317);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCEP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroCEP dialog = new CadastroCEP(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox jcbBairro;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbEstados;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JComboBox jcbRua;
    private javax.swing.JPanel jpControles;
    private javax.swing.JTextField jtfCEP;
    // End of variables declaration//GEN-END:variables

    private void acaoGravar() {
        String avisos = "";
        Pais p = (Pais) jcbPais.getSelectedItem();
        Estado esta = (Estado) jcbEstados.getSelectedItem();
        Cidade cida = (Cidade) jcbCidade.getSelectedItem();
        Bairro bairro = (Bairro) jcbBairro.getSelectedItem();
        Rua rua = (Rua) jcbRua.getSelectedItem();

        if (p.getPaisID() == null) {
            avisos = avisos + "Pais não pode ser vazio \n";
        }

        if (esta.getEstadoId() == null) {
            avisos = avisos + "Estado não pode ser vazio \n";
        }

        if (cida.getCidade() == null) {
            avisos = avisos + "Cidade não pode ser vazio \n";
        }

        if (bairro.getBairroId() == null) {
            avisos = avisos + "Bairro não pode ser vazio \n";
        }

        if (rua.getRuaId() == null) {
            avisos = avisos + "Rua não pode ser vazio \n";
        }

        if (jtfCEP.getText().equals("")) {
            avisos = avisos + "\n CEP não pode ser vazio";
        }
        
        if (avisos.equals("")) {
            cepController = new CepController();
            cep = new Cep();

            esta.setPaisId(p);
            cida.setEstadoId(esta);
            bairro.setCidadeId(cida);
            rua.setBairroID(bairro);

            cep.setRuaID(rua);
            cep.setCep(new Integer(jtfCEP.getText()));

            cep = cepController.gravar(cep);

            if (cep.getCepID() != null) {
                m = new Mensagens();
                m.jopAviso("Cep " + cep.getCep() + " - ID: " + cep.getCepID() + " gravado com sucesso!");
            }
        } else {
            m = new Mensagens();
            m.jopAlerta("O(s) campo(s) " + avisos + "não pode(m) ser vazio(s)!");
            jtfCEP.requestFocus();
        }
    }
}
