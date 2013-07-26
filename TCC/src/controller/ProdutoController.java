/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProdutoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Produto;

/**
 *
 * @author Bruno
 */
public class ProdutoController {
    
    public DefaultComboBoxModel<Produto> buscar(String field, String value) {
        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
        List<Produto> lista = ProdutoDAO.buscaByField(field, value);
        for (Produto produto : lista) {
            dcbm.addElement(produto);
        }
        return dcbm;
    }

//    public DefaultComboBoxModel<Produto> listaModulo() {
//        DefaultComboBoxModel<Produto> dcbm = new DefaultComboBoxModel<>();
//        List<Produto> lista = getListaProduto();
//        for (Produto produto : lista) {
//            dcbm.addElement(produto);
//        }
//        return dcbm;
//    }
    
    public boolean gravar(Produto produto) {
        if (ProdutoDAO.create(produto)) {
            return true;
        } else {
            return false;
        }
    }
    
    public Produto buscarProduto(String codigoBarra){
      List produtoList = ProdutoDAO.buscaByField("produtoCodigoBarras", codigoBarra);
      Produto produto = (Produto) produtoList.get(0);
      return produto;
              
    }
    
}
