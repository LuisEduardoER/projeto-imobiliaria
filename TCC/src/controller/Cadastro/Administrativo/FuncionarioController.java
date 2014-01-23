/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Administrativo;

import DAO.Cadastro.Administrativo.FuncionarioDAO;
import controller.Mensagens;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Cadastro.Adminsitrativo.Funcionario;
import modelo.Cadastro.Adminsitrativo.Usuario;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class FuncionarioController {

    FuncionarioDAO dao = new FuncionarioDAO();

    public DefaultComboBoxModel<Funcionario> buscar(String field, String value) {
        Funcionario funcionario = new Funcionario();
        DefaultComboBoxModel<Funcionario> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarFuncionario(field, value);
        if (!esatdoObject.isEmpty()) {
            funcionario.setIdFuncionario((Integer) esatdoObject.get(0)[0]);
            funcionario.setCpfCnpj((int) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(funcionario);
        return dcbm;
    }
    
    public Integer verificaUsuarioFuncionario(Funcionario funcionario){
        return dao.checaFuncionarioUsuario(funcionario);
    }
    
    public List<Funcionario> buscaTodos(){
        List<Object[]> listaObject = dao.buscarTodos();
        List<Funcionario> listaFuncionario = new ArrayList<>();
        
        for(int i = 0; i < listaObject.size(); i++){
            Funcionario f = new Funcionario();
            
            f.setIdFuncionario((Integer) listaObject.get(i)[0]);
            f.setNome((String) listaObject.get(i)[1]);
            f.setCpfCnpj((Integer) listaObject.get(i)[2]);
            
            Usuario u = new Usuario();
            u.setUsuarioName((String) listaObject.get(i)[3] != null ? (String) listaObject.get(i)[3] : "");
            
            f.setIdUsuario(u);
            
            listaFuncionario.add(f);
        }
        
        return listaFuncionario;
    }
    public DefaultComboBoxModel<Funcionario> listByField(String field, String value) {
        DefaultComboBoxModel<Funcionario> dcbm = new DefaultComboBoxModel<>();
        List<Funcionario> lista = dao.consultarTodos();
        for (Funcionario funcionario : lista) {
            dcbm.addElement(funcionario);
        }
        return dcbm;
    }
    /**
     * Método que efetua uma busca pelo ID do funcionario
     * @param id = id do funcionário
     * @return Funcionario funcionario
     */
    public Funcionario buscarFuncionarioById(Integer id) {
        Funcionario funcionario = dao.buscarFuncionarioById(id);
        return funcionario;
    }

    public Funcionario gravar(Funcionario funcionario) {
        
        Integer funcionarios = dao.checaFuncionarioExiste(funcionario);
        if (funcionarios > 0) {
            
            if(funcionario.getIdFuncionario() != null){
                if(funcionario.getIdUsuario() != null){
                    UsuarioController usuarioController = new UsuarioController();
                    funcionario.setIdUsuario(usuarioController.buscarUsuarioById(funcionario.getIdUsuario()));
                }
                funcionario.setUpdated(Datas.dataAtualDateTime());
                dao.atualizar(funcionario);
            }else{
                Mensagens m = new Mensagens();
                m.jopAlerta("Este CPF/CNPJ já existe.");
            }
            
        }else{
            funcionario.setInserted(Datas.dataAtualDateTime());
            funcionario = dao.gravar(funcionario);
        }
        return funcionario;
    }

    public Funcionario setDeleted(Funcionario funcionario) throws NonexistentEntityException, Exception {
        funcionario.setUpdated(Datas.dataAtualDateTime());
        funcionario.setDeleted('t');

        funcionario = dao.atualizar(funcionario);

        return funcionario;
    }
}
