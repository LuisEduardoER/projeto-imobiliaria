///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import DAO.ModuloDAO;
//import java.util.List;
//import javax.swing.DefaultComboBoxModel;
//import modelo.Modulo;
//
///**
// *
// * @author Bruno
// */
//public class ModuloController extends ModuloDAO {
//     
//    public DefaultComboBoxModel<Modulo> buscar(String field, String value) {
//        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
//        List<Modulo> lista = getListaModulosByField(field, value);
//        for (Modulo modulo : lista) {
//            dcbm.addElement(modulo);
//        }
//        return dcbm;
//    }
//
//    public DefaultComboBoxModel<Modulo> listaModulo() {
//        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
//        List<Modulo> lista = getListaModulo();
//        for (Modulo modulo : lista) {
//            dcbm.addElement(modulo);
//        }
//        return dcbm;
//    }
//    
//    public boolean gravar(Modulo modulo) {
//        if (gravar(modulo)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//}
