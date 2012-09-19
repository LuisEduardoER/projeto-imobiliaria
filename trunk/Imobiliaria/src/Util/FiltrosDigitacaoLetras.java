/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Bruno
 */
public class FiltrosDigitacaoLetras extends PlainDocument {

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {

        if (!str.matches("[0-9]+")) {
            super.insertString(offs, str, a);
        }
    }
    
}
