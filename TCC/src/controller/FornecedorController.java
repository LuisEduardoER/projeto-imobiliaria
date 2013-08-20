/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FornecedorDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Fornecedor;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class FornecedorController {

    FornecedorDAO dao = new FornecedorDAO();
    
    public DefaultComboBoxModel<Fornecedor> buscar(String field, String value) {
        DefaultComboBoxModel<Fornecedor> dcbm = new DefaultComboBoxModel<>();
        Fornecedor f = dao.consultarFornecedor(field, value);
        dcbm.addElement(f);
        return dcbm;
    }

    public DefaultComboBoxModel<Fornecedor> listByField(String field, String value) {
        DefaultComboBoxModel<Fornecedor> dcbm = new DefaultComboBoxModel<>();
        List<Fornecedor> lista = dao.consultarTodos();
        for (Fornecedor fornecedor : lista) {
            dcbm.addElement(fornecedor);
        }
        return dcbm;
    }

    public Fornecedor gravar(Fornecedor fornecedor) {
       fornecedor = dao.gravar(fornecedor);
       return fornecedor;
    }

    public Fornecedor setDeleted(Fornecedor fornecedor) throws NonexistentEntityException, Exception {
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dataFormatada = dateFormatada.format(date);

            fornecedor.setUpdated(dataFormatada);
        } catch (Exception e) {
            System.out.println("\n \n \n --------  \n \n \n " + e);
        }
        fornecedor.setDeleted('t');

        fornecedor = dao.atualizar(fornecedor);
        return fornecedor;
    }

}
