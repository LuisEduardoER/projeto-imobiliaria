/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bruno
 */
public class Garagem {
    int id;
    int vagas;
    boolean cobertura;
    boolean reservada_exclusiva;

    public boolean isReservada_exclusiva() {
        return reservada_exclusiva;
    }

    public void setReservada_exclusiva(boolean reservada_exclusiva) {
        this.reservada_exclusiva = reservada_exclusiva;
    }

    public boolean isCobertura() {
        return cobertura;
    }

    public void setCobertura(boolean cobertura) {
        this.cobertura = cobertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
