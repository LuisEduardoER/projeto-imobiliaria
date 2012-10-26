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
                    + "`vendido`,"
                    + "`tamanho`)"
                    + "VALUES (0," //id
                    + "?," //numero
                    + "?," //rua
                    + "?," //bairro
                    + "?," //Cidade
                    + "?," // ID pessoaProprietario
                    + "?," //valor
                    + "?,"// Não vendido = 0;
                    + "?);");//Tamanho                   

            stmt.setInt(1, i.getNumero());
            stmt.setString(2, i.getRua());
            stmt.setString(3, i.getBairro());
            stmt.setString(4, i.getCidade());
            stmt.setInt(5, i.getIdPessoaProprietario());
            stmt.setFloat(6, i.getValor());
            stmt.setInt(7, i.getVendido());
            stmt.setFloat(8, i.getTamanho());


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

            if ((null == (buscaImovel(imovel)))) {
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
        DefaultComboBoxModel modeloImovel;
        Vector<ImovelN> vetorImovel = new Vector<ImovelN>();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM imoveln "
                    + "WHERE numero = ? ");

            stmt.setInt(1, numero);
            rs = stmt.executeQuery();


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
                resultado.setTamanho(rs.getFloat("tamanho"));
                vetorImovel.add(resultado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaImovelNumero");
            return null;
        }
        modeloImovel = new DefaultComboBoxModel(vetorImovel);
        return modeloImovel;
    }

    public ImovelN buscaImovel(ImovelN imovel) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM imovelN "
                    + "WHERE id = ? ");

            stmt.setInt(1, imovel.getId());
            rs = stmt.executeQuery();

            if (rs.first()) {
                imovel.setId(rs.getInt("id"));
                imovel.setNumero(rs.getInt("numero"));
                imovel.setRua(rs.getString("rua"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setIdPessoaProprietario(rs.getInt("idPessoaProprietario"));
                imovel.setValor(rs.getFloat("valor"));
                imovel.setVendido(rs.getInt("vendido"));
                imovel.setTamanho(rs.getFloat("tamanho"));
                return imovel;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaImovel");
            return null;
        }

    }
}
