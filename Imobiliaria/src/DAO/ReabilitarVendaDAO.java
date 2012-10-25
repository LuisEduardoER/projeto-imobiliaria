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
    public boolean reabilitaImovel() {
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

            // UTILIZAR PARA RELATÓRIO DE VENDAS e tela de Reabilitação de Imovéis
            //                SELECT * FROM venda
            //INNER JOIN pessoan ON venda.idPessoaProprietario = 16
            //INNER JOIN imoveln ON venda.idImovel = 1
        } catch (SQLException ex) {
            Logger.getLogger(ReabilitarVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public DefaultComboBoxModel listaImóveis(ImovelN imovel) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;
        DefaultComboBoxModel d = new DefaultComboBoxModel();
        ReabilitaImovelModel reabilitar = new ReabilitaImovelModel();
        
        try {

            stmt = this.con.prepareStatement(""
                    + "SELECT * FROM venda"
                    + "WHERE idImovel = ? ");
            stmt.setInt(1, imovel.getId());
            
             rs = stmt.executeQuery();
            
            while (rs.next()){
                reabilitar.setIdImovel(Integer.parseInt("idImovel"));
                reabilitar.setIdPessoaProprietario(Integer.parseInt("idPessoaProprietario"));
                reabilitar.setIdVenda(Integer.parseInt("id"));
            }



        } catch (SQLException ex) {
            Logger.getLogger(ReabilitarVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
