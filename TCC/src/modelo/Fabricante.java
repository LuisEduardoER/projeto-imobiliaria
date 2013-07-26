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
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "fabricante")

public class Fabricante implements Serializable {
    @Column(name = "inserted")
    private String inserted;
    @Column(name = "updated")
    private String updated;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fabricante", fetch = FetchType.LAZY)
    private List<Estoque> estoqueList;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "fabricanteId")
    private int fabricanteId;
    @Column(name = "fabricanteNome")
    private String fabricanteNome;
    @Id
    @Basic(optional = false)
    @Column(name = "fabricanteCNPJ")
    private String fabricanteCNPJ;
    @OneToMany(mappedBy = "fabricante")
    private List<Produto> produtosFabricantes;

    public Fabricante() {
        this.fabricanteId = 0;
        this.deleted = 'f';
    }

    public Fabricante(String fabricanteCNPJ) {
        this.fabricanteCNPJ = fabricanteCNPJ;
    }

    public Fabricante(String fabricanteCNPJ, int fabricanteId) {
        this.fabricanteCNPJ = fabricanteCNPJ;
        this.fabricanteId = fabricanteId;
    }

    public int getFabricanteId() {
        return fabricanteId;
    }

    public void setFabricanteId(int fabricanteId) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fabricanteCNPJ != null ? fabricanteCNPJ.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fabricante)) {
            return false;
        }
        Fabricante other = (Fabricante) object;
        if ((this.fabricanteCNPJ == null && other.fabricanteCNPJ != null) || (this.fabricanteCNPJ != null && !this.fabricanteCNPJ.equals(other.fabricanteCNPJ))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fabricanteCNPJ;
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

    public String getUpdateed() {
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
