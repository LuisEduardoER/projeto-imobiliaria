/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.FabricanteDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Fabricante;
import org.joda.time.LocalDateTime;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class FabricanteController {

    FabricanteDAO dao = new FabricanteDAO();

    public DefaultComboBoxModel<Fabricante> buscar(String field, String value) {
        Fabricante fabricante = new Fabricante();
        DefaultComboBoxModel<Fabricante> dcbm = new DefaultComboBoxModel<>();
        
        List<Object[]> fabricanteObject = dao.consultarFabricante(field, value);
        if(!fabricanteObject.isEmpty()){
            fabricante.setFabricanteId((int) fabricanteObject.get(0)[0]);
            fabricante.setFabricanteNome((String) fabricanteObject.get(0)[1]);
            fabricante.setFabricanteCNPJ((String) fabricanteObject.get(0)[2]);
            fabricante.setInserted((LocalDateTime) fabricanteObject.get(0)[3]);
            fabricante.setUpdated((LocalDateTime) fabricanteObject.get(0)[4]);
            fabricante.setDeleted((String) fabricanteObject.get(0)[5]);
        }
//        Fabricante f = dao.consultarFabricante(field, value);
        
        dcbm.addElement(fabricante);
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
      Fabricante  fabricante = new Fabricante();
       // Fabricante fabricante = dao.consultarFabricante(field, value);
      List<Object[]> fabricanteObject = dao.consultarFabricante(field, value);
        if(!fabricanteObject.isEmpty()){
            fabricante.setFabricanteId((int) fabricanteObject.get(0)[0]);
            fabricante.setFabricanteNome((String) fabricanteObject.get(0)[1]);
            fabricante.setFabricanteCNPJ((String) fabricanteObject.get(0)[2]);
            fabricante.setInserted((LocalDateTime) fabricanteObject.get(0)[3]);
            fabricante.setUpdated((LocalDateTime) fabricanteObject.get(0)[4]);
            fabricante.setDeleted((String) fabricanteObject.get(0)[5]);
        }
        return fabricante;
    }

    public Fabricante gravar(Fabricante fabricante) {
        fabricante.setInserted(Datas.dataAtualDateTime());
        fabricante = dao.gravar(fabricante);
        return fabricante;
    }

    public Fabricante setDeleted(Fabricante fabricante) throws NonexistentEntityException, Exception {
        fabricante.setUpdated(Datas.dataAtualDateTime());
        fabricante.setDeleted("t");

        fabricante = dao.atualizar(fabricante);
        return fabricante;

    }
}
