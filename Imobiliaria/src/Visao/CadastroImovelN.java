/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorImovel;
import Controlador.Mensagens;
import DAO.ImovelDAO;
import Modelo.ImovelN;
import Util.FiltrosDigitacaoLetras;
import Util.FiltrosDigitacaoNumerico;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 *
 * @author MAYCON
 */
public class CadastroImovelN extends javax.swing.JFrame {

    Componentes c = new Componentes();
    JButton jbGravar;
    JButton jbBuscar;
    JButton jbEditar;
    JButton jbCancelar;
    JButton jbExcluir;
    ImovelN imovel;
    ControladorImovel controladorImovel;
    Mensagens m;

    /**
     * Creates new form CadastroImovelN
     */
    public CadastroImovelN() {
        initComponents();

        jtfTamanho.setDocument(new FiltrosDigitacaoNumerico());
        jtfValor.setDocument(new FiltrosDigitacaoNumerico());

        jtfRua.setDocument(new FiltrosDigitacaoLetras());
        jtfBairro.setDocument(new FiltrosDigitacaoLetras());
        jtfCidade.setDocument(new FiltrosDigitacaoLetras());

        jbGravar = c.criaBotaoGravar();
        jbBuscar = c.criaBotaoBuscar();
        jbEditar = c.criaBotaoEditar();
        jbCancelar = c.criaBotaoCancelar();
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

        jpBotoes.add(jbGravar);
        jpBotoes.add(jbBuscar);
        jpBotoes.add(jbCancelar);
        jpBotoes.add(jbExcluir);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDadosImovel = new javax.swing.JPanel();
        jpLabels = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpDados = new javax.swing.JPanel();
        jtfTamanho = new javax.swing.JTextField();
        jtfValor = new javax.swing.JTextField();
        jpEnderecoImovel = new javax.swing.JPanel();
        jpLabe = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jpTextField = new javax.swing.JPanel();
        jcbNumero = new javax.swing.JComboBox();
        jtfRua = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfCidade = new javax.swing.JTextField();
        jpBotoes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Imóveis");
        setResizable(false);

        jpDadosImovel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Imovel"));

        jpLabels.setLayout(new java.awt.GridLayout(2, 1, 0, 8));

        jLabel1.setText("Tamanho");
        jpLabels.add(jLabel1);

        jLabel2.setText("Valor");
        jpLabels.add(jLabel2);

        jpDados.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jpDados.add(jtfTamanho);
        jpDados.add(jtfValor);

        javax.swing.GroupLayout jpDadosImovelLayout = new javax.swing.GroupLayout(jpDadosImovel);
        jpDadosImovel.setLayout(jpDadosImovelLayout);
        jpDadosImovelLayout.setHorizontalGroup(
            jpDadosImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosImovelLayout.createSequentialGroup()
                .addComponent(jpLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jpDadosImovelLayout.setVerticalGroup(
            jpDadosImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpLabels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpEnderecoImovel.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço Imovel"));

        jpLabe.setLayout(new java.awt.GridLayout(4, 1, 0, 10));

        jLabel4.setText("Numero");
        jpLabe.add(jLabel4);

        jLabel5.setText("Rua");
        jpLabe.add(jLabel5);

        jLabel6.setText("Bairro");
        jpLabe.add(jLabel6);

        jLabel7.setText("Cidade");
        jpLabe.add(jLabel7);

        jpTextField.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jcbNumero.setEditable(true);
        jcbNumero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNumeroItemStateChanged(evt);
            }
        });
        jpTextField.add(jcbNumero);
        jpTextField.add(jtfRua);
        jpTextField.add(jtfBairro);
        jpTextField.add(jtfCidade);

        javax.swing.GroupLayout jpEnderecoImovelLayout = new javax.swing.GroupLayout(jpEnderecoImovel);
        jpEnderecoImovel.setLayout(jpEnderecoImovelLayout);
        jpEnderecoImovelLayout.setHorizontalGroup(
            jpEnderecoImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoImovelLayout.createSequentialGroup()
                .addComponent(jpLabe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
        );
        jpEnderecoImovelLayout.setVerticalGroup(
            jpEnderecoImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLabe, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpBotoes.setLayout(new java.awt.GridLayout(1, 4, 0, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpDadosImovel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpEnderecoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpDadosImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpEnderecoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-497)/2, (screenSize.height-274)/2, 497, 274);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbNumeroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNumeroItemStateChanged
        try {
            imovel = (ImovelN) jcbNumero.getSelectedItem();
            if (null != imovel) {
                jtfTamanho.setText(imovel.getTamanho() + "");
                jtfValor.setText(imovel.getValor() + "");

                jtfRua.setText(imovel.getRua());
                jtfBairro.setText(imovel.getBairro());
                jtfCidade.setText(imovel.getCidade());
            }
        } catch (ClassCastException e) {
        }
    }//GEN-LAST:event_jcbNumeroItemStateChanged

    /**
     * @param args the command line arguments
     */
    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        acaoRemover();
    }

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoBuscar();
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
            java.util.logging.Logger.getLogger(CadastroImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroImovelN().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox jcbNumero;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpDados;
    private javax.swing.JPanel jpDadosImovel;
    private javax.swing.JPanel jpEnderecoImovel;
    private javax.swing.JPanel jpLabe;
    private javax.swing.JPanel jpLabels;
    private javax.swing.JPanel jpTextField;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfRua;
    private javax.swing.JTextField jtfTamanho;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables

    public boolean validaCampos() {
        if (((null != jcbNumero.getSelectedItem())
                && ((null != jtfBairro.getText()) && !("".equals(jtfBairro.getText())))
                && ((null != jtfCidade.getText()) && !("".equals(jtfCidade.getText())))
                && ((null != jtfRua.getText()) && !("".equals(jtfRua.getText())))
                && ((null != jtfTamanho.getText()) && !("".equals(jtfTamanho.getText())))
                && ((null != jtfValor.getText()) && !("".equals(jtfValor.getText()))))) {

            imovel = new ImovelN();

            imovel.setNumero(Integer.parseInt(jcbNumero.getSelectedItem().toString()));
            imovel.setRua(jtfRua.getText());
            imovel.setBairro(jtfBairro.getText());
            imovel.setCidade(jtfCidade.getText());
            imovel.setTamanho(Float.parseFloat(jtfTamanho.getText()));
            imovel.setValor(Float.parseFloat(jtfValor.getText()));
            imovel.setVendido(0);
            return true;
        } else {
            return false;
        }
    }

    public void acaoGravar() {
        if (validaCampos()) {

            controladorImovel = new ImovelDAO();
            boolean insereImovel = controladorImovel.insereImovel(imovel);

            if (insereImovel) {
                m = new Mensagens();
                m.jopAviso("Cadastro realizado com sucesso!");
            }

            limparTela();

        } else {
            m = new Mensagens();
            m.jopAviso("Exitem campos vazios, preencha todos os campos antes de gravar.");
        }
    }

    public void acaoAlterar() {
        if (validaCampos()) {
            controladorImovel.alterarImovel(imovel);
        }
    }

    public boolean acaoBuscar() {
        if (null != jcbNumero.getSelectedItem().toString() && !("".equals(jcbNumero.getSelectedItem().toString()))) {

            controladorImovel = new ImovelDAO();
            int i = Integer.parseInt(jcbNumero.getSelectedItem().toString());
            DefaultComboBoxModel dcbm = controladorImovel.buscaImovelNumero(i); // informar o numero do imovel

            if (dcbm != null) {

                jcbNumero.setModel(dcbm);
                if (jcbNumero.getItemCount() >= 1) {
                    jcbNumero.setSelectedIndex(-1);
                    jcbNumero.setSelectedIndex(0);
                } else {
                    m = new Mensagens();
                    m.jopAviso("Nenhum imóvel encontrado.");
                    return false;
                }
                return true;
            } else {
                m = new Mensagens();
                m.jopAviso("Nenhum imóvel encontrado.");
                return false;
            }
        } else {
            m = new Mensagens();
            m.jopAviso("É nescessário informar o nome da pessoa para efetuar uma busca.");
            return false;
        }
    }

    public void acaoRemover() {
        if (acaoBuscar()) {
            controladorImovel = new ImovelDAO();
            imovel = (ImovelN) jcbNumero.getSelectedItem();
            controladorImovel.removeImovel(imovel);
            limparTela();
        }
    }

    public void limparTela() {
        jcbNumero.setSelectedIndex(-1);
        jtfBairro.setText("");
        jtfCidade.setText("");
        jtfRua.setText("");
        jtfTamanho.setText("");
        jtfValor.setText("");
    }
}
