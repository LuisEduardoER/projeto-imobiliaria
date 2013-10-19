/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MovimentoDAO;
import controller.Cadastro.EstoqueController;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Movimento;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class MovimentoController {

    MovimentoDAO dao = new MovimentoDAO();
    EstoqueController estoqueController;
    Mensagens m;
//    public DefaultComboBoxModel<Movimento> buscar(String field, String value) {
//        DefaultComboBoxModel<Movimento> dcbm = new DefaultComboBoxModel<>();
//        Movimento p = dao.consultarMovimento(field, value);
//        dcbm.addElement(p);
//        return dcbm;
//    }

    /**
     * 
     * @param Venda venda
     * @return Venda venda
     
     * Faz a gravação de cada um dos items de venda presentes no objeto venda
     * para cada item faz atualização da quantidade em estoque;
     */
    public Movimento gravar(Movimento movimento) {
        movimento.setMovimentoHorario(Datas.dataDateTime);
        
        movimento = dao.gravar(movimento);
        return movimento;
    }

    public List<Movimento> buscaTodos() {
        List<Movimento> lista = dao.consultarTodos();
        return lista;
    }

//   item

    public DefaultComboBoxModel<Movimento> listByField(String field, String value) {
        DefaultComboBoxModel<Movimento> dcbm = new DefaultComboBoxModel<>();
        List<Movimento> lista = dao.consultarTodos();
        for (Movimento movimento : lista) {
            dcbm.addElement(movimento);
        }
        return dcbm;
    }

    public Movimento setDeleted(Movimento movimento) throws NonexistentEntityException, Exception {
        movimento = dao.atualizar(movimento);
        return movimento;
    }

    public List<Movimento> buscarTodos() {
        List<Movimento> lista = dao.consultarTodos();
        return lista;
    }
}
