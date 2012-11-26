/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public interface ControladorUsuario {
     public boolean insereUsuario(Usuario usuario);

    public Usuario alterarUsuario(Usuario usuario);
    
    public Usuario buscaUsuario(Usuario usuario);

    public boolean removeUsuario(Usuario usuario);
    
    public DefaultComboBoxModel buscaUsuarioNome(String nome);
}
