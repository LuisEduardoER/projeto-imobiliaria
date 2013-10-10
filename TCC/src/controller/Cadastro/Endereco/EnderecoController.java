/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.EnderecoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Endereco;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class EnderecoController {

    EnderecoDAO dao = new EnderecoDAO();

    public DefaultComboBoxModel<Endereco> buscar(String field, String value) {
        Endereco endereco = new Endereco();
        DefaultComboBoxModel<Endereco> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarEndereco(field, value);
        if (!esatdoObject.isEmpty()) {
            endereco.setEnderecoID((Integer) esatdoObject.get(0)[0]);
        }
        dcbm.addElement(endereco);
        return dcbm;
    }

    public DefaultComboBoxModel<Endereco> listByField(String field, String value) {
        DefaultComboBoxModel<Endereco> dcbm = new DefaultComboBoxModel<>();
        List<Endereco> lista = dao.consultarTodos();
        for (Endereco endereco : lista) {
            dcbm.addElement(endereco);
        }
        return dcbm;
    }

    public Endereco buscarEndereco(String field, String value) {
        Endereco endereco = dao.buscarEndereco(field, value);
        return endereco;
    }

    public Endereco gravar(Endereco endereco) {
        endereco.setInserted(Datas.dataAtualDateTime());
        endereco = dao.gravar(endereco);
        return endereco;
    }

    public Endereco setDeleted(Endereco endereco) throws NonexistentEntityException, Exception {
        endereco.setUpdated(Datas.dataAtualDateTime());
        endereco.setDeleted('t');

        endereco = dao.atualizar(endereco);

        return endereco;
    }
}
