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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "perfil")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")})
public class Perfil implements Serializable {

    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(mappedBy = "perfilId", fetch = FetchType.LAZY)
    private List<PerfilModulopermissao> perfilModulopermissaoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "perfilID")
    private Integer perfilID;
    @Column(name = "perfilDesc")
    private String perfilDesc;
    @OneToMany(mappedBy = "usuarioPerfil", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @JoinColumn(name = "perfil_moduloPermissao", referencedColumnName = "moduloPermissaoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModuloPermissao perfilmoduloPermissao;

    public Perfil() {
    }

    public Perfil(Integer perfilID) {
        this.perfilID = perfilID;
    }

    public Integer getPerfilID() {
        return perfilID;
    }

    public void setPerfilID(Integer perfilID) {
        this.perfilID = perfilID;
    }

    public String getPerfilDesc() {
        return perfilDesc;
    }

    public void setPerfilDesc(String perfilDesc) {
        this.perfilDesc = perfilDesc;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public ModuloPermissao getPerfilmoduloPermissao() {
        return perfilmoduloPermissao;
    }

    public void setPerfilmoduloPermissao(ModuloPermissao perfilmoduloPermissao) {
        this.perfilmoduloPermissao = perfilmoduloPermissao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfilID != null ? perfilID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfilID == null && other.perfilID != null) || (this.perfilID != null && !this.perfilID.equals(other.perfilID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return perfilDesc;
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
