/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Cadastro.Adminsitrativo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import modelo.Compra;
import modelo.Estoque;
import modelo.Itemvenda;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "produto")

public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produto_id")
    private Integer produto_id;
    
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId", fetch = FetchType.LAZY)
    private List<Itemvenda> itemvendaList;
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId", fetch = FetchType.LAZY)
    private List<Compra> compraList;
    @JoinColumn(name = "fornecedorId", referencedColumnName = "fornecedorId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedorId;
    @JoinColumn(name = "fabricanteId", referencedColumnName = "fabricanteId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fabricante fabricanteId;
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "produtoNome")
    private String produtoNome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "produtoCodigoBarras")
    private String produtoCodigoBarras;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estqprodutoId", fetch = FetchType.LAZY)
    private List<Estoque> estoqueList;
    @ManyToOne(fetch = FetchType.LAZY)
    private Grupoproduto grupoProduto;

    public Produto() {
        this.deleted = 'f';
    }

    public Produto(Integer produtoId) {
        this.produto_id = produtoId;
    }

    public Produto(Integer produtoId, String produtoNome) {
        this.produto_id = produtoId;
        this.produtoNome = produtoNome;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProdutoId(Integer produtoId) {
        this.produto_id = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        String oldProdutoNome = this.produtoNome;
        this.produtoNome = produtoNome;
        changeSupport.firePropertyChange("produtoNome", oldProdutoNome, produtoNome);
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        Float oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public String getProdutoCodigoBarras() {
        return produtoCodigoBarras;
    }

    public void setProdutoCodigoBarras(String produtoCodigoBarras) {
        String oldProdutoCodigoBarras = this.produtoCodigoBarras;
        this.produtoCodigoBarras = produtoCodigoBarras;
        changeSupport.firePropertyChange("produtoCodigoBarras", oldProdutoCodigoBarras, produtoCodigoBarras);
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        Character oldDeleted = this.deleted;
        this.deleted = deleted;
        changeSupport.firePropertyChange("deleted", oldDeleted, deleted);
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

    public List<Itemvenda> getItemvendaList() {
        return itemvendaList;
    }

    public void setItemvendaList(List<Itemvenda> itemvendaList) {
        this.itemvendaList = itemvendaList;
    }

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    public Grupoproduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(Grupoproduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produto_id != null ? produto_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.produto_id == null && other.produto_id != null) || (this.produto_id != null && !this.produto_id.equals(other.produto_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produtoNome;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        Fornecedor oldFornecedorId = this.fornecedorId;
        this.fornecedorId = fornecedorId;
        changeSupport.firePropertyChange("fornecedorId", oldFornecedorId, fornecedorId);
    }

    public Fabricante getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Fabricante fabricanteId) {
        Fabricante oldFabricanteId = this.fabricanteId;
        this.fabricanteId = fabricanteId;
        changeSupport.firePropertyChange("fabricanteId", oldFabricanteId, fabricanteId);
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
