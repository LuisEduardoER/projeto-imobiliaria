/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.RuaDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Rua;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class RuaController {

    RuaDAO dao = new RuaDAO();

    public DefaultComboBoxModel<Rua> buscar(String field, String value) {
        Rua rua = new Rua();
        DefaultComboBoxModel<Rua> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> ruaObject = dao.consultarRua(field, value);
        if (!ruaObject.isEmpty()) {
            rua.setRuaId((Integer) ruaObject.get(0)[0]);
            rua.setRuaNome((String) ruaObject.get(0)[1]);
        }
        dcbm.addElement(rua);
        return dcbm;
    }

    public DefaultComboBoxModel<Rua> listByField(String field, String value) {
        DefaultComboBoxModel<Rua> dcbm = new DefaultComboBoxModel<>();
        List<Rua> lista = dao.consultarTodos();
        for (Rua bairro : lista) {
            dcbm.addElement(bairro);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<Rua> listRuaByBairro(Integer barirroId) {
        DefaultComboBoxModel<Rua> dcbm = new DefaultComboBoxModel<>();
        List<Rua> lista = dao.buscarRuaByBairro(barirroId);
        for (Rua rua : lista) {
            dcbm.addElement(rua);
        }
        return dcbm;
    }
    
    public Rua buscarRua(String field, String value) {
        Rua rua = dao.buscarRua(field, value);
        return rua;
    }

    public Rua gravar(Rua rua) {
        
        Integer bairros = dao.checaRuaExiste(rua);
        if (bairros > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Esta Rua já existe neste bairro.");
        }else{
            rua.setInserted(Datas.dataAtualDateTime());
            rua = dao.gravar(rua);
        }
        return rua;
    }

    public Rua setDeleted(Rua rua) throws NonexistentEntityException, Exception {
        rua.setUpdated(Datas.dataAtualDateTime());
        rua.setDeleted('t');

        rua = dao.atualizar(rua);

        return rua;
    }
}
