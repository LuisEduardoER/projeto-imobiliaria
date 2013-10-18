/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.CidadeDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Endereco.Cidade;
import modelo.Endereco.Estado;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class CidadeController {

    CidadeDAO dao = new CidadeDAO();

    public DefaultComboBoxModel<Cidade> buscar(String field, String value) {
        Cidade cidade = new Cidade();
        DefaultComboBoxModel<Cidade> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarCidade(field, value);
        if (!esatdoObject.isEmpty()) {
            cidade.setCidade((Integer) esatdoObject.get(0)[0]);
            cidade.setCidadeNome((String) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(cidade);
        return dcbm;
    }

    public DefaultComboBoxModel<Cidade> listByField(String field, String value) {
        DefaultComboBoxModel<Cidade> dcbm = new DefaultComboBoxModel<>();
        List<Cidade> lista = dao.consultarTodos();
        for (Cidade cidade : lista) {
            dcbm.addElement(cidade);
        }
        return dcbm;
    }

//    public DefaultComboBoxModel<Estado> listCidades() {
//        DefaultComboBoxModel<Estado> dcbm = new DefaultComboBoxModel<>();
//        List<Estado> lista = dao.consultarTodos();
//        for (Estado estado : lista) {
//            dcbm.addElement(estado);
//        }
//        return dcbm;
//    }
    
    public DefaultComboBoxModel<Cidade> listCidadesByEstado(Integer estadoId) {
        DefaultComboBoxModel<Cidade> dcbm = new DefaultComboBoxModel<>();
        List<Cidade> lista = dao.buscarCidadeByEstado(estadoId);
        for (Cidade cidade : lista) {
            dcbm.addElement(cidade);
        }
        return dcbm;
    }
    
    public Cidade buscarPais(String field, String value) {
        Cidade cidade = dao.buscarCidade(field, value);
        return cidade;
    }

    public Cidade gravar(Cidade cidade) {
        
        Integer cidades = dao.checaCidadeExiste(cidade);
        if (cidades > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Esta Cidade já existe neste estado.");
        }else{
            cidade.setInserted(Datas.dataAtualDateTime());
            cidade = dao.gravar(cidade);
        }
        return cidade;
    }

    public Cidade setDeleted(Cidade cidade) throws NonexistentEntityException, Exception {
        cidade.setUpdated(Datas.dataAtualDateTime());
        cidade.setDeleted('t');

        cidade = dao.atualizar(cidade);

        return cidade;
    }
}
