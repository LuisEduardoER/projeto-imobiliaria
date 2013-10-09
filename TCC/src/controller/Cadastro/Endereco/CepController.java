/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.BairroDAO;
import DAO.Cadastro.Endereco.CepDAO;
import DAO.Cadastro.Endereco.CidadeDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Bairro;
import modelo.Cep;
import modelo.Cidade;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class CepController {

    CepDAO dao = new CepDAO();

    public DefaultComboBoxModel<Cep> buscar(String field, String value) {
        Cep cep = new Cep();
        DefaultComboBoxModel<Cep> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> cepObject = dao.consultarCep(field, value);
        if (!cepObject.isEmpty()) {
            cep.setCepID((Integer) cepObject.get(0)[0]);
            cep.setCep((Integer) cepObject.get(0)[1]);
        }
        dcbm.addElement(cep);
        return dcbm;
    }

    public DefaultComboBoxModel<Cep> listByField(String field, String value) {
        DefaultComboBoxModel<Cep> dcbm = new DefaultComboBoxModel<>();
        List<Cep> lista = dao.consultarTodos();
        for (Cep bairro : lista) {
            dcbm.addElement(bairro);
        }
        return dcbm;
    }

    public Cep buscarPais(String field, String value) {
        Cep cep = dao.buscarCep(field, value);
        return cep;
    }

    public Cep gravar(Cep cep) {
        
        Integer bairros = dao.checaCepExiste(cep);
        if (bairros > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Esta Cep já existe nesta rua.");
        }else{
            cep.setInserted(Datas.dataAtualDateTime());
            cep = dao.gravar(cep);
        }
        return cep;
    }

    public Cep setDeleted(Cep cep) throws NonexistentEntityException, Exception {
        cep.setUpdated(Datas.dataAtualDateTime());
        cep.setDeleted('t');

        cep = dao.atualizar(cep);

        return cep;
    }
}
