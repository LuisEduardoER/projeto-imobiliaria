/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorPessoa;
import Controlador.Mensagens;
import DAO.PessoaDAO;
import Modelo.PessoaN;
import Util.FiltrosDigitacaoLetras;
import Util.FiltrosDigitacaoNumerico;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 *
 * @author Bruno
 */
public class CadastroPessoaN extends javax.swing.JDialog {

    /**
     * Creates new form CadastroPessoa
     */
    Componentes c = new Componentes();
    ControladorPessoa controladorPessoa;
    JButton botaoGravar;
    JButton botaoBuscar;
    JButton botaoExcluir;
    Mensagens m;
    PessoaN p = new PessoaN();

    public CadastroPessoaN(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jtfCPF.setDocument(new FiltrosDigitacaoNumerico());
        jtfNumero.setDocument(new FiltrosDigitacaoNumerico());

//        jcbNome.setDocument(new FiltrosDigitacaoLetras());
        jtfRua.setDocument(new FiltrosDigitacaoLetras());
        jtfBairro.setDocument(new FiltrosDigitacaoLetras());
        jtfCidade.setDocument(new FiltrosDigitacaoLetras());

        botaoGravar = c.criaBotaoGravar();
        botaoBuscar = c.criaBotaoBuscar();
        botaoExcluir = c.criaBotaoExcluir();

        botaoGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGravarActionPerformed(evt);
            }
        });

        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        jpControles.add(botaoGravar);
        jpControles.add(botaoBuscar);
        jpControles.add(botaoExcluir);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDadosPessoais = new javax.swing.JPanel();
        jpLDP = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        jpTFDP = new javax.swing.JPanel();
        jcbNome = new javax.swing.JComboBox();
        jtfCPF = new javax.swing.JTextField();
        jpEndereco = new javax.swing.JPanel();
        jpTFE = new javax.swing.JPanel();
        jtfRua = new javax.swing.JTextField();
        jtfNumero = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfCidade = new javax.swing.JTextField();
        jpLE = new javax.swing.JPanel();
        hlRua = new javax.swing.JLabel();
        jlNumero = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jpLDP.setLayout(new java.awt.GridLayout(2, 1, 0, 8));

        jlNome.setText("Nome:");
        jpLDP.add(jlNome);

        jlCPF.setText("CPF:");
        jpLDP.add(jlCPF);

        jpTFDP.setLayout(new java.awt.GridLayout(2, 1, 0, 4));

        jcbNome.setEditable(true);
        jpTFDP.add(jcbNome);
        jpTFDP.add(jtfCPF);

        javax.swing.GroupLayout jpDadosPessoaisLayout = new javax.swing.GroupLayout(jpDadosPessoais);
        jpDadosPessoais.setLayout(jpDadosPessoaisLayout);
        jpDadosPessoaisLayout.setHorizontalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jpLDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTFDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDadosPessoaisLayout.setVerticalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                .addComponent(jpTFDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jpLDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jpTFE.setLayout(new java.awt.GridLayout(4, 1, 0, 3));
        jpTFE.add(jtfRua);
        jpTFE.add(jtfNumero);
        jpTFE.add(jtfBairro);
        jpTFE.add(jtfCidade);

        jpLE.setLayout(new java.awt.GridLayout(4, 1, 0, 10));

        hlRua.setText("Rua:");
        jpLE.add(hlRua);

        jlNumero.setText("Número:");
        jpLE.add(jlNumero);

        jlBairro.setText("Bairro:");
        jpLE.add(jlBairro);

        jlCidade.setText("Cidade:");
        jpLE.add(jlCidade);

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addComponent(jpLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTFE, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpTFE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpControles.setLayout(new java.awt.GridLayout(1, 3, 25, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jpDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void botaoGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        acaoRemover();
    }

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoBuscar();
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
            java.util.logging.Logger.getLogger(CadastroPessoaN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoaN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoaN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoaN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroPessoaN dialog = new CadastroPessoaN(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel hlRua;
    private javax.swing.JComboBox jcbNome;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpDadosPessoais;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JPanel jpLDP;
    private javax.swing.JPanel jpLE;
    private javax.swing.JPanel jpTFDP;
    private javax.swing.JPanel jpTFE;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCPF;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRua;
    // End of variables declaration//GEN-END:variables

    public boolean validaCampos() {
        if (((null != jcbNome.getSelectedItem())
                && ((null != jtfCPF.getText())    && ("".equals(jtfCPF.getText())))
                && ((null != jtfRua.getText())    && ("".equals(jtfRua.getText())))
                && ((null != jtfNumero.getText()) && ("".equals(jtfNumero.getText())))
                && ((null != jtfBairro.getText()) && ("".equals(jtfBairro.getText())))
                && ((null != jtfCidade.getText()) && ("".equals(jtfCidade.getText()))))) {

            this.p.setBairro(jtfBairro.getText());
            this.p.setCPF(Integer.parseInt(jtfCPF.getText()));
            this.p.setCidade(jtfCidade.getText());
            this.p.setNome(jcbNome.getSelectedItem().toString());
            this.p.setNumero(Integer.parseInt(jtfNumero.getText()));
            this.p.setRua(jtfRua.getText());
            return true;

        } else {
            return false;
        }
    }

    public void acaoGravar() {
        if (validaCampos()) {
            
            controladorPessoa = new PessoaDAO();
            boolean inserePessoa = controladorPessoa.inserePessoa(this.p);

            if (inserePessoa) {
                m = new Mensagens();
                m.jopAviso("Cadastro realizado com sucesso!");
            }

            jtfCidade.setText("");
            jcbNome.setSelectedIndex(-1);
            //jtfNome.setText("");
            jtfCPF.setText(null);
            jtfBairro.setText("");
            jtfNumero.setText(null);
            jtfRua.setText("");
        } else {
            m = new Mensagens();
            m.jopAviso("Exitem campos vazios, preencha todos os campos antes de gravar.");
        }
    }

    public void acaoAlterar() {
        if (validaCampos()) {
            controladorPessoa.alterarPessoa(p);
        }
    }

    public boolean acaoBuscar() {
        if (null != jcbNome.getSelectedItem().toString() && !("".equals(jcbNome.getSelectedItem().toString()))) {

            controladorPessoa = new PessoaDAO();
            String s = (String) jcbNome.getSelectedItem().toString();
            DefaultComboBoxModel dcm = controladorPessoa.buscaPessoaNome(s);
            if (dcm != null) {

                jcbNome.setModel(dcm);

//            jtfCidade.setText(p.getCidade());
//            //jtfNome.setText(p.getNome()); alterado para o comboBox jcbNome para queja possível efetuar a busca
//            jtfCPF.setText(p.getCPF() + "");
//            jtfBairro.setText(p.getBairro());
//            jtfNumero.setText(p.getNumero() + "");
//            jtfRua.setText(p.getRua());
                return true;
            } else {
                m =  new Mensagens();
                m.jopAviso("Nenhuma pessoa encontrada.");
                return false;
            }
        } else {
            m =  new Mensagens();
            m.jopAviso("É nescessário informar o nome da pessoa para efetuar uma busca.");
            return false;
        }
    }

    public void acaoRemover() {
        if (acaoBuscar()) {
            controladorPessoa = new PessoaDAO();
            PessoaN p = (PessoaN) jcbNome.getSelectedItem();
            controladorPessoa.removePessoa(p);
        }
    }
}