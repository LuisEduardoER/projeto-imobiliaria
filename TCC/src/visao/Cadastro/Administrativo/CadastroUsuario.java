/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao.Cadastro.Administrativo;

import Componentes.Componentes;
import Componentes.TableModelFuncionario;
import controller.Cadastro.Administrativo.FuncionarioController;
import controller.Cadastro.Administrativo.UsuarioController;
import controller.Cadastro.Endereco.BairroController;
import controller.Cadastro.Endereco.CepController;
import controller.Cadastro.Endereco.CidadeController;
import controller.Cadastro.Endereco.EnderecoController;
import controller.Cadastro.Endereco.EstadoController;
import controller.Cadastro.Endereco.PaisController;
import controller.Cadastro.Endereco.RuaController;
import controller.Mensagens;
import controller.PerfilController;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Endereco.Bairro;
import modelo.Endereco.Cep;
import modelo.Endereco.Cidade;
import modelo.Endereco.Endereco;
import modelo.Endereco.Estado;
import modelo.Funcionario;
import modelo.Endereco.Pais;
import modelo.PerfisPermissoes.Perfil;
import modelo.Endereco.Rua;
import modelo.Usuario;

/**
 *
 * @author Bruno
 */
public class CadastroUsuario extends javax.swing.JDialog {

    /**
     * Creates new form CadastroUsuario
     */
    Componentes c = new Componentes();
    Mensagens m;
    JButton jbGravar = c.criaBotaoGravar();
    JButton jbExcluir = c.criaBotaoExcluir();
    JButton jbNovo = c.criaBotaoNovo();
    
    EstadoController estadoController;
    PaisController paisController;
    CidadeController cidadeController;
    BairroController bairroController;
    CepController cepController;
    RuaController ruaController;
    EnderecoController enderecoController;
    FuncionarioController funcionarioController;
    UsuarioController usuarioController;
    PerfilController perfilController;
    
    Pais p;
    Estado estado;
    Cidade cidade;
    Bairro bairro;
    Cep cep;
    Rua rua;
    Usuario usuario;
    Funcionario funcionario;
    Endereco endereco;
    Perfil perfil;
    
    List<Funcionario> funcionarioList;
    TableModelFuncionario modeloFuncionario;

    public CadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jtfNome.requestFocus();

        paisController = new PaisController();
        estadoController = new EstadoController();
        bairroController = new BairroController();
        ruaController = new RuaController();
        cepController = new CepController();
        funcionarioController = new FuncionarioController();
        perfilController = new PerfilController();

        jbGravar = c.criaBotaoGravar();
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

        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        funcionarioList = funcionarioController.buscaTodos();
        modeloFuncionario = new TableModelFuncionario();
        jtFuncionarios.setModel(modeloFuncionario);
        modeloFuncionario.addListaDeProdutos(funcionarioList);
        //jtFuncionarios.updateUI();

        jcbPerfil.setModel(perfilController.listPerfis());

        jcbPais.setModel(paisController.listPaises());
        jcbPais.updateUI();

        jcbEstados.setModel(estadoController.listEstados());
        jcbEstados.updateUI();

        if ((Estado) jcbEstados.getSelectedItem() != null) {
            cidadeController = new CidadeController();
            jcbCidade.setModel(cidadeController.listCidadesByEstado(((Estado) jcbEstados.getSelectedItem()).getEstadoId()));
            jcbCidade.updateUI();
        }

        if ((Cidade) jcbCidade.getSelectedItem() != null) {
            cidade = (Cidade) jcbCidade.getSelectedItem();
            jcbBairro.setModel(bairroController.listBairroByCidade(cidade.getCidade()));
            jcbBairro.updateUI();
        }

        if ((Bairro) jcbBairro.getSelectedItem() != null) {
            bairro = (Bairro) jcbBairro.getSelectedItem();
            jcbRua.setModel(ruaController.listRuaByBairro(bairro.getBairroId()));
            jcbRua.updateUI();
        }

        if ((Rua) jcbRua.getSelectedItem() != null) {
            rua = (Rua) jcbRua.getSelectedItem();
            jcbCEP.setModel(cepController.listCepByRua(rua.getRuaId()));
            jcbCEP.updateUI();
        }

        jpControles.add(jbExcluir);
        jpControles.add(jbGravar);
        jpControles.add(jbNovo);

