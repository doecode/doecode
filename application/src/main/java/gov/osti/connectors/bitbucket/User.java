/*
 */
package gov.osti.connectors.bitbucket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String username;
    private String website;
    @JsonProperty("display_name")
    private String displayName;
    private Link links;
    private String type;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return the links
     */
    public Link getLinks() {
        return links;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
}
