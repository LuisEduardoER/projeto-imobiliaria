/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

    public Permissao() {
    }

    public void setPermissaoGravar() {
        setPermissaoId(1);
        setPermissaoDesc("Gravar");
    }

    public void setPermissaoAlterar() {
        setPermissaoId(2);
        setPermissaoDesc("Alterar");
    }

    public void setPermissaoExcluir() {
        setPermissaoId(3);
        setPermissaoDesc("Excluir");
    }

    public void setPermissaoVisualizar() {
        setPermissaoId(4);
        setPermissaoDesc("Visualizar");
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissaoId != null ? permissaoId.hashCode() : 0);
        return hash;
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

    @Override
    public String toString() {
        return permissaoDesc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permissao other = (Permissao) obj;
        if (!Objects.equals(this.permissaoId, other.permissaoId)) {
            return false;
        }
        return true;
    }
}
