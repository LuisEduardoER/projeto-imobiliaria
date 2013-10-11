/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PerfilDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.PerfisPermissoes.Perfil;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class PerfilController {

    PerfilDAO dao = new PerfilDAO();

    public DefaultComboBoxModel<Perfil> buscar(String field, String value) {
        Perfil perfil = new Perfil();
        DefaultComboBoxModel<Perfil> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarPerfil(field, value);
        if (!esatdoObject.isEmpty()) {
            perfil.setPerfilID((Integer) esatdoObject.get(0)[0]);
//            funcionario.setCpfCnpj((int) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(perfil);
        return dcbm;
    }
    public List<Perfil> buscaTodos(){
        List<Perfil> listaObject = dao.buscarTodos();
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
    public DefaultComboBoxModel<Perfil> listByField(String field, String value) {
        DefaultComboBoxModel<Perfil> dcbm = new DefaultComboBoxModel<>();
        List<Perfil> lista = dao.consultarTodos();
        for (Perfil perfil : lista) {
            dcbm.addElement(perfil);
        }
        return dcbm;
    }
    /**
     * Método que efetua uma busca pelo ID do funcionario
     * @param id = id do funcionário
     * @return Funcionario funcionario
     */
    public Perfil buscarPerfilById(Integer id) {
        Perfil modulo = dao.buscarPerfilById(id);
        return modulo;
    }

    public Perfil gravar(Perfil perfil) {
        
        Integer perfis = dao.checaPerfilExiste(perfil);
        if (perfis > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este CPF/CNPJ já existe.");
        }else{
            perfil.setInserted(Datas.dataAtualDateTime());
            perfil = dao.gravar(perfil);
        }
        return perfil;
    }

    public DefaultComboBoxModel<Perfil> listPerfis() {
        DefaultComboBoxModel<Perfil> dcbm = new DefaultComboBoxModel<>();
        List<Perfil> lista = dao.consultarTodos();
        for (Perfil Perfil : lista) {
            dcbm.addElement(Perfil);
        }
        return dcbm;
    }
    
    public Perfil setDeleted(Perfil perfil) throws NonexistentEntityException, Exception {
        perfil.setUpdated(Datas.dataAtualDateTime());
        perfil.setDeleted('t');

        perfil = dao.atualizar(perfil);

        return perfil;
    }
}
