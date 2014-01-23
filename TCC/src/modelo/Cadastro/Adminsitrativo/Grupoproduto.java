/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Cadastro.Adminsitrativo;

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
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "grupoproduto")
public class Grupoproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupoProdutoId")
    private Integer grupoProdutoId;
    @Column(name = "grupoDescricao")
    private String grupoDescricao;
    @Column(name = "grupoIsSugereValor")
    private Character grupoIsSugereValor;
    @Column(name = "grupoValor")
    private Long grupoValor;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    
    @JoinColumn(name = "produtoId", referencedColumnName = "produtoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produtoId;
    
    public Grupoproduto() {
        this.deleted = 'f';
    }

    public Grupoproduto(Integer grupoProdutoId) {
        this.grupoProdutoId = grupoProdutoId;
    }

    public Integer getGrupoProdutoId() {
        return grupoProdutoId;
    }

    public void setGrupoProdutoId(Integer grupoProdutoId) {
        this.grupoProdutoId = grupoProdutoId;
    }

    public String getGrupoDescricao() {
        return grupoDescricao;
    }

    public void setGrupoDescricao(String grupoDescricao) {
        this.grupoDescricao = grupoDescricao;
    }

    public Character getGrupoIsSugereValor() {
        return grupoIsSugereValor;
    }

    public void setGrupoIsSugereValor(Character grupoIsSugereValor) {
        this.grupoIsSugereValor = grupoIsSugereValor;
    }

    public Long getGrupoValor() {
        return grupoValor;
    }

    public void setGrupoValor(Long grupoValor) {
        this.grupoValor = grupoValor;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
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

    public Produto getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Produto produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoProdutoId != null ? grupoProdutoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupoproduto)) {
            return false;
        }
        Grupoproduto other = (Grupoproduto) object;
        if ((this.grupoProdutoId == null && other.grupoProdutoId != null) || (this.grupoProdutoId != null && !this.grupoProdutoId.equals(other.grupoProdutoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cadastro.Adminsitrativo.Grupoproduto[ grupoProdutoId=" + grupoProdutoId + " ]";
    }
    
}
