/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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

    public Produto gravar(Produto produto, String quantidade, String quantidadeMin) {
        EstoqueController estoqueController = new EstoqueController();

        produto.setInserted(Datas.dataAtualDateTime());

        produto = dao.gravar(produto);
        Estoque estoque = new Estoque();

//        String cnpj = produto.getFabricanteId().getFabricanteCNPJ();

//            FabricanteController fc = new FabricanteController();
//            produto.setFabricante(fc.buscaByField("cnpj", cnpj));

        estoque.setProduto(produto);
        estoque.setFabricanteId(produto.getFabricanteId());
        estoque.setQuantidade(Integer.parseInt(quantidade));
        estoque.setQuantidade(Integer.parseInt(quantidadeMin));
        estoqueController.aumentarIniciarEstoque(estoque, produto.getProdutoId());

        return produto;

    }

    public Produto setDeleted(Produto produto) throws NonexistentEntityException, Exception {
        produto.setUpdated(Datas.dataAtualDateTime());
        produto.setDeleted('t');

        produto = dao.atualizar(produto);
        return produto;
    }
}
