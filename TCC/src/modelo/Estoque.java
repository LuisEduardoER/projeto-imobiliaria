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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estoqueId")
    private Integer estoqueId;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    private static final long serialVersionUID = 1L;
    @Column(name = "fabricanteCNPJ")
    private String fabricanteCNPJ;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "quantidadeMIN")
    private Integer quantidadeMIN;
    @Column(name = "deleted")
    private String deleted;
    
    @JoinColumn(name = "produtoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Produto produto;
    
    @JoinColumn(name = "fabricanteId", referencedColumnName = "fabricanteId")
    @ManyToOne(fetch = FetchType.LAZY)
    public Fabricante fabricanteId;

    public Estoque() {
    }

    public String getFabricanteCNPJ() {
        return fabricanteCNPJ;
    }

    public void setFabricanteCNPJ(String fabricanteCNPJ) {
        this.fabricanteCNPJ = fabricanteCNPJ;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidadeMIN() {
        return quantidadeMIN;
    }

    public void setQuantidadeMIN(Integer quantidadeMIN) {
        this.quantidadeMIN = quantidadeMIN;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fabricante getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Fabricante fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public Estoque(Integer estoqueId) {
        this.estoqueId = estoqueId;
    }

    public Integer getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(Integer estoqueId) {
        this.estoqueId = estoqueId;
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
        return estoqueId+"";
    }
}
