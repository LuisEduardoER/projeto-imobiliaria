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
    int idPessoaProprietario;
    int idImovel;
    float valor;

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

    public ConstrutorVenda valor(float valor) {
        this.valor = valor;
        return this;
    }

    public ConstrutorVenda cidade(String cidade){
        this.cidade = cidade;
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
        return new Venda(imovelNumero, idVenda, rua, cidade, idPessoaProprietario, idImovel, valor);
    }
}
