/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.ControladorPessoa;
import Controlador.Mensagens;
import Modelo.Pessoa;
import Modelo.PessoaN;
import Modelo.Telefone;
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
                //con.commit();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n inserePessoa");
            return false;
        }
    }

//    public boolean validaCadastroPessoa(Pessoa pessoa) {
//
//        ResultSet rs;
//        Mensagens mensagem = new Mensagens();
//
//        try {
//
//            stmt = PessoaDAO.con.prepareStatement(""
//                    + "SELECT * FROM pessoa "
//                    + "WHERE nome = ? "
//                    + "AND CPF_CNPJ = ? "
//                    + "AND RG = ? "
//                    + "AND nascimento = ?;");
//
//            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());
//
//            stmt.setString(1, pessoa.getNome());
//            stmt.setInt(2, pessoa.getCPF_CNPJ());
//            stmt.setInt(3, pessoa.getRG());
//            stmt.setDate(4, dataNascimento);
//            rs = stmt.executeQuery();
//
//            if (rs.first()) {
//
//                pessoa.setCEP_ZIP(rs.getInt("CEP_ZIP"));
//                pessoa.setCPF_CNPJ(rs.getInt("CPF_CNPJ"));
//                pessoa.setCTPS_Numero(rs.getInt("CTPS_Numero"));
//                pessoa.setCTPS_Serie(rs.getInt("CTPS_Serie"));
//                pessoa.setCTPS_UF(rs.getString("CTPS_UF"));
//                pessoa.setIdPessoa(rs.getInt("id"));
//                pessoa.setComplemento(rs.getString("complemento"));
//                pessoa.setIdBairro(rs.getInt("id_Bairro"));
//                pessoa.setIdCidade(rs.getInt("id_Cidade"));
//                pessoa.setIdEstado(rs.getInt("id_Estado"));
//                pessoa.setIdLogradouro(rs.getInt("id_Logradouro"));
//                pessoa.setIdPais(rs.getInt("id_Pais"));
//                pessoa.setNascimento(rs.getDate("nascimento"));
//                pessoa.setNome(rs.getString("nome"));
//                pessoa.setNumero(rs.getInt("numero"));
//                pessoa.setRG(rs.getInt("rg"));
//
//                return true;
//            } else {
//                mensagem.jopAlerta("Não foi possível validar a gravação do cadastro.\nCadastro não realizado.");
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
//            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n validaCadastroPessoa");
//            return false;
//        }
//
//
//    }
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

            if (rs.first()) {
                if (rs.next()) {
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
                } else {
                    rs.first();
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
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaPessoaNome");
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

    public boolean insereTelefonePessoa(Pessoa pessoa, Telefone telefone) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            stmt = this.con.prepareStatement(""
                    + "INSERT INTO `imobiliaria`.`telefone`"
                    + "  (`id`,"//id1
                    + "   `numero`,"//numero2
                    + "   `DDD`,"//ddd3
                    + "   `idPessoa`)"
                    + "VALUES (?,"
                    + "        ?,"
                    + "        ?,"
                    + "        ?);");

            stmt.setInt(1, 0);
            stmt.setInt(2, telefone.getNumero());
            stmt.setInt(3, telefone.getDDD());
            stmt.setInt(4, pessoa.getIdPessoa());

            if (validaCadastroTelefone(telefone, pessoa)) {
                con.commit();
                return true;
            } else {
                con.rollback();
                return false;

            }
        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n insereTelefone");

            return false;
        }
    }

    public boolean validaCadastroTelefone(Telefone telefone, Pessoa pessoa) {
        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM telefone "
                    + "WHERE ddd            = ?"
                    + "  AND numero         = ?"
                    + "  AND idPessoa       = ?;");

            stmt.setInt(1, telefone.getDDD());
            stmt.setInt(2, telefone.getNumero());
            stmt.setInt(3, pessoa.getIdPessoa());

            rs = stmt.executeQuery();

            if (rs.next()) {
                telefone.setDDD(rs.getInt("ddd"));
                telefone.setId(rs.getInt("id"));
                telefone.setIdPessoa(rs.getInt("idPessoa"));
                telefone.setNumero(rs.getInt("numero"));
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao buscar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n validaCadastroTelefone");

            return false;

        }
    }

    public Telefone buscaTelefone(Telefone telefone, Pessoa pessoa) {
        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM telefone "
                    + "WHERE ddd            = ?"
                    + "  AND numero         = ?"
                    + "  AND idPessoa       = ?;");

            stmt.setInt(1, telefone.getDDD());
            stmt.setInt(2, telefone.getNumero());
            stmt.setInt(3, pessoa.getIdPessoa());

            rs = stmt.executeQuery();

            if (rs.next()) {
                telefone.setDDD(rs.getInt("ddd"));
                telefone.setId(rs.getInt("id"));
                telefone.setIdPessoa(rs.getInt("idPessoa"));
                telefone.setNumero(rs.getInt("numero"));
                return telefone;
            } else {
                return null;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao buscar dados do no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n buscaTelefone");

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
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao remover o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n removePessoa");
            return false;
        }
    }
}
