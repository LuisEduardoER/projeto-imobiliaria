/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorImovel;
import Controlador.ControladorPessoa;
import Controlador.ControladorVenda;
import Controlador.Mensagens;
import DAO.ImovelDAO;
import DAO.PessoaDAO;
import DAO.VendaDAO;
import Modelo.ImovelN;
import Modelo.PessoaN;
import Modelo.Venda;
import Util.FiltrosDigitacaoNumerico;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 *
 * @author Bruno
 */
public class VendaImovelN extends javax.swing.JDialog {

    /**
     * Creates new form VendaImovelN
     */
    Componentes c = new Componentes();
    ControladorImovel controladorImovel;
    ControladorPessoa controladorPessoa;
    ControladorVenda controladorVenda;
    JButton imovelProcurar;
    JButton pessoaProcurar;
    JButton vendaGravar;
    JButton vendaProcurar;
    JButton vendaExcluir;
    Mensagens m;
    ImovelN imovel;
    PessoaN pessoa;
    Venda venda;

    public VendaImovelN(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jlDescricaoBairro.setText("-");
        jlDescricaoCPF.setText("-");
        jlDescricaoCidade.setText("-");
        jlDescricaoRua.setText("-");

        imovelProcurar = c.criaBotaoPesquisar();
        jpControleImovel.add(imovelProcurar);

        pessoaProcurar = c.criaBotaoPesquisar();
        jpControleComprador.add(pessoaProcurar);

        vendaGravar = c.criaBotaoGravar();
        vendaProcurar = c.criaBotaoPesquisar();
        vendaExcluir = c.criaBotaoExcluir();

        jpControlesVenda.add(vendaGravar);
        jpControlesVenda.add(vendaProcurar);
        jpControlesVenda.add(vendaExcluir);

        jtfValor.setDocument(new FiltrosDigitacaoNumerico());

        imovelProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imovelBuscarActionPerformed(evt);
            }
        });

        pessoaProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pessoaBuscarActionPerformed(evt);
            }
        });

        vendaGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaGravarActionPerformed(evt);
            }
        });

        vendaExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaExcluirActionPerformed(evt);
            }
        });

        vendaProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendaBuscarActionPerformed(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpImovel = new javax.swing.JPanel();
        jpIL = new javax.swing.JPanel();
        jlNumero = new javax.swing.JLabel();
        jlRua = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jpITF = new javax.swing.JPanel();
        jcbNumero = new javax.swing.JComboBox();
        jlDescricaoRua = new javax.swing.JLabel();
        jlDescricaoBairro = new javax.swing.JLabel();
        jlDescricaoCidade = new javax.swing.JLabel();
        jpControleImovel = new javax.swing.JPanel();
        jpComprador = new javax.swing.JPanel();
        jpCL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpCTF = new javax.swing.JPanel();
        jcbNome = new javax.swing.JComboBox();
        jlDescricaoCPF = new javax.swing.JLabel();
        jpControleComprador = new javax.swing.JPanel();
        jpVenda = new javax.swing.JPanel();
        jpVL = new javax.swing.JPanel();
        jlValor = new javax.swing.JLabel();
        jpVTF = new javax.swing.JPanel();
        jtfValor = new javax.swing.JTextField();
        jpControlesVenda = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpImovel.setBorder(javax.swing.BorderFactory.createTitledBorder("Imóvel"));

        jpIL.setLayout(new java.awt.GridLayout(4, 1, 0, 8));

        jlNumero.setText("Número:");
        jpIL.add(jlNumero);

        jlRua.setText("Rua:");
        jpIL.add(jlRua);

        jlBairro.setText("Bairro:");
        jpIL.add(jlBairro);

        jlCidade.setText("Cidade:");
        jpIL.add(jlCidade);

        jpITF.setLayout(new java.awt.GridLayout(4, 1, 0, 8));

        jcbNumero.setEditable(true);
        jcbNumero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNumeroItemStateChanged(evt);
            }
        });
        jpITF.add(jcbNumero);

        jlDescricaoRua.setText("(rua)");
        jpITF.add(jlDescricaoRua);

        jlDescricaoBairro.setText("(bairro)");
        jpITF.add(jlDescricaoBairro);

        jlDescricaoCidade.setText("(cidade)");
        jpITF.add(jlDescricaoCidade);

        jpControleImovel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jpImovelLayout = new javax.swing.GroupLayout(jpImovel);
        jpImovel.setLayout(jpImovelLayout);
        jpImovelLayout.setHorizontalGroup(
            jpImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImovelLayout.createSequentialGroup()
                .addComponent(jpIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpITF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpControleImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpImovelLayout.setVerticalGroup(
            jpImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImovelLayout.createSequentialGroup()
                .addGroup(jpImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpITF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControleImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpComprador.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprador"));

        jpCL.setLayout(new java.awt.GridLayout(2, 1, 0, 8));

        jLabel1.setText("Nome:");
        jpCL.add(jLabel1);

        jLabel2.setText("CPF:");
        jpCL.add(jLabel2);

        jpCTF.setLayout(new java.awt.GridLayout(2, 1, 0, 8));

        jcbNome.setEditable(true);
        jcbNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNomeItemStateChanged(evt);
            }
        });
        jpCTF.add(jcbNome);

        jlDescricaoCPF.setText("(cpf)");
        jpCTF.add(jlDescricaoCPF);

        jpControleComprador.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jpCompradorLayout = new javax.swing.GroupLayout(jpComprador);
        jpComprador.setLayout(jpCompradorLayout);
        jpCompradorLayout.setHorizontalGroup(
            jpCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCompradorLayout.createSequentialGroup()
                .addComponent(jpCL, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpCTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpControleComprador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpCompradorLayout.setVerticalGroup(
            jpCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCompradorLayout.createSequentialGroup()
                .addGroup(jpCompradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpCL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpCTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControleComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));

        jpVL.setLayout(new java.awt.GridLayout(1, 1));

        jlValor.setText("Valor:");
        jpVL.add(jlValor);

        jpVTF.setLayout(new java.awt.GridLayout(1, 1));
        jpVTF.add(jtfValor);

        javax.swing.GroupLayout jpVendaLayout = new javax.swing.GroupLayout(jpVenda);
        jpVenda.setLayout(jpVendaLayout);
        jpVendaLayout.setHorizontalGroup(
            jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVendaLayout.createSequentialGroup()
                .addComponent(jpVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpVTF, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpVendaLayout.setVerticalGroup(
            jpVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpVTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpVL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpControlesVenda.setLayout(new java.awt.GridLayout(1, 3, 25, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpImovel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpComprador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpControlesVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControlesVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbNumeroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNumeroItemStateChanged
        try {
            imovel = (ImovelN) jcbNumero.getSelectedItem();
            if (null != imovel) {
                jlDescricaoRua.setText(imovel.getRua());
                jlDescricaoBairro.setText(imovel.getBairro());
                jlDescricaoCidade.setText(imovel.getCidade());
            }
        } catch (ClassCastException e) {
        }
    }//GEN-LAST:event_jcbNumeroItemStateChanged

    private void jcbNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNomeItemStateChanged
        try {
            pessoa = (PessoaN) jcbNome.getSelectedItem();
            if (null != pessoa) {
                jlDescricaoCPF.setText(pessoa.getCPF() + "");
            }
        } catch (ClassCastException e) {
        }
    }//GEN-LAST:event_jcbNomeItemStateChanged

    /**
     * @param args the command line arguments
     */
    private void imovelBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        imovelBuscar();
    }

    private void pessoaBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        pessoaBuscar();
    }

    private void vendaGravarActionPerformed(java.awt.event.ActionEvent evt) {
        vendaGravar();
    }

    private void vendaExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        vendaRemover();
    }

    private void vendaBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        vendaBuscar();
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
            java.util.logging.Logger.getLogger(VendaImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaImovelN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VendaImovelN dialog = new VendaImovelN(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox jcbNome;
    private javax.swing.JComboBox jcbNumero;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlDescricaoBairro;
    private javax.swing.JLabel jlDescricaoCPF;
    private javax.swing.JLabel jlDescricaoCidade;
    private javax.swing.JLabel jlDescricaoRua;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlRua;
    private javax.swing.JLabel jlValor;
    private javax.swing.JPanel jpCL;
    private javax.swing.JPanel jpCTF;
    private javax.swing.JPanel jpComprador;
    private javax.swing.JPanel jpControleComprador;
    private javax.swing.JPanel jpControleImovel;
    private javax.swing.JPanel jpControlesVenda;
    private javax.swing.JPanel jpIL;
    private javax.swing.JPanel jpITF;
    private javax.swing.JPanel jpImovel;
    private javax.swing.JPanel jpVL;
    private javax.swing.JPanel jpVTF;
    private javax.swing.JPanel jpVenda;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables

    public boolean validaCampos() {
        if (((null != jcbNumero.getSelectedItem())
                && (null != jcbNome.getSelectedItem())
                && ((null != jtfValor.getText()) && !("".equals(jtfValor.getText()))))) {

            venda = new Venda();
            venda.setValor(Float.parseFloat(jtfValor.getText()));
            venda.setId(0);
            
            if (0 != pessoa.getId() && !("".equals(pessoa.getId()))) {
                venda.setIdPessoaProprietario(pessoa.getId());
            } else {
                m = new Mensagens();
                m.jopAlerta("É necessário buscar um proprietário antes de continuar.");
                return false;
            }

            if (0 != imovel.getId() && !("".equals(imovel.getId()))) {
                venda.setIdImovel(imovel.getId());
            } else {
                m = new Mensagens();
                m.jopAlerta("É necessário buscar um imovel antes de continuar.");
                return false;
            }

            return true;

        } else {
            return false;
        }
    }

    private boolean imovelBuscar() {
        if (null != jcbNumero.getSelectedItem().toString() && !("".equals(jcbNumero.getSelectedItem().toString()))) {

            controladorImovel = new ImovelDAO();
            int i = Integer.parseInt(jcbNumero.getSelectedItem().toString());
            DefaultComboBoxModel dcbm = controladorImovel.buscaImovelNumero(i); // informar o numero do imovel

            if (dcbm != null) {
                jcbNumero.setModel(dcbm);
                if (jcbNumero.getItemCount() >= 1) {
                    jcbNumero.setSelectedIndex(-1);
                    jcbNumero.setSelectedIndex(0);
                    return true;
                } else {
                    m = new Mensagens();
                    m.jopAviso("Nenhum imóvel encontrado.");
                    return false;
                }
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

    private boolean pessoaBuscar() {
        if (null != jcbNome.getSelectedItem().toString() && !("".equals(jcbNome.getSelectedItem().toString()))) {

            controladorPessoa = new PessoaDAO();
            String s = (String) jcbNome.getSelectedItem().toString();
            DefaultComboBoxModel dcbm = controladorPessoa.buscaPessoaNome(s);
            if (dcbm != null) {

                jcbNome.setModel(dcbm);
                if (jcbNome.getItemCount() >= 1) {
                    jcbNome.setSelectedIndex(-1);
                    jcbNome.setSelectedIndex(0);
                }
                return true;
            } else {
                m = new Mensagens();
                m.jopAviso("Nenhuma pessoa encontrada.");
                return false;
            }
        } else {
            m = new Mensagens();
            m.jopAviso("É nescessário informar o nome da pessoa para efetuar uma busca.");
            return false;
        }
    }

    private void vendaGravar() {
        if (validaCampos()) {
            controladorVenda = new VendaDAO();

            boolean insereVenda = controladorVenda.insereVenda(venda);

            if (insereVenda) {
                m = new Mensagens();
                m.jopAviso("Venda realizado com sucesso!");
            }

            limparTela();

        } else {
            m = new Mensagens();
            m.jopAviso("Exitem campos vazios, preencha todos os campos antes de gravar.");
        }

    }

    private void vendaRemover() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void vendaBuscar() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ImovelN montaImovel() {
        ImovelN imovel = new ImovelN();
        return imovel;
    }

    public void limparTela() {
        jcbNome.setSelectedIndex(-1);
        jcbNumero.setSelectedIndex(-1);

        jtfValor.setText("");

        jlDescricaoBairro.setText("-");
        jlDescricaoCPF.setText("-");
        jlDescricaoCidade.setText("-");
        jlDescricaoRua.setText("-");
    }
}
