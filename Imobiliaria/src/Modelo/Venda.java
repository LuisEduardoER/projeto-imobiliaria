/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class Venda {
    int id;
    int idPessoaProprietario;
    int idImovel;
    float valor; 

    public Venda() {
    }

    public Venda(int id, int idPessoaProprietario, int idImovel, float valor) {
        this.id = id;
        this.idPessoaProprietario = idPessoaProprietario;
        this.idImovel = idImovel;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoaProprietario() {
        return idPessoaProprietario;
    }

    public void setIdPessoaProprietario(int idPessoaProprietario) {
        this.idPessoaProprietario = idPessoaProprietario;
    }
 
}
