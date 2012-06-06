/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class Endereco {

    int idEndereco;
    int idBairro;
    String logradouro;
    int CEP_ZIP;
    int cdTipoEnderecos;
    String complemento;

    public Endereco() {
    }

    public int getCEP_ZIP() {
        return CEP_ZIP;
    }

    public void setCEP_ZIP(int CEP_ZIP) {
        this.CEP_ZIP = CEP_ZIP;
    }

    public int getCdTipoEnderecos() {
        return cdTipoEnderecos;
    }

    public void setCdTipoEnderecos(int cdTipoEnderecos) {
        this.cdTipoEnderecos = cdTipoEnderecos;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String toString() {
        return logradouro;
    }
}
