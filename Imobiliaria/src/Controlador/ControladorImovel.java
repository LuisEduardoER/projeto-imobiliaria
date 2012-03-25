/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ImovelDAO;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */

public class ControladorImovel extends ImovelDAO{

    public DefaultComboBoxModel carregartelaTipoImovel(){
        DefaultComboBoxModel tipoImovel = pesquisarTipoImovel();
        return tipoImovel;
    }
    
    
}
