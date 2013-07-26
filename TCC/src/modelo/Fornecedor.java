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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")})
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

    public Fornecedor() {
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.fornecedorCNPJ == null && other.fornecedorCNPJ != null) || (this.fornecedorCNPJ != null && !this.fornecedorCNPJ.equals(other.fornecedorCNPJ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Fornecedor[ fornecedorCNPJ=" + fornecedorCNPJ + " ]";
    }
    
}
