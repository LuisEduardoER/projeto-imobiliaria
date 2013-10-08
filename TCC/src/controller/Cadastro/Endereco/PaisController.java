/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.PaisDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Pais;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Bruno
 */
public class PaisController {

    PaisDAO dao = new PaisDAO();

    public DefaultComboBoxModel<Pais> buscar(String field, String value) {
        Pais pais = new Pais();
        DefaultComboBoxModel<Pais> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> paisObject = dao.consultarPais(field, value);
        if (!paisObject.isEmpty()) {
            pais.setPaisID((int) paisObject.get(0)[0]);
            pais.setPaisNome((String) paisObject.get(0)[1]);
            pais.setPaisCod((String) paisObject.get(0)[2]);
        }
        dcbm.addElement(pais);
        return dcbm;
    }

    public DefaultComboBoxModel<Pais> listByField(String field, String value) {
        DefaultComboBoxModel<Pais> dcbm = new DefaultComboBoxModel<>();
        List<Pais> lista = dao.consultarTodos();
        for (Pais pais : lista) {
            dcbm.addElement(pais);
        }
        return dcbm;
    }
    
    public Pais buscarPais(String field, String value) {
        Pais pais = dao.buscarPais(field,value);
        return pais;
    }

    public Pais gravar(Pais pais) {
        pais = dao.gravar(pais);
        return pais;
    }

    public Pais setDeleted(Pais pais) throws NonexistentEntityException, Exception {
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dataFormatada = dateFormatada.format(date);

//            pais.setUpdated(Datas.dataAtualDateTime());
        } catch (Exception e) {
            System.out.println("\n \n \n --------  \n \n \n " + e);
        }
//        pais.setDeleted('t');

        pais = dao.atualizar(pais);
        return pais;
    }
}
