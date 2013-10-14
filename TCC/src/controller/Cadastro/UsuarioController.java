/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro;

import DAO.Cadastro.UsuarioDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Pais;
import modelo.Usuario;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class UsuarioController {

    UsuarioDAO dao = new UsuarioDAO();

    public DefaultComboBoxModel<Usuario> buscar(String field, String value) {
        Usuario usuario = new Usuario();
        DefaultComboBoxModel<Usuario> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarUsuario(field, value);
        if (!esatdoObject.isEmpty()) {
            usuario.setUsuarioId((Integer) esatdoObject.get(0)[0]);
            usuario.setUsuarioName((String) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(usuario);
        return dcbm;
    }

    public DefaultComboBoxModel<Usuario> listByField(String field, String value) {
        DefaultComboBoxModel<Usuario> dcbm = new DefaultComboBoxModel<>();
        List<Usuario> lista = dao.consultarTodos();
        for (Usuario usuario : lista) {
            dcbm.addElement(usuario);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<Usuario> listUsuarios() {
        DefaultComboBoxModel<Usuario> dcbm = new DefaultComboBoxModel<>();
        List<Usuario> lista = dao.consultarTodos();
        for (Usuario usuario : lista) {
            dcbm.addElement(usuario);
        }
        return dcbm;
    }
    
//    public DefaultComboBoxModel<Usuario> listBairroByCidade(Integer cidadeId) {
//        DefaultComboBoxModel<Usuario> dcbm = new DefaultComboBoxModel<>();
//        List<Usuario> lista = dao.buscarCidadeByEstado(cidadeId);
//        for (Usuario bairro : lista) {
//            dcbm.addElement(bairro);
//        }
//        return dcbm;
//    }
    
    
    public Usuario buscarUsuario(String field, String value) {
        Usuario usuario = dao.buscarUsuario(field, value);
        return usuario;
    }

    public Usuario gravar(Usuario usuario) {
        
        Integer usuarios = dao.checaUsuarioExiste(usuario);
        if (usuarios > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este nome de usuario já existe.");
        }else{
            usuario.setInserted(Datas.dataAtualDateTime());
            usuario = dao.gravar(usuario);
        }
        return usuario;
    }

    public Usuario setDeleted(Usuario usuario) throws NonexistentEntityException, Exception {
        usuario.setUpdated(Datas.dataAtualDateTime());
        usuario.setDeleted('t');

        usuario = dao.atualizar(usuario);

        return usuario;
    }
}
