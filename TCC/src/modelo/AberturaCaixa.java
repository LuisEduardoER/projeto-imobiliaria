/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "caixamovimento")
@NamedQueries({
    @NamedQuery(name = "Caixamovimento.findAll", query = "SELECT c FROM Caixamovimento c")})
public class AberturaCaixa implements Serializable {
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aberturaCaixaId")
    private Integer aberturaCaixaId;
    @Basic(optional = false)
    @Column(name = "aberturaCaixa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aberturaCaixa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldoCaixa")
    private Float saldoCaixa;
    @Column(name = "saldoInicio")
    private Float saldoInicio;
    @Basic(optional = false)
    @Column(name = "fechamentoCaixa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamentoCaixa;
    @Column(name = "saldoFechamento")
    private Float saldoFechamento;
    @JoinColumn(name = "caixaId", referencedColumnName = "caixaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caixa caixaId;
    @Basic(optional = false)
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    
    public AberturaCaixa() {
    }

    public AberturaCaixa(Integer aberturaCaixaId) {
        this.aberturaCaixaId = aberturaCaixaId;
    }

    public AberturaCaixa(Integer aberturaCaixaId, Date aberturaCaixa, Date fechamentoCaixa) {
        this.aberturaCaixaId = aberturaCaixaId;
        this.aberturaCaixa = aberturaCaixa;
        this.fechamentoCaixa = fechamentoCaixa;
    }

    public Integer getAberturaCaixaId() {
        return aberturaCaixaId;
    }

    public void setAberturaCaixaId(Integer aberturaCaixaId) {
        this.aberturaCaixaId = aberturaCaixaId;
    }

    public Date getAberturaCaixa() {
        return aberturaCaixa;
    }

    public void setAberturaCaixa(Date aberturaCaixa) {
        this.aberturaCaixa = aberturaCaixa;
    }

    public Float getSaldoCaixa() {
        return saldoCaixa;
    }

    public void setSaldoCaixa(Float saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }

    public Float getSaldoInicio() {
        return saldoInicio;
    }

    public void setSaldoInicio(Float saldoInicio) {
        this.saldoInicio = saldoInicio;
    }

    public Date getFechamentoCaixa() {
        return fechamentoCaixa;
    }

    public void setFechamentoCaixa(Date fechamentoCaixa) {
        this.fechamentoCaixa = fechamentoCaixa;
    }

    public Float getSaldoFechamento() {
        return saldoFechamento;
    }

    public void setSaldoFechamento(Float saldoFechamento) {
        this.saldoFechamento = saldoFechamento;
    }

    public Caixa getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Caixa caixaId) {
        this.caixaId = caixaId;
    }

    public LocalDateTime getInserted() {
        return inserted;
    }

    public void setInserted(LocalDateTime inserted) {
        this.inserted = inserted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aberturaCaixaId != null ? aberturaCaixaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AberturaCaixa)) {
            return false;
        }
        AberturaCaixa other = (AberturaCaixa) object;
        if ((this.aberturaCaixaId == null && other.aberturaCaixaId != null) || (this.aberturaCaixaId != null && !this.aberturaCaixaId.equals(other.aberturaCaixaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Caixamovimento[ aberturaCaixaId=" + aberturaCaixaId + " ]";
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }
    
}
