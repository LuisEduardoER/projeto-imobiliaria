/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EstoqueDAO;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public DefaultComboBoxModel<Estoque> buscar(String field, String value) {
        DefaultComboBoxModel<Estoque> dcbm = new DefaultComboBoxModel<>();
        Estoque estoque = EstoqueDAO.buscaByField(field, value);
        dcbm.addElement(estoque);
        return dcbm;
    }

    public DefaultComboBoxModel<Estoque> listByField(String field, String value) {
        DefaultComboBoxModel<Estoque> dcbm = new DefaultComboBoxModel<>();
        List<Estoque> lista = EstoqueDAO.listByField(field, value);
        for (Estoque estoque : lista) {
            dcbm.addElement(estoque);
        }
        return dcbm;
    }

    public boolean gravar(Estoque estoque) {
        estoque.setInserted(Datas.dataAtual());
        if (EstoqueDAO.gravar(estoque)) {
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

        if (EstoqueDAO.edit(estoque)) {
            return true;
        } else {
            return false;
        }
    }

    public void aumentarIniciarEstoque(Estoque estoque) {

        try {
            List<Estoque> estoqueList = EstoqueDAO.listByField("produtoId", estoque.getProduto().getProdutoId().toString());
            if (estoqueList != null) {
                try {
                    Estoque _estoque = estoqueList.get(0);
                    _estoque.setQuantidade(estoque.getQuantidade() + _estoque.getQuantidade());

//                    java.util.Date dataUtil = new java.util.Date();
//                    java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
//
//                    DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                    Date date = new Date();
//                    String dataFormatada = dateFormatada.format(date);

                    _estoque.setUpdated(Datas.dataAtual());

                    EstoqueDAO.edit(_estoque);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                    m.jopError("Não foi possível iniciar o estoque para o produto cadastrado, não existe um registro de estoque para o produto. .\n" + ex);
                } catch (Exception ex) {
                    Logger.getLogger(EstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                    m.jopError("Não foi possível iniciar o estoque para o produto cadastrado.\n" + ex);
                }
            } else {
//                java.util.Date dataUtil = new java.util.Date();
//                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
//
//                DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                Date date = new Date();
//                String dataFormatada = dateFormatada.format(date);

                estoque.setInserted(Datas.dataAtual());
                EstoqueDAO.gravar(estoque);
            }
        } catch (Exception e) {
            m.jopError("Não foi possível iniciar o estoque para o produto cadastrado.\n" + e);
        }
    }
}
