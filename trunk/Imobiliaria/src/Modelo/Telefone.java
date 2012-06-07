/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class Telefone {
    int numero;
    int id;
    int DDD;

    public Telefone() {
    }

    public Telefone(int numero, int id, int DDD) {
        this.numero = numero;
        this.id = id;
        this.DDD = DDD;
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
