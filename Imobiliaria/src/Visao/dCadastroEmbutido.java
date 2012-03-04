/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controlador.ControladorIncluirBanco;
import Controlador.ControladorRemoverBanco;
import Controlador.Mensagens;
import Controlador.Pesquisas;
import Modelo.Embutido;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Bruno Esta classe e a tela de cadastro de embutidos que extend um
 * JDialog, para não criar outro icone na barra de tarefas ;), atraves dela sao
 * inseridos dados que farao parte do cadastro de imovel -> um embutido nao pode
 * ser removido se este e usado em algum cadastro!
 */
public class dCadastroEmbutido extends javax.swing.JDialog {

    Mensagens mensagem = new Mensagens();
    Pesquisas pesquisa = new Pesquisas();
    Embutido e = new Embutido();

    public dCadastroEmbutido(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        acoesBotoes();
        carregaDescricao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCadastroEmbutidos = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbConcluir = new javax.swing.JButton();
        jpNome = new javax.swing.JPanel();
        jlNome = new javax.swing.JLabel();
        jlIdRef = new javax.swing.JLabel();
        jlId = new javax.swing.JLabel();
        jcbNome = new javax.swing.JComboBox();
        jbPesquisar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Embutido");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpCadastroEmbutidos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro De Embutidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exit_16x16.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Sair sem salvar* (F1 para saber mais) (Esc)");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbConcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/save_16x16.png"))); // NOI18N
        jbConcluir.setText("Gravar");
        jbConcluir.setToolTipText("Insere um novo embutido! (F3)");
        jbConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConcluirActionPerformed(evt);
            }
        });

        jpNome.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlNome.setText("Nome:");

        jlIdRef.setText("ID de Referência:");

        jlId.setText("(nenhum item selecionado)");
        jlId.setEnabled(false);

        jcbNome.setEditable(true);

        javax.swing.GroupLayout jpNomeLayout = new javax.swing.GroupLayout(jpNome);
        jpNome.setLayout(jpNomeLayout);
        jpNomeLayout.setHorizontalGroup(
            jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNomeLayout.createSequentialGroup()
                        .addComponent(jlIdRef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlId))
                    .addGroup(jpNomeLayout.createSequentialGroup()
                        .addComponent(jlNome)
                        .addGap(18, 18, 18)
                        .addComponent(jcbNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpNomeLayout.setVerticalGroup(
            jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNome)
                    .addComponent(jcbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIdRef)
                    .addComponent(jlId)))
        );

        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search_16x16.png"))); // NOI18N
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.setToolTipText("Pesquisa por registros que contenham o trecho digitado ou parte dele (F2)");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/delete_16x16.png"))); // NOI18N
        jbRemover.setText("Remover");
        jbRemover.setToolTipText("Remove um registro que não esteja vinculado à nenhum outro (F1 para saber mais) (F5)");
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCadastroEmbutidosLayout = new javax.swing.GroupLayout(jpCadastroEmbutidos);
        jpCadastroEmbutidos.setLayout(jpCadastroEmbutidosLayout);
        jpCadastroEmbutidosLayout.setHorizontalGroup(
            jpCadastroEmbutidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroEmbutidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroEmbutidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpCadastroEmbutidosLayout.createSequentialGroup()
                        .addComponent(jbConcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jbRemover)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar)))
                .addContainerGap())
        );
        jpCadastroEmbutidosLayout.setVerticalGroup(
            jpCadastroEmbutidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroEmbutidosLayout.createSequentialGroup()
                .addComponent(jpNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCadastroEmbutidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jbConcluir)
                    .addComponent(jbPesquisar)
                    .addComponent(jbRemover)
                    .addComponent(jbCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastroEmbutidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCadastroEmbutidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-496)/2, (screenSize.height-203)/2, 496, 203);
    }// </editor-fold>//GEN-END:initComponents

    private void jbConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConcluirActionPerformed
        acaoGravar();
    }//GEN-LAST:event_jbConcluirActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        acaoSair("cancelar");
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        acaoSair("fechar");
    }//GEN-LAST:event_formWindowClosing

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        acaoPesquisar();
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {
        acaoRemover();
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
            java.util.logging.Logger.getLogger(dCadastroEmbutido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dCadastroEmbutido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dCadastroEmbutido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dCadastroEmbutido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                dCadastroEmbutido dialog = new dCadastroEmbutido(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbConcluir;
    public javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JComboBox jcbNome;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlIdRef;
    private javax.swing.JLabel jlNome;
    private javax.swing.JPanel jpCadastroEmbutidos;
    private javax.swing.JPanel jpNome;
    // End of variables declaration//GEN-END:variables

    public void carregaDescricao() {
        e.setDescricao("%");
        jcbNome.setModel(pesquisa.carregaTelaPesq(e));
        jcbNome.setSelectedIndex(-1);
        jcbNome.updateUI();
    }

    public void acaoGravar() {
        ControladorIncluirBanco controladorIncluir = new ControladorIncluirBanco();
        Pesquisas pesquisaE = new Pesquisas();
        Embutido e = new Embutido();
        String s;

        try {
            s = (String) (jcbNome.getSelectedItem().toString());
        } catch (NullPointerException ex) {
            mensagem.jopAlerta("Informe pelo menos uma letra para gravar!\n\nErro 0001\n" + ex);//Erro 0001: 
            s = null;
        }

        if (s != null) {
            e.setDescricao(jcbNome.getSelectedItem().toString());
            if (controladorIncluir.gravarEmbutido(e)) {
                mensagem.jopAviso("Embutido " + e.getDescricao() + " inclu\u00EDdo com sucesso!");
            } else {
                mensagem.jopAlerta("É necessário informar um nome para novo embutido!");
            }
        }

        DefaultComboBoxModel tmp = new DefaultComboBoxModel();
        e.setDescricao("%");
        tmp = pesquisaE.pesquisaEmbutido(e);
        jcbNome.removeAllItems();
        jcbNome.setModel(tmp);
        jcbNome.updateUI();
        jcbNome.updateUI();
        jcbNome.setSelectedIndex(-1);
        jcbNome.requestFocus();
    }

    public void acaoPesquisar() {
        Pesquisas pesquisaE = new Pesquisas();
        String s;
        jcbNome.requestFocus();
        jcbNome.updateUI();

        try {
            s = (String) (jcbNome.getSelectedItem().toString());
        } catch (NullPointerException ex) {
            mensagem.jopAlerta("Informe pelo menos uma letra para pesquisar!\n\nErro 0001\n" + ex);//Erro 0001: 
            s = null;
        }

        if (s != null) {
            Embutido e = new Embutido();
            e.setDescricao(jcbNome.getSelectedItem().toString());
            DefaultComboBoxModel tmp = new DefaultComboBoxModel();
            tmp = pesquisaE.pesquisaEmbutido(e);
            if (tmp != null) {
                jcbNome.setModel(tmp);
            } else {
                e.setDescricao("%");
                tmp = pesquisaE.pesquisaEmbutido(e);
                jcbNome.removeAllItems();
                jcbNome.setModel(tmp);
                jcbNome.updateUI();
            }
        }
    }

    public void acaoRemover() {
        ControladorRemoverBanco controladorRemover = new ControladorRemoverBanco();
        Embutido embutido = new Embutido();
        String descricao;

        try {
            descricao = jcbNome.getSelectedItem().toString();
        } catch (ClassCastException ex) {
            mensagem.jopError("Primeiro pesquise ou informe um embutido cadastrado para ser excluído!\n" + ex);
            descricao = null;
        }

        if (descricao != null) {
            embutido = (Embutido) (jcbNome.getSelectedItem());

            int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar este cadastro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (x == JOptionPane.YES_OPTION) {
                if (controladorRemover.removerEmbutido(embutido)) {
                    mensagem.jopAviso("Embutido " + embutido.getDescricao().toString() + " foi removido!");
                    jcbNome.removeAllItems();
                    carregaDescricao();
                }
            }
        }
        jcbNome.requestFocus();
        jcbNome.updateUI();
    }

    public void acoesBotoes() {
        KeyStroke f2 = KeyStroke.getKeyStroke("F2");
        KeyStroke f3 = KeyStroke.getKeyStroke("F3");
        KeyStroke f5 = KeyStroke.getKeyStroke("F5");
        KeyStroke esc = KeyStroke.getKeyStroke("ESCAPE");

        Action f2Action = new AbstractAction() {

            public void actionPerformed(ActionEvent actionEvent) {
            }
        };

        InputMap imap = this.rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        imap.put(f2, "null");
        //Mapeamos o bot�o 1 a a��o descrita pela string.  
        ActionMap amap = rootPane.getActionMap();
        //Mapeia a string para a a��o a ser executada.  
        amap.put("null", f2Action);

    }

    public void acaoSair(String acao) {
        int x = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja " + acao + "? Todos os dados em edição serão perdidos!", "Atençao", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            acaoSair("cancelar");
        }
    }
}