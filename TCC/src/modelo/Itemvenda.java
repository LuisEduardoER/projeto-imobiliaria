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
@Table(name = "itemvenda")
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i")})
public class Itemvenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemVendaId")
    private Integer itemVendaId;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorItemVenda")
    private Float valorItemVenda;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @JoinColumn(name = "vendaId", referencedColumnName = "vendaId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venda vendaId;
    @JoinColumn(name = "produtoId", referencedColumnName = "produto_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produtoId;

    public Itemvenda() {
        this.deleted = 'f';
    }

    public Itemvenda(Integer itemVendaId) {
        this.itemVendaId = itemVendaId;
    }

    public Integer getItemVendaId() {
        return itemVendaId;
    }

    public void setItemVendaId(Integer itemVendaId) {
        this.itemVendaId = itemVendaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorItemVenda() {
        return valorItemVenda;
    }

    public void setValorItemVenda(Float valorItemVenda) {
        this.valorItemVenda = valorItemVenda;
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

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemVendaId != null ? itemVendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemvenda)) {
            return false;
        }
        Itemvenda other = (Itemvenda) object;
        if ((this.itemVendaId == null && other.itemVendaId != null) || (this.itemVendaId != null && !this.itemVendaId.equals(other.itemVendaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Itemvenda[ itemVendaId=" + itemVendaId + " ]";
    }
    
}
