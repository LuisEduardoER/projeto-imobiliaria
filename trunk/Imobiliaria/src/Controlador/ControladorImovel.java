/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ImovelDAO;
import DAO.TipoImovelDAO;
import Modelo.ImovelN;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public interface ControladorImovel {

//    public static DefaultComboBoxModel carregartelaTipoImovel() {
//        DefaultComboBoxModel tipoImovel = TipoImovelDAO.pesquisarTipoImovel("%");
//        return tipoImovel;
//    }
    
    public boolean insereImovel(ImovelN imovel);

    public ImovelN alterarImovel(ImovelN imovel);

    public boolean removeImovel(ImovelN imovel);
    
    public DefaultComboBoxModel buscaImovelNumero(int numero);
    
    
}
