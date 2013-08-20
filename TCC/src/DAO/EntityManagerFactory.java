package DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {
	
	private javax.persistence.EntityManagerFactory factory;
	
	public EntityManagerFactory() {
		
		//o paramentro é mesmo nome usado na tag <persistence-unit> no arquivo persistence.xml 
		factory = Persistence.createEntityManagerFactory("TCCPU");
	}
	
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
}
