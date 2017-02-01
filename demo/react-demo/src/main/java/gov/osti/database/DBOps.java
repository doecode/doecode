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
	
	public static DOECodeMetadata lookupMetadata(long codeId) {
		DOECodeMetadata md = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		md = entityManager.find(DOECodeMetadata.class, codeId);
		entityManager.close();
		return md;
	}
	
	public static void deleteMetadata(long codeId) {
		DOECodeMetadata md = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		md = entityManager.find(DOECodeMetadata.class, codeId);
		entityManager.remove(md);
		entityManager.close();
	}
	
        
        /**
         * Shut down the entity manager factory at application shutdown.
         */
        public static void shutdown() {
            if (entityManagerFactory.isOpen()) 
                entityManagerFactory.close();
        }
	
	

}
