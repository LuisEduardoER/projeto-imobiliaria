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

    int imovelNumero;
    int idVenda;
    String rua;
    String cidade;
    int idPessoaProprietario;
    int idImovel;
    float valor;

    public Venda() {
    }

    public Venda(int imovelNumero, int idVenda, String rua, String cidade, int idPessoaProprietario, int idImovel, float valor) {
        this.imovelNumero = imovelNumero;
        this.idVenda = idVenda;
        this.rua = rua;
        this.cidade = cidade;
        this.idPessoaProprietario = idPessoaProprietario;
        this.idImovel = idImovel;
        this.valor = valor;
    }

    public int getImovelNumero() {
        return imovelNumero;
    }

    public void setImovelNumero(int imovelNumero) {
        this.imovelNumero = imovelNumero;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdPessoaProprietario() {
        return idPessoaProprietario;
    }

    public void setIdPessoaProprietario(int idPessoaProprietario) {
        this.idPessoaProprietario = idPessoaProprietario;
    }

    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return imovelNumero + "";
    }
    
    
    
}