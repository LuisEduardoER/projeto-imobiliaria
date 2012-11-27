/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import Controlador.ControladorGenerico;
import Controlador.Mensagens;
import DAO.RelatorioImovelDAO;
import DAO.RelatorioVendaDAO;
import Modelo.Venda;
import Relatorios.ImprimeRelatorioVenda;
import Util.FiltrosDigitacaoNumerico;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Bruno
 */
public class RelatorioVenda extends javax.swing.JDialog {

    /**
     * Creates new form RelatorioImovel
     */
    Componentes c;
    JButton jbImprimir;
    Venda venda;
    String SQL = "";
    ControladorGenerico<Object, Object> controladorRelatorio;
    Mensagens m;

    public RelatorioVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jtfNumero.setDocument(new FiltrosDigitacaoNumerico());


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
        jpTextFields = new javax.swing.JPanel();
        jtfNumero = new javax.swing.JTextField();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Imóveis");

        jpAgrupador.setBorder(javax.swing.BorderFactory.createTitledBorder("Relatório de Imóveis"));

        jpLabel.setLayout(new java.awt.GridLayout(1, 1, 1, 1));

        jlNumero.setText("Número:");
        jpLabel.add(jlNumero);

        jpTextFields.setLayout(new java.awt.GridLayout(1, 1, 0, 1));
        jpTextFields.add(jtfNumero);

        javax.swing.GroupLayout jpAgrupadorLayout = new javax.swing.GroupLayout(jpAgrupador);
        jpAgrupador.setLayout(jpAgrupadorLayout);
        jpAgrupadorLayout.setHorizontalGroup(
            jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgrupadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTextFields, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );
        jpAgrupadorLayout.setVerticalGroup(
            jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAgrupadorLayout.createSequentialGroup()
                .addGroup(jpAgrupadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpTextFields, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-282)/2, (screenSize.height-154)/2, 282, 154);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {
        controladorRelatorio = new RelatorioVendaDAO();
        ArrayList<Venda> lista = controladorRelatorio.relatorioVendas(montaFiltros());
        if (0 == lista.size() || lista == null) {
            m = new Mensagens();
            m.jopAlerta("Nenhum dado encontrado.");
        } else {
            new ImprimeRelatorioVenda(lista, "rImovel");
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
            java.util.logging.Logger.getLogger(RelatorioVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RelatorioVenda dialog = new RelatorioVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jlNumero;
    private javax.swing.JPanel jpAgrupador;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpLabel;
    private javax.swing.JPanel jpTextFields;
    private javax.swing.JTextField jtfNumero;
    // End of variables declaration//GEN-END:variables

    public String montaFiltros() {

        if ((jtfNumero.getText() != null) && (jtfNumero.getText().compareTo("") != 0)) {
            SQL = jtfNumero.getText() + ";";
        } else {
            SQL = SQL + "numero" + ";";
        }

        return SQL;
    }
}