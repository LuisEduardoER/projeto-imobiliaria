/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ImovelN;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public interface ControladorReabilitarImovel {

    public boolean reabilitaImovel();

    public DefaultComboBoxModel listaImóveis(ImovelN imovel);
}
