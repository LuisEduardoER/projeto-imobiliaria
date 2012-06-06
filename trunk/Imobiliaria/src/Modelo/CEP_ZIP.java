/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class CEP_ZIP {
    int cep_zip;

    public CEP_ZIP() {
    }

    public int getCep_zip() {
        return cep_zip;
    }

    public void setCep_zip(int cep_zip) {
        this.cep_zip = cep_zip;
    }

    @Override
    public String toString() {
        String s = cep_zip + "";
        return s;
    }

    
    
}
