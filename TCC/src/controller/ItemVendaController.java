/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Cadastro.EstoqueController;
import DAO.ItemVendaDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Estoque;
import modelo.Itemvenda;
import modelo.Cadastro.Adminsitrativo.Produto;
import modelo.Venda;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class ItemVendaController {

    ItemVendaDAO dao = new ItemVendaDAO();
    EstoqueController estoqueController;
    Mensagens m;
    public DefaultComboBoxModel<Itemvenda> buscar(String field, String value) {
        DefaultComboBoxModel<Itemvenda> dcbm = new DefaultComboBoxModel<>();
        Itemvenda p = dao.consultarItemVenda(field, value);
        dcbm.addElement(p);
        return dcbm;
    }

    /**
     * 
     * @param Venda venda
     * @return Venda venda
     
     * Faz a gravação de cada um dos items de venda presentes no objeto venda
     * para cada item faz atualização da quantidade em estoque;
     */
    public Venda gravar(Venda venda) {

        for (int i = 0; i < venda.getItemvendaList().size(); i++) {
            Itemvenda item = venda.getItemvendaList().get(i);

            item.setInserted(Datas.dataDateTime);
            item.setVendaId(venda);
            
            //atualiza a qunatidade em estoque, ainda sem finalidade
            estoqueController = new EstoqueController();
            
            Produto produto = item.getProdutoId();
            
            Estoque estoque = estoqueController.verificaQuantidade(produto);
            estoque.setQuantidade(estoque.getQuantidade()-item.getQuantidade());
            estoqueController.atualizar(estoque);
            // implementar esta verificação apenas no caso de compras por delivery!
//            if(estoque.getQuantidade() - item.getQuantidade() > estoque.getQuantidadeMIN()){
            dao.gravar(item);
//            }else if (estoque.getQuantidade() - item.getQuantidade() < 0){
//                m = new Mensagens();
//                m.jopAlerta("A quantidade solicitada para o Produto: " + item.getProdutoId().getProdutoNome() +" ultrapassa a quantidade em estoque!");
//            }
        }
        return venda;
    }

    public List<Itemvenda> buscaTodos() {
        List<Itemvenda> lista = dao.consultarTodos();
        return lista;
    }

    public Itemvenda buscaNome(String nome) {
        Itemvenda itemvenda = dao.consultarItemVenda("itemVenda", nome);
        return itemvenda;
    }

    public DefaultComboBoxModel<Itemvenda> listByField(String field, String value) {
        DefaultComboBoxModel<Itemvenda> dcbm = new DefaultComboBoxModel<>();
        List<Itemvenda> lista = dao.consultarTodos();
        for (Itemvenda itemvenda : lista) {
            dcbm.addElement(itemvenda);
        }
        return dcbm;
    }

    public Itemvenda setDeleted(Itemvenda itemVenda) throws NonexistentEntityException, Exception {
        itemVenda.setUpdated(Datas.dataAtualDateTime());
        itemVenda.setDeleted('t');
        itemVenda = dao.atualizar(itemVenda);
        return itemVenda;
    }

    public List<Itemvenda> buscarTodos() {
        List<Itemvenda> lista = dao.consultarTodos();
        return lista;
    }
}
