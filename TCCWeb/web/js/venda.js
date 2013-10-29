/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var produto = "";

function enviar() {

    var parametros = {};
        parametros['eMail']   = $('#eMail').val();
        parametros['nome']    = $('#nome').val();
        parametros['assunto'] = $('#assunto').val();
    
    $.ajax({
        async: false,
        url: 'contato/enviar',
        type : "POST",
        dataType: 'json',
        data: parametros,
        beforeSend: function() {
            $(".load-ajax").css({
                display:"block"
            });
        },
        error: function(xhr, status, error) {
            //resultValidator(xhr, error);
            alert(xhr.responseText['message']);
        },
        success: function(json) {
            alert('funfoooooo');
        },
        complete: function() {
            $(".load-ajax").css({
                display:"none"
            });
        }
    });
}

function buscaProduto() {

    var parametros = {};
        parametros['codigoBarras']   = $('#produtoId').val();
    
    $.ajax({
        async: false,
        url: 'vendaWeb/buscaProduto',
        type : "POST",
        dataType: 'json',
        data: parametros,
        beforeSend: function() {
            $(".load-ajax").css({
                display:"block"
            });
        },
        error: function(xhr, status, error) {
            //resultValidator(xhr, error);
            alert(xhr.responseText['message']);
        },
        success: function(json) {
            produto = json.produto;
        },
        complete: function() {
            $(".load-ajax").css({
                display:"none"
            });
        }
    });
}


$(document).ready(function(){  

    $("[id='produtoId']").keypress(function(event) {
        
        if ( event.which == 13 || event.which == 0) {
            buscaProduto();
            $("#prodQuantidade").focus();
        }
    });
    
});  