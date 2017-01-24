package gov.osti.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import gov.osti.entity.DOECodeMetadata;

public class DBOps {
	
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DOECode");
	
	public static void saveMetadata(DOECodeMetadata md) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(md);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}
	
	
	

}
