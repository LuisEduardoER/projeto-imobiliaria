/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ModuloPermissaoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.PerfisPermissoes.ModuloPermissao;
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

    public List<ModuloPermissao> buscaTodos() {
        List<ModuloPermissao> listaObject = dao.buscarTodos();
//        List<ModuloPermissao> listaModulo = new ArrayList<>();
//        
//        for(int i = 0; i < listaObject.size(); i++){
//            ModuloPermissao f = new Modulo();
//            
//            f.setModuloId((Integer) listaObject.get(i)[0]);
////            f.setNome((String) listaObject.get(i)[1]);
////            f.setCpfCnpj((Integer) listaObject.get(i)[2]);
//            
//            Usuario u = new Usuario();
//            u.setUsuarioName((String) listaObject.get(i)[3] != null ? (String) listaObject.get(i)[3] : "");
//            
//            f.setIdUsuario(u);
//            
//            listaFuncionario.add(f);
//        }

        return listaObject;
    }

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

    /**
     * Método que efetua uma busca pelo ID do funcionario
     *
     * @param id = id do funcionário
     * @return Funcionario funcionario
     */
    public ModuloPermissao buscarModuloPermissaoById(Integer id) {
        ModuloPermissao modulo = dao.buscarModuloPermissaoById(id);
        return modulo;
    }

    public ModuloPermissao gravar(ModuloPermissao moduloPermissao, List<Permissao> permissoes) {

        for (int i = 0; i < permissoes.size(); i++) {
            moduloPermissao.setPermissaoId(permissoes.get(i));
            moduloPermissao.setInserted(Datas.dataAtualDateTime());
            moduloPermissao = dao.gravar(moduloPermissao);
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
