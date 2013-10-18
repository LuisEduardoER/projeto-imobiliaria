/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.BairroDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Endereco.Bairro;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class BairroController {

    BairroDAO dao = new BairroDAO();

    public DefaultComboBoxModel<Bairro> buscar(String field, String value) {
        Bairro bairro = new Bairro();
        DefaultComboBoxModel<Bairro> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarBairro(field, value);
        if (!esatdoObject.isEmpty()) {
            bairro.setBairroId((Integer) esatdoObject.get(0)[0]);
            bairro.setBairroNome((String) esatdoObject.get(0)[1]);
        }
        dcbm.addElement(bairro);
        return dcbm;
    }

    public DefaultComboBoxModel<Bairro> listByField(String field, String value) {
        DefaultComboBoxModel<Bairro> dcbm = new DefaultComboBoxModel<>();
        List<Bairro> lista = dao.consultarTodos();
        for (Bairro bairro : lista) {
            dcbm.addElement(bairro);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<Bairro> listBairroByCidade(Integer cidadeId) {
        DefaultComboBoxModel<Bairro> dcbm = new DefaultComboBoxModel<>();
        List<Bairro> lista = dao.buscarCidadeByEstado(cidadeId);
        for (Bairro bairro : lista) {
            dcbm.addElement(bairro);
        }
        return dcbm;
    }
    
    
    public Bairro buscarPais(String field, String value) {
        Bairro bairro = dao.buscarBairro(field, value);
        return bairro;
    }

    public Bairro gravar(Bairro bairro) {
        
        Integer bairros = dao.checaBairroExiste(bairro);
        if (bairros > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este Bairro já existe nesta cidade.");
        }else{
            bairro.setInserted(Datas.dataAtualDateTime());
            bairro = dao.gravar(bairro);
        }
        return bairro;
    }

    public Bairro setDeleted(Bairro bairro) throws NonexistentEntityException, Exception {
        bairro.setUpdated(Datas.dataAtualDateTime());
        bairro.setDeleted('t');

        bairro = dao.atualizar(bairro);

        return bairro;
    }
}
