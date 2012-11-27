/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstrutoresModelo;

import Modelo.Venda;

/**
 *
 * @author Bruno
 */
public class ConstrutorVenda {

    int imovelNumero;
    int idVenda;
    String rua;
    String cidade;
    String comprador;
    int idPessoaProprietario;
    int idImovel;
    float valorVenda;
    float valorImovel;

    public ConstrutorVenda idVenda(int idVenda) {
        this.idVenda = idVenda;
        return this;
    }

    public ConstrutorVenda idPessoaProprietario(int idPessoaProprietario) {
        this.idPessoaProprietario = idPessoaProprietario;
        return this;
    }

    public ConstrutorVenda idImovel(int idImovel) {
        this.idImovel = idImovel;
        return this;
    }

    public ConstrutorVenda valorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
        return this;
    }
    
    public ConstrutorVenda valorImovel(float valorImovel) {
        this.valorImovel = valorImovel;
        return this;
    }

    public ConstrutorVenda cidade(String cidade){
        this.cidade = cidade;
        return this;
    }
    
    public ConstrutorVenda comprador(String comprador){
        this.comprador = comprador;
        return this;
    }
    
    public ConstrutorVenda rua(String rua){
        this.rua = rua;
        return this;
    }
    
    public ConstrutorVenda imovelNumero(int imovelNumero){
        this.imovelNumero = imovelNumero;
        return this;
    }
            
    
    public Venda construir() {
        return new Venda(imovelNumero, idVenda, rua, cidade, comprador, idPessoaProprietario, idImovel, valorVenda, valorImovel);
    }
}
