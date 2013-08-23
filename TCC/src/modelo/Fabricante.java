/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "fabricante")
@NamedQueries({
    @NamedQuery(name = "Fabricante.findAll", query = "SELECT f FROM Fabricante f")})
public class Fabricante implements Serializable {

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
    @Column(name = "fabricanteId")
    private Integer fabricanteId;
    @Column(name = "fabricanteNome")
    private String fabricanteNome;
    @Basic(optional = false)
    @Column(name = "fabricanteCNPJ")
    private String fabricanteCNPJ;
    @Column(name = "deleted")
    private String deleted;
    @OneToMany(mappedBy = "fabricanteId", fetch = FetchType.LAZY)
    private List<Produto> produtoList;
    @OneToMany(mappedBy = "fabricanteId", fetch = FetchType.LAZY)
    private List<Estoque> estoqueList;

    public Fabricante() {
        this.deleted = "f";
    }

    public Fabricante(Integer fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public Fabricante(Integer fabricanteId, String fabricanteCNPJ) {
        this.fabricanteId = fabricanteId;
        this.fabricanteCNPJ = fabricanteCNPJ;
    }

    public Integer getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(Integer fabricanteId) {
        this.fabricanteId = fabricanteId;
    }

    public String getFabricanteNome() {
        return fabricanteNome;
    }

    public void setFabricanteNome(String fabricanteNome) {
        this.fabricanteNome = fabricanteNome;
    }

    public String getFabricanteCNPJ() {
        return fabricanteCNPJ;
    }

    public void setFabricanteCNPJ(String fabricanteCNPJ) {
        this.fabricanteCNPJ = fabricanteCNPJ;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
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
        hash += (fabricanteId != null ? fabricanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.fabricanteId == null && other.fabricanteId != null) || (this.fabricanteId != null && !this.fabricanteId.equals(other.fabricanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fabricanteCNPJ;
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
}
