/*
 * To change this template, choose Tools | Templates 
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Mensagens;
import java.util.Date;

/**
 *
 * @author Juny
 */
public class Pessoa {
    Mensagens m = new Mensagens();
    
    int codigo;
    
    String nome;
    String CPF_CNPJ;
    String RG;
    String fone;
    Date Nascimento;
    
    String CTPS_Numero;
    String CTPS_Serie;
    Estado CTPS_UF;
    
    Pais pais;
    Cidade cidade;
    Estado estado;
    String logradouro;
    CEP_ZIP CEP_ZIP;
    int numero;
    String complemento;

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome, String CPF_CNPJ, String RG, String fone, Date Nascimento, String CTPS_Numero, String CTPS_Serie, Estado CTPS_UF, Pais pais, Cidade cidade, Estado estado, String logradouro, Modelo.CEP_ZIP CEP_ZIP, int numero, String complemento) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF_CNPJ = CPF_CNPJ;
        this.RG = RG;
        this.fone = fone;
        this.Nascimento = Nascimento;
        this.CTPS_Numero = CTPS_Numero;
        this.CTPS_Serie = CTPS_Serie;
        this.CTPS_UF = CTPS_UF;
        this.pais = pais;
        this.cidade = cidade;
        this.estado = estado;
        this.logradouro = logradouro;
        this.CEP_ZIP = CEP_ZIP;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Modelo.CEP_ZIP getCEP_ZIP() {
        return CEP_ZIP;
    }

    public void setCEP_ZIP(Modelo.CEP_ZIP CEP_ZIP) {
        this.CEP_ZIP = CEP_ZIP;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getCTPS_Numero() {
        return CTPS_Numero;
    }

    public void setCTPS_Numero(String CTPS_Numero) {
        this.CTPS_Numero = CTPS_Numero;
    }

    public String getCTPS_Serie() {
        return CTPS_Serie;
    }

    public void setCTPS_Serie(String CTPS_Serie) {
        this.CTPS_Serie = CTPS_Serie;
    }

    public Estado getCTPS_UF() {
        return CTPS_UF;
    }

    public void setCTPS_UF(Estado CTPS_UF) {
        this.CTPS_UF = CTPS_UF;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null || !(nome.endsWith(""))){
            this.nome = nome;
        }else{
            m.jopAlerta("O nome informado deve conter apenas letras (A a Z) e não pode ser vazio.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
