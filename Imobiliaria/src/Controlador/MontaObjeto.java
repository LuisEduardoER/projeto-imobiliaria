/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;

/**
 *
 * @author Bruno
 */
public class MontaObjeto {

    public PessoaN pessoa (String nome, int CPF, int numero, String bairro, String cidade, String rua, int id) {
        nome = nome;
        CPF = CPF;
        numero = numero;
        bairro = bairro;
        cidade = cidade;
        rua = rua;
        id = id;
    
        PessoaN pessoa = new PessoaN();
        
        return pessoa;
    }
}
