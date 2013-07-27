/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PermissaoDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Permissao;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class PermissaoController {

    public DefaultComboBoxModel<Permissao> buscar(String field, String value) {
        DefaultComboBoxModel<Permissao> dcbm = new DefaultComboBoxModel<>();
        Permissao p = PermissaoDAO.buscaByField(field, value);
        dcbm.addElement(p);
        return dcbm;
    }

    public DefaultComboBoxModel<Permissao> listByField(String field, String value) {
        DefaultComboBoxModel<Permissao> dcbm = new DefaultComboBoxModel<>();
        List<Permissao> lista = PermissaoDAO.listByField(field, value);
        for (Permissao permissao : lista) {
            dcbm.addElement(permissao);
        }
        return dcbm;
    }

    public boolean gravar(Permissao permissao) {

        if (PermissaoDAO.gravar(permissao)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDeleted(Permissao permissao) throws NonexistentEntityException, Exception {
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dataFormatada = dateFormatada.format(date);

            permissao.setUpdated(dataFormatada);
        } catch (Exception e) {
            System.out.println("\n \n \n --------  \n \n \n " + e);
        }
        permissao.setDeleted('t');

        if (PermissaoDAO.edit(permissao)) {
            return true;
        } else {
            return false;
        }
    }

}
