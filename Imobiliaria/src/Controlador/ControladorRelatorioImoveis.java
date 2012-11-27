/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Venda;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public interface ControladorRelatorioImoveis {
    
    public ArrayList<Venda> relatorioVendas (String sql);
    
}
