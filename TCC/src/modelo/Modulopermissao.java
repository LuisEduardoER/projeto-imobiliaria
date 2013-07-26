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
@Table(name = "modulopermissao")
@NamedQueries({
    @NamedQuery(name = "Modulopermissao.findAll", query = "SELECT m FROM Modulopermissao m")})
public class Modulopermissao implements Serializable {
    @OneToMany(mappedBy = "modulopermissao", fetch = FetchType.LAZY)
    private List<PerfilModulopermissao> perfilModulopermissaoList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "moduloPermissaoId")
    private Integer moduloPermissaoId;
    @OneToMany(mappedBy = "modulopermissao", fetch = FetchType.LAZY)
    private List<Perfil> perfilList;
    @JoinColumn(name = "moduloId", referencedColumnName = "moduloId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modulo modulo;
    @JoinColumn(name = "permissaoId", referencedColumnName = "permissaoId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Permissao permissao;

    public Modulopermissao() {
    }

    public Modulopermissao(Integer moduloPermissaoId) {
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

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
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
        if (!(object instanceof Modulopermissao)) {
            return false;
        }
        Modulopermissao other = (Modulopermissao) object;
        if ((this.moduloPermissaoId == null && other.moduloPermissaoId != null) || (this.moduloPermissaoId != null && !this.moduloPermissaoId.equals(other.moduloPermissaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Modulopermissao[ moduloPermissaoId=" + moduloPermissaoId + " ]";
    }

    public List<PerfilModulopermissao> getPerfilModulopermissaoList() {
        return perfilModulopermissaoList;
    }

    public void setPerfilModulopermissaoList(List<PerfilModulopermissao> perfilModulopermissaoList) {
        this.perfilModulopermissaoList = perfilModulopermissaoList;
    }
    
}