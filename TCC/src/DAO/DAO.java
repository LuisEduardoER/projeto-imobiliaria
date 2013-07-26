/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public interface DAO<T> {
    
    T loadByID(int id);
    
}
