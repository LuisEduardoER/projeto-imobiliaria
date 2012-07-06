/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Usuario {
    String nome;
    String telefone;
    String eMail;
    String login;
    String senha;
    String curso;
    int perfil;           //tipo Usuario, ou tipo Adminsitrador
    int id;               //cada usuario (usuario ou adminsitrador) tera seu ID Unico, independente do tipo e gerado automaticamente pelo sistema
    int serie;
    int grau;
    int bimestre;
    String idTeste;
    int aluno;   // atributo para verificação se o usuario é aluno.

    public int getAluno() {
        return aluno;
    }

    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        this.bimestre = bimestre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getGrau() {
        return grau;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(String idTeste) {
        this.idTeste = idTeste;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
