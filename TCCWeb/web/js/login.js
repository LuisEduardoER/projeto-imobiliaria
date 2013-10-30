/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function logar() {

    var parametros = {};
    
    parametros['usuarioName'] = $("[id='inputUsuario']").val();
    parametros['pass'] = $("[id='inputPassword']").val();
    
    $.ajax({
        async: false,
        url: 'login/logar',
        type : "POST",
        dataType: 'json',
        data: parametros,
        beforeSend: function() {
        },
        error: function(xhr, status, error) {
            //resultValidator(xhr, error);
//            alert(xhr.responseText['message']);
            if(xhr.status == 200){
                window.open("venda.jsp", '', '');

            }
        },
        success: function(json) {
            alert('funfoooooo');
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