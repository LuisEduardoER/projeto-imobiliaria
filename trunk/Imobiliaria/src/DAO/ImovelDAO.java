/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.Embutido;
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
public class ImovelDAO {
    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();


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

