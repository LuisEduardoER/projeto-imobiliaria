/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var produto = "";
var totalGlobal = 0;
var listProdutos = [''];
var tipoPagamento = 1;

function vender() {

    var parametros = {};
    
    for(var i =0; i<listProdutos.length; i++){
        parametros['produtos['+i+']'] = listProdutos[i];
    }
    
    parametros['totalVenda'] = totalGlobal;
    parametros['totalPago'] = $("[id='valorPago']").val();
    parametros['tipoPagamento'] = tipoPagamento;
    
    $.ajax({
        async: false,
        url: 'vendaWeb/vender',
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
            
            alert(xhr.statusText);
        },
        success: function(json) {
            alert('Venda: '+json.venda.vendaId + " realizada com sucesso!");
            limpaTela();
            $('#produtoId').focus();
        },
        complete: function() {
            $(".load-ajax").css({
                display:"none"
            });
        }
    });
}

function buscaProduto() {

    if($('#produtoId').val() != "" ){
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
                    $('#produtoId').val("");
                    $('#produtoId').focus();
                    alert(xhr.statusText);
                },
                success: function(json) {
                    produto = json.produto;

                    $("[id='produtoValor']").val(produto.valor);

                    $("#prodQuantidade").focus();
                },
                complete: function() {
                    $(".load-ajax").css({
                        display:"none"
                    });
                }
            });
}else{
    alert('Informe um código de barras!');
}

}

function atualizaTotal(){
    
    if(produto.valor != undefined && $("[id='prodQuantidade']").val() != ""){
        var total = $("[id='total']").val();
        
        total = (produto.valor * $("[id='prodQuantidade']").val());
        
        totalGlobal += total; 
        
        $("[id='logVenda']").append("\n");
        $("[id='logVenda']").append(produto.produtoNome +" R$ " + produto.valor + " x " + $("[id='prodQuantidade']").val());
        $("[id='logVenda']").append("\n");
        $("[id='logVenda']").append("Sub-Total: R$ " + total);
        $("[id='logVenda']").append("\n");
        $("[id='logVenda']").append("----------------------------------");
        $("[id='logVenda']").append("\n");
        
        $("[id='total']").html("R$ " + totalGlobal);
        
        listProdutos[listProdutos.length + 1] = "PK:" + produto.produto_id + "-"+$("[id='prodQuantidade']").val();
        
        $("[id='prodQuantidade']").val("");
        $("[id='produtoId']").val("");
        $("[id='produtoValor']").val("");
        total = 0;
        
        
        $("#produtoId").focus();
        
    }
}


function limpaTela(){
    produto = "";
    totalGlobal = 0;
    listProdutos = new Array;
    
    $("[id='logVenda']").text("Bem Vindo!");
    $("[id='prodQuantidade']").val("");
    $("[id='produtoId']").val("");
    $("[id='produtoValor']").val("");
    $("[id='total']").html(" R$ 0.000");
    $("[id='valorPago']").val("");
     $("[id='dinheiro']").attr('checked', true);
     tipoPagamento = 1;
}

$(document).ready(function(){

    $("[id='logVenda']").text("Bem Vindo!");
    $("[id='dinheiro']").attr('checked', true);

    
    $("[id='produtoId']").keypress(function(event) {
        if ( event.which == 13 || event.which == 0) {
            buscaProduto();
        }
    });
    
    $("[id='prodQuantidade']").keypress(function(event) {
        if ( event.which == 13 || event.which == 0) {
            atualizaTotal();
        }
    });
    
    $("[id='valorPago']").keypress(function(event) {
        if ( event.which == 13 || event.which == 0) {
            vender();
        }
    });
    
     $('#dinheiro').change(function() {
        if($(this).is(':checked')){
            tipoPagamento = 1;
        }
    });
     $('#cheque').change(function() {
        if($(this).is(':checked')){
            tipoPagamento = 2;
        }
    });
     $('#cartao').change(function() {
        if($(this).is(':checked')){
            tipoPagamento = 3;
        }
    });
    
    produto = "";
    totalGlobal = 0;
    listProdutos = new Array;
    
    $("[id='prodQuantidade']").val("");
    $("[id='produtoId']").val("");
    $("[id='produtoValor']").val("");
    $("[id='total']").html(" R$ 0.000");
     $("[id='valorPago']").val("");
});  