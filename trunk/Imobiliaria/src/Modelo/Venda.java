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
    String comprador;
    int idPessoaProprietario;
    int idImovel;
    float valorVenda;
    float valorImovel;

    public Venda() {
    }

    public Venda(int imovelNumero, int idVenda, String rua, String cidade, String comprador, int idPessoaProprietario, int idImovel, float valorVenda, float valorImovel) {
        this.imovelNumero = imovelNumero;
        this.idVenda = idVenda;
        this.rua = rua;
        this.cidade = cidade;
        this.comprador = comprador;
        this.idPessoaProprietario = idPessoaProprietario;
        this.idImovel = idImovel;
        this.valorVenda = valorVenda;
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
    
    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
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

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public float getValorImovel() {
        return valorImovel;
    }

    public void setValorImovel(float valorImovel) {
        this.valorImovel = valorImovel;
    }

    @Override
    public String toString() {
        return imovelNumero + "";
    }
    
    
    
}