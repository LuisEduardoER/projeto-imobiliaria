/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro;

import DAO.Cadastro.FuncionarioDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Funcionario;
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

    public DefaultComboBoxModel<Funcionario> listByField(String field, String value) {
        DefaultComboBoxModel<Funcionario> dcbm = new DefaultComboBoxModel<>();
        List<Funcionario> lista = dao.consultarTodos();
        for (Funcionario funcionario : lista) {
            dcbm.addElement(funcionario);
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
    
    
    public Funcionario buscarPais(String field, String value) {
        Funcionario funcionario = dao.buscarFuncionario(field, value);
        return funcionario;
    }

    public Funcionario gravar(Funcionario funcionario) {
        
        Integer funcionarios = dao.checaFuncionarioExiste(funcionario);
        if (funcionarios > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este CPF/CNPJ já existe.");
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
