/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.VendaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Itemvenda;
import modelo.Venda;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class VendaController {

    VendaDAO dao = new VendaDAO();
    ItemVendaController itemVendaController;
    ImpressaoCupomController impressao;
    Mensagens m;

    public DefaultComboBoxModel<Venda> buscar(String field, String value) {
        DefaultComboBoxModel<Venda> dcbm = new DefaultComboBoxModel<>();
        Venda p = dao.consultarCompra(field, value);
        dcbm.addElement(p);
        return dcbm;
    }

    public Venda gravar(Venda venda) {
        venda.setInserted(Datas.dataAtualDateTime());
        venda.setDataVenda(Datas.dataAtualDateTime());
        
        venda = dao.gravar(venda);

        return venda;
    }

    public Venda atualizarVenda(Venda venda){
        venda = dao.atualizar(venda);
        return venda;
    }
    
    public List<Venda> buscaTodos() {
        List<Venda> lista = dao.consultarTodos();
        return lista;
    }

    public Venda buscaNome(String nome) {
        Venda c = dao.consultarCompra("venda", nome);
        return c;
    }

    public DefaultComboBoxModel<Venda> listByField(String field, String value) {
        DefaultComboBoxModel<Venda> dcbm = new DefaultComboBoxModel<>();
        List<Venda> lista = dao.consultarTodos();
        for (Venda venda : lista) {
            dcbm.addElement(venda);
        }
        return dcbm;
    }

    public Venda setDeleted(Venda venda) throws NonexistentEntityException, Exception {
        venda.setUpdated(Datas.dataAtualDateTime());
        venda.setDeleted('t');
        venda = dao.atualizar(venda);
        return venda;
    }

    public List<Venda> buscarTodos() {
        List<Venda> lista = dao.consultarTodos();
        return lista;
    }

    public void imprimeCupomFiscal(Venda venda) {

        impressao = new ImpressaoCupomController();

        List<String> impressoras = new ArrayList<>();
        impressoras = impressao.retornaImressoras();

        if (impressoras.isEmpty()) {
            m = new Mensagens();
            m.jopAviso("Nenhuma impressora encotrada!");
        } else {
//            impressoras.get(0).
//            PrintService impressora = impressao.detectaImpressoras(impressoras);
        }
        //Bematech.AbrePortaSerial();
//        Bematech.AbreCupom("");
        }
    
}