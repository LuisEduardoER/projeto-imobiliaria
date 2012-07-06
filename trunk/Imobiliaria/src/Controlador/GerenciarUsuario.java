/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Bruno
 */
import Modelo.Usuario;
import Visao.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GerenciarUsuario {

    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();
    Usuario u = new Usuario();

    public boolean incluirUsuario(Usuario novo) {

        try {

            Statement stmt = this.con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT nomeUsuario FROM usuarios WHERE nomeUsuario ='" + novo.getLogin() + "';");
            String verifica;

            if (rs.first()) {
                verifica = rs.getString("nomeUsuario");

                if (!verifica.equals(novo.getLogin())) {
                    JOptionPane.showMessageDialog(null, "Nome de Usuário já existente, por favor selecione outro nome.");
                    return false;
                }
            } else {

                rs = stmt.executeQuery("SELECT MAX(id) FROM usuarios;");
                rs.first();
                novo.setId(Integer.parseInt(rs.getString("MAX(id)")) + 1);

                String query =
                        ("insert into usuarios (nome, serie, bimestre, idTeste, id, telefone, email, nomeUsuario, senha, grau, perfil,curso,aluno) values ('" + novo.getNome() + "', ' " + novo.getSerie() + " ', ' " + novo.getBimestre() + "',NULL,'" + novo.getId() + "', '" + novo.getTelefone() + "','" + novo.geteMail() + "','" + novo.getLogin() + "','" + novo.getSenha() + "','" + novo.getGrau() + "', " + novo.getPerfil() + ",'" + novo.getCurso() + "','"+novo.getAluno()+"');");
                stmt.executeUpdate(query);
                stmt.close();
                con.close();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return false;
        }

    }

    public boolean checarUsuario(String nomeUsuario) {

        try {
            String select = "SELECT nomeUsuario FROM usuarios WHERE nomeUsuario ='" + nomeUsuario + "';";
            PreparedStatement pStmt = this.con.prepareStatement(select);
            ResultSet rs = pStmt.executeQuery();

            if (rs.first()) {
                JOptionPane.showMessageDialog(null, "Nome de Usuário já existente, por favor selecione outro nome.");
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Nome de Usuário disponível!");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GerenciarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + "\nErro ao conectar ao Servidor de banco de dados!\nVerifique as Configurações de Conexão.");
            return false;
        }
    }
}
