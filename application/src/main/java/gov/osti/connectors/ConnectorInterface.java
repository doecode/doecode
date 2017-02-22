/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

/**
 * Define common access points for Connector type metadata producers.
 * 
 * @author ensornl
 */
public interface ConnectorInterface {
    /**
     * Initialize any values necessary for the Connector.
     * 
     * @throws IOException on file IO or other initializer errors
     */
    public void init() throws IOException;
    
    /**
     * Attempt to read information from a given URL value.  If unable to obtain
     * information, or the URL is not a recognizable pattern, return null to 
     * allow Connector chain to continue processing.
     * 
     * @param url the URL to read from
     * @return JSON of the metadata found, or null if none read
     */
    public JsonNode read(String url);
}
