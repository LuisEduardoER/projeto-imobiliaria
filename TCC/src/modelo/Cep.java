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
@Table(name = "cep")
@NamedQueries({
    @NamedQuery(name = "Cep.findAll", query = "SELECT c FROM Cep c")})
public class Cep implements Serializable {
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cepID")
    private Integer cepID;
    @Column(name = "cep")
    private Integer cep;
    @JoinColumn(name = "ruaID", referencedColumnName = "ruaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Rua ruaID;
    @OneToMany(mappedBy = "cepId", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarioList;

    public Cep() {
        this.deleted = 'f';
    }

    public Cep(Integer cepID) {
        this.cepID = cepID;
    }

    public Integer getCepID() {
        return cepID;
    }

    public void setCepID(Integer cepID) {
        this.cepID = cepID;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Rua getRuaID() {
        return ruaID;
    }

    public void setRuaID(Rua ruaID) {
        this.ruaID = ruaID;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepID != null ? cepID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cep)) {
            return false;
        }
        Cep other = (Cep) object;
        if ((this.cepID == null && other.cepID != null) || (this.cepID != null && !this.cepID.equals(other.cepID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cep.toString();
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
