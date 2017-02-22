/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ensornl
 */
public class ConnectorFactory {
    // a Logger
    private static final Logger log = LoggerFactory.getLogger(ConnectorFactory.class);
    // the set of Connectors to process
    private ArrayList<ConnectorInterface> connectors = new ArrayList<>();
    
    private ConnectorFactory() {
    }
    
    public static ConnectorFactory getInstance() {
        return ConnectorFactoryHolder.INSTANCE;
    }
    
    private static class ConnectorFactoryHolder {
        private static final ConnectorFactory INSTANCE = new ConnectorFactory();
    }
    
    /**
     * Add a new instance of a Connector onto the Factory.
     * 
     * @param connector an instantiated Connector
     * @return the Factory
     */
    public ConnectorFactory add(ConnectorInterface connector) {
        connectors.add(connector);
        return this;
    }
    
    /**
     * Initialize all Connectors and prepare for reading calls.
     * 
     * @return the Factory instance
     * @throws IOException on initializer errors
     */
    public ConnectorFactory build() throws IOException {
        // init each Connector
        for ( ConnectorInterface connector : connectors ) {
            connector.init();
        }
        
        return this;
    }
    
    /**
     * Process through each Connector in the chain, returning any JSON encountered.
     * 
     * @param url the URL to read from
     * @return the JSON of metadata if found, or null if none of the Connectors
     * recognize or could read the information
     */
    public JsonNode read(String url) {
        for ( ConnectorInterface c : connectors ) {
            JsonNode result = c.read(url);
            
            if (null!=result)
                return result;
        }
        
        return null;
    }
}
