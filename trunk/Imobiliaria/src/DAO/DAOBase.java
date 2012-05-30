/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public abstract class DAOBase {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String LOGIN = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/lujinha";
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public DAOBase() {
    }

    public void conectar() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(URL, LOGIN, SENHA);
            con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            if (rs != null /*
                     * && !rs.isClosed()
                     */) {
                rs.close();
            }

            if (ps != null /*
                     * && !ps.isClosed()
                     */) {
                ps.close();
            }

            if (con != null /*
                     * && !con.isClosed()
                     */) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public abstract void incluir(BeanBase bean) throws Exception;
//
//    public abstract void excluir(BeanBase bean) throws Exception;
//
//    public abstract void alterar(BeanBase bean) throws Exception;
//
//    public abstract Usuario consultar(int codigo) throws Exception;
//
//    public abstract List<Usuario> consultar(Usuario bean) throws Exception;
}
