/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")})
public class Produto implements Serializable {

    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produtoId")
    private Integer produtoId;
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
    @JoinColumn(name = "fornecedorId", referencedColumnName = "fornecedorId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedorId;
    @JoinColumn(name = "fabricanteId", referencedColumnName = "fabricanteId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fabricante fabricanteId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.LAZY)
    public List<Estoque> estoqueList;

    public Produto() {
    }

    public Produto(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Produto(Integer produtoId, String produtoNome) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getProdutoCodigoBarras() {
        return produtoCodigoBarras;
    }

    public void setProdutoCodigoBarras(String produtoCodigoBarras) {
        this.produtoCodigoBarras = produtoCodigoBarras;
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

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Fabricante getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Fabricante fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoId != null ? produtoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.produtoId == null && other.produtoId != null) || (this.produtoId != null && !this.produtoId.equals(other.produtoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produtoNome;
    }
}
