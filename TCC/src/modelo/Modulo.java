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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "modulo")

public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moduloId")
    private Integer moduloId;
    @Column(name = "moduloDesc")
    private String moduloDesc;
    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<Modulopermissao> modulopermissaoList;
    @Column(name = "inserted")
    private String inserted;
    @Column(name = "updated")
    private String updated;
    @Column(name = "deleted")
    private Character deleted;
    
    public Modulo() {
    }

    public Modulo(Integer moduloId) {
        this.moduloId = moduloId;
    }

    public Integer getModuloId() {
        return moduloId;
    }

    public void setModuloId(Integer moduloId) {
        this.moduloId = moduloId;
    }

    public String getModuloDesc() {
        return moduloDesc;
    }

    public void setModuloDesc(String moduloDesc) {
        this.moduloDesc = moduloDesc;
    }

    public List<Modulopermissao> getModulopermissaoList() {
        return modulopermissaoList;
    }

    public void setModulopermissaoList(List<Modulopermissao> modulopermissaoList) {
        this.modulopermissaoList = modulopermissaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduloId != null ? moduloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.moduloId == null && other.moduloId != null) || (this.moduloId != null && !this.moduloId.equals(other.moduloId))) {
            return false;
        }
        return true;
    }

    public void setInserted(String inserted) {
        this.inserted = inserted;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return moduloDesc;
    }
}
