/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Componentes.Componentes;
import ConstrutoresModelo.ConstrutorPessoaN;
import Controlador.ControladorPessoa;
import Controlador.Mensagens;
import Controlador.Sessao;
import DAO.PessoaDAO;
import Modelo.PessoaN;
import Modelo.Usuario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class NovoUsuario extends javax.swing.JDialog {

    /**
     * Creates new form NovoUsuario
     */
    Componentes c = new Componentes();
    ControladorPessoa controladorPessoa;
    JButton jbGravar;
    JButton jbBuscar;
    JButton jbExcluir;
    Mensagens m;
    Usuario u;
    ConstrutorPessoaN cP;
    PessoaN p;

    public NovoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();


        jbGravar = c.criaBotaoGravar();
        jbBuscar = c.criaBotaoBuscar();
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

        jpControles.add(jbGravar);
        jpControles.add(jbBuscar);
        jpControles.add(jbExcluir);


        if (null != Sessao.getInstance().getUsuario()) {
            int perfil = Sessao.getInstance().getUsuario().getPerfil();
            if (0 == perfil) {//1 = Administrador - 0 = Usuario
                jrbAdm.setEnabled(false);
                jrbUsuario.setSelected(true);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgTipoUsuario = new javax.swing.ButtonGroup();
        jpUsuario = new javax.swing.JPanel();
        jplUsuario = new javax.swing.JPanel();
        jlNomeUsuario = new javax.swing.JLabel();
        jlSenhaUsuario = new javax.swing.JLabel();
        jpTFUsuario = new javax.swing.JPanel();
        jtfNomeUsuario = new javax.swing.JTextField();
        jpfSenhaUsuario = new javax.swing.JPasswordField();
        jlTipoUsuario = new javax.swing.JPanel();
        jrbUsuario = new javax.swing.JRadioButton();
        jrbAdm = new javax.swing.JRadioButton();
        jpCadastroPessoa = new javax.swing.JPanel();
        jpCBCadastroPessoa = new javax.swing.JPanel();
        jcbPessoa = new javax.swing.JComboBox();
        jpLCadastroPessoa = new javax.swing.JPanel();
        jpNomePessoa = new javax.swing.JLabel();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");

        jpUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuário"));

        jplUsuario.setLayout(new java.awt.GridLayout(2, 1, 0, 12));

        jlNomeUsuario.setText("Nome de Usuário:");
        jplUsuario.add(jlNomeUsuario);

        jlSenhaUsuario.setText("Senha:");
        jplUsuario.add(jlSenhaUsuario);

        jpTFUsuario.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jpTFUsuario.add(jtfNomeUsuario);
        jpTFUsuario.add(jpfSenhaUsuario);

        jlTipoUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Usuario"));
        jlTipoUsuario.setLayout(new java.awt.GridLayout(2, 1));

        bgTipoUsuario.add(jrbUsuario);
        jrbUsuario.setSelected(true);
        jrbUsuario.setText("Usuario");
        jlTipoUsuario.add(jrbUsuario);

        bgTipoUsuario.add(jrbAdm);
        jrbAdm.setText("Administrador");
        jlTipoUsuario.add(jrbAdm);

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addComponent(jplUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTFUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioLayout.createSequentialGroup()
                .addGroup(jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jplUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpCadastroPessoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro da Pessoa"));

        jpCBCadastroPessoa.setLayout(new java.awt.GridLayout(1, 1));

        jcbPessoa.setEditable(true);
        jpCBCadastroPessoa.add(jcbPessoa);

        jpLCadastroPessoa.setLayout(new java.awt.GridLayout(1, 1));

        jpNomePessoa.setText("Nome:");
        jpLCadastroPessoa.add(jpNomePessoa);

        javax.swing.GroupLayout jpCadastroPessoaLayout = new javax.swing.GroupLayout(jpCadastroPessoa);
        jpCadastroPessoa.setLayout(jpCadastroPessoaLayout);
        jpCadastroPessoaLayout.setHorizontalGroup(
            jpCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroPessoaLayout.createSequentialGroup()
                .addComponent(jpLCadastroPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpCBCadastroPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpCadastroPessoaLayout.setVerticalGroup(
            jpCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCadastroPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpLCadastroPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpCBCadastroPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpControles.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpCadastroPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpCadastroPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-421)/2, (screenSize.height-322)/2, 421, 322);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (m.jopDeletar("Deseja realmente excluir este cadastro?") == JOptionPane.YES_OPTION) {
            acaoRemover();
        }
    }

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovoUsuario dialog = new NovoUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup bgTipoUsuario;
    private javax.swing.JComboBox jcbPessoa;
    private javax.swing.JLabel jlNomeUsuario;
    private javax.swing.JLabel jlSenhaUsuario;
    private javax.swing.JPanel jlTipoUsuario;
    private javax.swing.JPanel jpCBCadastroPessoa;
    private javax.swing.JPanel jpCadastroPessoa;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpLCadastroPessoa;
    private javax.swing.JLabel jpNomePessoa;
    private javax.swing.JPanel jpTFUsuario;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JPasswordField jpfSenhaUsuario;
    private javax.swing.JPanel jplUsuario;
    private javax.swing.JRadioButton jrbAdm;
    private javax.swing.JRadioButton jrbUsuario;
    private javax.swing.JTextField jtfNomeUsuario;
    // End of variables declaration//GEN-END:variables

    public boolean validaCampos() {
        if ((jtfNomeUsuario.getText() != null) && (jtfNomeUsuario.getText().compareTo("") > 0)
                && (jpfSenhaUsuario.toString() != null) && (jtfNomeUsuario.toString().compareTo("") > 0)) {
            return true;
        } else {
            m = new Mensagens();
            m.jopAviso("Os campos Nome de Usuário e Senha, são de preechimento obrigatório.");
            return false;
        }
    }

    public void acaoBuscar() {
        if (jcbPessoa.getSelectedItem() != null) {
            cP = new ConstrutorPessoaN();
            p = new PessoaN();
            p = cP.nome(jcbPessoa.getSelectedItem().toString())
                    .construir();
            controladorPessoa = new PessoaDAO();
            DefaultComboBoxModel dcbm = controladorPessoa.buscaPessoaNome(jcbPessoa.getSelectedItem().toString());
            if (dcbm.getSize() > 0) {
                jcbPessoa.setModel(dcbm);
                jcbPessoa.setSelectedIndex(0);
            } else {
                m = new Mensagens();
                m.jopAlerta("Nenhuma pessoa encontrada.");
            }
        }
    }

    public void acaoGravar() {
        if (validaCampos()) {
        
        
        }
    }
}