/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstrutoresModelo;

import Modelo.ReabilitaImovelModel;

/**
 *
 * @author Bruno
 */
public class ConstrutorReabilitaImovel {
    int idImovel;
    int idPessoaProprietario;
    int idVenda;
    int numero;
    int CPF;
    int tamanho;
    
    float valor;
    
    String nome;
    String rua;
    String bairro;
    String cidade;
    
    public ConstrutorReabilitaImovel idImovel(int idImovel){
        this.idImovel = idImovel;
        return this;
    }
 
    public ConstrutorReabilitaImovel idPessoaProprietario(int idPessoaProprietario){
        this.idPessoaProprietario = idPessoaProprietario;
        return this;
    }
    
    public ConstrutorReabilitaImovel idVenda(int idVenda){
        this.idVenda = idVenda;
        return this;
    }
    
    public ConstrutorReabilitaImovel numero(int numero){
        this.numero = numero;
        return this;
    }
    
    public ConstrutorReabilitaImovel CPF(int CPF){
        this.CPF = CPF;
        return this;
    }
    
    public ConstrutorReabilitaImovel tamanho(int tamanho){
        this.tamanho = tamanho;
        return this;
    }
    
    public ConstrutorReabilitaImovel valor(float valor){
        this.valor = valor;
        return this;
    }
    
    public ConstrutorReabilitaImovel nome(String nome){
        this.nome = nome;
        return this;
    }
    
    public ConstrutorReabilitaImovel rua(String rua){
        this.rua = rua;
        return this;
    }
    
    public ConstrutorReabilitaImovel bairro(String bairro){
        this.bairro = bairro;
        return this;
    }
    
    public ConstrutorReabilitaImovel cidade(String cidade){
        this.cidade = cidade;
        return this;
    }
    
    public ReabilitaImovelModel construir(){
        return new ReabilitaImovelModel(idImovel, idPessoaProprietario, idVenda, numero, CPF, tamanho, valor, nome, rua, bairro, cidade);
    }
}
