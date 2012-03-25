/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.Embutido;
import Modelo.Imovel;
import Modelo.TipoImovel;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public abstract class ImovelDAO {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;
    /*
     * public static DefaultComboBoxModel<Imovel> pesquisarImovel(String coluna,
     * String campos) {
     *
     * PreparedStatement stmt; ResultSet rs; DefaultComboBoxModel resultado;
     * Vector<Imovel> retorno = new Vector<Imovel>();
     *
     * try { stmt = this.con.prepareStatement("SELECT * FROM imoveis WHERE ?
     * LIKE ?;"); // criar consulta por atributos      *
     * // stmt.setString(1, coluna); // stmt.setString(2, "%" + i.getDescricao()
     * + "%");
     *
     * rs = stmt.executeQuery();
     *
     *
     * if (rs.first()) { if (rs.next()) { while (rs.next()) { Embutido embutido
     * = new Embutido();
     *
     * embutido.setDescricao(rs.getString("descricaoEmbutido"));
     * retorno.add(embutido); } } else { rs.first(); Embutido embutido = new
     * Embutido();
     *
     * embutido.setDescricao(rs.getString("descricaoEmbutido"));
     * retorno.add(embutido); } } else { return null; } } catch (SQLException
     * ex) {
     * Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE,
     * null, ex); JOptionPane.showMessageDialog(null, "Erro ao conectar no
     * servidor de banco de dados:\nSQLException: " + ex.getMessage()); return
     * null; } resultado = new DefaultComboBoxModel(retorno); return resultado;
     *
     * }
     */

    public static boolean verificaDescricaoTipoImovelExiste(String descricao) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = ImovelDAO.con.prepareStatement(""
                    + "SELECT numero,"
                    + "idCliente"
                    + "idEndereco"
                    + "FROM imoveis"
                    + "WHERE"
                    + "numero = imovel.getNumero()"
                    + "AND idCliente = proprietario.getID()"
                    + "AND idEndereco = imovel.getidEndereco()");
            
            stmt.setString(1, "'" + descricao + "'");
            rs = stmt.executeQuery();

            if (rs.first()) {
                mensagem.jopAlerta("Já existe um cadastro com este nome!");
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao verificar exitência de cadastros no servidor de banco de dados.\nSQLException: " + ex.getMessage());

            return false;
        }

    }

    public boolean gravarImovel(Imovel i) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            if (pesquisarImovel("numero,matricula,idEndereco", i.getEndereco()).verificaDescricaoEmbutidoExiste(novo.getDescricao(), msgErro)) { //criar verificacao por atributos

                stmt = this.con.prepareStatement(""
                        + "INSERT INTO `imobiliaria`.`imoveis`"
                        + "( `valor`,"
                        + "  `tamanho`,"
                        + "  `numero`,"
                        + "  `complemento`,"
                        + "  `quarto`,"
                        + "  `suite`,"
                        + "  `sala`,"
                        + "  `banheiro`,"
                        + "  `lavabo`,"
                        + "  `sacada`,"
                        + "  `idCloset`,"
                        + "  `churasqueira`,"
                        + "  `edicula`,"
                        + "  `idDocumento`,"
                        + "  `idGaragem`,"
                        + "  `locacao`,"
                        + "  `piscina`,"
                        + "  `idCliente`,"
                        + "  `idImovel`,"
                        + "  `idEndereco`,"
                        + "  `quadra`,"
                        + "  `lote`,"
                        + "  `matricula`,"
                        + "  `idEmbutido`)"
                        + "VALUES ('valor 1',"
                        + "  'tamanho 2',"
                        + "  'numero 3',"
                        + "  'complemento 4',"
                        + "  'quarto 5',"
                        + "  'suite 6',"
                        + "  'sala 7',"
                        + "  'banheiro 8',"
                        + "  'lavabo 9',"
                        + "  'sacada 10',"
                        + "  'idCloset 11',"
                        + "  'churasqueira 12',"
                        + "  'edicula 13',"
                        + "  'idDocumento 14',"
                        + "  'idGaragem 15',"
                        + "  'locacao 16',"
                        + "  'piscina 17',"
                        + "  'idClient 18e',"
                        + "  'idImovel 19',"
                        + "  'idEndereco 20',"
                        + "  'quadra 21',"
                        + "  'lote 22',"
                        + "  'matricula 23',"
                        + "  'idEmbutido 24');");

                stmt.setInt(1, maxId);
                stmt.setString(2, novo.getDescricao());
                stmt.execute();

                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return false;
        }
    }
}
