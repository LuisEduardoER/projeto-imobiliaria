/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Embutido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class ControladorIncluirBanco {

    ControladorPesquisarBanco cpb = new ControladorPesquisarBanco();
    
    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();

    public boolean gravarEmbutido(Embutido novo) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            String sql = "SELECT MAX(idEmbutido) as MAXID FROM embutidos";
            st = this.con.createStatement();
            rs = st.executeQuery(sql);

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao verificar identificador no servidor de banco de dados:\nSQLException: " + ex.getMessage()+"\nPossivelmente houve um problema com a conexão!");

            return false;
        }
        try {
            rs.next();
            int maxId = rs.getInt("MAXID") + 1;

            String msgErro = "Já existe um cadastro com este nome!";

            if (cpb.verificaDescricaoExiste(novo.getDescricao(), msgErro)) {

                stmt = this.con.prepareStatement("INSERT INTO embutidos (idEmbutido, descricaoEmbutido) VALUES (?,?);");

                stmt.setInt(1, maxId);
                stmt.setString(2, novo.getDescricao());
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
