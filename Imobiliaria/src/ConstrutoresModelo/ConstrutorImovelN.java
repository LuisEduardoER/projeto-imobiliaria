/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstrutoresModelo;

import Modelo.ImovelN;

/**
 *
 * @author Bruno
 */
public class ConstrutorImovelN {

    int id;
    int idPessoaProprietario;
    int numero;
    int vendido; // 0 - Não Vendido; 1 - Vendido
    float tamanho;
    String rua;
    String bairro;
    String cidade;
    float valor;

    public ConstrutorImovelN id(int id) {
        this.id = id;
        return this;
    }

    public ConstrutorImovelN idPessoaProprietario(int idPessoaProprietario) {
        this.idPessoaProprietario = idPessoaProprietario;
        return this;
    }

    public ConstrutorImovelN vendido(int vendido) {
        this.vendido = vendido;
        return this;
    }

    public ConstrutorImovelN tamanho(float tamanho) {
        this.tamanho = tamanho;
        return this;
    }

    public ConstrutorImovelN rua(String rua) {
        this.rua = rua;
        return this;
    }

    public ConstrutorImovelN bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public ConstrutorImovelN cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public ConstrutorImovelN valor(float valor) {
        this.valor = valor;
        return this;
    }

    public ConstrutorImovelN numero(int numero) {
        this.numero = numero;
        return this;
    }
    
    public ImovelN construir() {
        return new ImovelN(id, idPessoaProprietario, numero, vendido, tamanho, rua, bairro, cidade, valor);
    }
}
