/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Endereco;

import modelo.Endereco.Cep;
import modelo.Endereco.Endereco;
import modelo.Endereco.Bairro;
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
import modelo.Cadastro.Adminsitrativo.Usuario;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "rua")
@NamedQueries({
    @NamedQuery(name = "Rua.findAll", query = "SELECT r FROM Rua r")})
public class Rua implements Serializable {

    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(mappedBy = "rua", fetch = FetchType.LAZY)
    private List<Endereco> enderecoList;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ruaId")
    private Integer ruaId;
    @Column(name = "ruaNome")
    private String ruaNome;
    @OneToMany(mappedBy = "ruaID", fetch = FetchType.LAZY)
    private List<Cep> cepList;
    @JoinColumn(name = "bairroID", referencedColumnName = "bairroId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bairro bairroID;

    public Rua() {
        this.deleted = 'f';
    }

    public Rua(Integer ruaId) {
        this.ruaId = ruaId;
    }

    public Integer getRuaId() {
        return ruaId;
    }

    public void setRuaId(Integer ruaId) {
        this.ruaId = ruaId;
    }

    public String getRuaNome() {
        return ruaNome;
    }

    public void setRuaNome(String ruaNome) {
        this.ruaNome = ruaNome;
    }

    public List<Cep> getCepList() {
        return cepList;
    }

    public void setCepList(List<Cep> cepList) {
        this.cepList = cepList;
    }

    public Bairro getBairroID() {
        return bairroID;
    }

    public void setBairroID(Bairro bairroID) {
        this.bairroID = bairroID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruaId != null ? ruaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rua)) {
            return false;
        }
        Rua other = (Rua) object;
        if ((this.ruaId == null && other.ruaId != null) || (this.ruaId != null && !this.ruaId.equals(other.ruaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ruaNome;
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

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }
}
