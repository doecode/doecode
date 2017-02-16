/*
 */
package gov.osti.listeners;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Web application lifecycle listener.
 *
 * @author ensornl
 */
public class DoeServletContextListener implements ServletContextListener {
    // a Logger instance
    private static final Logger log = LoggerFactory.getLogger(DoeServletContextListener.class);
    
    // get an instance of EntityManagerFactory for persistence
    private static EntityManagerFactory emf = null;
    
    /**
     * Start up the services on deployment.
     * 
     * @param sce the ServletContextEvent triggering this function
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // attempt to load the persistence layer
        String persistence_unit = sce.getServletContext().getInitParameter("persistence_unit");
        emf = Persistence.createEntityManagerFactory(persistence_unit);
        
        log.info("DOECode instance started.");
    }

    /**
     * Free resources appropriately before undeployment.
     * @param sce the ServletContextEvent triggering the call
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // close down the Entity Manager
        log.info("Shutting down DOE Code application.");
        if (null!=emf)
            emf.close();
    }
    
    /**
     * Acquire an EntityManager for persistence operations.  Handling the resulting
     * EntityManager is the responsibility of the caller.  Make sure it is closed
     * appropriately.
     * 
     * @return an EntityManager from the Factory if possible
     */
    public static EntityManager createEntityManager() {
        if (null==emf)
            throw new IllegalStateException("Context not initialized!");
        
        return emf.createEntityManager();
    }
}
