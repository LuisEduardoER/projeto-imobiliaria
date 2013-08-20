/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Bruno
 */
@Entity(name = "fornecedor")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "fornecedorId")
    private int fornecedorId;
    @Id
    @Basic(optional = false)
    @Column(name = "fornecedorCNPJ")
    private String fornecedorCNPJ;
    @Column(name = "fornecedorNome")
    private String fornecedorNome;
    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtosFornecedores;
    @Column(name = "inserted")
    private String inserted;
    @Column(name = "updated")
    private String updated;
    @Column(name = "deleted")
    private Character deleted;

    public Fornecedor() {
        this.fornecedorId = 0;
        this.deleted = 'f';
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getFornecedorNome() {
        return fornecedorNome;
    }

    public void setFornecedorNome(String fornecedorNome) {
        this.fornecedorNome = fornecedorNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fornecedorCNPJ != null ? fornecedorCNPJ.hashCode() : 0);
        return hash;
    }

    public String getFornecedorCNPJ() {
        return fornecedorCNPJ;
    }

    public void setFornecedorCNPJ(String fornecedorCNPJ) {
        this.fornecedorCNPJ = fornecedorCNPJ;
    }

    public List<Produto> getProdutosFornecedores() {
        return produtosFornecedores;
    }

    public void setProdutosFornecedores(List<Produto> produtosFornecedores) {
        this.produtosFornecedores = produtosFornecedores;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.fornecedorCNPJ, other.fornecedorCNPJ)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fornecedorCNPJ;
    }
}
