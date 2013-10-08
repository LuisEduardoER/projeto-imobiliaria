package Componentes;

import java.awt.Dimension;
import javax.swing.JButton;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Bruno
 */
public class Componentes {

    public JButton criaBotaoGravar() {
        JButton jbGravar = new JButton();
        jbGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/save_16x16.png")));
        jbGravar.setText("Gravar");
        jbGravar.setToolTipText("Insere um novo embutido! (F3)");
        return jbGravar;
    }
   
    public JButton criaBotaoPesquisar() {
        JButton jbPesquisar = new JButton();
        jbPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search_16x16.png")));
        jbPesquisar.setText("Pesquisar");
        jbPesquisar.setToolTipText("Pesquisar um embutido! (F4)");
        jbPesquisar.setPreferredSize(new Dimension(100, 27));
        return jbPesquisar;
    }

    public JButton criaBotaoRemover() {
        JButton jbRemover = new JButton();
        jbRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/delete_16x16.png")));
        jbRemover.setText("Remover");
        jbRemover.setToolTipText("Remover um embutido! (F5)");
        jbRemover.setPreferredSize(new Dimension(100, 27));
        return jbRemover;
    }

    public JButton criaBotaoCancelar() {
        JButton jbCancelar = new JButton();
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/exit_16x16.png")));
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Cancelar um embutido! (F6)");
        jbCancelar.setPreferredSize(new Dimension(100, 27));
        return jbCancelar;
    }

    public JButton criaBotaoExcluir() {
        JButton jbExcluir = new JButton();
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/delete_16x16.png")));
        jbExcluir.setText("Excluir");
        jbExcluir.setToolTipText("Remove um cadastro que não esteja sendo utilizado! (F5)");
        return jbExcluir;
    }

    public JButton criaBotaoBuscar() {
        JButton jbBuscar = new JButton();
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search_16x16.png")));
        jbBuscar.setText("Procurar");
        jbBuscar.setToolTipText("Localiza um cadastro com base nas informações do campo buscar! (F2)");
        return jbBuscar;
    }
    
    public JButton criaBotaoEditar() {
        JButton jbEditar = new JButton();
       // jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/editar.png")));
        jbEditar.setText("editar");
        jbEditar.setToolTipText("Ediata um imovel!");
        return jbEditar;
    }
    
    public JButton criaBotaoRelatorio(){
        JButton jbRelatorios = new JButton();
        jbRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/Relatorios_16x16.png")));
        jbRelatorios.setText("Imprimir");
        jbRelatorios.setToolTipText("Gera um relatório com base nos dados informados!");
        return jbRelatorios;
    }
    
    public JButton criaBotaoNovo(){
        JButton jbNovo = new JButton();
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/plus.png")));
        jbNovo.setText("Novo");
        jbNovo.setToolTipText("Gera um relatório com base nos dados informados!");
        return jbNovo;
    }
    
    
}