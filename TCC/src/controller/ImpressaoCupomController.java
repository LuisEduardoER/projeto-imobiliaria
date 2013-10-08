/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Bruno
 */
public class ImpressaoCupomController {
    
    
    //lista impressoras
    public static List<String> retornaImressoras(){  
        try {  
            List<String> listaImpressoras = new ArrayList<>();  
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;    
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);    
            for (PrintService p : ps) {    
                listaImpressoras.add(p.getName());       
            }    
            return listaImpressoras;  
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
        return null;  
    }  
    
    
    private static PrintService impressora; // O Atributo citado anteriormente  
  
    public void detectaImpressoras(String impressoraSelecionada) {  //Passa por parâmetro o nome salvo da impressora  
        try {    
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;    
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);    
            for (PrintService p : ps) {    
                if(p.getName()!=null && p.getName().contains(impressoraSelecionada)){    
                    impressora = p;    
                }       
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
    } 
    
}
