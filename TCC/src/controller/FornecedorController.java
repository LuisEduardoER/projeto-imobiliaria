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

    public DefaultComboBoxModel<Fornecedor> buscar(String field, String value) {
        DefaultComboBoxModel<Fornecedor> dcbm = new DefaultComboBoxModel<>();
        Fornecedor f = FornecedorDAO.buscaByField(field, value);
        dcbm.addElement(f);
        return dcbm;
    }

    public DefaultComboBoxModel<Fornecedor> listByField(String field, String value) {
        DefaultComboBoxModel<Fornecedor> dcbm = new DefaultComboBoxModel<>();
        List<Fornecedor> lista = FornecedorDAO.listByField(field, value);
        for (Fornecedor fornecedor : lista) {
            dcbm.addElement(fornecedor);
        }
        return dcbm;
    }

    public boolean gravar(Fornecedor fornecedor) {

        if (FornecedorDAO.gravar(fornecedor)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDeleted(Fornecedor fornecedor) throws NonexistentEntityException, Exception {
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

        if (FornecedorDAO.edit(fornecedor)) {
            return true;
        } else {
            return false;
        }
    }

}
