/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.Cadastro.Adminsitrativo.Usuario;
import java.io.Serializable;
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
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "movimento")
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m")})
public class Movimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "movimentoHorario")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime movimentoHorario;
    @Column(name = "operacao")
    private Character operacao;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movimentoId")
    private Integer movimentoId;
    @JoinColumn(name = "usuarioId", referencedColumnName = "usuarioID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioId;
    @JoinColumn(name = "caixaId", referencedColumnName = "caixaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Caixa caixaId;
    @JoinColumn(name = "vendaId", referencedColumnName = "vendaId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venda vendaId;

    public Movimento() {
    }

    public Movimento(Integer movimentoId) {
        this.movimentoId = movimentoId;
    }

    public Movimento(Integer movimentoId, LocalDateTime movimentoHorario) {
        this.movimentoId = movimentoId;
        this.movimentoHorario = movimentoHorario;
    }

    public LocalDateTime getMovimentoHorario() {
        return movimentoHorario;
    }

    public void setMovimentoHorario(LocalDateTime movimentoHorario) {
        this.movimentoHorario = movimentoHorario;
    }

    public Character getOperacao() {
        return operacao;
    }

    public void setOperacao(Character operacao) {
        this.operacao = operacao;
    }

    public Integer getMovimentoId() {
        return movimentoId;
    }

    public void setMovimentoId(Integer movimentoId) {
        this.movimentoId = movimentoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Caixa getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Caixa caixaId) {
        this.caixaId = caixaId;
    }

    public Venda getVendaId() {
        return vendaId;
    }

    public void setVendaId(Venda vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimentoId != null ? movimentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.movimentoId == null && other.movimentoId != null) || (this.movimentoId != null && !this.movimentoId.equals(other.movimentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Movimento[ movimentoId=" + movimentoId + " ]";
    }
    
}
