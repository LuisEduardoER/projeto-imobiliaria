/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PerfisPermissoes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "modulopermissao")
@NamedQueries({
    @NamedQuery(name = "Modulopermissao.findAll", query = "SELECT m FROM Modulopermissao m")})
public class ModuloPermissao implements Serializable {

    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(mappedBy = "moduloPermissaoId", fetch = FetchType.LAZY)
    private List<PerfilModulopermissao> perfilModulopermissaoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moduloPermissaoId")
    private Integer moduloPermissaoId;
    @OneToMany(mappedBy = "perfilmoduloPermissao", fetch = FetchType.LAZY)
    private List<Perfil> perfilList;
    @JoinColumn(name = "permissaoId", referencedColumnName = "permissaoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Permissao permissaoId;
    @JoinColumn(name = "moduloId", referencedColumnName = "moduloId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modulo moduloId;

    public ModuloPermissao() {
    }

    public ModuloPermissao(Integer moduloPermissaoId) {
        this.moduloPermissaoId = moduloPermissaoId;
    }

    public Integer getModuloPermissaoId() {
        return moduloPermissaoId;
    }

    public void setModuloPermissaoId(Integer moduloPermissaoId) {
        this.moduloPermissaoId = moduloPermissaoId;
    }

    public List<Perfil> getPerfilList() {
        return perfilList;
    }

    public void setPerfilList(List<Perfil> perfilList) {
        this.perfilList = perfilList;
    }

    public Permissao getPermissaoId() {
        return permissaoId;
    }

    public void setPermissaoId(Permissao permissaoId) {
        this.permissaoId = permissaoId;
    }

    public Modulo getModuloId() {
        return moduloId;
    }

    public void setModuloId(Modulo moduloId) {
        this.moduloId = moduloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduloPermissaoId != null ? moduloPermissaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuloPermissao)) {
            return false;
        }
        ModuloPermissao other = (ModuloPermissao) object;
        if ((this.moduloPermissaoId == null && other.moduloPermissaoId != null) || (this.moduloPermissaoId != null && !this.moduloPermissaoId.equals(other.moduloPermissaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return moduloPermissaoId.toString();
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

    public List<PerfilModulopermissao> getPerfilModulopermissaoList() {
        return perfilModulopermissaoList;
    }

    public void setPerfilModulopermissaoList(List<PerfilModulopermissao> perfilModulopermissaoList) {
        this.perfilModulopermissaoList = perfilModulopermissaoList;
    }
}
