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
    
   public DefaultComboBoxModel<Produto> buscar(String field, String value) {
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
        Produto p = ProdutoDAO.buscaByField(field, value);
        dcbm.addElement(p);
        return dcbm;
    }

   public Produto buscaNome(String nome){
       Produto p = ProdutoDAO.buscaNome(nome);
       return p;
   }
   
    public DefaultComboBoxModel<Produto> listByField(String field, String value) {
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
        List<Produto> lista = ProdutoDAO.listByField(field, value);
        for (Produto produto : lista) {
            dcbm.addElement(produto);
        }
        return dcbm;
    }

    public boolean gravar(Produto produto, String quantidade, String quantidadeMin) {
        EstoqueController estoqueController = new EstoqueController();
        produto.setInserted(Datas.dataAtual());
        if (ProdutoDAO.gravar(produto)) {
            Estoque estoque = new Estoque();
            
            String cnpj = produto.getFabricante().getFabricanteCNPJ();
            
//            FabricanteController fc = new FabricanteController();
//            produto.setFabricante(fc.buscaByField("cnpj", cnpj));
            
            estoque.setProduto(produto);
            estoque.setFabricante(produto.getFabricante());
            estoque.setQuantidade(Integer.parseInt(quantidade));
            estoque.setQuantidade(Integer.parseInt(quantidadeMin));
            estoqueController.aumentarIniciarEstoque(estoque);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDeleted(Produto produto) throws NonexistentEntityException, Exception {
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dataFormatada = dateFormatada.format(date);

            produto.setUpdated(dataFormatada);
        } catch (Exception e) {
            System.out.println("\n \n \n --------  \n \n \n " + e);
        }
        produto.setDeleted('t');

        if (ProdutoDAO.edit(produto)) {
            return true;
        } else {
            return false;
        }
    }

    
}
