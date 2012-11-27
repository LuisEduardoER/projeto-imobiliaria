/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ImovelN;
import Modelo.PessoaN;
import Modelo.Venda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public interface ControladorGenerico<T, K> {

    //Exemplo de melhor implementação
    public boolean inserePessoa(T t);

    public PessoaN alterarPessoa(T t);

    public boolean remove(T t);
    
    public DefaultComboBoxModel busca(K k);
    
    public ArrayList<ImovelN> relatorioImoveis(K k);
    
    public ArrayList<Venda> relatorioVendas(K k);
}
