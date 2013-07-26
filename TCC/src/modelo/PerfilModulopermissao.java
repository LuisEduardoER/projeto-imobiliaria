/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    @JoinColumn(name = "perfilId", referencedColumnName = "perfilID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil perfil;
    @JoinColumn(name = "moduloPermissaoId", referencedColumnName = "moduloPermissaoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modulopermissao modulopermissao;

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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Modulopermissao getModulopermissao() {
        return modulopermissao;
    }

    public void setModulopermissao(Modulopermissao modulopermissao) {
        this.modulopermissao = modulopermissao;
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
        return "modelo.PerfilModulopermissao[ perfilmoduloPermissaoId=" + perfilmoduloPermissaoId + " ]";
    }
    
}
