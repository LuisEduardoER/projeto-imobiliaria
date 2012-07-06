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
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE nomeUsuario= '"+u.getNomeUsuario()+"' AND senha ='"+u.getSenha()+"';");

            if (rs.first()) {
                u.setId(Integer.parseInt(rs.getString("id")));
                u.setNome(rs.getString("nome"));
                u.setBimestre(Integer.parseInt(rs.getString("bimestre")));
                u.setCurso(rs.getString("curso"));
                u.setGrau(Integer.parseInt(rs.getString("grau")));
                u.setNomeUsuario(rs.getString("nomeUsuario"));
                u.setPerfil(Integer.parseInt(rs.getString("perfil")));
                u.setSenha(rs.getString("senha"));
                u.setSerie(Integer.parseInt(rs.getString("serie")));
                u.setTelefone(rs.getString("telefone"));
                u.seteMail(rs.getString("email"));
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
