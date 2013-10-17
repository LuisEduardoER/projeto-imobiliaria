/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author Bruno
 */
public class FactoryTeste {

    public static JRDataSource createDS() {
        return new DSTeste();
    }
}
