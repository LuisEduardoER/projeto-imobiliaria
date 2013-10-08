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

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "permissao")
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")})
public class Permissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "permissaoId")
    private Integer permissaoId;
    @Column(name = "permissaoDesc")
    private String permissaoDesc;
    @Column(name = "inserted")
    private String inserted;
    @Column(name = "updated")
    private String updated;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(mappedBy = "permissaoId", fetch = FetchType.LAZY)
    private List<Modulopermissao> modulopermissaoList;

    public Permissao() {
    }

    public Permissao(Integer permissaoId) {
        this.permissaoId = permissaoId;
    }

    public Integer getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(Integer permissaoId) {
        this.permissaoId = permissaoId;
    }

    public String getPermissaoDesc() {
        return permissaoDesc;
    }

    public void setPermissaoDesc(String permissaoDesc) {
        this.permissaoDesc = permissaoDesc;
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

    public List<Modulopermissao> getModulopermissaoList() {
        return modulopermissaoList;
    }

    public void setModulopermissaoList(List<Modulopermissao> modulopermissaoList) {
        this.modulopermissaoList = modulopermissaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissaoId != null ? permissaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.permissaoId == null && other.permissaoId != null) || (this.permissaoId != null && !this.permissaoId.equals(other.permissaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Permissao[ permissaoId=" + permissaoId + " ]";
    }
    
}
