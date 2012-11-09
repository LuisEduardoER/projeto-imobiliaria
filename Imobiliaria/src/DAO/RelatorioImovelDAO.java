/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorRelatorioImoveis;
import Controlador.Mensagens;
import Modelo.ImovelN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class RelatorioImovelDAO implements ControladorRelatorioImoveis {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    @Override
    public ArrayList<ImovelN> relatorioImoveis(String sql) {
        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        Statement sqlst;
        PreparedStatement numero;
        PreparedStatement rua;
        PreparedStatement bairro;
        PreparedStatement cidade;
        PreparedStatement tamanho;
        PreparedStatement valor;
        PreparedStatement vendido;

        String sNumero =  "numero";
        String sRua =     "rua";
        String sBairro =  "bairro";
        String sCidade =  "cidade";
        String sTamanho = "tamanho";
        String sValor =   "valor";
        String sVendido = "vendido";

        ArrayList<ImovelN> vetorImovel = new ArrayList<ImovelN>();

        String[] filtros = sql.split(";");

        try {

            String consulta = (""
                    + "SELECT * FROM imoveln "
                    + " WHERE numero = ");

            if ("numero".equals(filtros[0])) {
                consulta = consulta + "numero";
            } else {
                consulta = consulta + filtros[0] + " ";
            }

            consulta = consulta + " AND rua = ";

            if ("rua".equals(filtros[1])) {
                consulta = consulta + "rua";
            } else {
                consulta = consulta + filtros[1] + " ";
            }

            consulta = consulta + " AND bairro = ";

            if ("bairro".equals(filtros[2])) {
                consulta = consulta + "bairro";
            } else {
                consulta = consulta + filtros[2] + " ";
            }

            consulta = consulta + " AND cidade = ";

            if ("cidade".equals(filtros[3])) {
                consulta = consulta + "cidade";
            } else {
                consulta = consulta + filtros[3] + " ";
            }

            consulta = consulta + " AND valor = ";

            if ("valor".equals(filtros[4])) {
                consulta = consulta + "valor";
            } else {
                consulta = consulta + filtros[4] + " ";
            }

            consulta = consulta + " AND vendido = ";

            if ("vendido".equals(filtros[5])) {
                consulta = consulta + "vendido";
            } else {
                consulta = consulta + filtros[5] + " ";
            }

            consulta = consulta + " AND tamanho = ";

            if ("tamanho".equals(filtros[6])) {
                consulta = consulta + "tamanho";
            } else {
                consulta = consulta + filtros[6] + " ";
            }

            stmt = con.prepareStatement(consulta);
            rs = stmt.executeQuery();
            System.out.println(consulta);
            while (rs.next()) {
                ImovelN resultado = new ImovelN();

                resultado.setId(rs.getInt("id"));
                resultado.setNumero(rs.getInt("numero"));
                resultado.setRua(rs.getString("rua"));
                resultado.setBairro(rs.getString("bairro"));
                resultado.setCidade(rs.getString("cidade"));
                resultado.setIdPessoaProprietario(rs.getInt("idPessoaProprietario"));
                resultado.setValor(rs.getFloat("valor"));
                resultado.setVendido(rs.getInt("vendido"));
                resultado.setTamanho(rs.getFloat("tamanho"));
                vetorImovel.add(resultado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao buscar o cadastro no servidor de banco de dados.\nSQLException: " + ex.getMessage() + "\n buscaImovelNumero");
            return null;
        }
        return vetorImovel;
    }
}
