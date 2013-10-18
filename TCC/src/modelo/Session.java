/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
public class Session {

    private static Usuario usuario;
    private static AberturaCaixa aberturaCaixa;
    private static LocalDateTime inicio;
    private static LocalDateTime fim;
    
    public Session() {
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Session.usuario = usuario;
    }

    public static AberturaCaixa getCaixa() {
        return aberturaCaixa;
    }

    public static void setCaixa(AberturaCaixa caixa) {
        Session.aberturaCaixa = caixa;
    }

    public static LocalDateTime getInicio() {
        return inicio;
    }

    public static void setInicio(LocalDateTime inicio) {
        Session.inicio = inicio;
    }

    public static LocalDateTime getFim() {
        return fim;
    }

    public static void setFim(LocalDateTime fim) {
        Session.fim = fim;
    }
}
