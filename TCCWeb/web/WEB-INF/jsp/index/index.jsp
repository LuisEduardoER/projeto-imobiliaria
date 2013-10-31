<%-- 
    Document   : index
    Created on : 24/10/2013, 19:45:43
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>

        <script lang="JavaScript" type="text/javascript" src="js/jquery.min.js"></script>
        <script lang="JavaScript" type="text/javascript" src="js/login.js"></script>
    </head>
    <body>
        <form class="form-horizontal" style="margin-right: 50%;">
            <div class="control-group">
                <label class="control-label" for="inputUsuario">Usu&aacute;rio</label>
                <div class="controls">
                    <input id="inputUsuario" type="text" placeholder="Usuario" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="inputPassword">Senha</label>
                <div class="controls">
                    <input id="inputPassword" type="password" placeholder="Digite a sua senha..." />
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button class="btn" id="btnAcessar">Acessar</button>
                </div>
            </div>
        </form>
    </body>
</html>