/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.cadastro.administrativo.permissoes;

import DAO.PerfilModuloPermissaoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.PerfisPermissoes.PerfilModulopermissao;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class PerfilModuloPermissaoController {

    PerfilModuloPermissaoDAO dao = new PerfilModuloPermissaoDAO();

    public DefaultComboBoxModel<PerfilModulopermissao> buscar(String field, String value) {
        PerfilModulopermissao perfilModulopermissao = new PerfilModulopermissao();
        DefaultComboBoxModel<PerfilModulopermissao> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> perfilModulopermissaoObj = dao.consultarPerfilModulopermissao(field, value);
        if (!perfilModulopermissaoObj.isEmpty()) {
            perfilModulopermissao.setPerfilmoduloPermissaoId((Integer) perfilModulopermissaoObj.get(0)[0]);
//            funcionario.setCpfCnpj((int) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(perfilModulopermissao);
        return dcbm;
    }

//    public List<PerfilModulopermissao> buscaTodos() {
//        List<PerfilModulopermissao> listaObject = dao.buscarTodos();
//
//        return listaObject;
//    }

    public DefaultComboBoxModel<PerfilModulopermissao> listPerfilModulopermissao() {
        DefaultComboBoxModel<PerfilModulopermissao> dcbm = new DefaultComboBoxModel<>();
        List<PerfilModulopermissao> lista = dao.consultarTodos();
        for (PerfilModulopermissao moduloPermissao : lista) {
            dcbm.addElement(moduloPermissao);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<PerfilModulopermissao> listByField(String field, String value) {
        DefaultComboBoxModel<PerfilModulopermissao> dcbm = new DefaultComboBoxModel<>();
        List<PerfilModulopermissao> lista = dao.consultarTodos();
        for (PerfilModulopermissao moduloPermissao : lista) {
            dcbm.addElement(moduloPermissao);
        }
        return dcbm;
    }

    /**
     * Método que efetua uma busca pelo ID do funcionario
     *
     * @param id = id do funcionário
     * @return Funcionario funcionario
     */
    public PerfilModulopermissao buscarPerfilModulopermissaoById(Integer id) {
        PerfilModulopermissao modulo = dao.buscarPerfilModulopermissaoById(id);
        return modulo;
    }

    public PerfilModulopermissao gravar(PerfilModulopermissao perfilModulopermissao) {

            perfilModulopermissao.setInserted(Datas.dataAtualDateTime());
            perfilModulopermissao = dao.gravar(perfilModulopermissao);

        return perfilModulopermissao;
    }

    public PerfilModulopermissao setDeleted(PerfilModulopermissao modulo) throws NonexistentEntityException, Exception {
        modulo.setUpdated(Datas.dataAtualDateTime());
        modulo.setDeleted('t');

        modulo = dao.atualizar(modulo);

        return modulo;
    }
}
