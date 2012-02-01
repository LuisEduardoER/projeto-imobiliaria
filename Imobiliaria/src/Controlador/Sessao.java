/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pessoa;

/**
 *
 * @author Bruno
 */
public class Sessao{  
   private static Sessao instance = null;  
   private Pessoa pessoa;  
  
   private Sessao(){  
   }  
  
   public void setUsuario(Pessoa pessoa){  
      this.pessoa = pessoa;  
   }  
  
   public Pessoa getUsuario(){  
       return pessoa;  
   }  
   public static Sessao getInstance(){  
         if(instance == null){  
               instance = new Sessao();  
         }  
        return instance;  
   }  
} 
