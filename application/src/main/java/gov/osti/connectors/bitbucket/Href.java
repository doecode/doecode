/*
 */
package gov.osti.connectors.bitbucket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Simple HREF/URL link from API responses.
 * 
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Href {
    private String href = "";
        
    /**
     * Retrieve the HREF value if present
     * @return the HREF value of a Link
     */
    public String getHref() {
        return href;
    }
}
