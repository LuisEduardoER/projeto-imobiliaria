///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import controller.Mensagens;
//import java.util.List;
//import modelo.Modulo;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Restrictions;
///**
// *
// * @author Bruno
// */
//public class ModuloDAO {
////
////    public Session abreSessao() {
////        sf = new Configuration().configure().buildSessionFactory();
////        Session session = sf.openSession();
////        tr = session.beginTransaction();
////        return session;
////    }
////
////    public boolean gravar(Modulo modulo) {
////        Session session = abreSessao();
////        try {
////            session.save(modulo);
////            tr.commit();
////            return true;
////        } catch (Exception e) {
////            m = new Mensagens();
////            m.jopError("Erro ao gravar Modulo! \n ERRO: | ModuloDAO | gravar() | " + e);
////            session.close();
////            return false;
////        } finally {
////            session.getTransaction().rollback(); // ---- criar metodo
////            return false;
////        }
////    }
////
////    public boolean alterar(Modulo modulo) {
////        Session session = abreSessao();
////        try {
////            session.update(modulo);
////            tr.commit();
////            return true;
////        } catch (Exception e) {
////            m = new Mensagens();
////            m.jopError("Erro ao atualizar Modulo! \n ERRO: | ModuloDAO | alterar() | " + e);
////            session.close();
////            return false;
////        } finally {
////            session.close();
////            return false;
////        }
////    }
////
////    public boolean remover(Modulo modulo) {
////        Session session = abreSessao();
////        try {
////            session.delete(modulo);
////            tr.commit();
////            return true;
////        } catch (Exception e) {
////            m = new Mensagens();
////            m.jopError("Erro ao remover Modulo! \n ERRO: | ModuloDAO | remover() | " + e);
////            session.close();
////            return false;
////        } finally {
////            session.close();
////            return false;
////        }
////    }
////
////    public List getListaModulo() {
////        Session session = abreSessao();
////        Criteria criteria = session.createCriteria(Modulo.class);
////        return criteria.list();
////    }
////    
////    public List getListaModulosByField(String field, String value) {
////        Session session = abreSessao();
////        Criteria criteria = session.createCriteria(Modulo.class);
////
////        if (!field.equals("") || !value.equals("")) {
////            criteria.add(Restrictions.eq(field, value));
////        }
////        return criteria.list();
////    }
////}
