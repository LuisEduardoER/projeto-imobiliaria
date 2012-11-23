/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.ControladorVenda;
import Controlador.Mensagens;
import Modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class VendaDAO implements ControladorVenda {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    @Override
    public boolean insereVenda(Venda venda) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            stmt = this.con.prepareStatement(""
                    + " INSERT INTO `imobiliaria`.`venda`"
                    + "(`id`,"
                    + " `idPessoaProprietario`,"
                    + " `idImovel`,"
                    + " `valor`)"
                    + "VALUES (?,"
                    + "?,"
                    + "?,"
                    + "?);");

            stmt.setInt(1, venda.getIdVenda());
            stmt.setInt(2, venda.getIdPessoaProprietario());
            stmt.setInt(3, venda.getIdImovel());
            stmt.setFloat(4, venda.getValor());

            stmt.execute();

            if (stmt.getUpdateCount() > 0) {//se gravou a venda entra para atualziar o imovel

                // atualiza imóvel para vendido
                stmt = this.con.prepareStatement(""
                        + "UPDATE `imobiliaria`.`imoveln`"
                        + " SET `vendido` = 1" //Vendido = 1, Não Vendido = 0;
                        + " WHERE `id` = ?;");

                stmt.setInt(1, venda.getIdImovel());
                stmt.execute();

                if (stmt.getUpdateCount() > 0) {//se atualizar o imovel retorna true
                    return true;
                } else {
                    return false;// senão atualizar o imovel retorna false
                }
            } else {
                return false;//se não gravar a venda retorna false e não entra para atualizar o imovel
            }
        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n insereVenda");
            return false;
        }


    }

    @Override
    public Venda alterarVenda(Venda venda) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeVenda(Venda venda) {


        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "DELETE FROM `imobiliaria`.`venda` "
                    + "WHERE `id` = ?;");

            stmt.setInt(1, venda.getIdVenda());
            stmt.execute();

            stmt = PessoaDAO.con.prepareStatement(""
                    + " UPDATE `imobiliaria`.`imoveln`"
                    + " SET `vendido` = 0" //Vendido = 1, Não Vendido = 0;
                    + " WHERE `id` = ?;");
            stmt.setInt(1, venda.getIdImovel());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao remover venda no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n vendaDAO");
            return false;
        }

    }

    @Override
    public DefaultComboBoxModel buscaVendaImovel(int numero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public DefaultComboBoxModel buscaVenda(Venda venda) {
        ResultSet rs;
        Mensagens mensagem = new Mensagens();
        DefaultComboBoxModel modeloVenda;
        Vector<Venda> vetorVenda = new Vector<Venda>();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT "
                    + "imoveln.numero, "
                    + "imoveln.id as idImovel, "
                    + "imoveln.rua, "
                    + "imoveln.cidade, "
                    + "venda.id "
                    + "FROM imoveln "
                    + "INNER JOIN venda ON venda.idImovel = imoveln.id "
                    + "WHERE imoveln.numero = ? ");

            stmt.setInt(1, venda.getImovelNumero());
            rs = stmt.executeQuery();

            while (rs.next()) {

                Venda resultado = new Venda();
                resultado.setIdImovel(rs.getInt("idImovel"));
                resultado.setIdVenda(rs.getInt("id"));
                resultado.setCidade(rs.getString("cidade"));
                resultado.setImovelNumero(rs.getInt("numero"));
                resultado.setRua(rs.getString("rua"));
                vetorVenda.add(resultado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaVenda");
            return null;
        }
        modeloVenda = new DefaultComboBoxModel(vetorVenda);
        return modeloVenda;
    }
}
