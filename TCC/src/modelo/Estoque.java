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
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "estoque")

public class Estoque implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    protected int estoqueId;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "quantidadeMIN")
    private Integer quantidadeMIN;
    @JoinColumn(name = "fabricanteCNPJ", referencedColumnName = "fabricanteCNPJ", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fabricante fabricante;
    @JoinColumn(name = "produtoId", referencedColumnName = "produtoId", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    public Estoque() {
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
}