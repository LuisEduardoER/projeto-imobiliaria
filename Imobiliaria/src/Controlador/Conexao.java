/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Config;

import descontinuados.ConexaoTela;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {

    int posicao;
    Config conf = new Config();

    public Connection conexaoMysql() {
        try {

            Scanner sc = new Scanner(new File("config.txt"));
            String linha = null;
            for (int i = 0; i <= posicao; i++) {
                linha = sc.nextLine();
            }
            if (linha != null) {
                String[] vetor = linha.split(";");
                String ip = vetor[0];
                String porta = vetor[1];
                String banco = vetor[2];
                String usuario = vetor[3];
                String senha = vetor[4];

                conf.setIp(ip);
                conf.setPorta(porta);
                conf.setBanco(banco);
                conf.setUsuario(usuario);
                conf.setSenha(senha);
                sc.close();
            } else {
                JOptionPane.showMessageDialog(null, "Configuração de conexão não encontrada.\nVerifique as configurações de conexão com o servidor!");
            }

            String url = "jdbc:mysql://" + conf.getIp().toString() + ":" + conf.getPorta().toString() + "/" + conf.getBanco().toString();
            String login = conf.getUsuario().toString();
            String senha = conf.getSenha().toString();
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection conexao = DriverManager.getConnection(url, login, senha);
                //conexao.setAutoCommit(false);
                return conexao;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex + "\nErro ao conectar ao Servidor de banco de dados! \nVerifique as Configurações de Conexão.");
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex + "\nErro ao procurar pelo arquivo com as configurações do servidor! \nPor favor faça a confirugração do sistema!");
            ConexaoTela conexao = new ConexaoTela();
            conexao.setVisible(true);
        }
        return null;

    }

    public boolean gravar(Config conf) {

        PrintWriter pw = null;
        try {
            File file = new File("config.txt");
            file.setWritable(true, true);
            file.delete();
            pw = new PrintWriter(new FileWriter("config.txt", true));
            pw.println(conf.getIp() + ";" + conf.getPorta() + ";" + conf.getBanco() + ";" + conf.getUsuario() + ";" + conf.getSenha());
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, "Configurações salvas com sucesso!");
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível salvar as configurações.");
            return false;
        } finally {
        }
    }

    public boolean Testar(Config c) {

        try {
            String url = "jdbc:mysql://" + c.getIp() + ":" + c.getPorta() + "/" + c.getBanco();
            String login = c.getUsuario();
            String senha = c.getSenha();

            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection conexao = DriverManager.getConnection(url, login, senha);
            JOptionPane.showMessageDialog(null, "Conexão Ok!");

            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer a conexão com o servidor,\n por favor verifique suas configurações.");
            return false;
        }
    }
}
