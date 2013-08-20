/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FabricanteDAO;
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

    FabricanteDAO dao = new FabricanteDAO();

    public DefaultComboBoxModel<Fabricante> buscar(String field, String value) {
        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
        Fabricante f = dao.consultarFabricante(field, value);
        dcbm.addElement(f);
        return dcbm;
    }

    public DefaultComboBoxModel<Fabricante> listByField(String field, String value) {
        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
        List<Fabricante> lista = dao.consultarTodos();
        for (Fabricante fabricante : lista) {
            dcbm.addElement(fabricante);
        }
        return dcbm;
    }

    public Fabricante buscaByField(String field, String value) {
        Fabricante fabricante = dao.consultarFabricante(field, value);
        return fabricante;
    }

    public Fabricante gravar(Fabricante fabricante) {
        fabricante.setInserted(Datas.dataAtual());
        fabricante = dao.gravar(fabricante);
        return fabricante;
    }

    public Fabricante setDeleted(Fabricante fabricante) throws NonexistentEntityException, Exception {
        fabricante.setUpdated(Datas.dataAtual());
        fabricante.setDeleted('t');

        fabricante = dao.atualizar(fabricante);
        return fabricante;

    }
}
