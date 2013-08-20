/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EstoqueDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import modelo.Estoque;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class EstoqueController {

    Mensagens m;
    EstoqueDAO dao = new EstoqueDAO();

//    public DefaultComboBoxModel<Estoque> buscar(String field, String value) {
//        DefaultComboBoxModel<Estoque> dcbm = new DefaultComboBoxModel<>();
//        Estoque estoque = dao.consultarTodos(field, value);
//        dcbm.addElement(estoque);
//        return dcbm;
//    }
//
//    public DefaultComboBoxModel<Estoque> listByField(String field, String value) {
//        DefaultComboBoxModel<Estoque> dcbm = new DefaultComboBoxModel<>();
//        List<Estoque> lista = dao.listByField(field, value);
//        for (Estoque estoque : lista) {
//            dcbm.addElement(estoque);
//        }
//        return dcbm;
//    }

    public boolean gravar(Estoque estoque) {
        estoque.setInserted(Datas.dataAtual());
        if (dao.gravar(estoque) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDeleted(Estoque estoque) throws NonexistentEntityException, Exception {
//            java.util.Date dataUtil = new java.util.Date();
//            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
//
//            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = new Date();
//            String dataFormatada = dateFormatada.format(date);

        estoque.setUpdated(Datas.dataAtual());
        estoque.setDeleted('t');

        if (dao.atualizar(estoque) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Estoque aumentarIniciarEstoque(Estoque estoque) {
        Estoque retorno;
        try {
            if (dao.rowCount("produtoId", estoque.getProduto().getProdutoId().toString()) > 0) {
                try {
                    Estoque _estoque = dao.consultarEstoque("produtoId", estoque.getProduto().toString());
                    _estoque.setQuantidade(estoque.getQuantidade() + _estoque.getQuantidade());

                    _estoque.setUpdated(Datas.dataAtual());

                    retorno = dao.atualizar(_estoque);
                    return retorno;
                } catch (Exception ex) {
                    Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                    m.jopError("Não foi possível iniciar o estoque para o produto cadastrado.\n" + ex);
                }
            } else {
                estoque.setInserted(Datas.dataAtual());
                retorno = dao.gravar(estoque);
                return retorno;
            }
        } catch (Exception e) {
            m.jopError("Não foi possível iniciar o estoque para o produto cadastrado.\n" + e);
        }
        return  null;
    }
}
