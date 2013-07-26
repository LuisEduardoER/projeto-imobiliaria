/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.Conexao;
import controller.Mensagens;
import controller.PerfilController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import modelo.Perfil;
/**
 *
 * @author Bruno
 */
public class PerfilDAO {

//    static Conexao c = new Conexao();
//    static Connection con = c.conexaoMysql();
//    public static PreparedStatement stmt;
//
//    public DefaultComboBoxModel<Perfil> buscaPerfil() {
//        Perfil p;
//        DefaultComboBoxModel<Perfil> dcbm;
//        ResultSet rs;
//        Mensagens mensagem = new Mensagens();
//        dcbm = new DefaultComboBoxModel<>();
//        try {
//
//            stmt = FuncionarioDAO.con.prepareStatement(""
//                    + " SELECT *"
//                    + " FROM perfil;");
//
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                p = new Perfil();
//                p.setDescPerfil(rs.getString("perfilDesc"));
//                p.setIdPerfil(rs.getInt("perfilId"));
//                dcbm.addElement(p);
//            }
//            return dcbm;
//
//        } catch (SQLException ex) {
//            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            mensagem.jopError("Erro ao recuperar ID de Funcionario no servidor de banco de dados.\nSQLException: " + ex.getMessage());
//            return null;
//        }
//    }
//    SessionFactory sf;
//    Transaction tr;
//    Mensagens m;

//    public Session abreSessao() {
//        sf = new Configuration().configure().buildSessionFactory();
//        Session session = sf.openSession();
//        tr = session.beginTransaction();
//        return session;
//    }
//
//    public List getListaPerfil() {
//        Session session = abreSessao();
//        Criteria criteria = session.createCriteria(Perfil.class);
//        return criteria.list();
//    }
//    
//    public boolean gravar(Perfil p) {
//        Session session = abreSessao();
//        try {
//            session.save(p);
//            tr.commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao gravar Perfil! \n ERRO: | PerfilDAO | gravar() | " + e);
//            session.close();
//            return false;
//        } finally {
//            session.getTransaction().rollback(); // ---- criar metodo
//            return false;
//        }
//    }
//    
//    public List getListaPerfisByField(String field, String value) {
//        Session session = abreSessao();
//        Criteria criteria = session.createCriteria(Perfil.class);
//
//        if (!field.equals("") || !value.equals("")) {
//            criteria.add(Restrictions.eq(field, value));
//        }
//        return criteria.list();
//    }
    
}
