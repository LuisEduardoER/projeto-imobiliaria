package DAO.Cadastro;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import java.io.Serializable;
//import java.sql.*;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.DefaultComboBoxModel;
//import modelo.Usuario;
//
///**
// *
// * @author Bruno
// */
//public class UsuarioDAO implements Serializable{
//
//    
////    public boolean insereUsuario(Usuario usuario) {
////
////        PreparedStatement stmt;
////        ResultSet rs;
////        Statement st;
////
////        try {
////
////            stmt = this.con.prepareStatement(""
////                    + "INSERT INTO usuario"
////                    + "(nome,"
////                    + "id,"
////                    + "senha,"
////                    + "login,"
////                    + "perfil,"
////                    + "idPessoa) "
////                    + "VALUES (?,"// nome
////                    + " 0," // id
////                    + " ?," // senha
////                    + " ?," // login
////                    + " ?," // perfil
////                    + " ?);");       // idPessoa
////
////            stmt.setString(1, usuario.getNome());
////            stmt.setString(2, usuario.getSenha());
////            stmt.setString(3, usuario.getLogin());
////            stmt.setInt(4, usuario.getPerfil());
////            stmt.setInt(5, usuario.getIdPessoa());
////
////            stmt.execute();
////
////            if (stmt.getUpdateCount() > 0) {
////                return true;
////            } else {
////                return false;
////            }
////
////        } catch (SQLException ex) {
////
////            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
////            Mensagens erro = new Mensagens();
////            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage() + "\n insereUsuario");
////            return false;
////        }
////    }
//
//    @Override
//    public DefaultComboBoxModel buscaUsuarioNome(String nome) {
//
//        ResultSet rs;
//        Mensagens mensagem = new Mensagens();
//        PreparedStatement stmt;
//        DefaultComboBoxModel modeloUsuario;
//        Vector<Usuario> vetorUsuario = new Vector<Usuario>();
//
//        try {
//
//            stmt = UsuarioDAO.con.prepareStatement(""
//                    + "SELECT * FROM usuario "
//                    + "WHERE nome LIKE ? ");
//
//            stmt.setString(1, "%" + nome + "%");
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Usuario resultado = new Usuario();
//
//                resultado.setId(rs.getInt("id"));
//                resultado.setNome(rs.getString("nome"));
//                resultado.setLogin(rs.getString("login"));
//                resultado.setSenha(rs.getString("senha"));
//                resultado.setIdPessoa(rs.getInt("idPessoa"));
//                resultado.setPerfil(rs.getInt("perfil"));
//                vetorUsuario.add(resultado);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaUsuarioNome");
//            return null;
//        }
//        modeloUsuario = new DefaultComboBoxModel(vetorUsuario);
//        return modeloUsuario;
//    }
//
//    @Override
//    public Usuario buscaUsuario(Usuario usuario) {
//
//        ResultSet rs;
//        Mensagens mensagem = new Mensagens();
//
//        try {
//
//            stmt = UsuarioDAO.con.prepareStatement(""
//                    + "SELECT * FROM usuario "
//                    + "WHERE id = ? ");
//
//            stmt.setInt(1, usuario.getId());
//            rs = stmt.executeQuery();
//
//            if (rs.first()) {
//                usuario.setId(rs.getInt("id"));
//                usuario.setNome(rs.getString("nome"));
//                usuario.setLogin(rs.getString("login"));
//                usuario.setSenha(rs.getString("senha"));
//                usuario.setIdPessoa(rs.getInt("idPessoa"));
//                usuario.setPerfil(rs.getInt("perfil"));
//                return usuario;
//            } else {
//                return null;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaUsuario");
//            return null;
//        }
//    }
//    
//    @Override
//    public boolean removeUsuario(Usuario usario) {
//
//        Mensagens mensagem = new Mensagens();
//
//        try {
//
//            stmt = UsuarioDAO.con.prepareStatement(""
//                    + "DELETE FROM usuario "
//                    + "WHERE id = ?");
//
//            stmt.setInt(1, usario.getId());
//            stmt.execute();
//
//            if ((null == (buscaUsuario(usario)))) {
//                mensagem.jopAviso("Usuário removido com sucesso.");
//                return true;
//            } else {
//                mensagem.jopAviso("Não foi possível remover o usuário.");
//                return false;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            mensagem.jopError("Erro ao remover o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n removeUsuario");
//            return false;
//        }
//    }
//
//    @Override
//    public Usuario alterarUsuario(Usuario usuario) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//    
//}
