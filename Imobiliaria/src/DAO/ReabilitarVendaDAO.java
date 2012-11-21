/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConstrutoresModelo.ConstrutorReabilitaImovel;
import Controlador.Conexao;
import Controlador.ControladorReabilitarImovel;
import Modelo.ReabilitaImovelModel;
import Modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno
 */
public class ReabilitarVendaDAO implements ControladorReabilitarImovel {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;
    ConstrutorReabilitaImovel cR;

    @Override
    public boolean reabilitaImovel(ReabilitaImovelModel reabilitar) {
        try {
            PreparedStatement stmt;
            ResultSet rs;
            Statement st;

            stmt = this.con.prepareStatement(""
                    + "UPDATE `imobiliaria`.`imoveln`"
                    + " SET `vendido` = 0" //Vendido = 1, Não Vendido = 0;
                    + " WHERE `id` = ?;");

            stmt.setInt(1, reabilitar.getIdImovel());
            stmt.execute();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ReabilitarVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public DefaultComboBoxModel listaImoveis(ReabilitaImovelModel reabilitar) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;
        DefaultComboBoxModel d;
        Vector<ReabilitaImovelModel> vetor = new Vector<ReabilitaImovelModel>();

        try {

            stmt = this.con.prepareStatement(""
                    + "SELECT imovel.numero  AS imovelNumero,"
                    + "  imovel.valor         AS imovelValor,"
                    + "  imovel.rua           AS imovelRua,"
                    + "  imovel.bairro        AS imovelBairro,"
                    + "  imovel.cidade        AS imovelCidade,"
                    + "  imovel.tamanho       AS imovelTamanho,"
                    + "  imovel.id            AS imovelId,"
                    + "  pessoa.nome          AS pessoaNome,"
                    + "  pessoa.cpf           AS pessoaCPF,"
                    + "  pessoa.id            AS pessoaId,"
                    + "  venda.id             AS vendaId"
                    + " FROM imoveln imovel"
                    + "  INNER JOIN venda ON imovel.id = venda.idImovel"
                    + "  INNER JOIN pessoan pessoa ON venda.idPessoaProprietario = pessoa.id"
                    + " WHERE imovel.numero = ?"
                    + " AND  imovel.vendido = 1;");

            stmt.setInt(1, reabilitar.getNumero());
            rs = stmt.executeQuery();

            while (rs.next()) {
                cR = new ConstrutorReabilitaImovel();
                ReabilitaImovelModel resultado = new ReabilitaImovelModel();

                resultado = cR.idImovel(rs.getInt("imovelId"))
                        .numero(rs.getInt("imovelNumero"))
                        .valor(rs.getFloat("imovelValor"))
                        .rua(rs.getString("imovelRua"))
                        .bairro(rs.getString("imovelBairro"))
                        .cidade(rs.getString("imovelCidade"))
                        .tamanho(rs.getInt("imovelTamanho"))
                        .nome(rs.getString("pessoaNome"))
                        .CPF(rs.getInt("pessoaCPF"))
                        .idPessoaProprietario(rs.getInt("pessoaId"))
                        .idVenda(rs.getInt("vendaId"))
                        .construir();
                vetor.add(resultado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReabilitarVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        d = new DefaultComboBoxModel(vetor);
        return d;
    }
}
