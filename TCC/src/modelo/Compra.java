/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "compra")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")})
public class Compra implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @Basic(optional = false)
    @Column(name = "dataCompra")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDate")
    private LocalDate dataCompra;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCompra")
    private Float valorCompra;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "compraId")
    private Integer compraId;
    @Column(name = "deleted")
    private Character deleted;
    @JoinColumn(name = "produtoId", referencedColumnName = "produto_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produtoId;
    @JoinColumn(name = "fornecedorId", referencedColumnName = "fornecedorId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fornecedor fornecedorId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraId", fetch = FetchType.LAZY)
    private List<Titulopagar> titulopagarList;
    
    public Compra() {
        this.deleted = 'f';
    }

    public Compra(Integer compraId) {
        this.compraId = compraId;
    }

    public Compra(Integer compraId, LocalDate dataCompra) {
        this.compraId = compraId;
        this.dataCompra = dataCompra;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        Integer oldCompraId = this.compraId;
        this.compraId = compraId;
        changeSupport.firePropertyChange("compraId", oldCompraId, compraId);
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        Character oldDeleted = this.deleted;
        this.deleted = deleted;
        changeSupport.firePropertyChange("deleted", oldDeleted, deleted);
    }

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        Produto oldProdutoId = this.produtoId;
        this.produtoId = produtoId;
        changeSupport.firePropertyChange("produtoId", oldProdutoId, produtoId);
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        Fornecedor oldFornecedorId = this.fornecedorId;
        this.fornecedorId = fornecedorId;
        changeSupport.firePropertyChange("fornecedorId", oldFornecedorId, fornecedorId);
    }

    public List<Titulopagar> getTitulopagarList() {
        return titulopagarList;
    }

    public void setTitulopagarList(List<Titulopagar> titulopagarList) {
        this.titulopagarList = titulopagarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraId != null ? compraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraId == null && other.compraId != null) || (this.compraId != null && !this.compraId.equals(other.compraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Compra[ compraId=" + compraId + " ]";
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        LocalDate oldDataCompra = this.dataCompra;
        this.dataCompra = dataCompra;
        changeSupport.firePropertyChange("dataCompra", oldDataCompra, dataCompra);
    }

    public LocalDateTime getInserted() {
        return inserted;
    }

    public void setInserted(LocalDateTime inserted) {
        LocalDateTime oldInserted = this.inserted;
        this.inserted = inserted;
        changeSupport.firePropertyChange("inserted", oldInserted, inserted);
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        LocalDateTime oldUpdated = this.updated;
        this.updated = updated;
        changeSupport.firePropertyChange("updated", oldUpdated, updated);
    }

    public Float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Float valorCompra) {
        Float oldValorCompra = this.valorCompra;
        this.valorCompra = valorCompra;
        changeSupport.firePropertyChange("valorCompra", oldValorCompra, valorCompra);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
