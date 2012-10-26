/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorPessoa;
import Controlador.ControladorReabilitarImovel;
import Controlador.Mensagens;
import DAO.ReabilitarVendaDAO;
import Modelo.ImovelN;
import Modelo.PessoaN;
import Modelo.ReabilitaImovelModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

/**
 *
 * @author Bruno
 */
public class ReabilitarVenda extends javax.swing.JDialog {

    /**
     * Creates new form ReabilitarVenda
     */
    ControladorReabilitarImovel controlador;
    ReabilitaImovelModel reabilita;
    ImovelN imovelN;
    Mensagens m;

    public ReabilitarVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();


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
        jpiL = new javax.swing.JPanel();
        jcbNumero = new javax.swing.JComboBox();
        jpDadosImovel = new javax.swing.JPanel();
        jpDL = new javax.swing.JPanel();
        jlDadosNumero = new javax.swing.JLabel();
        jlDadosRua = new javax.swing.JLabel();
        jlDadosBairro = new javax.swing.JLabel();
        jlDadosCidade = new javax.swing.JLabel();
        jlDadosTamanho = new javax.swing.JLabel();
        jlDadosValor = new javax.swing.JLabel();
        jlDadosProprietario = new javax.swing.JLabel();
        jlDadosCPF = new javax.swing.JLabel();
        jpDDados = new javax.swing.JPanel();
        jlDadosMostraNumero = new javax.swing.JLabel();
        jlDadosMostraRua = new javax.swing.JLabel();
        jlDadosMostrabairro = new javax.swing.JLabel();
        jlDadosMostraCidade = new javax.swing.JLabel();
        jlDadosMostraTamanho = new javax.swing.JLabel();
        jlDadosMostraValor = new javax.swing.JLabel();
        jlDadosMostraNome = new javax.swing.JLabel();
        jlDadosMostraCPF = new javax.swing.JLabel();
        jpControles = new javax.swing.JPanel();
        jbProcessar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reabilitar Imóvel Para Venda");

        jpImovel.setBorder(javax.swing.BorderFactory.createTitledBorder("Imóvel"));

        jpIL.setLayout(new java.awt.GridLayout(1, 1));

        jlNumero.setText("Número:");
        jpIL.add(jlNumero);

        jpiL.setLayout(new java.awt.GridLayout(1, 1, 1, 1));

