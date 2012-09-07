/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CarregaEnderecoDAO;
import Modelo.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class CarregaEndereco {

    CarregaEnderecoDAO carregaEndereco = new CarregaEnderecoDAO();

    public DefaultComboBoxModel carregaPais() {
        DefaultComboBoxModel modeloPais = carregaEndereco.carregaPais();
        return modeloPais;
    }

    public DefaultComboBoxModel carregaEstado(Pais pais) {
        DefaultComboBoxModel modeloEstado = carregaEndereco.carregaEstado(pais);
        return modeloEstado;
    }

    public DefaultComboBoxModel carregaCidade(Estado estado) {
        DefaultComboBoxModel modeloCidade = carregaEndereco.carregaCidade(estado);
        return modeloCidade;
    }

    public DefaultComboBoxModel carregaBairro(Cidade cidade) {
        DefaultComboBoxModel modeloBairro = carregaEndereco.carregaBairro(cidade);
        return modeloBairro;
    }
    
    public DefaultComboBoxModel carregaEndereco(Bairro bairro) {
        DefaultComboBoxModel modeloEndereco = carregaEndereco.carregaEndereco(bairro);
        return modeloEndereco;
    }
    
        public DefaultComboBoxModel carregaCEP_ZIP(Bairro bairro) {
        DefaultComboBoxModel modeloCEP_ZIP = carregaEndereco.carregaCEP_ZIP(bairro);
        return modeloCEP_ZIP;
    }
}
