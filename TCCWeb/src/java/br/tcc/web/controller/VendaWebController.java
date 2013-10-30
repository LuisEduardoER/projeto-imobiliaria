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
import java.util.ArrayList;
import java.util.List;
import modelo.Itemvenda;
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

    @Post("/vendaWeb/vender")
    public void vendaWeb(List<String> produtos) {
        VendaController controller = new VendaController();
        Venda venda = new Venda();
        List<Itemvenda> itens = new ArrayList<Itemvenda>();

        for (int i = 0; i < produtos.size(); i++) {
            Itemvenda item = new Itemvenda();
            
            String itemPK = produtos.get(i).split(":")[1];
            item.setProdutoId(new Produto());
            item.getProdutoId().setProdutoId(new Integer(itemPK));
            
            itens.add(item);
        }
        controller.gravar(venda);
    }

    @Post("/vendaWeb/buscaProduto")
    public void buscaProduto(Integer codigoBarras) {
        ProdutoController prodController = new ProdutoController();
        Produto produto = prodController.buscaCodigoBarra(codigoBarras.toString());

        result.use(Results.json()).from(produto).serialize();
    }
}