        jcbNumero.setEditable(true);
        jcbNumero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNumeroItemStateChanged(evt);
            }
        });
        jpiL.add(jcbNumero);

        jpDadosImovel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jpDL.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        jlDadosNumero.setText("Número:");
        jpDL.add(jlDadosNumero);

        jlDadosRua.setText("Rua:");
        jpDL.add(jlDadosRua);

        jlDadosBairro.setText("Bairro:");
        jpDL.add(jlDadosBairro);

        jlDadosCidade.setText("Cidade:");
        jpDL.add(jlDadosCidade);

        jlDadosTamanho.setText("Tamanho:");
        jpDL.add(jlDadosTamanho);

        jlDadosValor.setText("Valor:");
        jpDL.add(jlDadosValor);

        jlDadosProprietario.setText("Proprietário:");
        jpDL.add(jlDadosProprietario);

        jlDadosCPF.setText("CPF:");
        jpDL.add(jlDadosCPF);

        jpDDados.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        jlDadosMostraNumero.setText("(numero)");
        jpDDados.add(jlDadosMostraNumero);

        jlDadosMostraRua.setText("(rua)");
        jpDDados.add(jlDadosMostraRua);

        jlDadosMostrabairro.setText("(bairro)");
        jpDDados.add(jlDadosMostrabairro);

        jlDadosMostraCidade.setText("(cidade)");
        jpDDados.add(jlDadosMostraCidade);

        jlDadosMostraTamanho.setText("(tamanho)");
        jpDDados.add(jlDadosMostraTamanho);

        jlDadosMostraValor.setText("(valor)");
        jpDDados.add(jlDadosMostraValor);

        jlDadosMostraNome.setText("(nome)");
        jpDDados.add(jlDadosMostraNome);

        jlDadosMostraCPF.setText("(cpf)");
        jpDDados.add(jlDadosMostraCPF);

        javax.swing.GroupLayout jpDadosImovelLayout = new javax.swing.GroupLayout(jpDadosImovel);
        jpDadosImovel.setLayout(jpDadosImovelLayout);
        jpDadosImovelLayout.setHorizontalGroup(
            jpDadosImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosImovelLayout.createSequentialGroup()
                .addComponent(jpDL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDDados, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpDadosImovelLayout.setVerticalGroup(
            jpDadosImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpDDados, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(jpDL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpImovelLayout = new javax.swing.GroupLayout(jpImovel);
        jpImovel.setLayout(jpImovelLayout);
        jpImovelLayout.setHorizontalGroup(
            jpImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImovelLayout.createSequentialGroup()
                .addComponent(jpIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpiL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpImovelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDadosImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpImovelLayout.setVerticalGroup(
            jpImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImovelLayout.createSequentialGroup()
                .addGroup(jpImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpiL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpDadosImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpControles.setLayout(new java.awt.GridLayout(1, 1, 1, 0));

        jbProcessar.setText("Processar");
        jbProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcessarActionPerformed(evt);
            }
        });
        jpControles.add(jbProcessar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpImovel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-416)/2, (screenSize.height-322)/2, 416, 322);
    }// </editor-fold>//GEN-END:initComponents

    private void jbProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcessarActionPerformed
        acaoProcessar();
    }//GEN-LAST:event_jbProcessarActionPerformed

    private void jcbNumeroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNumeroItemStateChanged
        acaoBuscar();
    }//GEN-LAST:event_jcbNumeroItemStateChanged

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
            java.util.logging.Logger.getLogger(ReabilitarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReabilitarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReabilitarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReabilitarVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReabilitarVenda dialog = new ReabilitarVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbProcessar;
    private javax.swing.JComboBox jcbNumero;
    private javax.swing.JLabel jlDadosBairro;
    private javax.swing.JLabel jlDadosCPF;
    private javax.swing.JLabel jlDadosCidade;
    private javax.swing.JLabel jlDadosMostraCPF;
    private javax.swing.JLabel jlDadosMostraCidade;
    private javax.swing.JLabel jlDadosMostraNome;
    private javax.swing.JLabel jlDadosMostraNumero;
    private javax.swing.JLabel jlDadosMostraRua;
    private javax.swing.JLabel jlDadosMostraTamanho;
    private javax.swing.JLabel jlDadosMostraValor;
    private javax.swing.JLabel jlDadosMostrabairro;
    private javax.swing.JLabel jlDadosNumero;
    private javax.swing.JLabel jlDadosProprietario;
    private javax.swing.JLabel jlDadosRua;
    private javax.swing.JLabel jlDadosTamanho;
    private javax.swing.JLabel jlDadosValor;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpDDados;
    private javax.swing.JPanel jpDL;
    private javax.swing.JPanel jpDadosImovel;
    private javax.swing.JPanel jpIL;
    private javax.swing.JPanel jpImovel;
    private javax.swing.JPanel jpiL;
    // End of variables declaration//GEN-END:variables

    private boolean validaCampos() {
        if (null != jcbNumero.getSelectedItem()) {
            return true;
        } else {
            return false;
        }
    }

    private void acaoProcessar() {
        if (validaCampos()) {
            ReabilitaImovelModel reabilitar = new ReabilitaImovelModel();
            reabilitar.setNumero(Integer.parseInt(jcbNumero.getSelectedItem().toString()));
            controlador = new ReabilitarVendaDAO();
            if (controlador.reabilitaImovel(reabilitar)) {
                m.jopAviso("Imovel disponível para venda novamente.");
            }
        }
    }

    private void acaoBuscar() {
        ReabilitaImovelModel reabilitar = new ReabilitaImovelModel();
        reabilitar.setNumero(Integer.parseInt(jcbNumero.getSelectedItem().toString()));
        controlador = new ReabilitarVendaDAO();
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        dcbm = controlador.listaImoveis(reabilitar);
        jcbNumero.setModel(dcbm);
        montarTela(reabilitar);
    }

    public void montarTela(ReabilitaImovelModel reabilitar) {
        jlDadosMostraCPF.setText(reabilitar.getCPF() + "");
        jlDadosMostraCidade.setText(reabilitar.getCidade() + "");
        jlDadosMostrabairro.setText(reabilitar.getBairro());
        jlDadosMostraNome.setText(reabilitar.getNome() + "");
        jlDadosMostraNumero.setText(reabilitar.getNumero() + "");
        jlDadosMostraRua.setText(reabilitar.getRua());
        jlDadosMostraTamanho.setText(reabilitar.getTamanho() + "");
        jlDadosMostraValor.setText(reabilitar.getValor() + "");
    }
}
