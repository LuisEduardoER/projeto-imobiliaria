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
@Table(name = "tipopagamento")
@NamedQueries({
    @NamedQuery(name = "Tipopagamento.findAll", query = "SELECT t FROM Tipopagamento t")})
public class Tipopagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoPagamentoId")
    private Integer tipoPagamentoId;
    @Column(name = "tipoPagamentoDesc")
    private String tipoPagamentoDesc;
    @Basic(optional = false)
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Basic(optional = false)
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @Column(name = "deleted")
    private Character deleted;
    @OneToMany(mappedBy = "tipoPagamentoId", fetch = FetchType.LAZY)
    private List<Venda> vendaList;

    public Tipopagamento() {
        this.deleted = 'f';
    }

    public Tipopagamento(Integer tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    public Tipopagamento(Integer tipoPagamentoId, LocalDateTime inserted, LocalDateTime updated) {
        this.tipoPagamentoId = tipoPagamentoId;
        this.inserted = inserted;
        this.updated = updated;
    }

    public Integer getTipoPagamentoId() {
        return tipoPagamentoId;
    }

    public void setTipoPagamentoId(Integer tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    public String getTipoPagamentoDesc() {
        return tipoPagamentoDesc;
    }

    public void setTipoPagamentoDesc(String tipoPagamentoDesc) {
        this.tipoPagamentoDesc = tipoPagamentoDesc;
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

    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> vendaList) {
        this.vendaList = vendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPagamentoId != null ? tipoPagamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopagamento)) {
            return false;
        }
        Tipopagamento other = (Tipopagamento) object;
        if ((this.tipoPagamentoId == null && other.tipoPagamentoId != null) || (this.tipoPagamentoId != null && !this.tipoPagamentoId.equals(other.tipoPagamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipopagamento[ tipoPagamentoId=" + tipoPagamentoId + " ]";
    }
    
}
