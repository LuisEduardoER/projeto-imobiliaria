/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ImovelDAO;
import DAO.TipoImovelDAO;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class ControladorImovel extends ImovelDAO {

    public static DefaultComboBoxModel carregartelaTipoImovel() {
        DefaultComboBoxModel tipoImovel = TipoImovelDAO.pesquisarTipoImovel("%");
        return tipoImovel;
    }
}
