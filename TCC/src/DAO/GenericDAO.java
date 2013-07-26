///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAO;
//
//import controller.SessionFactoryCreator;
//import javax.annotation.PreDestroy;
//
///**
// *
// * @author Bruno
// */
//public abstract class GenericDAO<T> {
//
//    protected Session session;
//    protected SessionFactoryCreator sfc;
//    
//    public GenericDAO() {
//        
//    }
//
//    public GenericDAO(Session session) {
//        sfc = new SessionFactoryCreator();
//        sfc.create();
//        this.session = session;
//    }
//
////    @PostConstruct
////    public void create() {
////        entityClass = (Class<T>) (getClass().getGenericSuperclass());
////    }
//
//    @PreDestroy
//    public void destroy() {
//        session.close();
//    }
//
//    public void rollbackTransaction() {
//        if (session.getTransaction() != null && session.getTransaction().isActive()) {
//            session.getTransaction().rollback();
//        }
//    }
//
//    public void beginTransaction() {
//        session.beginTransaction();
//    }
//
//    public void commitTransaction() {
//        session.getTransaction().commit();
//    }
//
//    public Session getSession() {
//        return this.session;
//    }
//
////    public void refresh(T entity) {
////        if (entity != null) {
////            this.getSession().refresh(entity);
////        }
////    }
//
//    public String getDatabaseType() {
//        return SessionFactoryCreator.DATABASE_TYPE;
//    }
//}