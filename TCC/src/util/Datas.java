/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.ParseException;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
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
    
    public static LocalDate localDateParser(String dataBR) throws ParseException{
        
        String date = "";
        
        if(dataBR.isEmpty()){
            throw new ParseException("Impossivel converter a data informada!",0);
        }
        
        String dateArray[] = dataBR.split("/");
        
        return new LocalDate(Integer.parseInt(dateArray[2]),Integer.parseInt(dateArray[1]),Integer.parseInt(dateArray[0]));
    }
    
}
