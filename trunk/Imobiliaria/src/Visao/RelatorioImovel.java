/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorGenerico;
import Controlador.ControladorRelatorioImoveis;
import Controlador.Mensagens;
import DAO.RelatorioImovelDAO;
import Modelo.ImovelN;
import Relatorios.ImprimeRelatorio;
import Util.FiltrosDigitacaoLetras;
import Util.FiltrosDigitacaoNumerico;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Bruno
 */
public class RelatorioImovel extends javax.swing.JDialog {

    /**
     * Creates new form RelatorioImovel
     */
    Componentes c;
    JButton jbImprimir;
    ImovelN imovel;
    String SQL = "";
    ControladorGenerico<Object, Object> controladorRelatorio;
    Mensagens m;

    public RelatorioImovel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jtfTamanho.setDocument(new FiltrosDigitacaoNumerico());
        jtfValor.setDocument(new FiltrosDigitacaoNumerico());
        jtfNumero.setDocument(new FiltrosDigitacaoNumerico());

        jtfRua.setDocument(new FiltrosDigitacaoLetras());
        jtfCidade.setDocument(new FiltrosDigitacaoLetras());
        jtfBairro.setDocument(new FiltrosDigitacaoLetras());

        c = new Componentes();
        jbImprimir = c.criaBotaoRelatorio();

        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jpControles.add(jbImprimir);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgVendido = new javax.swing.ButtonGroup();
        jpAgrupador = new javax.swing.JPanel();
        jpLabel = new javax.swing.JPanel();
        jlNumero = new javax.swing.JLabel();
        jlRua = new javax.swing.JLabel();
        jlBiarro = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlTamanho = new javax.swing.JLabel();
        jlValor = new javax.swing.JLabel();
        jpTextFields = new javax.swing.JPanel();
        jtfNumero = new javax.swing.JTextField();
        jtfRua = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfCidade = new javax.swing.JTextField();
        jtfTamanho = new javax.swing.JTextField();
        jtfValor = new javax.swing.JTextField();
        jpVendido = new javax.swing.JPanel();
        jrbSim = new javax.swing.JRadioButton();
        jrbNao = new javax.swing.JRadioButton();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Imóveis");

        jpAgrupador.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório de Imóveis"));

        jpLabel.setLayout(new java.awt.GridLayout(6, 1, 8, 8));

        jlNumero.setText("Número:");
        jpLabel.add(jlNumero);

        jlRua.setText("Rua:");
        jpLabel.add(jlRua);

        jlBiarro.setText("Bairro:");
        jpLabel.add(jlBiarro);

        jlCidade.setText("Cidade:");
        jpLabel.add(jlCidade);

        jlTamanho.setText("Tamanho:");
        jpLabel.add(jlTamanho);

        jlValor.setText("Valor:");
        jpLabel.add(jlValor);

        jpTextFields.setLayout(new java.awt.GridLayout(6, 1, 0, 8));
        jpTextFields.add(jtfNumero);
        jpTextFields.add(jtfRua);
        jpTextFields.add(jtfBairro);
        jpTextFields.add(jtfCidade);
        jpTextFields.add(jtfTamanho);
        jpTextFields.add(jtfValor);

        jpVendido.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Vendido")));
        jpVendido.setLayout(new java.awt.BorderLayout());

        bgVendido.add(jrbSim);
        jrbSim.setText("Sim");
        jpVendido.add(jrbSim, java.awt.BorderLayout.CENTER);

        bgVendido.add(jrbNao);
        jrbNao.setSelected(true);
        jrbNao.setText("Não");
        jpVendido.add(jrbNao, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jpAgrupadorLayout = new javax.swing.GroupLayout(jpAgrupador);
        jpAgrupador.setLayout(jpAgrupadorLayout);
        jpAgrupadorLayout.setHorizontalGroup(
            jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgrupadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAgrupadorLayout.createSequentialGroup()
                        .addComponent(jpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpTextFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpAgrupadorLayout.createSequentialGroup()
                        .addComponent(jpVendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 179, Short.MAX_VALUE))))
        );
        jpAgrupadorLayout.setVerticalGroup(
            jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgrupadorLayout.createSequentialGroup()
                .addGroup(jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpTextFields, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpVendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpControles.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpAgrupador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpAgrupador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-282)/2, (screenSize.height-374)/2, 282, 374);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {
        controladorRelatorio = new RelatorioImovelDAO();
        ArrayList<ImovelN> lista = controladorRelatorio.relatorioImoveis(montaFiltros());
        if (0 == lista.size() || lista == null) {
            m = new Mensagens();
            m.jopAlerta("Nenhum dado encontrado.");
        } else {
            new ImprimeRelatorio(lista, "rImovel");
        }

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
            java.util.logging.Logger.getLogger(RelatorioImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RelatorioImovel dialog = new RelatorioImovel(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgVendido;
    private javax.swing.JLabel jlBiarro;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlRua;
    private javax.swing.JLabel jlTamanho;
    private javax.swing.JLabel jlValor;
    private javax.swing.JPanel jpAgrupador;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpLabel;
    private javax.swing.JPanel jpTextFields;
    private javax.swing.JPanel jpVendido;
    private javax.swing.JRadioButton jrbNao;
    private javax.swing.JRadioButton jrbSim;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfRua;
    private javax.swing.JTextField jtfTamanho;
    private javax.swing.JTextField jtfValor;
    // End of variables declaration//GEN-END:variables

    public String montaFiltros() {

        if ((jtfNumero.getText() != null) && (jtfNumero.getText().compareTo("") != 0)) {
            SQL = jtfNumero.getText() + ";";
        } else {
            SQL = SQL + "numero" + ";";
        }

        if ((null != jtfRua.getText()) && (jtfRua.getText().compareTo("") != 0)) {
            SQL = SQL + jtfRua.getText() + ";";
        } else {
            SQL = SQL + "rua" + ";";
        }

        if ((null != jtfBairro.getText()) && (jtfBairro.getText().compareTo("") != 0)) {
            SQL = SQL + jtfBairro.getText() + ";";
        } else {
            SQL = SQL + "bairro" + ";";
        }

        if ((null != jtfCidade.getText()) && (jtfCidade.getText().compareTo("") != 0)) {
            SQL = SQL + jtfCidade.getText() + ";";
        } else {
            SQL = SQL + "cidade" + ";";
        }

        if ((null != jtfValor.getText()) && (jtfValor.getText().compareTo("") != 0)) {
            SQL = SQL + jtfValor.getText() + ";";
        } else {
            SQL = SQL + "valor" + ";";
        }

        //vendido (1 = SIM) (2 = NAO)
        if (jrbSim.isSelected()) {
            SQL = SQL + 1 + ";";
        } else {
            if (jrbNao.isSelected()) {
                SQL = SQL + 0 + ";";
            } else {
                SQL = SQL + "vendido" + ";";
            }
        }

        if ((null != jtfTamanho.getText()) && (jtfTamanho.getText().compareTo("") != 0)) {
            SQL = SQL + jtfTamanho.getText() + ";";
        } else {
            SQL = SQL + "tamanho" + ";";
        }

        return SQL;
    }
}
