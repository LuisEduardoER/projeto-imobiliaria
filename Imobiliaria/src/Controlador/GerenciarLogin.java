/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Visao.dConexaoTela;
import java.sql.Connection;
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
public class GerenciarLogin {

    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();
    //Usuario u = new Usuario();

    public Usuario login(Usuario u) {
        try {
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario WHERE login = '"+u.getLogin()+"' AND senha ='"+u.getSenha()+"';");

            if (rs.first()) {
                u.setId(Integer.parseInt(rs.getString("id")));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setPerfil(Integer.parseInt(rs.getString("perfil")));
                u.setSenha(rs.getString("senha"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarLogin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + "\nErro ao conectar ao Servidor de banco de dados! \nVerifique as Configurações de Conexão.");
            dConexaoTela c = new dConexaoTela(null, true);
            c.setVisible(true);
        }
        return null;
    }
}
