/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TituloPagarDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Titulopagar;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class TituloPagarController {

    TituloPagarDAO dao = new TituloPagarDAO();

//    public DefaultComboBoxModel<Titulopagar> buscar(String field, String value) {
//        DefaultComboBoxModel<Titulopagar> dcbm = new DefaultComboBoxModel<>();
//        Titulopagar titulo = dao.consultarCompra(field, value);
//        dcbm.addElement(titulo);
//        return dcbm;
//    }

    public Titulopagar buscaTituloPagar(Integer id) {
        Titulopagar tituloPagar = dao.consultarTituloPagarById(id);
        return tituloPagar;
    }

    public DefaultComboBoxModel<Titulopagar> listByField(String field, String value) {
        DefaultComboBoxModel<Titulopagar> dcbm = new DefaultComboBoxModel<>();
        List<Titulopagar> lista = dao.consultarTodos();
        for (Titulopagar tituloPagar : lista) {
            dcbm.addElement(tituloPagar);
        }
        return dcbm;
    }

    public Titulopagar gravar(Titulopagar tituloPagar) {
        tituloPagar.setInserted(Datas.dataAtualDateTime());
        tituloPagar = dao.gravar(tituloPagar);
        return tituloPagar;
    }
    
    public Titulopagar baixarTituloPagar(Titulopagar tituloPagar) {
        tituloPagar.setUpdated(Datas.dataAtualDateTime());
        tituloPagar.setDataBaixado(Datas.dataAtualDateTime());
        tituloPagar.setBaixado('t');
        tituloPagar = dao.atualizar(tituloPagar);
        return tituloPagar;
    }

    public Titulopagar setDeleted(Titulopagar tituloPagar) throws NonexistentEntityException, Exception {
        tituloPagar.setUpdated(Datas.dataAtualDateTime());
        tituloPagar.setDeleted('t');
        tituloPagar = dao.atualizar(tituloPagar);
        return tituloPagar;
    }
    
    public List<Titulopagar> buscarTodos(){
       List<Titulopagar> lista = dao.consultarTodos();
       return lista;
    }
    
}
