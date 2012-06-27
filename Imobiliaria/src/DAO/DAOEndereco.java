/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.Mensagens;
import Modelo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maycon
 */
public class DAOEndereco {
    
    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;
    
     public Pais buscaEndereco(Pais pais) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = PessoaDAO.con.prepareStatement(""
                    + "SELECT * FROM pais ");


            stmt.setString(1, pais.getNome());
            stmt.setString(2, pais.getSigla());
            rs = stmt.executeQuery();

            if (rs.first()) {

                pais.setNome(rs.getString("Descricao"));
                pais.setSigla(rs.getString("sigla"));
                pais.setCodigo(rs.getInt("idPais"));

                return pais;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao validar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage());
            return null;
        }

    }
}
