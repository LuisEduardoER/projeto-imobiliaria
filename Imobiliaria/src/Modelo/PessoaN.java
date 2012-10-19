/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class PessoaN {

    String nome;
    String bairro;
    String cidade;
    String rua;
    int CPF;
    int numero;
    int id;

    public PessoaN() {
    }

    public PessoaN(String nome, int CPF, int numero, String bairro, String cidade, String rua, int id) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
