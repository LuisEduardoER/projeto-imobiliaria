/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Cadastro.Administrativo;

import DAO.Cadastro.Administrativo.GrupoProdutoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.Cadastro.Adminsitrativo.Grupoproduto;
import org.joda.time.LocalDateTime;
import persistencia.exceptions.NonexistentEntityException;
import util.Datas;

/**
 *
 * @author Bruno
 */
public class GrupoProdutoController {

    GrupoProdutoDAO dao = new GrupoProdutoDAO();

    public DefaultComboBoxModel<Grupoproduto> buscar(String field, String value) {
        Grupoproduto grupoproduto = new Grupoproduto();
        DefaultComboBoxModel<Grupoproduto> dcbm = new DefaultComboBoxModel<>();
        
        List<Object[]> grupoList = dao.consultarGrupoproduto(field, value);
        if(!grupoList.isEmpty() && grupoList.size() > 0){
            grupoproduto.setGrupoProdutoId((int) grupoList.get(0)[0]);
            grupoproduto.setGrupoDescricao((String) grupoList.get(0)[1]);
            grupoproduto.setGrupoIsSugereValor((Character) grupoList.get(0)[2]);
            grupoproduto.setGrupoValor((Long) grupoList.get(0)[3]);
            grupoproduto.setInserted((LocalDateTime) grupoList.get(0)[4]);
            grupoproduto.setUpdated((LocalDateTime) grupoList.get(0)[5]);
            grupoproduto.setDeleted((Character) grupoList.get(0)[6]);
            dcbm.addElement(grupoproduto);
        }
        
        return dcbm;
    }

    public DefaultComboBoxModel<Grupoproduto> listByField(String field, String value) {
        DefaultComboBoxModel<Grupoproduto> dcbm = new DefaultComboBoxModel<>();
        List<Grupoproduto> lista = dao.consultarTodos();
        for (Grupoproduto grupoproduto : lista) {
            dcbm.addElement(grupoproduto);
        }
        return dcbm;
    }

    public Grupoproduto buscaByField(String field, String value) {
      Grupoproduto  grupoproduto = new Grupoproduto();
       // Fabricante fabricante = dao.consultarFabricante(field, value);
      List<Object[]> grupoList = dao.consultarGrupoproduto(field, value);
        if(!grupoList.isEmpty()){
            grupoproduto.setGrupoProdutoId((int) grupoList.get(0)[0]);
            grupoproduto.setGrupoDescricao((String) grupoList.get(0)[1]);
            grupoproduto.setGrupoIsSugereValor((Character) grupoList.get(0)[2]);
            grupoproduto.setGrupoValor((Long) grupoList.get(0)[3]);
            grupoproduto.setInserted((LocalDateTime) grupoList.get(0)[4]);
            grupoproduto.setUpdated((LocalDateTime) grupoList.get(0)[5]);
            grupoproduto.setDeleted((Character) grupoList.get(0)[6]);
        }
        return grupoproduto;
    }

    public Grupoproduto gravar(Grupoproduto grupoproduto) {
        grupoproduto.setInserted(Datas.dataAtualDateTime());
        grupoproduto = dao.gravar(grupoproduto);
        return grupoproduto;
    }

    public Grupoproduto setDeleted(Grupoproduto grupoproduto) throws NonexistentEntityException, Exception {
        grupoproduto.setUpdated(Datas.dataAtualDateTime());
        grupoproduto.setDeleted('t');

        grupoproduto = dao.atualizar(grupoproduto);
        return grupoproduto;

    }
}
