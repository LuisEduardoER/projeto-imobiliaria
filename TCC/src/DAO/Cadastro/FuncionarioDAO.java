package DAO.Cadastro;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import controller.Mensagens;
//import java.io.Serializable;
//import java.util.List;
//import modelo.Funcionario;
///**
// *
// * @author Bruno
// */
//public class FuncionarioDAO implements Serializable{
//
////    SessionFactory sf;
////    Transaction tr;
//    Mensagens m;
////    protected Session session;
//
//    public FuncionarioDAO() {
//    }
//    
//    public FuncionarioDAO(Session session){
//        super(session);
//    }
//    
//    public boolean gravar(Funcionario f) {
////        session = abreSessao();
//        try {
//            session.beginTransaction();
//            session.save(f);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao gravar Funcionario! \n ERRO: | FuncionarioDAO | gravar() | " + e);
//            return false;
//        } finally {
//            rollbackTransaction(); 
//            return false;
//        }
//    }
//
//    public boolean alterar(Funcionario f) {
////        Session session = abreSessao();
//        try {
//            session.beginTransaction();
//            session.update(f);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao atualizar Funcionario! \n ERRO: | FuncionarioDAO | alterar() | " + e);
//            return false;
//        } finally {
//            rollbackTransaction(); 
//            return false;
//        }
//    }
//
//    public boolean remover(Funcionario f) {
////        Session session = abreSessao();
//        try {
//            session.beginTransaction();
//            session.delete(f);
//            session.getTransaction().commit();
//            return true;
//        } catch (Exception e) {
//            m = new Mensagens();
//            m.jopError("Erro ao remover Funcionario! \n ERRO: | FuncionarioDAO | remover() | " + e);
//            return false;
//        } finally {
//            rollbackTransaction();
//            return false;
//        }
//    }
//
//    public List getListaFuncionarioByField(String field, String value) {
////        Session session = abreSessao();
//        Criteria criteria = session.createCriteria(Funcionario.class);
//
//        if (!field.equals("") || !value.equals("")) {
//            criteria.add(Restrictions.eq(field, value));
//        }
//        return criteria.list();
//    }
//
//    public Funcionario loadById(int id){
//        Criteria criteria = session.createCriteria(Funcionario.class);
//        criteria.add(Restrictions.eq("idFuncionario", id));
//        return (Funcionario) criteria.uniqueResult();
//    }
//}
