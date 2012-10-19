/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PessoaN;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public interface ControladorPessoa {

    public boolean inserePessoa(PessoaN pessoa);

    public PessoaN alterarPessoa(PessoaN pessoa);

    public boolean removePessoa(PessoaN pessoa);
    
    public DefaultComboBoxModel buscaPessoaNome(String nome);
}
