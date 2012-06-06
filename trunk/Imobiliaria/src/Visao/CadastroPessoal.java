/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.CarregaEndereco;
import Modelo.*;
import java.awt.event.ItemEvent;
import javax.swing.JButton;

/**
 *
 * @author Bruno
 */
public class CadastroPessoal extends javax.swing.JDialog {

    CarregaEndereco carregaEndereco = new CarregaEndereco();
    Componentes c = new Componentes();
    JButton botaoGravar;

    /**
     * Creates new form CadastroPessoal
     */
    public CadastroPessoal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        botaoGravar = c.criaBotaoGravar();


        botaoGravar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGravarActionPerformed(evt);
            }
        });

        jpControles.add(c.criaBotaoGravar());

        jcbPais.setModel(carregaEndereco.carregaPais());
        jcbPais.setSelectedIndex(0);

        jcbEstado.setModel(carregaEndereco.carregaEstado((Pais) jcbPais.getSelectedItem()));
        jcbEstado.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpAbas = new javax.swing.JTabbedPane();
        jpPessoal = new javax.swing.JPanel();
        jspPainelRolagem = new javax.swing.JScrollPane();
        jpAgrupador = new javax.swing.JPanel();
        jpCadastro = new javax.swing.JPanel();
        jtfBuscar = new javax.swing.JTextField();
        jlBuscar = new javax.swing.JLabel();
        jlCadastro = new javax.swing.JLabel();
        jlCadastroNmr = new javax.swing.JLabel();
        jpDadosPrincipais = new javax.swing.JPanel();
        jpLabelsDP = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        jlRG = new javax.swing.JLabel();
        jlCPF_CNPJ = new javax.swing.JLabel();
        jpTextFieldsDP = new javax.swing.JPanel();
        jtfCPF_CNPJ = new javax.swing.JTextField();
        jtfRG = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jpEndereco = new javax.swing.JPanel();
        jpLabelsE = new javax.swing.JPanel();
        jlPais = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlLogradouro = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlCEP_ZIP = new javax.swing.JLabel();
        jlComplemento = new javax.swing.JLabel();
        jpTextFieldsE = new javax.swing.JPanel();
        jcbPais = new javax.swing.JComboBox();
        jcbEstado = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox();
        jcbBairro = new javax.swing.JComboBox();
        jcbLogradouro = new javax.swing.JComboBox();
        jtfNumero = new javax.swing.JTextField();
        jcbCEP_ZIP = new javax.swing.JComboBox();
        jtfComplemento = new javax.swing.JTextField();
        jpControles = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jpDadosFuncionario = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtpAbas.setPreferredSize(new java.awt.Dimension(400, 600));

        jspPainelRolagem.setBorder(null);

        jlBuscar.setText("Buscar:");

        jlCadastro.setText("Cadastro:");

        javax.swing.GroupLayout jpCadastroLayout = new javax.swing.GroupLayout(jpCadastro);
        jpCadastro.setLayout(jpCadastroLayout);
        jpCadastroLayout.setHorizontalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlCadastroNmr)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpCadastroLayout.setVerticalGroup(
            jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBuscar)
                    .addComponent(jlCadastro)
                    .addComponent(jlCadastroNmr))
                .addContainerGap())
        );

        jpDadosPrincipais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Principais"));

        jpLabelsDP.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        jlNome.setText("Nome:");
        jpLabelsDP.add(jlNome);

        jlRG.setText("RG:");
        jpLabelsDP.add(jlRG);

        jlCPF_CNPJ.setText("CPF/CNPJ:");
        jpLabelsDP.add(jlCPF_CNPJ);

        jpTextFieldsDP.setLayout(new java.awt.GridLayout(3, 1, 0, 5));
        jpTextFieldsDP.add(jtfCPF_CNPJ);
        jpTextFieldsDP.add(jtfRG);
        jpTextFieldsDP.add(jtfNome);

        javax.swing.GroupLayout jpDadosPrincipaisLayout = new javax.swing.GroupLayout(jpDadosPrincipais);
        jpDadosPrincipais.setLayout(jpDadosPrincipaisLayout);
        jpDadosPrincipaisLayout.setHorizontalGroup(
            jpDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPrincipaisLayout.createSequentialGroup()
                .addComponent(jpLabelsDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpTextFieldsDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDadosPrincipaisLayout.setVerticalGroup(
            jpDadosPrincipaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLabelsDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpTextFieldsDP, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jpLabelsE.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        jlPais.setText("País:");
        jpLabelsE.add(jlPais);

        jlEstado.setText("Estado:");
        jpLabelsE.add(jlEstado);

        jlCidade.setText("Cidade:");
        jpLabelsE.add(jlCidade);

        jLabel1.setText("Bairro:");
        jpLabelsE.add(jLabel1);

        jlLogradouro.setText("Logradouro:");
        jpLabelsE.add(jlLogradouro);

        jlNumero.setText("Número:");
        jpLabelsE.add(jlNumero);

        jlCEP_ZIP.setText("CEP/ZIP:");
        jpLabelsE.add(jlCEP_ZIP);

        jlComplemento.setText("Complemento:");
        jpLabelsE.add(jlComplemento);

        jpTextFieldsE.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        jcbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPaisItemStateChanged(evt);
            }
        });
        jpTextFieldsE.add(jcbPais);

        jcbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoItemStateChanged(evt);
            }
        });
        jpTextFieldsE.add(jcbEstado);

        jcbCidade.setEnabled(false);
        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });
        jpTextFieldsE.add(jcbCidade);

        jcbBairro.setEnabled(false);
        jcbBairro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBairroItemStateChanged(evt);
            }
        });
        jpTextFieldsE.add(jcbBairro);

        jcbLogradouro.setEnabled(false);
        jcbLogradouro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbLogradouroItemStateChanged(evt);
            }
        });
        jpTextFieldsE.add(jcbLogradouro);
        jpTextFieldsE.add(jtfNumero);

        jcbCEP_ZIP.setEnabled(false);
        jcbCEP_ZIP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCEP_ZIPItemStateChanged(evt);
            }
        });
        jpTextFieldsE.add(jcbCEP_ZIP);
        jpTextFieldsE.add(jtfComplemento);

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addComponent(jpLabelsE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTextFieldsE, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLabelsE, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
            .addComponent(jpTextFieldsE, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpAgrupadorLayout = new javax.swing.GroupLayout(jpAgrupador);
        jpAgrupador.setLayout(jpAgrupadorLayout);
        jpAgrupadorLayout.setHorizontalGroup(
            jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgrupadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpEndereco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDadosPrincipais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpAgrupadorLayout.setVerticalGroup(
            jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgrupadorLayout.createSequentialGroup()
                .addComponent(jpCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpDadosPrincipais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(321, Short.MAX_VALUE))
        );

        jspPainelRolagem.setViewportView(jpAgrupador);

        jpControles.setLayout(new javax.swing.BoxLayout(jpControles, javax.swing.BoxLayout.LINE_AXIS));
        jpControles.add(filler1);
        jpControles.add(filler2);
        jpControles.add(filler3);
        jpControles.add(filler4);
        jpControles.add(filler5);

        javax.swing.GroupLayout jpPessoalLayout = new javax.swing.GroupLayout(jpPessoal);
        jpPessoal.setLayout(jpPessoalLayout);
        jpPessoalLayout.setHorizontalGroup(
            jpPessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspPainelRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addGroup(jpPessoalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpPessoalLayout.setVerticalGroup(
            jpPessoalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPessoalLayout.createSequentialGroup()
                .addComponent(jspPainelRolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtpAbas.addTab("Dados da Pessoa", jpPessoal);

        javax.swing.GroupLayout jpDadosFuncionarioLayout = new javax.swing.GroupLayout(jpDadosFuncionario);
        jpDadosFuncionario.setLayout(jpDadosFuncionarioLayout);
        jpDadosFuncionarioLayout.setHorizontalGroup(
            jpDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );
        jpDadosFuncionarioLayout.setVerticalGroup(
            jpDadosFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        jtpAbas.addTab("Dados do Funcionário", jpDadosFuncionario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        jtpAbas.getAccessibleContext().setAccessibleName("Dados Principais");
        jtpAbas.getAccessibleContext().setAccessibleDescription("Dados Principais");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPaisItemStateChanged
    }//GEN-LAST:event_jcbPaisItemStateChanged

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            // jcbBairro.setModel(null);
            jcbBairro.setEnabled(true);
            jcbBairro.setModel(carregaEndereco.carregaBairro((Cidade) jcbCidade.getSelectedItem()));
        }
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void jcbLogradouroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbLogradouroItemStateChanged
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            //  jcbCEP_ZIP.setModel(null);
            jcbCEP_ZIP.setEnabled(true);
            jcbCEP_ZIP.setModel(carregaEndereco.carregaCEP_ZIP((Bairro) jcbBairro.getSelectedItem()));
        }
    }//GEN-LAST:event_jcbLogradouroItemStateChanged

    private void jcbCEP_ZIPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCEP_ZIPItemStateChanged
    }//GEN-LAST:event_jcbCEP_ZIPItemStateChanged

    private void jcbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            //jcbCidade.setModel(null);
            jcbCidade.setEnabled(true);
            jcbCidade.setModel(carregaEndereco.carregaCidade((Estado) jcbEstado.getSelectedItem()));
        }
    }//GEN-LAST:event_jcbEstadoItemStateChanged

    private void jcbBairroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBairroItemStateChanged
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            //jcbLogradouro.setModel(null);
            jcbLogradouro.setEnabled(true);
            jcbLogradouro.setModel(carregaEndereco.carregaEndereco((Bairro) jcbBairro.getSelectedItem()));
        }
    }//GEN-LAST:event_jcbBairroItemStateChanged

    /**
     * @param args the command line arguments
     */
    private void botaoGravarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(CadastroPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CadastroPessoal dialog = new CadastroPessoal(new javax.swing.JFrame(), true);
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
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jcbBairro;
    private javax.swing.JComboBox jcbCEP_ZIP;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JComboBox jcbLogradouro;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JLabel jlBuscar;
    private javax.swing.JLabel jlCEP_ZIP;
    private javax.swing.JLabel jlCPF_CNPJ;
    private javax.swing.JLabel jlCadastro;
    private javax.swing.JLabel jlCadastroNmr;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlLogradouro;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlPais;
    private javax.swing.JLabel jlRG;
    private javax.swing.JPanel jpAgrupador;
    private javax.swing.JPanel jpCadastro;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpDadosFuncionario;
    private javax.swing.JPanel jpDadosPrincipais;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JPanel jpLabelsDP;
    private javax.swing.JPanel jpLabelsE;
    private javax.swing.JPanel jpPessoal;
    private javax.swing.JPanel jpTextFieldsDP;
    private javax.swing.JPanel jpTextFieldsE;
    private javax.swing.JScrollPane jspPainelRolagem;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfCPF_CNPJ;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRG;
    private javax.swing.JTabbedPane jtpAbas;
    // End of variables declaration//GEN-END:variables
}
