/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Cadastro.Administrativo;

import Componentes.Componentes;
import Componentes.TableModelProduto;
import controller.Cadastro.Administrativo.FabricanteController;
import controller.Cadastro.Administrativo.FornecedorController;
import controller.Cadastro.Administrativo.GrupoProdutoController;
import controller.Mensagens;
import controller.Cadastro.Administrativo.ProdutoController;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Compra;
import modelo.Estoque;
import modelo.Cadastro.Adminsitrativo.Fabricante;
import modelo.Cadastro.Adminsitrativo.Fornecedor;
import modelo.Cadastro.Adminsitrativo.Grupoproduto;
import modelo.Cadastro.Adminsitrativo.Produto;
import org.joda.time.LocalDate;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class CadastroProduto extends javax.swing.JDialog {

    /**
     * Creates new form CadastroProduto
     */
    Componentes c = new Componentes();
    JButton jbGravar;
    JButton jbBuscar;
    JButton jbExcluir;
    JButton jbNovo;
    Mensagens m;
    FornecedorController fornecedorController;
    FabricanteController fabricanteController;
    ProdutoController produtoController;
    GrupoProdutoController grupoProdutoController;
    String cnpj;
    Fornecedor fornecedor;
    Fabricante fabricante;
    Produto p;
    Estoque e;
    Compra compra;
    List<Produto> produtoList;
    TableModelProduto modeloProduto;

    public CadastroProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        produtoController = new ProdutoController();
        grupoProdutoController = new GrupoProdutoController();
        jbGravar = c.criaBotaoGravar();
        jbBuscar = c.criaBotaoBuscar();
        jbExcluir = c.criaBotaoExcluir();
        jbNovo = c.criaBotaoNovo();

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

        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jcbGrupoProduto.setModel(grupoProdutoController.listGrupos());
        jcbGrupoProduto.updateUI();

        jpControles.add(jbGravar);
//        jpControles.add(jbBuscar);
//        jpControles.add(jbExcluir);
        jpControles.add(jbNovo);
        produtoList = produtoController.buscaTodos();
        modeloProduto = new TableModelProduto();
        jtProdutos.setModel(modeloProduto);
        modeloProduto.addListaDeProdutos(produtoList);
        jtProdutos.updateUI();

        jtProdutos.setDefaultEditor(Object.class, null);
        jtProdutos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                jtProdutosMouseClicked(e);
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

        jtpAbas = new javax.swing.JTabbedPane();
        jpConsultaProdutos = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jpCadastroProdutos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtfProdNome = new javax.swing.JTextField();
        jcbFabricanteCNPJ = new javax.swing.JComboBox();
        jtfCodigoBarras = new javax.swing.JTextField();
        jtfQuantidade = new javax.swing.JTextField();
        jbBuscarFabricante = new javax.swing.JButton();
        jtfQtdMinima = new javax.swing.JTextField();
        jtfValor = new javax.swing.JTextField();
        jcbGrupoProduto = new javax.swing.JComboBox();
        jpDadosCompra = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jcbFornecedorCNPJ = new javax.swing.JComboBox();
        jtfDataCompra = new javax.swing.JTextField();
        jtfValorCompra = new javax.swing.JTextField();
        jbBuscarFornecedor = new javax.swing.JButton();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setResizable(false);

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtProdutos);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpConsultaProdutosLayout = new javax.swing.GroupLayout(jpConsultaProdutos);
        jpConsultaProdutos.setLayout(jpConsultaProdutosLayout);
        jpConsultaProdutosLayout.setHorizontalGroup(
            jpConsultaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultaProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpConsultaProdutosLayout.setVerticalGroup(
            jpConsultaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultaProdutosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpAbas.addTab("Produtos", jpConsultaProdutos);

        jpCadastroProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jPanel1.setLayout(new java.awt.GridLayout(7, 1, 4, 13));

        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1);

        jLabel2.setText("Fabricante:");
        jPanel1.add(jLabel2);

        jLabel10.setText("Grupo:");
        jPanel1.add(jLabel10);

        jLabel4.setText("Valor: (Para Venda)");
        jPanel1.add(jLabel4);

        jLabel5.setText("Código de Barras:");
        jPanel1.add(jLabel5);

        jLabel6.setText("Saldo Inicial:");
        jPanel1.add(jLabel6);

        jLabel7.setText("Quantidade mínima:");
        jPanel1.add(jLabel7);

        jcbFabricanteCNPJ.setEditable(true);

        jbBuscarFabricante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search_16x16.png"))); // NOI18N
        jbBuscarFabricante.setToolTipText("Buscar Fabricante");
        jbBuscarFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarFabricanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCodigoBarras)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfQtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbGrupoProduto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfProdNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jcbFabricanteCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbBuscarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jtfProdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbFabricanteCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbGrupoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jtfCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfQtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpCadastroProdutosLayout = new javax.swing.GroupLayout(jpCadastroProdutos);
        jpCadastroProdutos.setLayout(jpCadastroProdutosLayout);
        jpCadastroProdutosLayout.setHorizontalGroup(
            jpCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroProdutosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpCadastroProdutosLayout.setVerticalGroup(
            jpCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroProdutosLayout.createSequentialGroup()
                .addGroup(jpCadastroProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpCadastroProdutosLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jtpAbas.addTab("Cadastrar Produto", jpCadastroProdutos);

        jpDadosCompra.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Compra", 0, 0, null, java.awt.Color.black));

        jLabel8.setText("Data:");

        jLabel9.setText("Valor:");

        jLabel3.setText("Fornecedor:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbFornecedorCNPJ.setEditable(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbFornecedorCNPJ, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDataCompra)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jtfValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 398, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jcbFornecedorCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbBuscarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search_16x16.png"))); // NOI18N
        jbBuscarFornecedor.setToolTipText("Buscar Fornecedor");
        jbBuscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarFornecedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDadosCompraLayout = new javax.swing.GroupLayout(jpDadosCompra);
        jpDadosCompra.setLayout(jpDadosCompraLayout);
        jpDadosCompraLayout.setHorizontalGroup(
            jpDadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosCompraLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpDadosCompraLayout.setVerticalGroup(
            jpDadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbBuscarFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jpDadosCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpAbas.addTab("Dados da Compra", jpDadosCompra);

        jpControles.setLayout(new java.awt.GridLayout(1, 3, 3, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpAbas)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpAbas)
                .addGap(18, 18, 18)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-729)/2, (screenSize.height-430)/2, 729, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarFabricanteActionPerformed
        acaoBuscarFabricante();
    }//GEN-LAST:event_jbBuscarFabricanteActionPerformed

    private void jbBuscarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarFornecedorActionPerformed
        acaoBuscarFornecedor();
    }//GEN-LAST:event_jbBuscarFornecedorActionPerformed

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (p != null) {
            if (p.getProduto_id() != 0) {
                if (m.jopDeletar("Deseja realmente excluir este fornecedor ?") == JOptionPane.YES_OPTION) {
//                    acaoRemover();
                }
            } else {
                m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
            }
        } else {
            m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
        }
    }

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        //acaoBuscar();
    }

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        acaoNovo();
    }

    private void jtProdutosMouseClicked(java.awt.event.MouseEvent e) {
        // TODO add your handling code here:  
        if (e.getClickCount() == 2) {
            Point p = e.getPoint();
            int row = jtProdutos.rowAtPoint(p);
            int col = jtProdutos.columnAtPoint(p);

            Produto produto = new Produto();
            produto = modeloProduto.getProduto(row);

            alterar(produto);
        }
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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroProduto dialog = new CadastroProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarFabricante;
    private javax.swing.JButton jbBuscarFornecedor;
    private javax.swing.JComboBox jcbFabricanteCNPJ;
    private javax.swing.JComboBox jcbFornecedorCNPJ;
    private javax.swing.JComboBox jcbGrupoProduto;
    private javax.swing.JPanel jpCadastroProdutos;
    private javax.swing.JPanel jpConsultaProdutos;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpDadosCompra;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField jtfCodigoBarras;
    private javax.swing.JTextField jtfDataCompra;
    private javax.swing.JTextField jtfProdNome;
    private javax.swing.JTextField jtfQtdMinima;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTextField jtfValor;
    private javax.swing.JTextField jtfValorCompra;
    private javax.swing.JTabbedPane jtpAbas;
    // End of variables declaration//GEN-END:variables

    public boolean validacampos() {
        m = new Mensagens();
        
        StringBuilder camposVazios = new StringBuilder();

        if (jtfProdNome.getText() == null || jtfProdNome.getText().equals("")) {
            camposVazios.append("Nome\n");
        }
        if (jcbFabricanteCNPJ.getSelectedItem().toString() == null || jcbFabricanteCNPJ.getSelectedItem().toString().equals("")) {
            camposVazios.append("Fabricante\n");
        }
        if (jcbGrupoProduto.getSelectedItem().toString() == null && !jcbGrupoProduto.getSelectedItem().toString().equals("")) {
            camposVazios.append("Fornecedor\n");
        }
        if (jcbFornecedorCNPJ.getSelectedItem().toString() == null && !jcbFornecedorCNPJ.getSelectedItem().toString().equals("")) {
            camposVazios.append("Fornecedor\n");
        }
        if (jtfValor.getText() == null && !jtfValor.getText().equals("")) {
            camposVazios.append("Valor\n");
        }
        if (jtfCodigoBarras.getText() == null && !jtfCodigoBarras.getText().equals("")) {
            camposVazios.append("Codigo de Barras\n");
        }
        if (jtfQuantidade.getText() == null && !jtfQuantidade.getText().equals("")) {
            camposVazios.append("Quantidade\n");
        }
        if (jtfValor.getText() == null && !jtfValor.getText().equals("")) {
            camposVazios.append("Valor\n");
        }

        if (!camposVazios.equals("")) {
            m.jopAlerta("O(s) seguinte(s) campo(s) encontran-se vazios:\n"
                    + camposVazios
                    + "\nMensagem do sistema: " + e);
            return false;
        } else {
            return true;
        }

    }

    private void acaoGravar() {
        if (validacampos()) {
            m = new Mensagens();
            p = new Produto();
            e = new Estoque();
            compra = new Compra();

            p.setProdutoNome(jtfProdNome.getText());
            p.setFabricanteId(fabricante);
            p.setFornecedorId(fornecedor);
            p.setProdutoCodigoBarras(jtfCodigoBarras.getText());
            p.setValor(Float.parseFloat(jtfValor.getText()));
            p.setGrupoProduto((Grupoproduto) jcbGrupoProduto.getSelectedItem());
            
            e.setFabricanteId(fabricante);
            e.setQuantidade(new Float(jtfQuantidade.getText()));
            e.setQuantidadeMIN(new Float(jtfQtdMinima.getText()));

            compra.setFornecedorId(fornecedor);

            LocalDate dataCompra = new LocalDate();
            try {
                dataCompra = Datas.localDateParser(jtfDataCompra.getText());
            } catch (Exception ex) {
                m.jopError("Data informada no padrão errado! \n" + ex);
            }

            compra.setDataCompra(dataCompra);
            compra.setValorCompra(Float.parseFloat(jtfValorCompra.getText()));

            produtoController = new ProdutoController();
            p = produtoController.gravar(p, e, compra);
            if (p.getProduto_id() != null) {
                modeloProduto.addProduto(p);
                m = new Mensagens();
                m.jopAviso("Produto gravado com sucesso!");
                gerenciaCampos(false);
                setAba(0);
            }

        }
    }

    private void limparTela() {
        jtfProdNome.setText("");
        jcbFabricanteCNPJ.removeAll();
        jcbFornecedorCNPJ.removeAll();
        jtfValor.setText("");
        jtfCodigoBarras.setText("");
        jtfQuantidade.setText("");
        jtfQtdMinima.setText("");
        jtfDataCompra.setText("");
        jtfValorCompra.setText("");
    }

    private void alterar(Produto p) {
        jtfCodigoBarras.setText(p.getProdutoCodigoBarras());
        jtfProdNome.setText(p.getProdutoNome());
        jtfValor.setText(p.getValor().toString());
        jcbFabricanteCNPJ.setSelectedItem(p.getFabricanteId());
        acaoBuscarFabricante();
        jcbFornecedorCNPJ.setSelectedItem(p.getFornecedorId());
        acaoBuscarFornecedor();
//        jtfQtdMinima.setText();
//        jtfValorCompra.setText();
        gerenciaCampos(true);
        setAba(1);
    }

    private boolean acaoBuscarFabricante() {
        try {
            if (jcbFabricanteCNPJ.getSelectedItem() != null) {
                if (!jcbFabricanteCNPJ.getSelectedItem().toString().equals("")) {

                    fabricanteController = new FabricanteController();
                    String s = jcbFabricanteCNPJ.getSelectedItem().toString();
                    DefaultComboBoxModel dcbm = fabricanteController.buscar("fabricanteCNPJ", s);

                    if (dcbm != null) {
                        jcbFabricanteCNPJ.setModel(dcbm);

                        if (jcbFabricanteCNPJ.getItemCount() >= 1) {
                            jcbFabricanteCNPJ.setSelectedIndex(-1);
                            jcbFabricanteCNPJ.setSelectedIndex(0);
                            fabricante = (Fabricante) jcbFabricanteCNPJ.getSelectedItem();
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
                } else {
                    m = new Mensagens();
                    m.jopAviso("É nescessário informar o CNPJ ou o nome do fabricante para efetuar uma busca.");
                    fabricante = null;
                    fabricanteController = null;
                    return false;
                }
            } else {
                m = new Mensagens();
                m.jopAviso("É nescessário informar o CNPJ ou o nome do fabricante para efetuar uma busca.");
                fabricante = null;
                fabricanteController = null;
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroFabricante.class.getName()).log(Level.SEVERE, null, ex + "\n É nescessário informar o CNPJ ou o nome do fabricante para efetuar uma busca.");
            System.out.println("exception >>>>>>>>>>>>>>>>>>>>>" + ex);
            m = new Mensagens();
            m.jopAlerta("É nescessário informar o CNPJ ou o nome do fabricante para efetuar uma busca.\n" + ex);
            return false;
        }
    }

    private boolean acaoBuscarFornecedor() {
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
                            m.jopAviso("Nenhum fornecedor encontrado.");
                            return false;
                        }
                    } else {
                        m = new Mensagens();
                        m.jopAviso("Nenhum fornecedor encontrado.");
                        return false;
                    }
                } else {
                    m = new Mensagens();
                    m.jopAviso("É nescessário informar o CNPJ do fornecedor para efetuar uma busca.");
                    fornecedor = null;
                    fornecedorController = null;
                    return false;
                }
            } else {
                m = new Mensagens();
                m.jopAviso("É nescessário informar o CNPJ do fornecedor para efetuar uma busca.");
                fornecedor = null;
                fornecedorController = null;
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastroFabricante.class.getName()).log(Level.SEVERE, null, ex + "\n É nescessário informar o CNPJ do fornecedor para efetuar uma busca.");
            m = new Mensagens();
            m.jopAlerta("É nescessário informar o CNPJ do fornecedor para efetuar uma busca.");
            return false;
        }
    }

    private void acaoNovo() {
        limparTela();
        gerenciaCampos(true);
        setAba(1);
    }

    private void gerenciaCampos(boolean habilitaDesabilita) {
        jtfCodigoBarras.setEnabled(habilitaDesabilita);
        jtfProdNome.setEnabled(habilitaDesabilita);
        jtfQtdMinima.setEnabled(habilitaDesabilita);
        jtfQuantidade.setEnabled(habilitaDesabilita);
        jtfValor.setEnabled(habilitaDesabilita);
        jtfValorCompra.setEnabled(habilitaDesabilita);

        jcbGrupoProduto.setEnabled(habilitaDesabilita);
        jcbFabricanteCNPJ.setEnabled(habilitaDesabilita);
        jcbFornecedorCNPJ.setEnabled(habilitaDesabilita);
        jtfDataCompra.setEnabled(habilitaDesabilita);
        jbGravar.setEnabled(habilitaDesabilita);
    }

    private void setAba(int i) {
        jtpAbas.setSelectedIndex(i);
    }
}
