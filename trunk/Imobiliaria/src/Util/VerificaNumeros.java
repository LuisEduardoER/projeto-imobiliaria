/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Bruno
 */
public class VerificaNumeros {

    public static boolean verificaNumeros(String valorCampo) {
        boolean retorno = false;

        for (int i = 0; i < valorCampo.length(); i++) {

            char s = valorCampo.charAt(i);

            if (Character.isDigit(s) == false) {
                retorno = false;
            } else {
                retorno = true;
            }
        }
        return retorno;
    }
}
