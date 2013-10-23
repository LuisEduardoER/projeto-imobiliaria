/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Relatorios;

import DAO.Relatorios.RelatorioTitulosAPagarDAO;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class RelatorioTitulosAPagarController {

    RelatorioTitulosAPagarDAO dao = new RelatorioTitulosAPagarDAO();

    public List<Object[]> relatorioTitulosPagarNaoBaixados() {

        List<Object[]> titulosPagar = dao.relatorioTitulosPagarNaoBaixados();

        return titulosPagar;
    }
}
