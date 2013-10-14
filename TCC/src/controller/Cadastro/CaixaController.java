/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro;

import DAO.Cadastro.CaixaDAO;
import DAO.Cadastro.Endereco.PaisDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Caixa;
import modelo.Pais;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class CaixaController {

    CaixaDAO dao = new CaixaDAO();

    public DefaultComboBoxModel<Caixa> buscar(String field, String value) {
        Caixa caixa = new Caixa();
        DefaultComboBoxModel<Caixa> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> caixaObject = dao.consultarCaixa(field, value);
        if (!caixaObject.isEmpty()) {
            caixa.setCaixaId((Integer)caixaObject.get(0)[0]);
            caixa.setCaixaDesc((String) caixaObject.get(0)[1]);
        }
        dcbm.addElement(caixa);
        return dcbm;
    }

    public DefaultComboBoxModel<Caixa> listCaixa() {
        DefaultComboBoxModel<Caixa> dcbm = new DefaultComboBoxModel<>();
        List<Caixa> lista = dao.consultarTodos();
        for (Caixa caixa : lista) {
            dcbm.addElement(caixa);
        }
        return dcbm;
    }

    public Caixa buscarCaixa(String field, String value) {
        Caixa caixa = dao.buscarCaixa(field, value);
        return caixa;
    }

    public Caixa gravar(Caixa caixa) {
        
        Integer caixas = dao.rowCount("caixa.caixaDesc", caixa.getCaixaDesc());
        if (caixas > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Já existe um caixa cadastrado com este nome!");
        }else{
            caixa.setInserted(Datas.dataAtualDateTime());
            caixa = dao.gravar(caixa);
        }
        return caixa;
    }

    public Caixa setDeleted(Caixa caixa) throws NonexistentEntityException, Exception {
        caixa.setUpdated(Datas.dataAtualDateTime());
        caixa.setDeleted('t');

        caixa = dao.atualizar(caixa);

        return caixa;
    }
}
