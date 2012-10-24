/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;

/**
 *
 * @author Bruno
 */
public class Sessao{  
   private static Sessao instance;  
   private Usuario usuario;  
  
   private Sessao(){  
   }  
  
   public void setUsuario(Usuario pessoa){  
      this.usuario = pessoa;  
   }  
  
   public Usuario getUsuario(){  
       return usuario;  
   }  
   public static Sessao getInstance(){  
         if(instance == null){  
               instance = new Sessao();  
         }  
        return instance;  
   }  
} 
