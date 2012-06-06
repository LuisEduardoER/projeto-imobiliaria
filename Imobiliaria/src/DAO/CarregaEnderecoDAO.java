/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class CarregaEnderecoDAO {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    public DefaultComboBoxModel carregaPais() {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloPais;
        Vector<Pais> vetorPais = new Vector<Pais>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM paises;");

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Pais pais = new Pais();

                        pais.setNome(rs.getString("Descricao"));
                        pais.setCodigo(rs.getInt("idPais"));
                        pais.setSigla(rs.getString("Sigla"));
                        vetorPais.add(pais);
                    }
                } else {
                    rs.first();
                    Pais pais = new Pais();

                    pais.setNome(rs.getString("Descricao"));
                    pais.setCodigo(rs.getInt("idPais"));
                    pais.setSigla(rs.getString("Sigla"));
                    vetorPais.add(pais);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloPais = new DefaultComboBoxModel(vetorPais);
        return modeloPais;

    }

    public DefaultComboBoxModel carregaEstado(Pais pais) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloEstado;
        Vector<Estado> vetorEstado = new Vector<Estado>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM estados WHERE idPais = ?;");
            stmt.setInt(1, pais.getCodigo());

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Estado estado = new Estado();

                        estado.setNome(rs.getString("Descricao"));
                        estado.setIdPais(rs.getInt("idPais"));
                        estado.setId(rs.getInt("idEstado"));
                        estado.setUf(rs.getString("UF"));
                        vetorEstado.add(estado);
                    }
                } else {
                    rs.first();
                    Estado estado = new Estado();

                    estado.setNome(rs.getString("Descricao"));
                    estado.setIdPais(rs.getInt("idPais"));
                    estado.setId(rs.getInt("idEstado"));
                    estado.setUf(rs.getString("UF"));
                    vetorEstado.add(estado);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloEstado = new DefaultComboBoxModel(vetorEstado);
        return modeloEstado;
    }

    public DefaultComboBoxModel carregaCidade(Estado estado) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloCidade;
        Vector<Cidade> vetorCidade = new Vector<Cidade>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM municipios WHERE idEstado = ?;");
            stmt.setInt(1, estado.getId());

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Cidade cidade = new Cidade();

                        cidade.setNome(rs.getString("Descricao"));
                        cidade.setCodigo(rs.getInt("idMunicipio"));
                        cidade.setUf(rs.getInt("idEstado"));
                        vetorCidade.add(cidade);
                    }
                } else {
                    rs.first();
                    Cidade cidade = new Cidade();

                    cidade.setNome(rs.getString("Descricao"));
                    cidade.setCodigo(rs.getInt("idMunicipio"));
                    cidade.setUf(rs.getInt("idEstado"));
                    vetorCidade.add(cidade);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloCidade = new DefaultComboBoxModel(vetorCidade);
        return modeloCidade;
    }

    public DefaultComboBoxModel carregaBairro(Cidade cidade) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloBairro;
        Vector<Bairro> vetorBairro = new Vector<Bairro>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM bairros WHERE idMunicipio = ?;");
            stmt.setInt(1, cidade.getCodigo());

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Bairro bairro = new Bairro();

                        bairro.setDescricao(rs.getString("Descricao"));
                        bairro.setComplemento(rs.getString("Complemento"));
                        bairro.setIdMunicipio(rs.getInt("idMunicipio"));
                        bairro.setIdBairro(rs.getInt("idBairro"));
                        vetorBairro.add(bairro);
                    }
                } else {
                    rs.first();
                    Bairro bairro = new Bairro();

                    bairro.setDescricao(rs.getString("Descricao"));
                    bairro.setComplemento(rs.getString("Complemento"));
                    bairro.setIdMunicipio(rs.getInt("idMunicipio"));
                    bairro.setIdBairro(rs.getInt("idBairro"));
                    vetorBairro.add(bairro);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloBairro = new DefaultComboBoxModel(vetorBairro);
        return modeloBairro;
    }

    public DefaultComboBoxModel carregaEndereco(Bairro bairro) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloLogradouro;
        Vector<Endereco> vetorEnderecos = new Vector<Endereco>();

        try {
            stmt = this.con.prepareStatement("SELECT * FROM enderecos WHERE idBairro = ?;");
            stmt.setInt(1, bairro.getIdBairro());

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Endereco endereco = new Endereco();

                        endereco.setLogradouro(rs.getString("Logradouro"));
                        endereco.setComplemento(rs.getString("Complemento"));
                        endereco.setIdBairro(rs.getInt("idBairro"));
                        endereco.setIdEndereco(rs.getInt("idEndereco"));
                        endereco.setCdTipoEnderecos(rs.getInt("Cd_Tipo_Enderecos"));
                        endereco.setCEP_ZIP(rs.getInt("CEP"));
                        vetorEnderecos.add(endereco);
                    }
                } else {
                        Endereco endereco = new Endereco();

                        endereco.setLogradouro(rs.getString("Logradouro"));
                        endereco.setComplemento(rs.getString("Complemento"));
                        endereco.setIdBairro(rs.getInt("idBairro"));
                        endereco.setIdEndereco(rs.getInt("idEndereco"));
                        endereco.setCdTipoEnderecos(rs.getInt("Cd_Tipo_Enderecos"));
                        endereco.setCEP_ZIP(rs.getInt("CEP"));
                        vetorEnderecos.add(endereco);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloLogradouro = new DefaultComboBoxModel(vetorEnderecos);
        return modeloLogradouro;
    }

    public DefaultComboBoxModel carregaCEP_ZIP(Bairro bairro) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel modeloCEP_ZIP;
        Vector<CEP_ZIP> vetorCEP_ZIP = new Vector<CEP_ZIP>();

        try {
            stmt = this.con.prepareStatement("SELECT cep FROM enderecos WHERE idBairro = ?;");
            stmt.setInt(1, bairro.getIdBairro());

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        CEP_ZIP cep_zip = new CEP_ZIP();

                        cep_zip.setCep_zip(rs.getInt("cep"));
                        vetorCEP_ZIP.add(cep_zip);
                    }
                } else {
                        CEP_ZIP cep_zip = new CEP_ZIP();

                        cep_zip.setCep_zip(rs.getInt("cep"));
                        vetorCEP_ZIP.add(cep_zip);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarregaEnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        modeloCEP_ZIP = new DefaultComboBoxModel(vetorCEP_ZIP);
        return modeloCEP_ZIP;
    }
    
}
