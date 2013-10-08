/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controller.Mensagens;
import controller.ProdutoController;
import controller.VendaController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import modelo.Itemvenda;
import modelo.Produto;
import modelo.Tipopagamento;
import modelo.Venda;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class VendaTela extends javax.swing.JDialog {

    ProdutoController pc;
    VendaController vendaController;
    Produto produto;
    Float totalVenda = Float.MIN_VALUE;
    Mensagens m;
    Venda venda = new Venda();
    Itemvenda itemvenda;
    List<Itemvenda> itens = new ArrayList<>();
    Tipopagamento tipopagamento = new Tipopagamento();
    final int DINHEIRO = 1;
    final int CHEQUES = 2;
    final int CARTAO = 3;
    
    
    /**
     * Creates new form Venda
     */
    public VendaTela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jtaLista.append("\n");
        tipopagamento.setTipoPagamentoId(DINHEIRO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pagamentoRbg = new javax.swing.ButtonGroup();
        jpTotais = new javax.swing.JPanel();
        jpTotaisL_JTF = new javax.swing.JPanel();
        jlTotal = new javax.swing.JLabel();
        jtfDinheiro = new javax.swing.JTextField();
        jlTroco = new javax.swing.JLabel();
        jpTotaisL = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpDetalhesProd = new javax.swing.JPanel();
        jlDetalheProdutoJTF = new javax.swing.JPanel();
        jtfCodigoBarra = new javax.swing.JTextField();
        jtfQuantidade = new javax.swing.JTextField();
        jlValorPrd = new javax.swing.JLabel();
        jpDetalheProdL = new javax.swing.JPanel();
        jlProduto = new javax.swing.JLabel();
        jlQtd = new javax.swing.JLabel();
        jlValor = new javax.swing.JLabel();
        jpListaProds = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaLista = new javax.swing.JTextArea();
        jpPagamento = new javax.swing.JPanel();
        jrbDinheiro = new javax.swing.JRadioButton();
        jrbCheque = new javax.swing.JRadioButton();
        jrbCartao = new javax.swing.JRadioButton();

        setTitle("Venda");
        setResizable(false);

        jpTotaisL_JTF.setLayout(new java.awt.GridLayout(3, 0, 8, 10));

        jlTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlTotal.setForeground(new java.awt.Color(0, 153, 51));
        jlTotal.setText("R$ 0.0000");
        jpTotaisL_JTF.add(jlTotal);

        jtfDinheiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfDinheiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDinheiroKeyPressed(evt);
            }
        });
        jpTotaisL_JTF.add(jtfDinheiro);

        jlTroco.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlTroco.setText("R$ 0,0000");
        jpTotaisL_JTF.add(jlTroco);

        jpTotaisL.setLayout(new java.awt.GridLayout(3, 0, 0, 18));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total (R$):");
        jpTotaisL.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Total Pago (R$):");
        jpTotaisL.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Troco(R$):");
        jpTotaisL.add(jLabel6);

        javax.swing.GroupLayout jpTotaisLayout = new javax.swing.GroupLayout(jpTotais);
        jpTotais.setLayout(jpTotaisLayout);
        jpTotaisLayout.setHorizontalGroup(
            jpTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTotaisL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jpTotaisL_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpTotaisLayout.setVerticalGroup(
            jpTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTotaisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTotaisL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpTotaisL_JTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jlDetalheProdutoJTF.setLayout(new java.awt.GridLayout(3, 0, 0, 2));

        jtfCodigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodigoBarraKeyPressed(evt);
            }
        });
        jlDetalheProdutoJTF.add(jtfCodigoBarra);

        jtfQuantidade.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jtfQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfQuantidadeKeyPressed(evt);
            }
        });
        jlDetalheProdutoJTF.add(jtfQuantidade);

        jlValorPrd.setText("R$ 0,0000");
        jlDetalheProdutoJTF.add(jlValorPrd);

        jpDetalheProdL.setLayout(new java.awt.GridLayout(3, 0, 0, 10));

        jlProduto.setText("Produto:");
        jpDetalheProdL.add(jlProduto);

        jlQtd.setText("Quantidade:");
        jpDetalheProdL.add(jlQtd);

        jlValor.setText("Valor (R$):");
        jpDetalheProdL.add(jlValor);

        javax.swing.GroupLayout jpDetalhesProdLayout = new javax.swing.GroupLayout(jpDetalhesProd);
        jpDetalhesProd.setLayout(jpDetalhesProdLayout);
        jpDetalhesProdLayout.setHorizontalGroup(
            jpDetalhesProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalhesProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDetalheProdL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDetalheProdutoJTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDetalhesProdLayout.setVerticalGroup(
            jpDetalhesProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalhesProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDetalhesProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDetalheProdutoJTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpDetalheProdL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpListaProds.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));
        jpListaProds.setFocusable(false);

        jtaLista.setColumns(20);
        jtaLista.setRows(5);
        jtaLista.setText("Bem Vindo!");
        jtaLista.setEnabled(false);
        jtaLista.setFocusable(false);
        jScrollPane1.setViewportView(jtaLista);

        javax.swing.GroupLayout jpListaProdsLayout = new javax.swing.GroupLayout(jpListaProds);
        jpListaProds.setLayout(jpListaProdsLayout);
        jpListaProdsLayout.setHorizontalGroup(
            jpListaProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jpListaProdsLayout.setVerticalGroup(
            jpListaProdsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );

        jpPagamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Pagamento"));

        pagamentoRbg.add(jrbDinheiro);
        jrbDinheiro.setSelected(true);
        jrbDinheiro.setText("Dinheiro");
        jrbDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDinheiroActionPerformed(evt);
            }
        });

        pagamentoRbg.add(jrbCheque);
        jrbCheque.setText("Cheque");
        jrbCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbChequeActionPerformed(evt);
            }
        });

        pagamentoRbg.add(jrbCartao);
        jrbCartao.setText("Cartão");
        jrbCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCartaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPagamentoLayout = new javax.swing.GroupLayout(jpPagamento);
        jpPagamento.setLayout(jpPagamentoLayout);
        jpPagamentoLayout.setHorizontalGroup(
            jpPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbDinheiro)
                    .addComponent(jrbCheque)
                    .addComponent(jrbCartao))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jpPagamentoLayout.setVerticalGroup(
            jpPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPagamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbDinheiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbCheque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbCartao)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpListaProds, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDetalhesProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                        .addComponent(jpTotais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDetalhesProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpListaProds, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTotais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-641)/2, (screenSize.height-517)/2, 641, 517);
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCodigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoBarraKeyPressed
        setNextFocus(evt);
    }//GEN-LAST:event_jtfCodigoBarraKeyPressed

    private void jtfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfQuantidadeKeyPressed
        setPreviousFocus(evt);
    }//GEN-LAST:event_jtfQuantidadeKeyPressed

    private void jtfDinheiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDinheiroKeyPressed
        finalizaVenda(evt);
    }//GEN-LAST:event_jtfDinheiroKeyPressed

    private void jrbDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDinheiroActionPerformed
        if (jrbDinheiro.isSelected()) {
            tipopagamento.setTipoPagamentoId(DINHEIRO);
            jtfDinheiro.setEnabled(true);
        }
    }//GEN-LAST:event_jrbDinheiroActionPerformed

    private void jrbChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbChequeActionPerformed
        if (jrbCheque.isSelected()) {
            tipopagamento.setTipoPagamentoId(CHEQUES);
            jtfDinheiro.setEnabled(false);
        }
    }//GEN-LAST:event_jrbChequeActionPerformed

    private void jrbCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCartaoActionPerformed
        if (jrbCartao.isSelected()) {
            tipopagamento.setTipoPagamentoId(CARTAO);
            jtfDinheiro.setEnabled(false);
        }
    }//GEN-LAST:event_jrbCartaoActionPerformed

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
            java.util.logging.Logger.getLogger(VendaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VendaTela dialog = new VendaTela(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jlDetalheProdutoJTF;
    private javax.swing.JLabel jlProduto;
    private javax.swing.JLabel jlQtd;
    private javax.swing.JLabel jlTotal;
    private javax.swing.JLabel jlTroco;
    private javax.swing.JLabel jlValor;
    private javax.swing.JLabel jlValorPrd;
    private javax.swing.JPanel jpDetalheProdL;
    private javax.swing.JPanel jpDetalhesProd;
    private javax.swing.JPanel jpListaProds;
    private javax.swing.JPanel jpPagamento;
    private javax.swing.JPanel jpTotais;
    private javax.swing.JPanel jpTotaisL;
    private javax.swing.JPanel jpTotaisL_JTF;
    private javax.swing.JRadioButton jrbCartao;
    private javax.swing.JRadioButton jrbCheque;
    private javax.swing.JRadioButton jrbDinheiro;
    private javax.swing.JTextArea jtaLista;
    private javax.swing.JTextField jtfCodigoBarra;
    private javax.swing.JTextField jtfDinheiro;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.ButtonGroup pagamentoRbg;
    // End of variables declaration//GEN-END:variables

    private void setNextFocus(KeyEvent evt) {
        if (evt.getKeyChar() == 13 || evt.getKeyChar() == 10) {
            buscaProduto();
            jtfQuantidade.requestFocus();
        }
    }

    private void setPreviousFocus(KeyEvent evt) {
        if (evt.getKeyChar() == 13 || evt.getKeyChar() == 10) {
            atualizaVenda();
            jtfCodigoBarra.requestFocus();
        }
    }

    private void buscaProduto() {
        pc = new ProdutoController();
        produto = pc.buscaCodigoBarra(jtfCodigoBarra.getText());
        if(produto != null){
            jlValorPrd.setText(produto.getValor().toString());
        }else{
            m = new Mensagens();
            m.jopAlerta("Não foram encontrados produtos com este código de barras");
            jtfCodigoBarra.requestFocus();
        }
    }

    private void atualizaVenda() {

        if (!jtfQuantidade.getText().equals("") && jtfQuantidade.getText() != null && !jtfCodigoBarra.getText().equals("") && jtfCodigoBarra.getText() != null) {
            if (produto.getValor() != null && produto.getValor() > 0) {

                float valor = produto.getValor();
                Float qtd = new Float(jtfQuantidade.getText());
                Float total = valor * qtd;

                jlValorPrd.setText("R$ " + total);
                totalVenda = totalVenda + total;
                jlTotal.setText(totalVenda.toString());

                jtaLista.append("\n");
                jtaLista.append(produto.getProdutoNome() + " R$ " + produto.getValor().toString() + " x " + jtfQuantidade.getText());
                jtaLista.append("\n");
                jtaLista.append("Sub-Total: R$ " + total);
                jtaLista.append("\n");
                jtaLista.append("----------------------------------");
                jtaLista.append("\n");
                
                itemvenda = new Itemvenda();
                itemvenda.setProdutoId(produto);
                itemvenda.setQuantidade(qtd);
                itemvenda.setValorItemVenda(valor);
                
                itens.add(itemvenda);
                
                limpaTela();
            }
        } else {
            jlValorPrd.setText(jlValorPrd.getText());
        }
    }

    public void limpaTela() {
        jtfCodigoBarra.setText("");
        jtfQuantidade.setText("");
        jlValorPrd.setText("");
    }

    private void finalizaVenda(KeyEvent evt) {
        
        if (evt.getKeyChar() == 13 || evt.getKeyChar() == 10) {
        
            m = new Mensagens();
            int i = 0;
            if (totalVenda > Float.MIN_VALUE) {
                i = JOptionPane.showConfirmDialog(null, "Deseja finalizar esta venda ?\n"
                                                       + "Total: " + totalVenda +"\n"
                                                       + "Forma de pagamento: " + getSelectedPagamento(pagamentoRbg)+"\n",
                                                         "Finalizar", JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                    
                    venda.setDataVenda(Datas.dataDateTime);
                    venda.setValorTotal(totalVenda);
                    venda.setTotalPago(Float.parseFloat(jtfDinheiro.getText()));
                    venda.setTipoPagamentoId(tipopagamento);
                    
                    vendaController = new VendaController();
                    vendaController.gravar(venda, itens);
                    
                    vendaController.imprimeCupomFiscal(venda);
                    
                } else {
                    jtfCodigoBarra.requestFocus();
                }
            } else {
                m.jopAlerta("Para finalizar a venda o valor deve ser superior à 0(zero).");
            }
        }
    }

    public String getSelectedPagamento(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}