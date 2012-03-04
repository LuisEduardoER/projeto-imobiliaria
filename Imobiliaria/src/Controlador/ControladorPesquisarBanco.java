/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Embutido;
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
public class ControladorPesquisarBanco {

    Mensagens mensagem = new Mensagens();
    Conexao c = new Conexao();
    Connection con = c.conexaoMysql();

    public DefaultComboBoxModel pesquisarEmbutido(Embutido e) {

        PreparedStatement stmt;
        ResultSet rs;
        DefaultComboBoxModel resultado;
        Vector<Embutido> retorno = new Vector<Embutido>();

        try {
            stmt = this.con.prepareStatement("SELECT descricaoEmbutido FROM embutidos WHERE descricaoEmbutido LIKE ?;");

            stmt.setString(1, "%" + e.getDescricao() + "%");

            rs = stmt.executeQuery();


            if (rs.first()) {
                if (rs.next()) {
                    while (rs.next()) {
                        Embutido embutido = new Embutido();

                        embutido.setDescricao(rs.getString("descricaoEmbutido"));
                        retorno.add(embutido);
                    }
                } else {
                    rs.first();
                    Embutido embutido = new Embutido();

                    embutido.setDescricao(rs.getString("descricaoEmbutido"));
                    retorno.add(embutido);
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao conectar no servidor de banco de dados:\nSQLException: " + ex.getMessage());
            return null;
        }
        resultado = new DefaultComboBoxModel(retorno);
        return resultado;
    }

    public boolean verificaDescricaoExiste(String descricao, String msg) {

        PreparedStatement stmt;
        ResultSet rs;

        try {

            stmt = this.con.prepareStatement("SELECT descricaoEmbutido FROM embutidos WHERE descricaoEmbutido LIKE ? ");
            stmt.setString(1, "'" + descricao + "'");

            rs = stmt.executeQuery();

            if (rs.first()) {
                mensagem.jopAlerta(msg);
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorIncluirBanco.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados no servidor de banco de dados:\nSQLException: " + ex.getMessage());

            return false;
        }

    }
//
//    private class BuscaUF extends JFrame {
//
//        private Connection con;
//
//        private BuscaUF() {
//            super("Relatório de Estados");
//            setSize(400, 300);
//            setLocationRelativeTo(null);
//            try {
//                con = gConexao.getConexao();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Conexão não estabelecida\n Registro não encontrado", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
//            }
//            buscaEstado();
//        } //FIM BUSCA UF
//
//        private void buscaEstado() {
//            Statement st;
//            ResultSet res;
//            try {
//                Vector cabecalho = new Vector();
//                Vector linhas = new Vector();
//                st = con.createStatement();
//                res = st.executeQuery("select uf, descricao, idestado from estado WHERE uf LIKE'%" + tUF.getText() + "%'");
//                res.next();
//                ResultSetMetaData rsmd = res.getMetaData();
//                UFIDEstado = (res.getInt("idestado"));
//                String[] titulos = new String[2];
//                titulos[0] = "UF";
//                titulos[1] = "Descrição";
//                for (int i = 0; i < 2; ++i) {
//                    cabecalho.addElement(titulos[i]);
//                }
//
//                do {
//                    linhas.addElement(proximaLinhaBuscaUF(res, rsmd));
//                } while (res.next());
//                tabelaUF = new JTable(linhas, cabecalho);
//                tabelaUF.setBounds(100, 170, 500, 200);
//                tabelaUF.getTableHeader().setReorderingAllowed(false);
//                JScrollPane scroller = new JScrollPane(tabelaUF);
//                scroller.setVisible(true);
//                getContentPane().add(scroller);
//                recebeTabela = tabelaUF.getValueAt(0, 0).toString();
//                RecebeUF = tabelaUF.getValueAt(0, 1).toString();
//                tabelaMouseClicked(null);
//
//                validate();
//                repaint();
//                st.close();
//            } catch (SQLException sqlex) {
//                System.out.println("Erro na sql: " + sqlex);
//            }
//        } // FIM BUSCA ESTADO
//
//        private Vector proximaLinhaBuscaUF(ResultSet rs, ResultSetMetaData rsmd) {
//            Vector LinhaAtual = new Vector();
//            try {
//                for (int i = 1; i <= rsmd.getColumnCount() - 1; ++i) {
//                    switch (rsmd.getColumnType(i)) {
//                        case Types.VARCHAR:
//                            LinhaAtual.addElement(rs.getString(i));
//                            break;
//                        case Types.TIMESTAMP:
//                            LinhaAtual.addElement(rs.getDate(i));
//                            break;
//                        case Types.INTEGER:
//                            LinhaAtual.addElement(new Long(rs.getLong(i)));
//                            break;
//                    }
//                }
//            } catch (SQLException e) {
//            }
//            return LinhaAtual;
//        } // FIM PROXIMA LINHA BUSCA UF
//
//        private void tabelaMouseClicked(MouseEvent e) {
//            int dadoCampo;
//            if (tabelaUF.getSelectedRow() == -1) {
//                dadoCampo = 0;
//            } else {
//                dadoCampo = tabelaUF.getSelectedRow();
//            }
//            recebeTabela = tabelaUF.getValueAt(dadoCampo, 0).toString();
//            tUF.setText(recebeTabela);
//            setVisible(false);
//            dispose();
//            tabelaUF.addMouseListener(new MouseAdapter() {
//
//                public void mouseClicked(MouseEvent e) {
//                    tabelaMouseClicked(e);
//                }
//            });
//        } // FIM MOUSE CLICK
//    } //FIM BUSCA UF
}