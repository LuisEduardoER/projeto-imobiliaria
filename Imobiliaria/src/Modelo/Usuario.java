/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author Bruno
 */
public class Usuario {
    String nome;
    String login;
    String senha;
    int perfil;           
    int id;    
    int idPessoa;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha, int perfil, int id, int idPessoa) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.id = id;
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
