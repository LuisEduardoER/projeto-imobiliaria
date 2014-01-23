/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Administrativo;

import DAO.Cadastro.Administrativo.FornecedorDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Cadastro.Adminsitrativo.Fornecedor;
import org.joda.time.LocalDateTime;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class FornecedorController {

    FornecedorDAO dao = new FornecedorDAO();

    public DefaultComboBoxModel<Fornecedor> buscar(String field, String value) {
        Fornecedor fornecedor = new Fornecedor();
        DefaultComboBoxModel<Fornecedor> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> fornecedorObject = dao.consultarFornecedor(field, value);
        if (!fornecedorObject.isEmpty()) {
            fornecedor.setFornecedorId((int) fornecedorObject.get(0)[0]);
            fornecedor.setFornecedorNome((String) fornecedorObject.get(0)[1]);
            fornecedor.setFornecedorCNPJ((String) fornecedorObject.get(0)[2]);
            fornecedor.setInserted((LocalDateTime) fornecedorObject.get(0)[3]);
            fornecedor.setUpdated((LocalDateTime) fornecedorObject.get(0)[4]);
            fornecedor.setDeleted((Character) fornecedorObject.get(0)[5]);
        }

        dcbm.addElement(fornecedor);
        return dcbm;
    }

    public DefaultComboBoxModel<Fornecedor> listByField(String field, String value) {
        DefaultComboBoxModel<Fornecedor> dcbm = new DefaultComboBoxModel<>();
        List<Fornecedor> lista = dao.consultarTodos();
        for (Fornecedor fornecedor : lista) {
            dcbm.addElement(fornecedor);
        }
        return dcbm;
    }
    
    public Fornecedor buscarFornecedor(String field, String value) {
        Fornecedor fornecedor = dao.buscarFornecedor(field,value);
        return fornecedor;
    }

    public Fornecedor gravar(Fornecedor fornecedor) {
        fornecedor = dao.gravar(fornecedor);
        return fornecedor;
    }

    public Fornecedor setDeleted(Fornecedor fornecedor) throws NonexistentEntityException, Exception {
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            DateFormat dateFormatada = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String dataFormatada = dateFormatada.format(date);

            fornecedor.setUpdated(Datas.dataAtualDateTime());
        } catch (Exception e) {
            System.out.println("\n \n \n --------  \n \n \n " + e);
        }
        fornecedor.setDeleted('t');

        fornecedor = dao.atualizar(fornecedor);
        return fornecedor;
    }
}
