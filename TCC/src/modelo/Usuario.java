/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
    private int ativo;
    @Basic(optional = false)
    @Column(name = "usuarioName")
    private int usuarioName;
    @JoinColumn(name = "funcionarioId", referencedColumnName = "idFuncionario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario funcionarioId;
    @JoinColumn(name = "usuarioPerfil", referencedColumnName = "perfilID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil usuarioPerfil;

    public Usuario() {
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Funcionario getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Funcionario funcionarioId) {
        this.funcionarioId = funcionarioId;
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
        return "Usuario{" + "usuarioId=" + usuarioId + ", usuarioName=" + usuarioName + '}';
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
