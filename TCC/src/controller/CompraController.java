/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CompraDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Compra;
import modelo.Titulopagar;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class CompraController {

    CompraDAO dao = new CompraDAO();

    public DefaultComboBoxModel<Compra> buscar(String field, String value) {
        DefaultComboBoxModel<Compra> dcbm = new DefaultComboBoxModel<>();
        Compra p = dao.consultarCompra(field, value);
        dcbm.addElement(p);
        return dcbm;
    }

    public List<Compra> buscaTodos(){
        List<Compra> lista = dao.consultarTodos();
        return lista;
    }
    
    public Compra buscaNome(String nome) {
        Compra c = dao.consultarCompra("compra", nome);
        return c;
    }

    public DefaultComboBoxModel<Compra> listByField(String field, String value) {
        DefaultComboBoxModel<Compra> dcbm = new DefaultComboBoxModel<>();
        List<Compra> lista = dao.consultarTodos();
        for (Compra compra : lista) {
            dcbm.addElement(compra);
        }
        return dcbm;
    }

    public Titulopagar gravar(Compra compra) {
        compra.setInserted(Datas.dataAtualDateTime());
        compra = dao.gravar(compra);
        
        TituloPagarController tituloController = new TituloPagarController();
        Titulopagar tP = new Titulopagar();
        
        tP.setCompraId(compra);
        
        tP = tituloController.gravar(tP);
        
        return tP;
    }

    public Compra setDeleted(Compra compra) throws NonexistentEntityException, Exception {
        compra.setUpdated(Datas.dataAtualDateTime());
        compra.setDeleted('t');
        compra = dao.atualizar(compra);
        return compra;
    }
    
    public List<Compra> buscarTodos(){
       List<Compra> lista = dao.consultarTodos();
       return lista;
    }
    
}