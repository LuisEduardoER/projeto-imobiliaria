/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.Imovel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public abstract class ImovelDAO {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    public static boolean verificaImovelExiste(Imovel i) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = ImovelDAO.con.prepareStatement(""
                    + "SELECT idEndereco,"
                    +        "idCliente"
                    + "FROM imoveis"
                    +  "WHERE"
                    +    "idEndereco = ?"
                    +    "AND idCliente = ? ");
            
//            stmt.setInt(1, i.getIdEndereco());
//            stmt.setInt(2, proprietario.getID());
            rs = stmt.executeQuery();

            if (rs.first()) {
                mensagem.jopAlerta("Já existe um imovél com este proprietário e endereço.\n Não é possível cadastrar ou imovél com estes dados!");
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
            if (verificaImovelExiste(i)) { 

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

//                stmt.setInt(1, maxId);
//                stmt.setString(2, novo.getDescricao());
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
