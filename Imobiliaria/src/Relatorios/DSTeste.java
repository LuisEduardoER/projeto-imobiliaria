/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Relatorios;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Bruno
 */
public class DSTeste implements JRDataSource {

    int i;

    public DSTeste() {
    }

    @Override
    public boolean next() throws JRException {
        return i++ < 10;
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {


        if ("field1".equals(jrf.getName())) {
            return "campo1";
        }
        if ("field2".equals(jrf.getName())) {
            return "oi";
        }
        
        return "num deu";
                
    }
}
