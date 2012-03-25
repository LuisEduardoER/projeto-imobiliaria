/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.Conexao;
import Controlador.ControladorIncluirBanco;
import Controlador.Mensagens;
import Modelo.Embutido;
import Modelo.TipoImovel;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bruno Esta classe é responsável pela administração dos objetos
 * TipoImovel (casa, apartamento chalé...) nesta classe existem os seguintes
 * métodos: boolean VerificaDescricaoTipoImovelExiste: responsável por fazer uma
 * consulta no banco de dados e verificar a existência da descrição passada por
 * parâmetro, defaultComboBoxModel PesquisarTipoImovel: responsável por trazer
 * todos os dados da tabela TipoImovel caso o parâmetro passado seja % ou trazer
 * os resultados conforme o parâmetro passado, boolean gravarTipoImovel: apenas
 * insere um novo objeto no banco.
 */
public class TipoImovelDAO {

    static Conexao c = new Conexao();
    static Connection con = c.conexaoMysql();
    public static PreparedStatement stmt;

    /*
     * boolean VerificaDescricaoTipoImovelExiste: este método já é construido
     * pronto para verificar se uma descrição de TipoImovel existe no banco de
     * dados, caso exista retorna FALSE, se não existir retorna TRUE;
     * Parâmetros: String descrição; Esta string será consultada no banco.
     */
    public static boolean verificaDescricaoTipoImovelExiste(String descricao) {

        ResultSet rs;
        Mensagens mensagem = new Mensagens();

        try {

            stmt = TipoImovelDAO.con.prepareStatement("SELECT descricaoTipoImovel FROM TipoImovel WHERE descricaoTipoImovel LIKE ? ");
            stmt.setString(1, "'" + descricao + "'");
            rs = stmt.executeQuery();

            if (rs.first()) {
                mensagem.jopAlerta("Já existe um cadastro com este nome!");
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipoImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem.jopError("Erro ao verificar exitência de cadastros no servidor de banco de dados.\nSQLException: " + ex.getMessage());

            return false;
        }

    }

    /*
     * DefaultComboBoxModel pesquisarTipoImovel: Método construído para montar
     * um ComboBox com os resultados da pesquisa na tabela tipoImovel, este
     * método é utilizado para carregar as telas de Cadastro de Imóveis passando
     * como parâmetro % para realizar uma full select; Cadastro de Tipo Imovel
     * passando % também ou uma descrição para pesquisa refinada. Parâmetros:
     * String descricao; Esta string será consultada no banco; Para uma consulta
     * que retorne todos os dados utilizer: % (percentual)
     */
    public static DefaultComboBoxModel pesquisarTipoImovel(String descricao) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel resultado;
        Vector<TipoImovel> retorno = new Vector<TipoImovel>();
        Mensagens msg = new Mensagens();

        try {
            stmt = TipoImovelDAO.con.prepareStatement("SELECT * FROM TipoImovelWHERE descricaoTipoImovel LIKE ?;");

            stmt.setString(1, "%" + descricao + "%");

            rs = stmt.executeQuery();

            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        TipoImovel tipoImovel = new TipoImovel();

                        tipoImovel.setDescricao(rs.getString("descricaoTipoImovel"));
                        retorno.add(tipoImovel);
                    }
                } else {
                    rs.first();
                    TipoImovel tipoImovel = new TipoImovel();

                    tipoImovel.setDescricao(rs.getString("descricaoTipoImovel"));
                    retorno.add(tipoImovel);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImovelDAO.class.getName()).log(Level.SEVERE, null, ex);
            msg.jopError("Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        resultado = new DefaultComboBoxModel(retorno);
        return resultado;
    }

    /*
     * boolean GravraTipoImovel: Este método insere um novo objeto no banco,
     * caso o retorno verificaDescricaoTipoImovelExiste seja TRUE, caso
     * contrário alerta sobre a existência do objeto em banco. Parâmetros:
     * TipoImovel i, objeto TipoImovel com descrição que atenda aos requisitos
     * de:VerificaDescricaoTipoImovelExiste, isto é: não exista em banco; o ID é
     * preenchido automaticamente pelo banco.
     */
    public boolean gravarTipoImovel(TipoImovel i) {

        PreparedStatement stmt;
        ResultSet rs;
        Statement st;

        try {
            st = this.con.createStatement();

            if (verificaDescricaoTipoImovelExiste(i.getDescricao())) {

                stmt = this.con.prepareStatement("INSERT INTO TipoImovel (idTipoImovel, descricaoTipoImovel) VALUES (?,?);");

                stmt.setInt(1, 0);
                stmt.setString(2, i.getDescricao());
                stmt.execute();
                return true;

            } else {
                return false;
            }

        } catch (SQLException ex) {

            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens erro = new Mensagens();
            erro.jopError("Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return false;
        }
    }

    /*
     * boolean removerTipoImovel: Método resposnável por remover um objeto
     * TipoImovel do banco de dados* *Possível apenas se este objeto não estiver
     * vinculado à nenhum outro, Após remover o metodo utiliza
     * VerificaDescricaoTipoImovelExiste, para verificar a deleção, caso retorne
     * TRUE o objeto não existe.
     */
    public boolean removerTipoImovel(TipoImovel i) {

        PreparedStatement stmt;

        try {
            stmt = this.con.prepareStatement("DELETE FROM tipoImovel WHERE descricaoTipoImovel LIKE ?;");

            stmt.setString(1, i.getDescricao());

            stmt.executeUpdate();

            if (verificaDescricaoTipoImovelExiste(i.getDescricao())) {
                Mensagens msg = new Mensagens();
                msg.jopAviso("Cadastro de Tipo de Imóvel removido com sucesso!");
                return true;
            } else {
                Mensagens msg = new Mensagens();
                msg.jopAlerta("Cadastro não removido.");
                return false;
            }


        } catch (SQLException ex) {
            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            Mensagens msg = new Mensagens();
            msg.jopError("Erro ao remover dados, possívelmente este cadastro está vinculado! F1 para mais detalhes.\nSQLException: " + ex.getMessage());

            return false;
        }
    }
}
