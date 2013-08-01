/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.joda.time.DateTime;

/**
 *
 * @author Bruno
 */
public class Datas {

    public static DateTime data;

    public static String dataAtual() {
        data = new DateTime();
        return data.toString("YYYY-MM-dd HH:mm:ss");
    }
}
