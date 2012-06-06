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
        DefaultComboBoxModel<Pais> modeloPais = carregaEndereco.carregaPais();
        return modeloPais;
    }

    public DefaultComboBoxModel carregaEstado(Pais pais) {
        DefaultComboBoxModel<Estado> modeloEstado = carregaEndereco.carregaEstado(pais);
        return modeloEstado;
    }

    public DefaultComboBoxModel carregaCidade(Estado estado) {
        DefaultComboBoxModel<Cidade> modeloCidade = carregaEndereco.carregaCidade(estado);
        return modeloCidade;
    }

    public DefaultComboBoxModel carregaBairro(Cidade cidade) {
        DefaultComboBoxModel<Bairro> modeloBairro = carregaEndereco.carregaBairro(cidade);
        return modeloBairro;
    }
    
    public DefaultComboBoxModel carregaEndereco(Bairro bairro) {
        DefaultComboBoxModel<Endereco> modeloEndereco = carregaEndereco.carregaEndereco(bairro);
        return modeloEndereco;
    }
    
        public DefaultComboBoxModel carregaCEP_ZIP(Bairro bairro) {
        DefaultComboBoxModel<CEP_ZIP> modeloCEP_ZIP = carregaEndereco.carregaCEP_ZIP(bairro);
        return modeloCEP_ZIP;
    }
}
