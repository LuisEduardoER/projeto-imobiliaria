/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstrutoresModelo;

import Modelo.PessoaN;

/**
 *
 * @author Bruno
 * Atualização de Desgign Pattern - Fluence Interface - 20/11/2012
 *
 * A atualização implicou na criação desta classe,
 * adicionado "super();" à classe PessoaN do pacote Modelo e
 * alteração em por exemplo: Visao.CadastroePessoaN, onde a construção dos objetos
 * foi portada para este padrão.
 */
public class ConstrutorPessoaN {
    
    String nome;
    String bairro;
    String cidade;
    String rua;
    int CPF;
    int numero;
    int id;
    
    public ConstrutorPessoaN nome(String nome){
        this.nome = nome;
        return this;
    }
    
    public ConstrutorPessoaN bairro(String bairro){
        this.bairro = bairro;
        return this;
    }
    
    public ConstrutorPessoaN cidade(String cidade){
        this.cidade = cidade;
        return this;
    }
    
    public ConstrutorPessoaN rua(String rua){
        this.rua = rua;
        return this;
    }
    
    public ConstrutorPessoaN CPF(int CPF){
        this.CPF = CPF;
        return this;
    }
    
    public ConstrutorPessoaN numero(int numero){
        this.numero = numero;
        return this;
    }
    
    public ConstrutorPessoaN id(int id){
        this.id = id;
        return this;
    }
    
    public PessoaN construir(){
        return new PessoaN(nome, CPF, numero, bairro, cidade, rua, id);
    }
}
