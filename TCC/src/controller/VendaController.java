/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.VendaDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Compra;
import modelo.Itemvenda;
import modelo.Titulopagar;
import modelo.Venda;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class VendaController {

    VendaDAO dao = new VendaDAO();
    ItemVendaController itemVendaController;
            
    public DefaultComboBoxModel<Venda> buscar(String field, String value) {
        DefaultComboBoxModel<Venda> dcbm = new DefaultComboBoxModel<>();
        Venda p = dao.consultarCompra(field, value);
        dcbm.addElement(p);
        return dcbm;
    }

    public Venda gravar(Venda venda, List<Itemvenda> itens) {
        venda.setInserted(Datas.dataAtualDateTime());
        venda.setDataVenda(Datas.dataAtualDateTime());
        
        venda = dao.gravar(venda);
        venda.setItemvendaList(itens);
        
        itemVendaController = new ItemVendaController();
        venda = itemVendaController.gravar(venda);
        
        return venda;
    }
    
    public List<Venda> buscaTodos(){
        List<Venda> lista = dao.consultarTodos();
        return lista;
    }
    
    public Venda buscaNome(String nome) {
        Venda c = dao.consultarCompra("venda", nome);
        return c;
    }

    public DefaultComboBoxModel<Venda> listByField(String field, String value) {
        DefaultComboBoxModel<Venda> dcbm = new DefaultComboBoxModel<>();
        List<Venda> lista = dao.consultarTodos();
        for (Venda venda : lista) {
            dcbm.addElement(venda);
        }
        return dcbm;
    }

    public Venda setDeleted(Venda venda) throws NonexistentEntityException, Exception {
        venda.setUpdated(Datas.dataAtualDateTime());
        venda.setDeleted('t');
        venda = dao.atualizar(venda);
        return venda;
    }
    
    public List<Venda> buscarTodos(){
       List<Venda> lista = dao.consultarTodos();
       return lista;
    }
    
}
