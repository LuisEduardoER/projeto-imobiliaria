/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Embutido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ControladorRemoverBanco {
    
    ControladorPesquisarBanco cpb = new ControladorPesquisarBanco();
    Mensagens mensagem = new Mensagens();
    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();

    public boolean removerEmbutido(Embutido embutido) {

        PreparedStatement stmt;

        try {
            stmt = this.con.prepareStatement("DELETE FROM embutidos WHERE idEmbutido = ?;");

            stmt.setInt(1, embutido.getId());
            
            stmt.executeUpdate();
            
            String msgErro = "";
            
            if (cpb.verificaDescricaoExiste(embutido.getDescricao(),msgErro)){
                    return true;

            } else {
                return false;
            }


        } catch (SQLException ex) {
            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao remover dados, possívelmente este cadastro está vinculado! F1 para mais detalhes.:\nSQLException: " + ex.getMessage());

            return false;
        }
    }
}
