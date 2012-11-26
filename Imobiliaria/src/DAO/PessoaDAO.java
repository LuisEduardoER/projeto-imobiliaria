/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.ControladorPessoa;
import Controlador.Mensagens;
import Modelo.PessoaN;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class PessoaDAO implements ControladorPessoa {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    @Override
    public boolean inserePessoa(PessoaN pessoa) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {

            stmt = this.con.prepareStatement(""
                    + "INSERT INTO pessoan"
                    + "(id,"
                    + "nome,"
                    + "cpf,"
                    + "rua,"
                    + "bairro,"
                    + "cidade,"
                    + "numero) "
                    + "VALUES (0,"// id
                    + " ?,"       // nome
                    + " ?,"       // cpf
                    + " ?,"       // rua
                    + " ?,"       // bairro
                    + " ?,"       // cidade
                    + " ?);");    // numero

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getCPF());
            stmt.setString(3, pessoa.getRua());
            stmt.setString(4, pessoa.getBairro());
            stmt.setString(5, pessoa.getCidade());
            stmt.setInt(6, pessoa.getNumero());
            
            stmt.execute();
                        
            if (stmt.getUpdateCount() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n inserePessoa");
            return false;
        }
    }


    @Override
    public DefaultComboBoxModel buscaPessoaNome(String nome) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();
        PreparedStatement stmt;
        DefaultComboBoxModel modeloPessoa;
        Vector<PessoaN> vetorPessoa = new Vector<PessoaN>();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pessoaN "
                    + "WHERE nome LIKE ? ");

            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

                     while (rs.next()) {
                        PessoaN resultado = new PessoaN();

                        resultado.setId(rs.getInt("id"));
                        resultado.setNome(rs.getString("nome"));
                        resultado.setCPF(rs.getInt("cpf"));
                        resultado.setNumero(rs.getInt("numero"));
                        resultado.setRua(rs.getString("rua"));
                        resultado.setBairro(rs.getString("bairro"));
                        resultado.setCidade(rs.getString("cidade"));
                        vetorPessoa.add(resultado);
                    }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaPessoaNome");
            return null;
        }
        modeloPessoa = new DefaultComboBoxModel(vetorPessoa);
        return modeloPessoa;

    }

    @Override
    public DefaultComboBoxModel buscaPessoaId(int id) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();
        PreparedStatement stmt;
        DefaultComboBoxModel modeloPessoa;
        Vector<PessoaN> vetorPessoa = new Vector<PessoaN>();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pessoaN "
                    + "WHERE id = ? ");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

                     while (rs.next()) {
                        PessoaN resultado = new PessoaN();

                        resultado.setId(rs.getInt("id"));
                        resultado.setNome(rs.getString("nome"));
                        resultado.setCPF(rs.getInt("cpf"));
                        resultado.setNumero(rs.getInt("numero"));
                        resultado.setRua(rs.getString("rua"));
                        resultado.setBairro(rs.getString("bairro"));
                        resultado.setCidade(rs.getString("cidade"));
                        vetorPessoa.add(resultado);
                    }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaPessoaId");
            return null;
        }
        modeloPessoa = new DefaultComboBoxModel(vetorPessoa);
        return modeloPessoa;

    }
    
    public PessoaN buscaPessoa(PessoaN pessoa) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pessoaN "
                    + "WHERE id = ? ");

            stmt.setInt(1, pessoa.getId());
            rs = stmt.executeQuery();

            if (rs.first()) {
                pessoa.setId(rs.getInt("id"));
                pessoa.setCPF(rs.getInt("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNumero(rs.getInt("numero"));
                pessoa.setRua(rs.getString("rua"));
                pessoa.setBairro(rs.getString("bairro"));
                pessoa.setCidade(rs.getString("cidade"));
                return pessoa;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaPessoa");
            return null;
        }

    }

    @Override
    public PessoaN alterarPessoa(PessoaN pessoa) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {

            stmt = this.con.prepareStatement(""
                    + "UPDATE pessoaN SET "
                    + "`nome`          = ?,"
                    + "`CPF`           = ?,"
                    + "`rua`           = ?,"
                    + "`bairro`        = ?,"
                    + "`cidade`        = ?,"
                    + "`numero`        = ?,"
                    + "WHERE "
                    + "`id`            = ?;");

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getCPF());
            stmt.setString(3, pessoa.getRua());
            stmt.setString(4, pessoa.getBairro());
            stmt.setString(5, pessoa.getCidade());
            stmt.setInt(6, pessoa.getNumero());
            stmt.setInt(7, pessoa.getId());
            stmt.execute();
            buscaPessoa(pessoa);
            return pessoa;

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n alterarPessoa");

            return null;
        }
    }

    @Override
    public boolean removePessoa(PessoaN pessoa) {

        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "DELETE FROM pessoaN "
                    + "WHERE id = ?");

            stmt.setInt(1, pessoa.getId());
            stmt.execute();

            if ((null == (buscaPessoa(pessoa)))) {
                mensagem.jopAviso("Cadastro removido com sucesso.");
                return true;
            } else {
                mensagem.jopAviso("Não foi possível remover o cadastro.");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao remover o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n removePessoa");
            return false;
        }
    }
}
