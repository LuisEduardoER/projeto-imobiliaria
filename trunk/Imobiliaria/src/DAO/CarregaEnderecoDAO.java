/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Modelo.Estado;
import Modelo.Pais;
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
public class CarregaEnderecoDAO {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    public DefaultComboBoxModel carregaPais() {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloPais;
        Vector<Pais> vetorPais = new Vector<Pais>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM paises;");

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Pais pais = new Pais();

                        pais.setNome(rs.getString("Descricao"));
                        pais.setCodigo(rs.getInt("idPais"));
                        pais.setSigla(rs.getString("Sigla"));
                        vetorPais.add(pais);
                    }
                } else {
                    rs.first();
                    Pais pais = new Pais();

                    pais.setNome(rs.getString("Descricao"));
                    pais.setCodigo(rs.getInt("idPais"));
                    pais.setSigla(rs.getString("Sigla"));
                    vetorPais.add(pais);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloPais = new DefaultComboBoxModel(vetorPais);
        return modeloPais;

    }

    public DefaultComboBoxModel carregaEstado() {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloEstado;
        Vector<Estado> vetorEstado = new Vector<Estado>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM estados;");

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Estado estado = new Estado();

                        estado.setNome(rs.getString("Descricao"));
                        estado.setCodigo(rs.getInt("idPais"));
                        estado.setCodigo(rs.getInt("idEstado"));
                        estado.setSigla(rs.getString("UF"));
                        vetorEstado.add(estado);
                    }
                } else {
                    rs.first();
                    Estado estado = new Estado();

                    estado.setNome(rs.getString("Descricao"));
                    estado.setCodigo(rs.getInt("idPais"));
                    estado.setSigla(rs.getString("Sigla"));
                    vetorEstado.add(estado);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloEstado = new DefaultComboBoxModel(vetorEstado);
        return modeloEstado;
    }
}