        jtFuncionarios.setDefaultEditor(Object.class, null);
        jtFuncionarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                jtFuncionariosMouseClicked(e);
            }
        });
        jtpAbas.setEnabledAt(1, false);    
        jtpAbas.setEnabledAt(2, false);
    }

    private void jbGravarActionPerformed(java.awt.event.ActionEvent evt) {
        acaoGravar();
    }

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        m = new Mensagens();
        if (p != null) {
            if (p.getPaisID() != 0) {
                if (m.jopDeletar("Deseja realmente excluir este Pais ?") == JOptionPane.YES_OPTION) {
//                    acaoRemover();
                }
            } else {
                m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
            }
        } else {
            m.jopAlerta("Para excluir registro, é nescessário efetuar uma busca.");
        }
    }

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        limpar();
        jtpAbas.setEnabledAt(1, true);    
        jtpAbas.setEnabledAt(2, true);
    }

    private void jtFuncionariosMouseClicked(java.awt.event.MouseEvent e) {
        // TODO add your handling code here:  
        if (e.getClickCount() == 2) {
            Point p = e.getPoint();
            int row = jtFuncionarios.rowAtPoint(p);
            int col = jtFuncionarios.columnAtPoint(p);

            Funcionario funcionario = new Funcionario();
            funcionario = modeloFuncionario.getFuncionario(row);

            alterar(funcionario);
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

        jtpAbas = new javax.swing.JTabbedPane();
        jpConsultaFuncionarios = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFuncionarios = new javax.swing.JTable();
        jpFuncionario = new javax.swing.JPanel();
        jpDadosPessoais = new javax.swing.JPanel();
        jpTextField = new javax.swing.JPanel();
        jtfNome = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JTextField();
        jtfCPF = new javax.swing.JTextField();
        jtfRG = new javax.swing.JTextField();
        jtfCTPS = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jpLabel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpEndereco = new javax.swing.JPanel();
        jpTextFieldEndereco = new javax.swing.JPanel();
        jcbPais = new javax.swing.JComboBox();
        jcbEstados = new javax.swing.JComboBox();
        jcbCidade = new javax.swing.JComboBox();
        jpLabelEndereco = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpLabelEndereco1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jpTextFieldEndereco1 = new javax.swing.JPanel();
        jcbBairro = new javax.swing.JComboBox();
        jcbRua = new javax.swing.JComboBox();
        jcbCEP = new javax.swing.JComboBox();
        jpUsuario = new javax.swing.JPanel();
        jpDadosPessoais1 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jpTextField1 = new javax.swing.JPanel();
        jtfUserName = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jcbPerfil = new javax.swing.JComboBox();
        jpLabel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jpControles = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtFuncionarios);

        javax.swing.GroupLayout jpConsultaFuncionariosLayout = new javax.swing.GroupLayout(jpConsultaFuncionarios);
        jpConsultaFuncionarios.setLayout(jpConsultaFuncionariosLayout);
        jpConsultaFuncionariosLayout.setHorizontalGroup(
            jpConsultaFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultaFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpConsultaFuncionariosLayout.setVerticalGroup(
            jpConsultaFuncionariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpConsultaFuncionariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpAbas.addTab("Funcionários", jpConsultaFuncionarios);

        jpDadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Pessoais"));

        jpTextField.setLayout(new java.awt.GridLayout(6, 1, 0, 5));
        jpTextField.add(jtfNome);
        jpTextField.add(jtfTelefone);
        jpTextField.add(jtfCPF);
        jpTextField.add(jtfRG);
        jpTextField.add(jtfCTPS);
        jpTextField.add(jtfEmail);

        jpLabel.setLayout(new java.awt.GridLayout(6, 1, 0, 11));

        jLabel4.setText("Nome:");
        jpLabel.add(jLabel4);

        jLabel5.setText("Telefone:");
        jpLabel.add(jLabel5);

        jLabel6.setText("CPF:");
        jpLabel.add(jLabel6);

        jLabel7.setText("RG:");
        jpLabel.add(jLabel7);

        jLabel8.setText("CTPS:");
        jpLabel.add(jLabel8);

        jLabel9.setText("E-mail:");
        jpLabel.add(jLabel9);

        javax.swing.GroupLayout jpDadosPessoaisLayout = new javax.swing.GroupLayout(jpDadosPessoais);
        jpDadosPessoais.setLayout(jpDadosPessoaisLayout);
        jpDadosPessoaisLayout.setHorizontalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 372, Short.MAX_VALUE)
            .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jpDadosPessoaisLayout.setVerticalGroup(
            jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
            .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpDadosPessoaisLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jpTextFieldEndereco.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jpTextFieldEndereco.add(jcbPais);

        jpTextFieldEndereco.add(jcbEstados);

        jpTextFieldEndereco.add(jcbCidade);

        jpLabelEndereco.setLayout(new java.awt.GridLayout(5, 1, 0, 11));

        jLabel10.setText("Pais:");
        jpLabelEndereco.add(jLabel10);

        jLabel11.setText("Estado:");
        jpLabelEndereco.add(jLabel11);

        jLabel12.setText("Cidade:");
        jpLabelEndereco.add(jLabel12);

        jpLabelEndereco1.setLayout(new java.awt.GridLayout(5, 1, 0, 11));

        jLabel13.setText("Bairro:");
        jpLabelEndereco1.add(jLabel13);

        jLabel14.setText("Rua:");
        jpLabelEndereco1.add(jLabel14);

        jLabel15.setText("CEP:");
        jpLabelEndereco1.add(jLabel15);

        jpTextFieldEndereco1.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jpTextFieldEndereco1.add(jcbBairro);

        jpTextFieldEndereco1.add(jcbRua);

        jpTextFieldEndereco1.add(jcbCEP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jpTextFieldEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpLabelEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpTextFieldEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpLabelEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEnderecoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpEnderecoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jpTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(360, Short.MAX_VALUE)))
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpEnderecoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jpLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpFuncionarioLayout = new javax.swing.GroupLayout(jpFuncionario);
        jpFuncionario.setLayout(jpFuncionarioLayout);
        jpFuncionarioLayout.setHorizontalGroup(
            jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jpDadosPessoais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(260, 260, 260))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jpEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jpFuncionarioLayout.setVerticalGroup(
            jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpAbas.addTab("Dados Funcionário", jpFuncionario);

        jpDadosPessoais1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Acesso ao Sistema"));

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Ativo");

        jpTextField1.setLayout(new java.awt.GridLayout(3, 1, 0, 5));
        jpTextField1.add(jtfUserName);

        jpfSenha.setText("jPasswordField1");
        jpTextField1.add(jpfSenha);

        jpTextField1.add(jcbPerfil);

        jpLabel1.setLayout(new java.awt.GridLayout(3, 1, 0, 11));

        jLabel16.setText("Nome de Usuário:");
        jpLabel1.add(jLabel16);

        jLabel17.setText("Senha:");
        jpLabel1.add(jLabel17);

        jLabel18.setText("Perfil:");
        jpLabel1.add(jLabel18);

        javax.swing.GroupLayout jpDadosPessoais1Layout = new javax.swing.GroupLayout(jpDadosPessoais1);
        jpDadosPessoais1.setLayout(jpDadosPessoais1Layout);
        jpDadosPessoais1Layout.setHorizontalGroup(
            jpDadosPessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosPessoais1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
            .addGroup(jpDadosPessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpDadosPessoais1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jpTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jpDadosPessoais1Layout.setVerticalGroup(
            jpDadosPessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosPessoais1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
            .addGroup(jpDadosPessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpDadosPessoais1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpDadosPessoais1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jpLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpUsuarioLayout = new javax.swing.GroupLayout(jpUsuario);
        jpUsuario.setLayout(jpUsuarioLayout);
        jpUsuarioLayout.setHorizontalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpDadosPessoais1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(344, Short.MAX_VALUE))
        );
        jpUsuarioLayout.setVerticalGroup(
            jpUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpDadosPessoais1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jtpAbas.addTab("Dados Usuário", jpUsuario);

        jpControles.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpAbas, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(jpControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-695)/2, (screenSize.height-518)/2, 695, 518);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroUsuario dialog = new CadastroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbBairro;
    private javax.swing.JComboBox jcbCEP;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbEstados;
    private javax.swing.JComboBox jcbPais;
    private javax.swing.JComboBox jcbPerfil;
    private javax.swing.JComboBox jcbRua;
    private javax.swing.JPanel jpConsultaFuncionarios;
    private javax.swing.JPanel jpControles;
    private javax.swing.JPanel jpDadosPessoais;
    private javax.swing.JPanel jpDadosPessoais1;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JPanel jpFuncionario;
    private javax.swing.JPanel jpLabel;
    private javax.swing.JPanel jpLabel1;
    private javax.swing.JPanel jpLabelEndereco;
    private javax.swing.JPanel jpLabelEndereco1;
    private javax.swing.JPanel jpTextField;
    private javax.swing.JPanel jpTextField1;
    private javax.swing.JPanel jpTextFieldEndereco;
    private javax.swing.JPanel jpTextFieldEndereco1;
    private javax.swing.JPanel jpUsuario;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTable jtFuncionarios;
    private javax.swing.JTextField jtfCPF;
    private javax.swing.JTextField jtfCTPS;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfRG;
    private javax.swing.JTextField jtfTelefone;
    private javax.swing.JTextField jtfUserName;
    private javax.swing.JTabbedPane jtpAbas;
    // End of variables declaration//GEN-END:variables

    private void acaoGravar() {
        String avisos = "";
        Pais p = (Pais) jcbPais.getSelectedItem();
        Estado estado = (Estado) jcbEstados.getSelectedItem();
        Cidade cidade = (Cidade) jcbCidade.getSelectedItem();
        Bairro bairro = (Bairro) jcbBairro.getSelectedItem();
        Rua rua = (Rua) jcbRua.getSelectedItem();
        Cep cep = (Cep) jcbCEP.getSelectedItem();

        if (funcionario == null) {
            funcionario = new Funcionario();
        }

        usuario = new Usuario();
        endereco = new Endereco();
        enderecoController = new EnderecoController();
        funcionarioController = new FuncionarioController();

        if (p.getPaisID() == null) {
            avisos = avisos + "\n Pais não pode ser vazio";
        }

        if (estado.getEstadoId() == null) {
            avisos = avisos + "\n Estado não pode ser vazio ";
        }

        if (cidade.getCidade() == null) {
            avisos = avisos + "\n Cidade não pode ser vazio ";
        }

        if (bairro.getBairroId() == null) {
            avisos = avisos + "\n Bairro não pode ser vazio ";
        }

        if (rua.getRuaId() == null) {
            avisos = avisos + "\n Rua não pode ser vazio ";
        }

        if (cep.getCepID() == null) {
            avisos = avisos + "\n Cep não pode ser vazio ";
        }
        if (jtfNome.getText().equals("")) {
            avisos = avisos + "\n Nome não pode ser vazio ";
        }

        if (jtfCPF.getText().equals("")) {
            avisos = avisos + "\n CPF não pode ser vazio ";
        }

        if (jtfRG.getText().equals("")) {
            avisos = avisos + "\n RG não pode ser vazio";
        }

        if (avisos.equals("")) {
            endereco.setPais(p);
            endereco.setEstado(estado);
            endereco.setCidade(cidade);
            endereco.setBairro(bairro);
            endereco.setRua(rua);
            endereco.setCep(cep);

            endereco = enderecoController.gravar(endereco);

            if (!jtfUserName.getText().equals("") && !(new String(jpfSenha.getPassword())).toString().equals("")) {

                usuario.setUsuarioName(jtfUserName.getText());
                usuario.setUsuarioSenha(new String(jpfSenha.getPassword()));

                perfil = new Perfil();
                perfil = (Perfil) jcbPerfil.getSelectedItem();

                usuario.setUsuarioPerfil(perfil);

                funcionario.setIdUsuario(usuario);

                usuarioController = new UsuarioController();
                funcionario.setIdUsuario(usuarioController.gravar(funcionario));

                if (funcionario.getIdUsuario().getUsuarioId() == null) {
                    Mensagens m = new Mensagens();
                    m.jopAviso("Não foi possível gravar o usuário, porém, a gravação do funcionário continuará.");
                    funcionario.setIdUsuario(null);
                }
            }

            funcionario.setEnderecoID(endereco);
            funcionario.setCpfCnpj(new Integer(jtfCPF.getText()));
            funcionario.setCtps(jtfCPF.getText());
            funcionario.setEmail(jtfEmail.getText());
            funcionario.setNome(jtfNome.getText());
            funcionario.setRg(new Integer(jtfRG.getText()));
            funcionario.setTelefone(jtfTelefone.getText());

            funcionario = funcionarioController.gravar(funcionario);

            if (funcionario.getIdFuncionario() != null) {
                funcionarioList = funcionarioController.buscaTodos();
                modeloFuncionario = new TableModelFuncionario();
                jtFuncionarios.setModel(modeloFuncionario);
                modeloFuncionario.addListaDeProdutos(funcionarioList);
                gerenciaCampos(false);
                setAba(0);
                jtpAbas.setEnabledAt(1, false);    
                jtpAbas.setEnabledAt(2, false);
                m = new Mensagens();
                m.jopAviso("Funcionario " + funcionario.getNome() + " - CPF: " + funcionario.getCpfCnpj() + " gravado com sucesso!");
            }
        } else {
            m = new Mensagens();
            m.jopAlerta("Verifique: " + avisos + "!");
            jtfNome.requestFocus();
        }
    }

    private void alterar(Funcionario f) {
        funcionario = funcionarioController.buscarFuncionarioById(f.getIdFuncionario());

        jtfNome.setText(funcionario.getNome());
        jtfCPF.setText(funcionario.getCpfCnpj().toString());
        jtfCTPS.setText(funcionario.getCtps());
        jtfEmail.setText(funcionario.getEmail());
        jtfRG.setText(funcionario.getRg().toString());
        jtfTelefone.setText(funcionario.getTelefone());

        jcbPais.setSelectedItem(funcionario.getEnderecoID().getPais());
        jcbEstados.setSelectedItem(funcionario.getEnderecoID().getEstado());
        jcbCidade.setSelectedItem(funcionario.getEnderecoID().getCidade());
        jcbBairro.setSelectedItem(funcionario.getEnderecoID().getBairro());
        jcbRua.setSelectedItem(funcionario.getEnderecoID().getRua());
        jcbCEP.setSelectedItem(funcionario.getEnderecoID().getCep());

        if (funcionario.getIdUsuario() != null) {
            jtfUserName.setText(funcionario.getIdUsuario().getUsuarioName() != null ? funcionario.getIdUsuario().getUsuarioName() : "");
            jpfSenha.setText(funcionario.getIdUsuario().getUsuarioSenha() != null ? funcionario.getIdUsuario().getUsuarioSenha() : "");
        } else {
            jtfUserName.setText("");
            jpfSenha.setText("");
        }

        gerenciaCampos(true);
        setAba(1);
        jtpAbas.setEnabledAt(1, true);    
        jtpAbas.setEnabledAt(2, true);
    }

    private void gerenciaCampos(boolean abilitaDesabilita) {
        jtfNome.setEnabled(abilitaDesabilita);
        jtfCPF.setEnabled(abilitaDesabilita);
        jtfCTPS.setEnabled(abilitaDesabilita);
        jtfEmail.setEnabled(abilitaDesabilita);
        jtfRG.setEnabled(abilitaDesabilita);
        jtfTelefone.setEnabled(abilitaDesabilita);

        jcbPais.setEnabled(abilitaDesabilita);
        jcbEstados.setEnabled(abilitaDesabilita);
        jcbCidade.setEnabled(abilitaDesabilita);
        jcbBairro.setEnabled(abilitaDesabilita);
        jcbRua.setEnabled(abilitaDesabilita);
        jcbCEP.setEnabled(abilitaDesabilita);

        jtfUserName.setEnabled(abilitaDesabilita);
        jpfSenha.setEnabled(abilitaDesabilita);

        jbGravar.setEnabled(abilitaDesabilita);
        jbExcluir.setEnabled(abilitaDesabilita);
    }

    private void setAba(int i) {
        jtpAbas.setSelectedIndex(i);
    }

    private void limpar() {
        
        gerenciaCampos(true);
        
        jtfNome.setText("");
        jtfCPF.setText("");
        jtfCTPS.setText("");
        jtfEmail.setText("");
        jtfRG.setText("");
        jtfTelefone.setText("");

        jcbPais.setSelectedIndex(0);
        jcbEstados.setSelectedIndex(0);
        jcbCidade.setSelectedIndex(0);
        jcbBairro.setSelectedIndex(0);
        jcbRua.setSelectedIndex(0);
        jcbCEP.setSelectedIndex(0);

        jtfUserName.setText("");
        jpfSenha.setText("");
        setAba(1);
    }
}
