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
import br.com.caelum.vraptor.view.Results;
import controller.Cadastro.Administrativo.ProdutoController;
import controller.VendaController;
import modelo.Produto;
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
    
    @Post("/vendaWeb/buscaProduto")
    public void buscaProduto(Integer codigoBarras) {
        ProdutoController prodController = new ProdutoController();
        Produto produto = prodController.buscaCodigoBarra(codigoBarras.toString());

        result.use(Results.json()).from(produto).serialize();
    }
}
