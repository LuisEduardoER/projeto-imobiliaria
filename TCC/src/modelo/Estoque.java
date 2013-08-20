/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bruno
 */
@Entity(name = "estoque")
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    protected int estoqueId;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "quantidadeMIN")
    private Integer quantidadeMIN;
    
    @JoinColumn(name = "fabricanteCNPJ")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fabricante fabricante;
    
    @JoinColumn(name = "produtoId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    @Column(name = "inserted")
    private String inserted;
    @Column(name = "updated")
    private String updated;
    @Column(name = "deleted")
    private Character deleted;

    public Estoque() {
        this.deleted = 'f';
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getEstoqueId() {
        return estoqueId;
    }

    public void setEstoqueId(int estoqueId) {
        this.estoqueId = estoqueId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.estoqueId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estoque other = (Estoque) obj;
        if (this.estoqueId != other.estoqueId) {
            return false;
        }
        return true;
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
    public String toString() {
        return "Estoque{" + "estoqueId=" + estoqueId + '}';
    }
}
