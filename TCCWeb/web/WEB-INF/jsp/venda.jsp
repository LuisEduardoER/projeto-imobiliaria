<%-- 
    Document   : venda
    Created on : 26/10/2013, 14:54:36
    Author     : Bruno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>TCC Bruno - Web</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="http://pingendo-web.herokuapp.com/bootstrap-3/js/bootstrap.js"></script>
        
        <script lang="JavaScript" type="text/javascript" src="js/venda.js"></script>
        <!--[if lt IE 9]>
            <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script>
        <![endif]-->
        <!--[if lt IE 9]>
            <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.6.1/html5shiv.js"></script>
        <![endif]-->
    </head>

    <body class="">
        <div class="container">
            <br>
            <div class="navbar navbar-default navbar-static-top navbar-inverse">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
                        <span class="icon-bar"></span><span class="icon-bar"></span> </button><a class="navbar-brand" href="#">TCC Bruno - Web</a>
                </div>
<!--                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#">Home</a>
                        </li>
                        <li><a href="#">Contacts</a>
                        </li>
                    </ul>
                </div>-->
            </div>
            <div id="textAreaLog" class="row">
                <div class="col-md-2">
                    <ul class="nav nav-stacked nav-pills">
                        <li class="active"><a class="" href="/venda.jsp">Venda</a>
                        </li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
                <div class="col col-md-4" style="width: 110px;">
                    <div class="panel">
                        <div class="panel">
                            <div style="padding-top: 5px;">
                                <label>
                                    C&oacute;digo de Barras:
                                </label>
                            </div>

                            <div>
                                <br>
                            </div>

                            <div style="padding-top: 5px;">
                                <label>
                                    Quantidade:
                                </label>
                            </div>

                            <div>
                                <br>
                            </div>

                            <div style="padding-top: 5px;">
                                <label>
                                    Valor:
                                </label>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="col col-md-6">

                    <div class="panel">

                        <div class="input-group input-group-sm">
                            <input class="form-control" id="produtoId" type="text">
                        </div>
                        
                        <div>
                            <br>
                        </div>
                        <div class="input-group input-group-sm">
                            <input class="form-control" id="prodQuantidade" align="right" type="text">
                            <span class="input-group-addon">.00</span>
                        </div>

                        <div>
                            <br>
                        </div>

                        <div class="input-group input-group-sm">
                            <span class="input-group-addon">$</span>
                            <input id="produtoValor" class="form-control" disabled="" type="text">
                            <span class="input-group-addon">.00</span>
                        </div>

                    </div>

                </div>

                <div class="panel">
                    <div class="col-md-6">
                        <textarea class="form-control" rows="3" disabled=""></textarea>
                    </div>
                </div>

            </div>

            <div class="col-md-3">
                <label> Forma de Pagamento:</label>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">
                        <input type="radio" id="dinheiro" name="formaPagamento">
                    </span>
                    <input type="text" class="form-control" disabled value="Dinheiro" />
                </div>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon">
                        <input type="radio" id="cheque" name="formaPagamento">
                    </span>
                    <input type="text" class="form-control" disabled value="Cheque" />
                </div>
                <div class="input-group input-group-sm">
                    <span class="input-group-addon" >
                        <input type="radio" id="cartao" name="formaPagamento">
                    </span>
                    <input type="text" class="form-control" disabled value="Cartão" />
                </div>
            </div>

            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>
            <br/>

            <div>
                <label> Total:</label>
                <label> R$ 0,000:</label>
            </div>
            
            <div class="row">
                <div class="col-md-12">
                    <hr>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <p class="text-center">TCC Web
                        <br>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>