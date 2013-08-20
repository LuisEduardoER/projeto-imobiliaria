/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity(name = "produto")
public class Produto implements Serializable {

    @Column(name = "produtoCodigoBarras")
    private String produtoCodigoBarras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto", fetch = FetchType.LAZY)
    private List<Estoque> estoqueList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "produtoId")
    private Integer produtoId;
    @Column(name = "produtoNome")
    private String produtoNome;
    @JoinColumn(name = "fornecedorCNPJ")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;
    @JoinColumn(name = "fabricanteCNPJ")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fabricante fabricante;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "inserted")
    private String inserted;
    @Column(name = "updated")
    private String updated;
    @Column(name = "deleted")
    private Character deleted;

    public Produto() {
        this.deleted = 'f';
        this.produtoId = 0;
    }

    public Produto(Integer produtoId) {
        this.produtoId = produtoId;
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

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
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

    public String getProdutoCodigoBarras() {
        return produtoCodigoBarras;
    }

    public void setProdutoCodigoBarras(String produtoCodigoBarras) {
        this.produtoCodigoBarras = produtoCodigoBarras;
    }

    public List<Estoque> getEstoqueList() {
        return estoqueList;
    }

    public void setEstoqueList(List<Estoque> estoqueList) {
        this.estoqueList = estoqueList;
    }

    public String getInserted() {
        return inserted;
    }

    public void setInserted(String inserted) {
        this.inserted = inserted;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }
}
