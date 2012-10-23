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
public interface ControladorImovel {

    public boolean insereImovel(ImovelN imovel);

    public ImovelN alterarImovel(ImovelN imovel);

    public boolean removeImovel(ImovelN imovel);
    
    public DefaultComboBoxModel buscaImovelNumero(int numero);
    
    
}
