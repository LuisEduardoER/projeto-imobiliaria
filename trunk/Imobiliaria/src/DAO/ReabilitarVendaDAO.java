/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorReabilitarImovel;
import Modelo.ImovelN;
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

    @Override
    public boolean reabilitaImovel(ReabilitaImovelModel reabilitar) {
        try {
            PreparedStatement stmt;
            ResultSet rs;
            Statement st;
            Venda venda = new Venda();

            stmt = this.con.prepareStatement(""
                    + "UPDATE `imobiliaria`.`imoveln`"
                    + " SET `vendido` =0" //Vendido = 1, Não Vendido = 0;
                    + " WHERE `id` = ?;");

            stmt.setInt(1, venda.getIdImovel());
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
                    + " WHERE imovel.numero = ?");

            stmt.setInt(1, reabilitar.getNumero());
            rs = stmt.executeQuery();

            while (rs.next()) {
                ReabilitaImovelModel resultado = new ReabilitaImovelModel();
                resultado.setIdImovel(rs.getInt("imovelId"));
                resultado.setNumero(rs.getInt("imovelNumero"));
                resultado.setValor(rs.getFloat("imovelValor"));
                resultado.setRua(rs.getString("imovelRua"));
                resultado.setBairro(rs.getString("imovelBairro"));
                resultado.setCidade(rs.getString("imovelCidade"));
                resultado.setTamanho(rs.getInt("imovelTamanho"));
                resultado.setNome(rs.getString("pessoaNome"));
                resultado.setCPF(rs.getInt("pessoaCPF"));
                resultado.setIdPessoaProprietario(rs.getInt("pessoaId"));
                resultado.setIdVenda(rs.getInt("vendaId"));
                vetor.add(resultado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReabilitarVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        d = new DefaultComboBoxModel(vetor);
        return d;
    }
}
