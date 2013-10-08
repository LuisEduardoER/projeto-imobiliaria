/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "endereco")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "enderecoID")
    private Integer enderecoID;
    @Column(name = "rua")
    private String rua;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "CEP")
    private Integer cep;
    @Column(name = "bairro")
    private String bairro;
    @OneToMany(mappedBy = "enderecoID", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarioList;

    public Endereco() {
    }

    public Endereco(Integer enderecoID) {
        this.enderecoID = enderecoID;
    }

    public Integer getEnderecoID() {
        return enderecoID;
    }

    public void setEnderecoID(Integer enderecoID) {
        this.enderecoID = enderecoID;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enderecoID != null ? enderecoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.enderecoID == null && other.enderecoID != null) || (this.enderecoID != null && !this.enderecoID.equals(other.enderecoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Endereco[ enderecoID=" + enderecoID + " ]";
    }
    
}
