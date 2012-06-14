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
    int idPessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public Telefone() {
    }

    public Telefone(int numero, int id, int DDD, int idPessoa) {
        this.numero = numero;
        this.id = id;
        this.DDD = DDD;
        this.idPessoa = idPessoa;
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
