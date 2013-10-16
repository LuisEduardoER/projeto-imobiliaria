/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ModuloPermissaoDAO;
import controller.cadastro.administrativo.permissoes.PerfilModuloPermissaoController;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.PerfisPermissoes.ModuloPermissao;
import modelo.PerfisPermissoes.PerfilModulopermissao;
import modelo.PerfisPermissoes.Permissao;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class ModuloPermissaoController {

    ModuloPermissaoDAO dao = new ModuloPermissaoDAO();
    
    public DefaultComboBoxModel<ModuloPermissao> buscar(String field, String value) {
        ModuloPermissao modulo = new ModuloPermissao();
        DefaultComboBoxModel<ModuloPermissao> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarModuloPermissao(field, value);
        if (!esatdoObject.isEmpty()) {
            modulo.setModuloPermissaoId((Integer) esatdoObject.get(0)[0]);
//            funcionario.setCpfCnpj((int) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(modulo);
        return dcbm;
    }

//    public List<ModuloPermissao> buscaTodos() {
//        List<ModuloPermissao> listaObject = dao.buscarTodos();
//
//        return listaObject;
//    }

    public DefaultComboBoxModel<ModuloPermissao> listModuloPermissaos() {
        DefaultComboBoxModel<ModuloPermissao> dcbm = new DefaultComboBoxModel<>();
        List<ModuloPermissao> lista = dao.consultarTodos();
        for (ModuloPermissao moduloPermissao : lista) {
            dcbm.addElement(moduloPermissao);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<ModuloPermissao> listByField(String field, String value) {
        DefaultComboBoxModel<ModuloPermissao> dcbm = new DefaultComboBoxModel<>();
        List<ModuloPermissao> lista = dao.consultarTodos();
        for (ModuloPermissao moduloPermissao : lista) {
            dcbm.addElement(moduloPermissao);
        }
        return dcbm;
    }

    public ModuloPermissao buscarModuloPermissaoById(Integer id) {
        ModuloPermissao modulo = dao.buscarModuloPermissaoById(id);
        return modulo;
    }

    public ModuloPermissao gravar(ModuloPermissao moduloPermissao, List<Permissao> permissoes) {
        PerfilModuloPermissaoController pmpController = new PerfilModuloPermissaoController();
        PerfilModulopermissao pmp;
        for (int i = 0; i < permissoes.size(); i++) {
            moduloPermissao.setPermissaoId(permissoes.get(i));
            moduloPermissao.setInserted(Datas.dataAtualDateTime());
            moduloPermissao = dao.gravar(moduloPermissao);
            
            pmp = new PerfilModulopermissao();
            pmp.setModuloPermissaoId(moduloPermissao);

            pmpController.gravar(pmp);
        }

        return moduloPermissao;
    }

    public ModuloPermissao setDeleted(ModuloPermissao modulo) throws NonexistentEntityException, Exception {
        modulo.setUpdated(Datas.dataAtualDateTime());
        modulo.setDeleted('t');

        modulo = dao.atualizar(modulo);

        return modulo;
    }
}
