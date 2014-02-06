/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.Cadastro.Adminsitrativo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
import modelo.AberturaCaixa;
import modelo.Caixa;
import modelo.Endereco.Bairro;
import modelo.Endereco.Cep;
import modelo.Endereco.Cidade;
import modelo.Endereco.Estado;
import modelo.Endereco.Pais;
import modelo.Endereco.Rua;
import modelo.Movimento;
import modelo.PerfisPermissoes.Perfil;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
    public class Usuario implements Serializable {
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Bairro> bairroList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Cidade> cidadeList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Cep> cepList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Estado> estadoList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Pais> paisList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Rua> ruaList;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuarioId")
    private Integer usuarioId;
    @Column(name = "usuarioSenha")
    private String usuarioSenha;
    @Basic(optional = false)
    @Column(name = "ativo")
    private char ativo;
    @Basic(optional = false)
    @Column(name = "usuarioName")
    private String usuarioName;
    @JoinColumn(name = "usuarioPerfil", referencedColumnName = "perfilID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil usuarioPerfil;
    @Column(name = "deleted")
    private Character deleted;
    @Column(name = "inserted")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime inserted;
    @Column(name = "updated")
    @Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDateTime")
    private LocalDateTime updated;
    @OneToMany(mappedBy = "usuarioRespId", fetch = FetchType.LAZY)
    private List<Caixa> caixaList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<AberturaCaixa> caixamovimentoList;
    @OneToMany(mappedBy = "usuarioId", fetch = FetchType.LAZY)
    private List<Movimento> movimentoList;
    
    public Usuario() {
        this.deleted = 'f';
        this.ativo = 't';
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public Perfil getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(Perfil usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.usuarioId);
        return hash;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Caixa> getCaixaList() {
        return caixaList;
    }

    public void setCaixaList(List<Caixa> caixaList) {
        this.caixaList = caixaList;
    }

    public List<AberturaCaixa> getCaixamovimentoList() {
        return caixamovimentoList;
    }

    public void setCaixamovimentoList(List<AberturaCaixa> caixamovimentoList) {
        this.caixamovimentoList = caixamovimentoList;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
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

    public List<Movimento> getMovimentoList() {
        return movimentoList;
    }

    public void setMovimentoList(List<Movimento> movimentoList) {
        this.movimentoList = movimentoList;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuarioId, other.usuarioId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuarioName;
    }

    public List<Bairro> getBairroList() {
        return bairroList;
    }

    public void setBairroList(List<Bairro> bairroList) {
        this.bairroList = bairroList;
    }

    public List<Cidade> getCidadeList() {
        return cidadeList;
    }

    public void setCidadeList(List<Cidade> cidadeList) {
        this.cidadeList = cidadeList;
    }

    public List<Cep> getCepList() {
        return cepList;
    }

    public void setCepList(List<Cep> cepList) {
        this.cepList = cepList;
    }

    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public List<Rua> getRuaList() {
        return ruaList;
    }

    public void setRuaList(List<Rua> ruaList) {
        this.ruaList = ruaList;
    }
}