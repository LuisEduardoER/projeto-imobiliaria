/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function logar() {

    var parametros = {};
    
    parametros['usuarioName'] = $("#inputUsuario").val();
    parametros['pass'] = $("#inputPassword").val();
    
    $.ajax({
        async: false,
        url: 'login/logar',
        type : "POST",
        data: parametros,
        error: function(xhr, status, error) {
        },
        success: function(json) {
            window.open("venda.jsp", "parent", '');
            
        },
        complete: function() {
        }
    });

}


$(document).ready(function(){  

    $("[id='btnAcessar']").click(function() {
        logar();
    });
    
});  