/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.Pessoa;
import Modelo.Telefone;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class PessoaDAO {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    public boolean inserePessoa(Pessoa pessoa, Telefone telefone) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            
            stmt = this.con.prepareStatement(""
                    + "INSERT INTO pessoa"
                    + "(`id`,"
                    + "`nome`,"
                    + "`CPF_CNPJ`,"
                    + "`RG`,"
                    + "`nascimento`,"
                    + "`CTPS_Numero`,"
                    + "`CTPS_Serie`,"
                    + "`CTPS_UF`,"
                    + "`id_Pais`,"
                    + "`id_Estado`,"
                    + "`id_Cidade`,"
                    + "`id_Logradouro`,"
                    + "`CEP_ZIP`,"
                    + "`numero`,"
                    + "`complemento`,"
                    + "`idBairro`)"
                    + "VALUES (?," //id1
                    + "        ?,"//nome2
                    + "        ?,"//CPF_CNPJ3
                    + "        ?,"//RG4
                    + "        ?,"//nascimento5
                    + "        ?,"//CTPS_Numero6
                    + "        ?,"//CTPS_Serie7
                    + "        ?,"//CTPS_UF8
                    + "        ?,"//id_Pais9
                    + "        ?,"//id_Estado10
                    + "        ?,"//id_Cidade11
                    + "        ?,"//id_Logradouro12
                    + "        ?,"//CEP_ZIP13
                    + "        ?,"//numero14
                    + "        ?,"//vcomplemento15
                    + "        ?);");//idBairro16

//            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());

            stmt.setInt(1, 0);
            stmt.setString(2, pessoa.getNome());
            stmt.setInt(3, pessoa.getCPF_CNPJ());
            stmt.setInt(4, pessoa.getRG());
            stmt.setDate(5, null);
            stmt.setInt(6, pessoa.getCTPS_Numero());
            stmt.setInt(7, pessoa.getCTPS_Serie());
            stmt.setString(8, pessoa.getCTPS_UF());
            stmt.setInt(9, pessoa.getIdPais());
            stmt.setInt(10, pessoa.getIdEstado());
            stmt.setInt(11, pessoa.getIdCidade());
            stmt.setInt(12, pessoa.getIdLogradouro());
            stmt.setInt(13, pessoa.getCEP_ZIP());
            stmt.setInt(14, pessoa.getNumero());
            stmt.setString(15, pessoa.getComplemento());
            stmt.setInt(16, pessoa.getIdBairro());
            stmt.execute();


            if (validaCadastroPessoa(pessoa)) {
                con.commit();
                pessoa = buscaPessoa(pessoa);
                insereTelefonePessoa(pessoa, telefone);
                validaCadastroTelefone(telefone, pessoa);
                return true;
            } else {
                con.rollback();
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return false;
        }
    }

    public boolean validaCadastroPessoa(Pessoa pessoa) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pessoa "
                    + "WHERE nome = ? "
                    + "AND CPF_CNPJ = ? "
                    + "AND RG = ? "
                    + "AND nascimento = ?;");

            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getCPF_CNPJ());
            stmt.setInt(3, pessoa.getRG());
            stmt.setDate(4, dataNascimento);
            rs = stmt.executeQuery();

            if (rs.first()) {

                pessoa.setCEP_ZIP(rs.getInt(""));
                pessoa.setCPF_CNPJ(rs.getInt(""));
                pessoa.setCTPS_Numero(rs.getInt(""));
                pessoa.setCTPS_Serie(rs.getInt(""));
                pessoa.setCTPS_UF(rs.getString(""));
                pessoa.setIdPessoa(rs.getInt(""));
                pessoa.setComplemento(rs.getString(""));
                pessoa.setFone(rs.getString(""));
                pessoa.setIdBairro(rs.getInt(""));
                pessoa.setIdCidade(rs.getInt(""));
                pessoa.setIdEstado(rs.getInt(""));
                pessoa.setIdLogradouro(rs.getInt(""));
                pessoa.setIdPais(rs.getInt(""));
                pessoa.setNascimento(rs.getDate(""));
                pessoa.setNome(rs.getString(""));
                pessoa.setNumero(rs.getInt(""));
                pessoa.setRG(rs.getInt(""));

                return true;
            } else {
                mensagem.jopAlerta("Não foi possível validar a gravação do cadastro.\nCadastro não realizado.");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage());
            return false;
        }


    }

    public Pessoa buscaPessoa(Pessoa pessoa) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pessoa "
                    + "WHERE nome = ?"
                    + "AND CPF_CNPJ = ?"
                    + "AND RG = ?"
                    + "AND dataNascimento = ?;");

            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getCPF_CNPJ());
            stmt.setInt(3, pessoa.getRG());
            stmt.setDate(4, dataNascimento);
            rs = stmt.executeQuery();

            if (rs.first()) {

                pessoa.setCEP_ZIP(rs.getInt(""));
                pessoa.setCPF_CNPJ(rs.getInt(""));
                pessoa.setCTPS_Numero(rs.getInt(""));
                pessoa.setCTPS_Serie(rs.getInt(""));
                pessoa.setCTPS_UF(rs.getString(""));
                pessoa.setIdPessoa(rs.getInt(""));
                pessoa.setComplemento(rs.getString(""));
                pessoa.setFone(rs.getString(""));
                pessoa.setIdBairro(rs.getInt(""));
                pessoa.setIdCidade(rs.getInt(""));
                pessoa.setIdEstado(rs.getInt(""));
                pessoa.setIdLogradouro(rs.getInt(""));
                pessoa.setIdPais(rs.getInt(""));
                pessoa.setNascimento(rs.getDate(""));
                pessoa.setNome(rs.getString(""));
                pessoa.setNumero(rs.getInt(""));
                pessoa.setRG(rs.getInt(""));

                return pessoa;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao validar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage());
            return null;
        }

    }

    public Pessoa alterarPessoa(Pessoa pessoa) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {

            stmt = this.con.prepareStatement(""
                    + "UPDATE pessoa SET "
                    + "`nome`          = ?,"
                    + "`CPF_CNPJ`      = ?,"
                    + "`RG`            = ?,"
                    + "`nascimento`    = ?,"
                    + "`CTPS_Numero`   = ?,"
                    + "`CTPS_Serie`    = ?,"
                    + "`CTPS_UF`       = ?,"
                    + "`id_Pais`       = ?,"
                    + "`id_Estado`     = ?,"
                    + "`id_Cidade`     = ?,"
                    + "`id_Logradouro` = ?,"
                    + "`CEP_ZIP`       = ?,"
                    + "`numero`        = ?,"
                    + "`vcomplemento`  = ?,"
                    + "`idBairro`      = ?)"
                    + "WHERE "
                    + "`id`            = ?;");

            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());

            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getCPF_CNPJ());
            stmt.setInt(3, pessoa.getRG());
            stmt.setDate(4, dataNascimento);
            stmt.setInt(5, pessoa.getCTPS_Numero());
            stmt.setInt(6, pessoa.getCTPS_Serie());
            stmt.setString(7, pessoa.getCTPS_UF());
            stmt.setInt(8, pessoa.getIdPais());
            stmt.setInt(9, pessoa.getIdEstado());
            stmt.setInt(10, pessoa.getIdCidade());
            stmt.setInt(11, pessoa.getIdLogradouro());
            stmt.setInt(12, pessoa.getCEP_ZIP());
            stmt.setInt(13, pessoa.getNumero());
            stmt.setString(14, pessoa.getComplemento());
            stmt.setInt(15, pessoa.getIdBairro());
            stmt.setInt(16, pessoa.getIdPessoa());
            stmt.execute();

            buscaPessoa(pessoa);
            return pessoa;

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

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

            return true;
        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

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
            erro.jopError("Erro ao buscar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

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
            erro.jopError("Erro ao buscar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return null;

        }
    }
}
