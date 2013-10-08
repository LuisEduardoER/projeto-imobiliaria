/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bruno
 */
@Embeddable
public class UsuarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "usuarioID")
    private int usuarioID;
    @Basic(optional = false)
    @Column(name = "usuarioName")
    private String usuarioName;

    public UsuarioPK() {
    }

    public UsuarioPK(int usuarioID, String usuarioName) {
        this.usuarioID = usuarioID;
        this.usuarioName = usuarioName;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioID;
        hash += (usuarioName != null ? usuarioName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if (this.usuarioID != other.usuarioID) {
            return false;
        }
        if ((this.usuarioName == null && other.usuarioName != null) || (this.usuarioName != null && !this.usuarioName.equals(other.usuarioName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.UsuarioPK[ usuarioID=" + usuarioID + ", usuarioName=" + usuarioName + " ]";
    }
    
}
