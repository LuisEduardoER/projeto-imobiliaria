/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PermissaoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Permissao;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class PermissaoController {

    PermissaoDAO dao = new PermissaoDAO();

    public DefaultComboBoxModel<Permissao> buscar(String field, String value) {
        Permissao permissao = new Permissao();
        DefaultComboBoxModel<Permissao> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarPermissao(field, value);
        if (!esatdoObject.isEmpty()) {
            permissao.setPermissaoId((Integer) esatdoObject.get(0)[0]);
//            funcionario.setCpfCnpj((int) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(permissao);
        return dcbm;
    }
    public List<Permissao> buscaTodos(){
        List<Permissao> listaObject = dao.buscarTodos();
//        List<Modulo> listaModulo = new ArrayList<>();
//        
//        for(int i = 0; i < listaObject.size(); i++){
//            Modulo f = new Modulo();
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
    public DefaultComboBoxModel<Permissao> listByField(String field, String value) {
        DefaultComboBoxModel<Permissao> dcbm = new DefaultComboBoxModel<>();
        List<Permissao> lista = dao.consultarTodos();
        for (Permissao permissao : lista) {
            dcbm.addElement(permissao);
        }
        return dcbm;
    }
    /**
     * Método que efetua uma busca pelo ID do funcionario
     * @param id = id do funcionário
     * @return Funcionario funcionario
     */
    public Permissao buscarPermissaoById(Integer id) {
        Permissao modulo = dao.buscarPermissaoById(id);
        return modulo;
    }

    public Permissao gravar(Permissao permissao) {
        
        Integer perfis = dao.checaPermissaoExiste(permissao);
        if (perfis > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este CPF/CNPJ já existe.");
        }else{
            permissao.setInserted(Datas.dataAtualDateTime());
            permissao = dao.gravar(permissao);
        }
        return permissao;
    }

    public Permissao setDeleted(Permissao permissao) throws NonexistentEntityException, Exception {
        permissao.setUpdated(Datas.dataAtualDateTime());
        permissao.setDeleted('t');

        permissao = dao.atualizar(permissao);

        return permissao;
    }
}
