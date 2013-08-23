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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
public class Fornecedor implements Serializable {

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
    @Column(name = "fornecedorId")
    private Integer fornecedorId;
    @Basic(optional = false)
    @Column(name = "fornecedorCNPJ")
    private String fornecedorCNPJ;
    @Column(name = "fornecedorNome")
    private String fornecedorNome;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(mappedBy = "fornecedorId", fetch = FetchType.LAZY)
    private List<Produto> produtoList;

    public Fornecedor() {
    }

    public Fornecedor(Integer fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Fornecedor(Integer fornecedorId, String fornecedorCNPJ) {
        this.fornecedorId = fornecedorId;
        this.fornecedorCNPJ = fornecedorCNPJ;
    }

    public Integer getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Integer fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getFornecedorCNPJ() {
        return fornecedorCNPJ;
    }

    public void setFornecedorCNPJ(String fornecedorCNPJ) {
        this.fornecedorCNPJ = fornecedorCNPJ;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
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

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornecedorId != null ? fornecedorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.fornecedorId == null && other.fornecedorId != null) || (this.fornecedorId != null && !this.fornecedorId.equals(other.fornecedorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fornecedorCNPJ;
    }
}
