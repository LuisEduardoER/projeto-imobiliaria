/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FabricanteDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Fabricante;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class FabricanteController {

    public DefaultComboBoxModel<Fabricante> buscar(String field, String value) {
        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
        Fabricante f = FabricanteDAO.buscaByField(field, value);
        dcbm.addElement(f);
        return dcbm;
    }

    public DefaultComboBoxModel<Fabricante> listByField(String field, String value) {
        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
        List<Fabricante> lista = FabricanteDAO.listByField(field, value);
        for (Fabricante fabricante : lista) {
            dcbm.addElement(fabricante);
        }
        return dcbm;
    }

    public Fabricante buscaByField(String field, String value) {
        Fabricante fabricante = FabricanteDAO.buscaByField(field, value);
        return fabricante;
    }

    public boolean gravar(Fabricante fabricante) {
        fabricante.setInserted(Datas.dataAtual());
        if (FabricanteDAO.gravar(fabricante)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDeleted(Fabricante fabricante) throws NonexistentEntityException, Exception {
//            java.util.Date dataUtil = new java.util.Date();
//            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
//
//            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = new Date();
//            String dataFormatada = dateFormatada.format(date);

        fabricante.setUpdated(Datas.dataAtual());
        fabricante.setDeleted('t');

        if (FabricanteDAO.edit(fabricante)) {
            return true;
        } else {
            return false;
        }
    }
}
