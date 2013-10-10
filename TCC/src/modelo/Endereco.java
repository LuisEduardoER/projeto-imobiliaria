/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

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
    @Column(name = "numero")
    private Integer numero;
    @JoinColumn(name = "rua", referencedColumnName = "ruaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rua rua;
    @JoinColumn(name = "pais", referencedColumnName = "paisID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;
    @JoinColumn(name = "estado", referencedColumnName = "estadoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;
    @JoinColumn(name = "cidade", referencedColumnName = "cidade")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;
    @JoinColumn(name = "CEP", referencedColumnName = "cepID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cep cep;
    @JoinColumn(name = "bairro", referencedColumnName = "bairroId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bairro bairro;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;

    public Endereco() {
        this.deleted = 'f';
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

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public LocalDateTime getInserted() {
        return inserted;
    }

    public void setInserted(LocalDateTime inserted) {
        this.inserted = inserted;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
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
