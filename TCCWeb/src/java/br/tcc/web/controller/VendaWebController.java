/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.tcc.web.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import controller.VendaController;
import modelo.Venda;

/**
 *
 * @author Bruno
 */
@Resource
public class VendaWebController {

    private final Result result;
    private Validator validator;

    public VendaWebController(Result result, Validator validator) {
        this.result = result;
        this.validator = validator;
    }

    @Get("/venda.jsp")
    public void redirecionaPgVenda() {
       result.forwardTo("/WEB-INF/jsp/venda.jsp");
    }

    @Post("/vendaWeb/venda")
    public void vendaWeb() {
        VendaController controller = new VendaController();
        Venda venda = new Venda();

        controller.gravar(venda);
    }
}
