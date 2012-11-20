/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MAYCON
 */
public class ImovelN {
    
    
    int id;
    int idPessoaProprietario;
    int numero;
    int vendido; // 0 - Não Vendido; 1 - Vendido
    float tamanho;
    String rua;
    String bairro;
    String cidade;
    
    float valor;

    public ImovelN() {
}

    public ImovelN(int id, int idPessoaProprietario, int numero, int vendido,float tamanho, String rua, String bairro, String cidade, float valor) {
        super();
        this.id = id;
        this.idPessoaProprietario = idPessoaProprietario;
        this.numero = numero;
        this.vendido = vendido;
        this.tamanho = tamanho;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.valor = valor;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTamanho(float tamanho){
        this.tamanho = tamanho;
    }
    
    public float getTamanho(){
        return tamanho;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getVendido() {
        return vendido;
    }

    public void setVendido(int vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return numero+"";
    }
    
    
    
}
