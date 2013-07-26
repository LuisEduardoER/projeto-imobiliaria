/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bruno
 */
public class EntityManagerFactoryCreator {

    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEMF() {
        
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("TCCPU");
        }
        
        return emf;
    }
}
