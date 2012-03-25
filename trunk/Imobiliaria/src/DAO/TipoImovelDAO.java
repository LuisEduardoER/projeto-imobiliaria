/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.Mensagens;
import Modelo.TipoImovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class TipoImovelDAO {

    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();

    public boolean verificaDescricaoTipoImovelExiste(String descricao, String msg) {

        PreparedStatement stmt;
        ResultSet rs;
        Mensagens mensagem = new Mensagens();
        try {

            stmt = this.con.prepareStatement("SELECT descricaoTipoImovel FROM TipoImovel WHERE descricaoTipoImovel LIKE ? ");
            stmt.setString(1, "'" + descricao + "'");

            rs = stmt.executeQuery();

            if (rs.first()) {
                mensagem.jopAlerta(msg);
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return false;
        }

    }

    public DefaultComboBoxModel pesquisarTipoImovel() {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel resultado;
        Vector<TipoImovel> retorno = new Vector<TipoImovel>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM TipoImovel;");

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        TipoImovel tipoImovel = new TipoImovel();

                        tipoImovel.setDescricao(rs.getString("descricaoTipoImovel"));
                        retorno.add(tipoImovel);
                    }
                } else {
                    rs.first();
                    TipoImovel tipoImovel = new TipoImovel();

                    tipoImovel.setDescricao(rs.getString("descricaoTipoImovel"));
                    retorno.add(tipoImovel);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        resultado = new DefaultComboBoxModel(retorno);
        return resultado;
    }
}
