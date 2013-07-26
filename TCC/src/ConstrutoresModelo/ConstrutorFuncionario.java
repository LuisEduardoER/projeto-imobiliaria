/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstrutoresModelo;

import modelo.Funcionario;



/**
 *
 * @author Bruno
 */
public class ConstrutorFuncionario {

    private int idFuncionario;
    private String nome;
    private String nomeUsuario;
    private String senha;
    private int idEndereco;
    private String telefone;
    private int CPF;
    private int RG;
    private String CTPS;
    private String email;
    private int perfil;
    private int ativo;
    private int idUsuario;

    public ConstrutorFuncionario(int idFuncionario, String nome, String nomeUsuario, String senha, int idEndereco, String telefone, int CPF, int RG, String CTPS, String email, int perfil, int ativo, int idUsuario) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.idEndereco = idEndereco;
        this.telefone = telefone;
        this.CPF = CPF;
        this.RG = RG;
        this.CTPS = CTPS;
        this.email = email;
        this.perfil = perfil;
        this.ativo = ativo;
        this.idUsuario = idUsuario;
    }

    public ConstrutorFuncionario() {
    }

    public ConstrutorFuncionario idFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
        return this;
    }

    public ConstrutorFuncionario idEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
        return this;
    }

    public ConstrutorFuncionario CPF(int CPF) {
        this.CPF = CPF;
        return this;
    }

    public ConstrutorFuncionario RG(int RG) {
        this.RG = RG;
        return this;
    }

    public ConstrutorFuncionario perfil(int perfil) {
        this.perfil = perfil;
        return this;
    }

    public ConstrutorFuncionario ativo(int ativo) {
        this.ativo = ativo;
        return this;
    }

    public ConstrutorFuncionario idUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ConstrutorFuncionario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ConstrutorFuncionario nomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        return this;
    }

    public ConstrutorFuncionario senha(String senha) {
        this.senha = senha;
        return this;
    }

    public ConstrutorFuncionario telefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public ConstrutorFuncionario CTPS(String CTPS) {
        this.CTPS = CTPS;
        return this;
    }

    public ConstrutorFuncionario email(String email) {
        this.email = email;
        return this;
    }

//    public Funcionario construir() {
//      // return new Funcionario(CPF, RG, idUsuario, nome, telefone, nome, email, idFuncionario, null, null, null);
//    }
}
