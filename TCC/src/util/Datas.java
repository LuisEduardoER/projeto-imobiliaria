/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

/**
 *
 * @author Bruno
 */
public class Datas {

    public static DateTime data;
    public static LocalDateTime dataDateTime;
    
    public static String dataAtual() {
        data = new DateTime();
        return data.toString("YYYY-MM-dd HH:mm:ss");
    }
    public static LocalDateTime dataAtualDateTime() {
        dataDateTime = new LocalDateTime();
        return dataDateTime;
    }
}
