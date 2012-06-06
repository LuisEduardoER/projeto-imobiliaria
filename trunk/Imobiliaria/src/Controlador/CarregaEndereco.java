/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CarregaEnderecoDAO;
import Modelo.Estado;
import Modelo.Pais;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class CarregaEndereco {

    CarregaEnderecoDAO carregaEndereco = new CarregaEnderecoDAO();

    public DefaultComboBoxModel carregaPais() {
        DefaultComboBoxModel<Pais> modeloPais = carregaEndereco.carregaPais();
        return modeloPais;
    }

    public DefaultComboBoxModel carregaEstado() {
        DefaultComboBoxModel<Estado> modeloEstado = carregaEndereco.carregaEstado();
        return modeloEstado;
    }
}
