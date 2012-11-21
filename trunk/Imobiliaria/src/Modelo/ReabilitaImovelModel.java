/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class ReabilitaImovelModel {
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

    public ReabilitaImovelModel() {
    }

    public ReabilitaImovelModel(int idImovel, int idPessoaProprietario, int idVenda, int numero, int CPF, int tamanho, float valor, String nome, String rua, String bairro, String Cidade) {
        this.idImovel = idImovel;
        this.idPessoaProprietario = idPessoaProprietario;
        this.idVenda = idVenda;
        this.numero = numero;
        this.CPF = CPF;
        this.tamanho = tamanho;
        this.valor = valor;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = Cidade;
    }
    
    public int getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(int idImovel) {
        this.idImovel = idImovel;
    }

    public int getIdPessoaProprietario() {
        return idPessoaProprietario;
    }

    public void setIdPessoaProprietario(int idPessoaProprietario) {
        this.idPessoaProprietario = idPessoaProprietario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    @Override
    public String toString() {
        return numero+"";
    }
}
