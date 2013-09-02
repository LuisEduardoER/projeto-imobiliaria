/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Compra;
import modelo.Estoque;
import modelo.Produto;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class ProdutoController {

    ProdutoDAO dao = new ProdutoDAO();

    public DefaultComboBoxModel<Produto> buscar(String field, String value) {
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
        Produto p = dao.consultarProduto(field, value);
        dcbm.addElement(p);
        return dcbm;
    }
    
    public List<Produto> buscaTodos(){
        List<Produto> lista = dao.buscarTodos();
        return lista;
    }
    public DefaultComboBoxModel<Produto> buscaTodosDCBM(){
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
        List<Produto> lista = dao.buscarTodos();
        for (Produto produto : lista) {
            dcbm.addElement(produto);
        }
        return dcbm;
    }
    
    public Produto buscaNome(String nome) {
        Produto p = dao.consultarProduto("produtoNome", nome);
        return p;
    }

    public DefaultComboBoxModel<Produto> listByField(String field, String value) {
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
        List<Produto> lista = dao.consultarTodos();
        for (Produto produto : lista) {
            dcbm.addElement(produto);
        }
        return dcbm;
    }

    public Produto gravar(Produto produto, Estoque estoque, Compra compra) {
        EstoqueController estoqueController = new EstoqueController();
        CompraController compraController = new CompraController();

        produto.setInserted(Datas.dataAtualDateTime());
        try {
            produto = dao.gravar(produto);

//        String cnpj = produto.getFabricanteId().getFabricanteCNPJ();

//            FabricanteController fc = new FabricanteController();
//            produto.setFabricante(fc.buscaByField("cnpj", cnpj));

            estoque.setEstqprodutoId(produto);
            estoque.setInserted(Datas.dataAtualDateTime());
//        estoque.setFabricanteId(produto.getFabricanteId());
//        estoque.setQuantidade(Integer.parseInt(quantidade));
//        estoque.setQuantidade(Integer.parseInt(quantidadeMin));

            estoqueController.aumentarIniciarEstoque(estoque, produto.getProduto_id());

            compraController.gravar(compra);
            
        } catch (Exception e) {
            e.printStackTrace();
            Mensagens m = new Mensagens();
            m.jopError(e.getMessage());
        }
        return produto;

    }

    public Produto setDeleted(Produto produto) throws NonexistentEntityException, Exception {
        produto.setUpdated(Datas.dataAtualDateTime());
        produto.setDeleted('t');

        produto = dao.atualizar(produto);
        return produto;
    }
}
