/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ImovelN;
import java.util.ArrayList;

/**
 *
 * @author Bruno
 */
public interface ControladorRelatorioImoveis {
    
    public ArrayList<ImovelN> relatorioImoveis(String sql);
    
}
