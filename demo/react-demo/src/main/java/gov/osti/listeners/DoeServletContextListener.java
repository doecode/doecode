/*
 */
package gov.osti.listeners;

import gov.osti.database.DBOps;
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
    private static final Logger log = LoggerFactory.getLogger(DoeServletContextListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // does nothing yet
        log.info("DOE Code context initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // close down the Entity Manager
        log.info("Shutting down DOE Code application.");
        DBOps.shutdown();
    }
}
