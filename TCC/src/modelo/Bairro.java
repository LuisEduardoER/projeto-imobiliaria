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
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "bairro")
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b")})
public class Bairro implements Serializable {
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bairroId")
    private Integer bairroId;
    @Column(name = "bairroNome")
    private String bairroNome;
    @JoinColumn(name = "cidadeId", referencedColumnName = "cidade")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidadeId;
    @OneToMany(mappedBy = "bairroID", fetch = FetchType.LAZY)
    private List<Rua> ruaList;

    public Bairro() {
    }

    public Bairro(Integer bairroId) {
        this.bairroId = bairroId;
    }

    public Integer getBairroId() {
        return bairroId;
    }

    public void setBairroId(Integer bairroId) {
        this.bairroId = bairroId;
    }

    public String getBairroNome() {
        return bairroNome;
    }

    public void setBairroNome(String bairroNome) {
        this.bairroNome = bairroNome;
    }

    public Cidade getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Cidade cidadeId) {
        this.cidadeId = cidadeId;
    }

    public List<Rua> getRuaList() {
        return ruaList;
    }

    public void setRuaList(List<Rua> ruaList) {
        this.ruaList = ruaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bairroId != null ? bairroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.bairroId == null && other.bairroId != null) || (this.bairroId != null && !this.bairroId.equals(other.bairroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Bairro[ bairroId=" + bairroId + " ]";
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

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}
