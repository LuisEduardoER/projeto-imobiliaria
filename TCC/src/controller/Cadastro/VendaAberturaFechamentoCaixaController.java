/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro;

import DAO.VendaAberturaFechamentoCaixaDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.AberturaCaixa;
import modelo.Caixa;
import modelo.Usuario;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class VendaAberturaFechamentoCaixaController {

    VendaAberturaFechamentoCaixaDAO dao = new VendaAberturaFechamentoCaixaDAO();

    public DefaultComboBoxModel<AberturaCaixa> buscar(String field, String value) {
        AberturaCaixa aberturaCaixa = new AberturaCaixa();
        DefaultComboBoxModel<AberturaCaixa> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> aberturaCaixaObject = dao.consultarCaixamovimento(field, value);
        if (!aberturaCaixaObject.isEmpty()) {
            aberturaCaixa.setAberturaCaixaId((Integer) aberturaCaixaObject.get(0)[0]);
        }
        dcbm.addElement(aberturaCaixa);
        return dcbm;
    }

    public DefaultComboBoxModel<AberturaCaixa> listCaixamovimento() {
        DefaultComboBoxModel<AberturaCaixa> dcbm = new DefaultComboBoxModel<>();
        List<AberturaCaixa> lista = dao.consultarTodos();
        for (AberturaCaixa aberturaCaixa : lista) {
            dcbm.addElement(aberturaCaixa);
        }
        return dcbm;
    }

    public AberturaCaixa buscarCaixamovimento(Integer caixaId) {
        AberturaCaixa aberturaCaixa = dao.buscarCaixamovimento(caixaId);
        return aberturaCaixa;
    }

    public Integer rowCountCaixasAbertosByUsuario(Integer usuarioId) {
        Integer caixasAbertos = dao.rowCountCaixasAbertosByUsuario(usuarioId);
        return caixasAbertos;
    }
    
    public AberturaCaixa getCaixaAbertoByFuncionario(Integer usuarioId) {
        AberturaCaixa aberturaCaixa = dao.getCaixaAbertoByFuncionario(usuarioId);
        return aberturaCaixa;
    }

    public AberturaCaixa gravar(AberturaCaixa aberturaCaixa) {

        Integer aberturaCaixas = dao.rowCountCaixasAbertos(aberturaCaixa.getCaixaId().getCaixaId());

        if (aberturaCaixas > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este caixa já se encontra aberto!");
        } else {
            aberturaCaixa.setInserted(Datas.dataAtualDateTime());
            aberturaCaixa.setAberturaCaixa(Datas.dataAtualDateTime());
            aberturaCaixa = dao.gravar(aberturaCaixa);
            modelo.Session.setCaixa(aberturaCaixa);
        }
        return aberturaCaixa;
    }
//    public AberturaCaixa setDeleted(AberturaCaixa aberturaCaixa) throws NonexistentEntityException, Exception {
//        aberturaCaixa.setUpdated(Datas.dataAtualDateTime());
//        aberturaCaixa.setDeleted('t');
//
//        aberturaCaixa = dao.atualizar(aberturaCaixa);
//
//        return aberturaCaixa;
//    }
}
