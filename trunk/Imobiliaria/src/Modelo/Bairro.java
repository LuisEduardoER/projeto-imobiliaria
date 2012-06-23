/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class Bairro {
    int idBairro;
    int idMunicipio;
    String descricao;
    String complemento;

    public Bairro() {
    }

    public Bairro(int idBairro, int idMunicipio, String descricao, String complemento) {
        this.idBairro = idBairro;
        this.idMunicipio = idMunicipio;
        this.descricao = descricao;
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
