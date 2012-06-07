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
    int CPF_CNPJ;
    int RG;
    String fone;
    Date Nascimento;
    
    int CTPS_Numero;
    int CTPS_Serie;
    String CTPS_UF;
    
    int idBairro;
    int idPais;
    int idCidade;
    int idEstado;
    int idLogradouro;
    int CEP_ZIP;
    int numero;
    String complemento;

    public Pessoa() {
    }

    public int getCEP_ZIP() {
        return CEP_ZIP;
    }

    public void setCEP_ZIP(int CEP_ZIP) {
        this.CEP_ZIP = CEP_ZIP;
    }

    public int getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(int CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public int getCTPS_Numero() {
        return CTPS_Numero;
    }

    public void setCTPS_Numero(int CTPS_Numero) {
        this.CTPS_Numero = CTPS_Numero;
    }

    public int getCTPS_Serie() {
        return CTPS_Serie;
    }

    public void setCTPS_Serie(int CTPS_Serie) {
        this.CTPS_Serie = CTPS_Serie;
    }

    public String getCTPS_UF() {
        return CTPS_UF;
    }

    public void setCTPS_UF(String CTPS_UF) {
        this.CTPS_UF = CTPS_UF;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int RG) {
        this.RG = RG;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNome(String nome) {
        if (nome != null || !(nome.endsWith(""))){
            this.nome = nome;
        }else{
            m.jopAlerta("O nome informado deve conter apenas letras (A a Z) e não pode ser vazio.");
        }
    }

    public String getNome() {
        return nome;
    }
    
}
