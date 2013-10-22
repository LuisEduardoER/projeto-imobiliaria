/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bemajava.*;

/**
 *
 * @author Bruno
 */
public class ImpressaoCupomController {

    public static void main(String[] args) {

        int iRetorno;

        BemaInteger ACK, ST1, ST2, ST3;

        ACK = new BemaInteger();

        ST1 = new BemaInteger();

        ST2 = new BemaInteger();

        ST3 = new BemaInteger();



        // Habilitando o retorno estendido da impressora MFD

        iRetorno = Bematech.HabilitaDesabilitaRetornoEstendidoMFD("1");



        // Emitindo uma Leitura X

        iRetorno = Bematech.LeituraX();

        System.out.println("Retorno: " + iRetorno);



        // Pegando o retorno da impressora MFD

        iRetorno = Bematech.RetornoImpressoraMFD(ACK, ST1, ST2, ST3);

        String retorno = "ACK: " + ACK.number;

        retorno += "\nST1: " + ST1.number;

        retorno += "\nST2: " + ST2.number;

        retorno += "\nST3: " + ST3.number;

        System.out.println("Retorno Impressora MFD: \n" + retorno);

        iRetorno = Bematech.AbreCupom("11.111.111-11");
        iRetorno = Bematech.VendeItem("123", "Caneta", "1200", "I", "10", 2, "0,25", "%", "0000");
        iRetorno = Bematech.IniciaFechamentoCupom("A", "%", "1000");
        iRetorno = Bematech.EfetuaFormaPagamento("DINHEIRO", "50,00");
        iRetorno = Bematech.TerminaFechamentoCupom("Obrigado, volte sempre !!!");
        iRetorno = Bematech.FechaCupom("Dinheiro", "A", "$", "0000", "35,00", "Obrigado, volte sempre !!!");






        
    }
}
