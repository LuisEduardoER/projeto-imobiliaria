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
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;
import controller.Cadastro.Administrativo.UsuarioController;
import controller.Cadastro.VendaAberturaFechamentoCaixaController;
import modelo.AberturaCaixa;
import modelo.Session;
import modelo.Cadastro.Adminsitrativo.Usuario;

/**
 *
 * @author Bruno
 */
@Resource
public class LoginController {

    private final Result result;
    private Validator validator;

    public LoginController(Result result, Validator validator) {
        this.result = result;
        this.validator = validator;
    }

    @Get("/")
    public void redirecionaPgInicio() {
        result.forwardTo("/WEB-INF/jsp/index/index.jsp");
    }

    @Post("/login/logar")
    public void login(String usuarioName, String pass) {
        controller.LoginController controller = new controller.LoginController();
        UsuarioController userController = new UsuarioController();
        
        if(usuarioName == null){
            validator.add(new ValidationMessage("O campo login não pode ser vazio!", "inputUsuario"));
        }else if(usuarioName.equals("")){
            validator.add(new ValidationMessage("O campo login não pode ser vazio!", "inputUsuario"));
        }
        
        if(pass == null){
            validator.add(new ValidationMessage("O campo senha não pode ser vazio!", "inputPassword"));
        }else if(pass.equals("")){
            validator.add(new ValidationMessage("O campo senha não pode ser vazio!", "inputPassword"));
        }
        
        if (!validator.getErrors().isEmpty()) {
            validator.onErrorSendBadRequest();
        }
        
        Usuario usuario = new Usuario();

        usuario.setUsuarioName(usuarioName);
        usuario.setUsuarioSenha(pass);

        usuario = userController.buscarUsuarioByLogin(usuario);

        if (usuario.getUsuarioId() != null) {
            controller.login(usuario);
            VendaAberturaFechamentoCaixaController vendaAberturaFechamentoCaixaController = new VendaAberturaFechamentoCaixaController();
            Integer caixasAbertos = vendaAberturaFechamentoCaixaController.rowCountCaixasAbertosByUsuario(usuario.getUsuarioId());
            if (caixasAbertos > 0) {
                AberturaCaixa aberturaCaixa = vendaAberturaFechamentoCaixaController.getCaixaAbertoByFuncionario(usuario.getUsuarioId());
                Session.setCaixa(aberturaCaixa);
            }
            result.use(Results.http()).setStatusCode(200);
//            result.forwardTo("/WEB-INF/jsp/venda.jsp");
        }

    }
    
}
