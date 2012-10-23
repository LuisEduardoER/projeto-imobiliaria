/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorImovel;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.ImovelN;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class ImovelDAO implements ControladorImovel {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    public boolean verificaImovelExiste(ImovelN i) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = ImovelDAO.con.prepareStatement(""
                    + "SELECT idEndereco,"
                    + "idCliente"
                    + "FROM imoveis"
                    + "WHERE"
                    + "idEndereco = ?"
                    + "AND idCliente = ? ");

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

    @Override
    public boolean insereImovel(ImovelN i) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            stmt = this.con.prepareStatement(""
                    + " INSERT INTO `imobiliaria`.`imoveln`"
                    + "(`id`,"
                    + "`numero`,"
                    + "`rua`,"
                    + "`bairro`,"
                    + "`cidade`,"
                    + "`idPessoaProprietario`,"
                    + "`valor`,"
                    + "`vendido`)"
                    + "VALUES (0," //id
                    + "?," //numero
                    + "?," //rua
                    + "?," //bairro
                    + "?," //Cidade
                    + "'idPessoaProprietario'," // ID pessoaProprietario
                    + "?," //valor
                    + "0);");                   // Não vendido = 0;

            stmt.setInt(1, i.getNumero());
            stmt.setString(2, i.getRua());
            stmt.setString(3, i.getBairro());
            stmt.setString(4, i.getCidade());
            stmt.setInt(5, i.getIdPessoaProprietario());
            stmt.setFloat(6, i.getValor());


            stmt.execute();

            if (stmt.getUpdateCount() > 0) {
                //con.commit();
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

    @Override
    public ImovelN alterarImovel(ImovelN imovel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeImovel(ImovelN imovel) {
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "DELETE FROM imovelN "
                    + "WHERE id = ?");

            stmt.setInt(1, imovel.getId());
            stmt.execute();

            if ((null == (buscaImovelNumero(imovel.getNumero())))) {
                mensagem.jopAviso("Cadastro removido com sucesso.");
                return true;
            } else {
                mensagem.jopAviso("Não foi possível remover o cadastro.");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao remover o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n removeImovel");
            return false;
        }
    }

    @Override
    public DefaultComboBoxModel buscaImovelNumero(int numero) {
        ResultSet rs;
        Mensagens mensagem = new Mensagens();
        PreparedStatement stmt;
        DefaultComboBoxModel modeloPessoa;
        Vector<ImovelN> vetorImovel = new Vector<ImovelN>();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pessoaN "
                    + "WHERE numero = ? ");

            stmt.setInt(1, numero);
            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        ImovelN resultado = new ImovelN();

                        resultado.setId(rs.getInt("id"));
                        resultado.setNumero(rs.getInt("numero"));
                        resultado.setRua(rs.getString("rua"));
                        resultado.setBairro(rs.getString("bairro"));
                        resultado.setCidade(rs.getString("cidade"));
                        resultado.setIdPessoaProprietario(rs.getInt("idPessoaProprietario"));
                        resultado.setValor(rs.getFloat("valor"));
                        resultado.setVendido(rs.getInt("vendido"));
                        vetorImovel.add(resultado);
                    }
                } else {
                    rs.first();
                    ImovelN resultado = new ImovelN();

                    resultado.setId(rs.getInt("id"));
                    resultado.setNumero(rs.getInt("numero"));
                    resultado.setRua(rs.getString("rua"));
                    resultado.setBairro(rs.getString("bairro"));
                    resultado.setCidade(rs.getString("cidade"));
                    resultado.setIdPessoaProprietario(rs.getInt("idPessoaProprietario"));
                    resultado.setValor(rs.getFloat("valor"));
                    resultado.setVendido(rs.getInt("vendido"));
                    vetorImovel.add(resultado);
                }
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaImovelNumero");
            return null;
        }
        modeloPessoa = new DefaultComboBoxModel(vetorImovel);
        return modeloPessoa;


    }
}
