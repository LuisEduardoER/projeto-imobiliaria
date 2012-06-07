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
                    + "`vcomplemento`)"
                    + "VALUES ('id',"
                    + "      'nome',"
                    + "     'CPF_CNPJ',"
                    + "   'RG',"
                    + " 'nascimento',"
                    + "'CTPS_Numero',"
                    + "'CTPS_Serie',"
                    + "'id_Pais',"
                    + "'id_Estado',"
                    + "'id_Cidade',"
                    + "'id_Logradouro',"
                    + "'CEP_ZIP',"
                    + "'numero',"
                    + "'vcomplemento');");

            java.sql.Date dataNascimento = new java.sql.Date(pessoa.getNascimento().getTime());
            
                stmt.setInt(1, 0);
                stmt.setString(2, pessoa.getNome());
                stmt.setInt(3, pessoa.getCPF_CNPJ());
                stmt.setDate(4, dataNascimento);
                stmt.setInt(5, pessoa.getCTPS_Numero());
                stmt.setInt(6, pessoa.getCTPS_Serie());
                stmt.setInt(7, pessoa.getCTPS_Serie());
                stmt.setInt(8, pessoa.getIdPais());
                stmt.setInt(8, pessoa.getIdEstado());
                stmt.setInt(8, pessoa.getIdCidade());
                stmt.setInt(8, pessoa.getIdBairro());
                stmt.setInt(8, pessoa.getIdLogradouro());
                stmt.setInt(8, pessoa.getNumero());
                stmt.setInt(8, pessoa.getCEP_ZIP());
                stmt.setString(8, pessoa.getComplemento());
                stmt.setString(8, pessoa.getComplemento());
                
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
