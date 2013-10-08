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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "perfil")
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")})
public class Perfil implements Serializable {
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
    private Modulopermissao perfilmoduloPermissao;

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

    public Modulopermissao getPerfilmoduloPermissao() {
        return perfilmoduloPermissao;
    }

    public void setPerfilmoduloPermissao(Modulopermissao perfilmoduloPermissao) {
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
        return "modelo.Perfil[ perfilID=" + perfilID + " ]";
    }
    
}
