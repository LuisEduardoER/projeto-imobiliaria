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
@Table(name = "estoque")
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e")})
public class Estoque implements Serializable {

    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    
    @JoinColumn(name = "fabricanteId", referencedColumnName = "fabricanteId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fabricante fabricanteId;
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estoqueId")
    private Integer estoqueId;
    
    @Column(name = "quantidade")
    private Float quantidade;
    
    @Column(name = "quantidadeMIN")
    private Float quantidadeMIN;
    
    @Column(name = "deleted")
    private Character deleted;
    
    @JoinColumn(name = "estq_produtoId", referencedColumnName = "produto_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto estqprodutoId;

    public Estoque() {
        this.deleted = 'f';
    }

    public Estoque(Integer estoqueId) {
        this.estoqueId = estoqueId;
    }

    public Estoque(Integer estoqueId, Fabricante fabricanteId) {
        this.estoqueId = estoqueId;
        this.fabricanteId = fabricanteId;
    }

    public Integer getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(Integer estoqueId) {
        this.estoqueId = estoqueId;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Float getQuantidadeMIN() {
        return quantidadeMIN;
    }

    public void setQuantidadeMIN(Float quantidadeMIN) {
        this.quantidadeMIN = quantidadeMIN;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Produto getEstqprodutoId() {
        return estqprodutoId;
    }

    public void setEstqprodutoId(Produto estqprodutoId) {
        this.estqprodutoId = estqprodutoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estoqueId != null ? estoqueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.estoqueId == null && other.estoqueId != null) || (this.estoqueId != null && !this.estoqueId.equals(other.estoqueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estoque[ estoqueId=" + estoqueId + " ]";
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

    public Fabricante getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Fabricante fabricanteId) {
        this.fabricanteId = fabricanteId;
    }
}
