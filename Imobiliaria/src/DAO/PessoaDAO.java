/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.Imovel;
import Modelo.Pessoa;
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

    public boolean inserePessoa(Pessoa pessoa) {

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
                    + "`vcomplemento,"
                    + "idBairro`)"
                    + "VALUES (?," //id1
                    + "?,"//nome2
                    + "?,"//CPF_CNPJ3
                    + "?,"//RG4
                    + "?,"//nascimento5
                    + "?,"//CTPS_Numero6
                    + "?,"//CTPS_Serie7
                    + "?,"//CTPS_UF8
                    + "?,"//id_Pais9
                    + "?,"//id_Estado10
                    + "?,"//id_Cidade11
                    + "?,"//id_Logradouro12
                    + "?,"//CEP_ZIP13
                    + "?,"//numero14
                    + "?,"//vcomplemento15
                    + "?);");//idBairro16

            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());
            
                stmt.setInt(1, 0);
                stmt.setString(2, pessoa.getNome());
                stmt.setInt(3, pessoa.getCPF_CNPJ());
                stmt.setInt(4, pessoa.getRG());
                stmt.setDate(5, dataNascimento);
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

            return true;


        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return false;
        }
    }
}
