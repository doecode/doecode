/*
 */
package gov.osti.connectors.sourceforge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String name;
    private String url;
    private String username;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
}
