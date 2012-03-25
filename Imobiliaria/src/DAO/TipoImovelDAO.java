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
import java.sql.*;
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

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    public static boolean verificaDescricaoTipoImovelExiste(String descricao) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();
        
        try {

            stmt = TipoImovelDAO.con.prepareStatement("SELECT descricaoTipoImovel FROM TipoImovel WHERE descricaoTipoImovel LIKE ? ");
            stmt.setString(1, "'" + descricao + "'");
            rs = stmt.executeQuery();

            if (rs.first()) {
                mensagem.jopAlerta("Já existe um cadastro com este nome!");
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao verificar exitência de cadastros no servidor de banco de dados.\nSQLException: " + ex.getMessage());

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

    public boolean gravarEmbutido(Embutido novo) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            st = this.con.createStatement();


            if (verificaDescricaoTipoImovelExiste(novo.getDescricao())) {

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
