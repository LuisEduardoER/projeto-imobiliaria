/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FornecedorDAO;
import modelo.Fornecedor;

/**
 *
 * @author Bruno
 */
public class FornecedorController {
    
//     public DefaultComboBoxModel<Fabricante> buscar(String field, String value) {
//        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
//        List<Fabricante> lista = FabricanteDAO.getListaFuncionarioByField(field, value);
//        for (Fabricante fabricante : lista) {
//            dcbm.addElement(fabricante);
//        }
//        return dcbm;
//    }

//    public DefaultComboBoxModel<Fabricante> listaModulo() {
//        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
//        List<Fabricante> lista = dao.getListaFabricante();
//        for (Fabricante fabricante : lista) {
//            dcbm.addElement(fabricante);
//        }
//        return dcbm;
//    }
    
    public boolean gravar(Fornecedor fornecedor) {
        
        if (FornecedorDAO.gravar(fornecedor)) {
            return true;
        } else {
            return false;
        }
    }
    
}
