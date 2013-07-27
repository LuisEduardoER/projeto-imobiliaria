/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ModuloDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Modulo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class ModuloController {
     
  public DefaultComboBoxModel<Modulo> buscar(String field, String value) {
        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
        Modulo m = ModuloDAO.buscaByField(field, value);
        dcbm.addElement(m);
        return dcbm;
    }

    public DefaultComboBoxModel<Modulo> listByField(String field, String value) {
        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
        List<Modulo> lista = ModuloDAO.listByField(field, value);
        for (Modulo modulo : lista) {
            dcbm.addElement(modulo);
        }
        return dcbm;
    }

    public boolean gravar(Modulo modulo) {

        if (ModuloDAO.gravar(modulo)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDeleted(Modulo modulo) throws NonexistentEntityException, Exception {
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dataFormatada = dateFormatada.format(date);

            modulo.setUpdated(dataFormatada);
        } catch (Exception e) {
            System.out.println("\n \n \n --------  \n \n \n " + e);
        }
        modulo.setDeleted('t');

        if (ModuloDAO.edit(modulo)) {
            return true;
        } else {
            return false;
        }
    }

}
