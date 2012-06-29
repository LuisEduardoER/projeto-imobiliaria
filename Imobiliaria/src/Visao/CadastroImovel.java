/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastroImovel.java
 *
 * Created on 12/01/2012, 19:24:39
 */
package Visao;

/**
 *
 * @author Bruno
 */
public class CadastroImovel extends javax.swing.JFrame {

    /** Creates new form CadastroImovel */
    public CadastroImovel() {
        initComponents();
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspRolagem = new javax.swing.JScrollPane();
        jpCadastroImovel = new javax.swing.JPanel();
        jpTipo = new javax.swing.JPanel();
        jlTipoImovel = new javax.swing.JLabel();
        jcbTipoImovel = new javax.swing.JComboBox();
        jChkbLocacao = new javax.swing.JCheckBox();
        jChkbVenda = new javax.swing.JCheckBox();
        jChkbComercial = new javax.swing.JCheckBox();
        jChkbResidncial = new javax.swing.JCheckBox();
        jpEndereco = new javax.swing.JPanel();
        jlPais = new javax.swing.JLabel();
        jlRecebePais = new javax.swing.JLabel();
        jlEstado = new javax.swing.JLabel();
        jlRecebeEstado = new javax.swing.JLabel();
        jlCidade = new javax.swing.JLabel();
        jlRecebeCidade = new javax.swing.JLabel();
        jlBairro = new javax.swing.JLabel();
        jlRecebeBairro = new javax.swing.JLabel();
        jlLogradouro = new javax.swing.JLabel();
        jlRecebeLogradouro = new javax.swing.JLabel();
        jlCEP = new javax.swing.JLabel();
        jlRecebeCEP = new javax.swing.JLabel();
        jlComplemento = new javax.swing.JLabel();
        jlRecebeComplemento = new javax.swing.JLabel();
        jlLocalizacaoQuadra = new javax.swing.JLabel();
        jlRecebeLocQuadra = new javax.swing.JLabel();
        jbModificarEndereco = new javax.swing.JButton();
        jpPropriedades = new javax.swing.JPanel();
        jlQuartos = new javax.swing.JLabel();
        jlSalas = new javax.swing.JLabel();
        jlBanheiros = new javax.swing.JLabel();
        jlSuites = new javax.swing.JLabel();
        jlGaragem = new javax.swing.JLabel();
        jlVagaGaragem = new javax.swing.JLabel();
        jcbNumeroQuartos = new javax.swing.JComboBox();
        jcbNumeroSuites = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jChkbPiscina = new javax.swing.JCheckBox();
        jChkbSotao = new javax.swing.JCheckBox();
        jChkbPorao = new javax.swing.JCheckBox();
        jChkbSacada = new javax.swing.JCheckBox();
        jChkbCloset = new javax.swing.JCheckBox();
        jChkbMobiliada = new javax.swing.JCheckBox();
        jChkbEmbutidos = new javax.swing.JCheckBox();
        jChkbEdicula = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jChkbTipoConstrucao = new javax.swing.JCheckBox();
        jChkbTipoAssoalho = new javax.swing.JCheckBox();
        jChkbTipoForro = new javax.swing.JCheckBox();
        jChkbTipoTelhado = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Imóvel");
        setMinimumSize(new java.awt.Dimension(800, 600));

        jspRolagem.setMinimumSize(new java.awt.Dimension(800, 768));
        jspRolagem.setPreferredSize(new java.awt.Dimension(800, 600));

        jpCadastroImovel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Imóvel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jpCadastroImovel.setMinimumSize(new java.awt.Dimension(800, 600));
        jpCadastroImovel.setPreferredSize(new java.awt.Dimension(800, 600));

        jpTipo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlTipoImovel.setText("Tipo do Imóvel:");

        jcbTipoImovel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbTipoImovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoImovelActionPerformed(evt);
            }
        });

        jChkbLocacao.setText("Locação");

        jChkbVenda.setText("Venda");

        jChkbComercial.setText("Comercial");

        jChkbResidncial.setText("Residencial");

        javax.swing.GroupLayout jpTipoLayout = new javax.swing.GroupLayout(jpTipo);
        jpTipo.setLayout(jpTipoLayout);
        jpTipoLayout.setHorizontalGroup(
            jpTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTipoImovel)
                .addGap(18, 18, 18)
                .addComponent(jcbTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jChkbLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jChkbVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jChkbComercial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jChkbResidncial)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        jpTipoLayout.setVerticalGroup(
            jpTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipoImovel)
                    .addComponent(jcbTipoImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChkbLocacao)
                    .addComponent(jChkbVenda)
                    .addComponent(jChkbComercial)
                    .addComponent(jChkbResidncial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jlPais.setText("Pais:");

        jlRecebePais.setText("(não definido)");

        jlEstado.setText("Estado:");

        jlRecebeEstado.setText("(não definido)");

        jlCidade.setText("Cidade:");

        jlRecebeCidade.setText("(não definido)");

        jlBairro.setText("Bairro:");

        jlRecebeBairro.setText("(não definido)");

        jlLogradouro.setText("Logradouro:");

        jlRecebeLogradouro.setText("(não definido)");

        jlCEP.setText("CEP:");

        jlRecebeCEP.setText("(não definido)");

        jlComplemento.setText("Complemento");

        jlRecebeComplemento.setText("(não definido)");

        jlLocalizacaoQuadra.setText("Localização na Quadra:");

        jlRecebeLocQuadra.setText("(não definido)");

        jbModificarEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/editar2.png"))); // NOI18N
        jbModificarEndereco.setToolTipText("Editar Endereço");

        javax.swing.GroupLayout jpEnderecoLayout = new javax.swing.GroupLayout(jpEndereco);
        jpEndereco.setLayout(jpEnderecoLayout);
        jpEnderecoLayout.setHorizontalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlRecebeEstado))
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlRecebeCidade))
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlRecebeBairro))
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlLogradouro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlRecebeLogradouro))
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlRecebeCEP))
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlComplemento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlRecebeComplemento))
                            .addGroup(jpEnderecoLayout.createSequentialGroup()
                                .addComponent(jlPais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlRecebePais)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                        .addComponent(jbModificarEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpEnderecoLayout.createSequentialGroup()
                        .addComponent(jlLocalizacaoQuadra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlRecebeLocQuadra)
                        .addContainerGap())))
        );
        jpEnderecoLayout.setVerticalGroup(
            jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPais)
                    .addComponent(jlRecebePais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstado)
                    .addComponent(jlRecebeEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCidade)
                    .addComponent(jlRecebeCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBairro)
                    .addComponent(jlRecebeBairro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLogradouro)
                    .addComponent(jlRecebeLogradouro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCEP)
                    .addComponent(jlRecebeCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlComplemento)
                    .addComponent(jlRecebeComplemento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLocalizacaoQuadra)
                    .addComponent(jlRecebeLocQuadra)))
            .addComponent(jbModificarEndereco)
        );

        jpPropriedades.setBorder(javax.swing.BorderFactory.createTitledBorder("Cômodos"));

        jlQuartos.setText("Quartos:");

        jlSalas.setText("Salas:");

        jlBanheiros.setText("Banheiros:");

        jlSuites.setText("Suítes:");

        jlGaragem.setText("Garagem:");

        jlVagaGaragem.setText("Vaga de Garagem:");

        jcbNumeroQuartos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbNumeroSuites.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpPropriedadesLayout = new javax.swing.GroupLayout(jpPropriedades);
        jpPropriedades.setLayout(jpPropriedadesLayout);
        jpPropriedadesLayout.setHorizontalGroup(
            jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPropriedadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPropriedadesLayout.createSequentialGroup()
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlQuartos)
                            .addComponent(jlSalas))
                        .addGap(18, 18, 18)
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbNumeroQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNumeroSuites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlVagaGaragem)
                            .addComponent(jlGaragem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPropriedadesLayout.createSequentialGroup()
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlBanheiros)
                            .addComponent(jlSuites))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(457, Short.MAX_VALUE))
        );
        jpPropriedadesLayout.setVerticalGroup(
            jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPropriedadesLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbNumeroQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlQuartos)
                    .addComponent(jlGaragem)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSalas)
                    .addComponent(jcbNumeroSuites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlVagaGaragem)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBanheiros)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPropriedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSuites))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Extras"));

        jChkbPiscina.setText("Piscina:");

        jChkbSotao.setText("Sótão:");

        jChkbPorao.setText("Porão:");

        jChkbSacada.setText("Sacada:");

        jChkbCloset.setText("Closet:");

        jChkbMobiliada.setText("Mobiliada:");

        jChkbEmbutidos.setText("Embutidos:");

        jChkbEdicula.setText("Edícula:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkbPorao)
                    .addComponent(jChkbSotao)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkbEdicula)
                            .addComponent(jChkbSacada)
                            .addComponent(jChkbCloset))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChkbMobiliada)
                            .addComponent(jChkbEmbutidos)
                            .addComponent(jChkbPiscina))))
                .addContainerGap(553, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jChkbEdicula)
                        .addGap(0, 0, 0)
                        .addComponent(jChkbSacada)
                        .addGap(0, 0, 0)
                        .addComponent(jChkbCloset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkbPorao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChkbSotao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jChkbMobiliada)
                        .addGap(0, 0, 0)
                        .addComponent(jChkbEmbutidos)
                        .addGap(0, 0, 0)
                        .addComponent(jChkbPiscina)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Características"));

        jChkbTipoConstrucao.setText("Tipo de Construção:");

        jChkbTipoAssoalho.setText("Tipo de Assoalho:");

        jChkbTipoForro.setText("Tipo de Forro:");

        jChkbTipoTelhado.setText("Tipo de Telhado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChkbTipoTelhado)
                    .addComponent(jChkbTipoForro)
                    .addComponent(jChkbTipoAssoalho)
                    .addComponent(jChkbTipoConstrucao))
                .addContainerGap(653, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jChkbTipoTelhado)
                .addGap(0, 0, 0)
                .addComponent(jChkbTipoForro)
                .addGap(0, 0, 0)
                .addComponent(jChkbTipoAssoalho)
                .addGap(0, 0, 0)
                .addComponent(jChkbTipoConstrucao)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpCadastroImovelLayout = new javax.swing.GroupLayout(jpCadastroImovel);
        jpCadastroImovel.setLayout(jpCadastroImovelLayout);
        jpCadastroImovelLayout.setHorizontalGroup(
            jpCadastroImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPropriedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpCadastroImovelLayout.setVerticalGroup(
            jpCadastroImovelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroImovelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jpEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpPropriedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jspRolagem.setViewportView(jpCadastroImovel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspRolagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jspRolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-816)/2, (screenSize.height-604)/2, 816, 604);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbTipoImovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoImovelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoImovelActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroImovel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroImovel().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jChkbCloset;
    private javax.swing.JCheckBox jChkbComercial;
    private javax.swing.JCheckBox jChkbEdicula;
    private javax.swing.JCheckBox jChkbEmbutidos;
    private javax.swing.JCheckBox jChkbLocacao;
    private javax.swing.JCheckBox jChkbMobiliada;
    private javax.swing.JCheckBox jChkbPiscina;
    private javax.swing.JCheckBox jChkbPorao;
    private javax.swing.JCheckBox jChkbResidncial;
    private javax.swing.JCheckBox jChkbSacada;
    private javax.swing.JCheckBox jChkbSotao;
    private javax.swing.JCheckBox jChkbTipoAssoalho;
    private javax.swing.JCheckBox jChkbTipoConstrucao;
    private javax.swing.JCheckBox jChkbTipoForro;
    private javax.swing.JCheckBox jChkbTipoTelhado;
    private javax.swing.JCheckBox jChkbVenda;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbModificarEndereco;
    private javax.swing.JComboBox jcbNumeroQuartos;
    private javax.swing.JComboBox jcbNumeroSuites;
    private javax.swing.JComboBox jcbTipoImovel;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlBanheiros;
    private javax.swing.JLabel jlCEP;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlEstado;
    private javax.swing.JLabel jlGaragem;
    private javax.swing.JLabel jlLocalizacaoQuadra;
    private javax.swing.JLabel jlLogradouro;
    private javax.swing.JLabel jlPais;
    private javax.swing.JLabel jlQuartos;
    private javax.swing.JLabel jlRecebeBairro;
    private javax.swing.JLabel jlRecebeCEP;
    private javax.swing.JLabel jlRecebeCidade;
    private javax.swing.JLabel jlRecebeComplemento;
    private javax.swing.JLabel jlRecebeEstado;
    private javax.swing.JLabel jlRecebeLocQuadra;
    private javax.swing.JLabel jlRecebeLogradouro;
    private javax.swing.JLabel jlRecebePais;
    private javax.swing.JLabel jlSalas;
    private javax.swing.JLabel jlSuites;
    private javax.swing.JLabel jlTipoImovel;
    private javax.swing.JLabel jlVagaGaragem;
    private javax.swing.JPanel jpCadastroImovel;
    private javax.swing.JPanel jpEndereco;
    private javax.swing.JPanel jpPropriedades;
    private javax.swing.JPanel jpTipo;
    private javax.swing.JScrollPane jspRolagem;
    // End of variables declaration//GEN-END:variables



}
