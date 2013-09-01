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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "titulopagar")
@NamedQueries({
    @NamedQuery(name = "Titulopagar.findAll", query = "SELECT t FROM Titulopagar t")})
public class Titulopagar implements Serializable {

    @Column(name = "dataBaixado")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime dataBaixado;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "deleted")
    private Character deleted;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tituloId")
    private Integer tituloId;
    @Basic(optional = false)
    @Column(name = "baixado")
    private char baixado;
    @JoinColumn(name = "compraId", referencedColumnName = "compraId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Compra compraId;

    public Titulopagar() {
        this.baixado = 'f';
    }

    public Titulopagar(Integer tituloId) {
        this.tituloId = tituloId;
    }

    public Titulopagar(Integer tituloId, char baixado) {
        this.tituloId = tituloId;
        this.baixado = baixado;
    }

    public Integer getTituloId() {
        return tituloId;
    }

    public void setTituloId(Integer tituloId) {
        this.tituloId = tituloId;
    }

    public char getBaixado() {
        return baixado;
    }

    public void setBaixado(char baixado) {
        this.baixado = baixado;
    }

    public Compra getCompraId() {
        return compraId;
    }

    public void setCompraId(Compra compraId) {
        this.compraId = compraId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tituloId != null ? tituloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Titulopagar)) {
            return false;
        }
        Titulopagar other = (Titulopagar) object;
        if ((this.tituloId == null && other.tituloId != null) || (this.tituloId != null && !this.tituloId.equals(other.tituloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Componentes.Titulopagar[ tituloId=" + tituloId + " ]";
    }

    public LocalDateTime getDataBaixado() {
        return dataBaixado;
    }

    public void setDataBaixado(LocalDateTime dataBaixado) {
        this.dataBaixado = dataBaixado;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getInserted() {
        return inserted;
    }

    public void setInserted(LocalDateTime inserted) {
        this.inserted = inserted;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }
}
