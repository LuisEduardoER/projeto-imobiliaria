/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.CepDAO;
import DAO.Cadastro.Endereco.PaisDAO;
import controller.Mensagens;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Cep;
import modelo.Pais;
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
            cep.setCepID((int) cepObject.get(0)[0]);
            cep.setCep((Integer) cepObject.get(0)[1]);
        }
        dcbm.addElement(cep);
        return dcbm;
    }

    public DefaultComboBoxModel<Cep> listByField(String field, String value) {
        DefaultComboBoxModel<Cep> dcbm = new DefaultComboBoxModel<>();
        List<Cep> lista = dao.consultarTodos();
        for (Cep cep : lista) {
            dcbm.addElement(cep);
        }
        return dcbm;
    }

    public Cep buscarPais(String field, String value) {
        Cep cep = dao.buscarCep(field, value);
        return cep;
    }

    public Cep gravar(Cep cep) {
        
        Integer ceps = dao.rowCount("cep.cep", cep.getCep().toString());
        if (ceps > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este CEP Já existe.");
        }else{
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
