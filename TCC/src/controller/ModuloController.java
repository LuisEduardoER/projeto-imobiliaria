/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ModuloDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.PerfisPermissoes.Modulo;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class ModuloController {

    ModuloDAO dao = new ModuloDAO();

    public DefaultComboBoxModel<Modulo> buscar(String field, String value) {
        Modulo modulo = new Modulo();
        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarModulo(field, value);
        if (!esatdoObject.isEmpty()) {
            modulo.setModuloId((Integer) esatdoObject.get(0)[0]);
//            funcionario.setCpfCnpj((int) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(modulo);
        return dcbm;
    }

    public List<Modulo> buscaTodos() {
        List<Modulo> listaObject = dao.buscarTodos();
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

    public DefaultComboBoxModel<Modulo> listModulos() {
        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
        List<Modulo> lista = dao.consultarTodos();
        for (Modulo modulo : lista) {
            dcbm.addElement(modulo);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<Modulo> listByField(String field, String value) {
        DefaultComboBoxModel<Modulo> dcbm = new DefaultComboBoxModel<>();
        List<Modulo> lista = dao.consultarTodos();
        for (Modulo modulo : lista) {
            dcbm.addElement(modulo);
        }
        return dcbm;
    }

    /**
     * Método que efetua uma busca pelo ID do funcionario
     *
     * @param id = id do funcionário
     * @return Funcionario funcionario
     */
    public Modulo buscarModuloById(Integer id) {
        Modulo modulo = dao.buscarModuloById(id);
        return modulo;
    }

    public Modulo gravar(Modulo modulo) {

        Integer modulos = dao.checaModuloExiste(modulo);
        if (modulos > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este CPF/CNPJ já existe.");
        } else {
            modulo.setInserted(Datas.dataAtualDateTime());
            modulo = dao.gravar(modulo);
        }
        return modulo;
    }

    public Modulo setDeleted(Modulo modulo) throws NonexistentEntityException, Exception {
        modulo.setUpdated(Datas.dataAtualDateTime());
        modulo.setDeleted('t');

        modulo = dao.atualizar(modulo);

        return modulo;
    }
}
