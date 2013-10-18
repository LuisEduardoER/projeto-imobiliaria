/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Endereco;

import DAO.Cadastro.Endereco.EstadoDAO;
import controller.Mensagens;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Endereco.Estado;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class EstadoController {

    EstadoDAO dao = new EstadoDAO();

    public DefaultComboBoxModel<Estado> buscar(String field, String value) {
        Estado estado = new Estado();
        DefaultComboBoxModel<Estado> dcbm = new DefaultComboBoxModel<>();
        List<Object[]> esatdoObject = dao.consultarEstado(field, value);
        if (!esatdoObject.isEmpty()) {
            estado.setEstadoId((int) esatdoObject.get(0)[0]);
            estado.setEstadoNome((String) esatdoObject.get(0)[1]);
            estado.setEstadoUF((String) esatdoObject.get(0)[2]);
        }
        dcbm.addElement(estado);
        return dcbm;
    }

    public DefaultComboBoxModel<Estado> listEstados() {
        DefaultComboBoxModel<Estado> dcbm = new DefaultComboBoxModel<>();
        List<Estado> lista = dao.consultarTodos();
        for (Estado estado : lista) {
            dcbm.addElement(estado);
        }
        return dcbm;
    }

    public DefaultComboBoxModel<Estado> listEstadosByPais(Integer paisId) {
        DefaultComboBoxModel<Estado> dcbm = new DefaultComboBoxModel<>();
        List<Estado> lista = dao.buscarEstadoByPais(paisId);
        for (Estado estado : lista) {
            dcbm.addElement(estado);
        }
        return dcbm;
    }

    public Estado buscarEstado(Integer estadoId) {
        Estado estado = dao.buscarEstadoById(estadoId);
        return estado;
    }

    public Estado gravar(Estado estado) {

        Integer estados = dao.rowCount("estado.estadoNome", estado.getEstadoNome());
        if (estados > 0) {
            Mensagens m = new Mensagens();
            m.jopAlerta("Este Estado já existe.");
        } else {
            estado.setInserted(Datas.dataAtualDateTime());
            estado = dao.gravar(estado);
        }
        return estado;
    }

    public Estado setDeleted(Estado esatdo) throws NonexistentEntityException, Exception {
        esatdo.setUpdated(Datas.dataAtualDateTime());
        esatdo.setDeleted('t');

        esatdo = dao.atualizar(esatdo);

        return esatdo;
    }
}
