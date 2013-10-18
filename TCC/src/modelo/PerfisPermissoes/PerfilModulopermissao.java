/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.PerfisPermissoes;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "perfil_modulopermissao")
@NamedQueries({
    @NamedQuery(name = "PerfilModulopermissao.findAll", query = "SELECT p FROM PerfilModulopermissao p")})
public class PerfilModulopermissao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perfil_moduloPermissaoId")
    private Integer perfilmoduloPermissaoId;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @JoinColumn(name = "perfilId", referencedColumnName = "perfilID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil perfilId;
    @JoinColumn(name = "moduloPermissaoId", referencedColumnName = "moduloPermissaoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModuloPermissao moduloPermissaoId;

    public PerfilModulopermissao() {
    }

    public PerfilModulopermissao(Integer perfilmoduloPermissaoId) {
        this.perfilmoduloPermissaoId = perfilmoduloPermissaoId;
    }

    public Integer getPerfilmoduloPermissaoId() {
        return perfilmoduloPermissaoId;
    }

    public void setPerfilmoduloPermissaoId(Integer perfilmoduloPermissaoId) {
        this.perfilmoduloPermissaoId = perfilmoduloPermissaoId;
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

    public Perfil getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Perfil perfilId) {
        this.perfilId = perfilId;
    }

    public ModuloPermissao getModuloPermissaoId() {
        return moduloPermissaoId;
    }

    public void setModuloPermissaoId(ModuloPermissao moduloPermissaoId) {
        this.moduloPermissaoId = moduloPermissaoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilmoduloPermissaoId != null ? perfilmoduloPermissaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilModulopermissao)) {
            return false;
        }
        PerfilModulopermissao other = (PerfilModulopermissao) object;
        if ((this.perfilmoduloPermissaoId == null && other.perfilmoduloPermissaoId != null) || (this.perfilmoduloPermissaoId != null && !this.perfilmoduloPermissaoId.equals(other.perfilmoduloPermissaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return perfilmoduloPermissaoId.toString();
    }
    
}
