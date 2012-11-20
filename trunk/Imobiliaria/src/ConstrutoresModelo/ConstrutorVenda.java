/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstrutoresModelo;

import Modelo.Venda;
import Visao.VendaImovelN;

/**
 *
 * @author Bruno
 */
public class ConstrutorVenda {

    int id;
    int idPessoaProprietario;
    int idImovel;
    float valor;

    public ConstrutorVenda id(int id) {
        this.id = id;
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

    public Venda construir() {
        return new Venda(id, idPessoaProprietario, idImovel, valor);
    }
}
