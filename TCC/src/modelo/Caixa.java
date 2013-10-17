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
@Table(name = "caixa")
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")})
public class Caixa implements Serializable {

    @JoinColumn(name = "usuarioRespId", referencedColumnName = "usuarioID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioRespId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "caixaId")
    private Integer caixaId;
    @Basic(optional = false)
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "caixaDesc")
    private String caixaDesc;
    @OneToMany(mappedBy = "caixaId", fetch = FetchType.LAZY)
    private List<AberturaCaixa> caixamovimentoList;

    public Caixa() {
        this.deleted = 'f';
    }

    public Caixa(Integer caixaId) {
        this.caixaId = caixaId;
    }

    public Integer getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Integer caixaId) {
        this.caixaId = caixaId;
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

    public String getCaixaDesc() {
        return caixaDesc;
    }

    public void setCaixaDesc(String caixaDesc) {
        this.caixaDesc = caixaDesc;
    }

    public List<AberturaCaixa> getCaixamovimentoList() {
        return caixamovimentoList;
    }

    public void setCaixamovimentoList(List<AberturaCaixa> caixamovimentoList) {
        this.caixamovimentoList = caixamovimentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caixaId != null ? caixaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.caixaId == null && other.caixaId != null) || (this.caixaId != null && !this.caixaId.equals(other.caixaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return caixaDesc;
    }

    public Usuario getUsuarioRespId() {
        return usuarioRespId;
    }

    public void setUsuarioRespId(Usuario usuarioRespId) {
        this.usuarioRespId = usuarioRespId;
    }
}
