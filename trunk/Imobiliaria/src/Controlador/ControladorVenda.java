/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Venda;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public interface ControladorVenda {
    
    public boolean insereVenda(Venda venda);
    
    public Venda alterarVenda(Venda venda);

    public boolean removeVenda(Venda venda);
    
    public DefaultComboBoxModel buscaVendaImovel(int numero);
    
}
