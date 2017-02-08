/*
 */
package gov.osti.connectors.bitbucket;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author ensornl
 */
public class User {
    private String username;
    private String website;
    @JsonProperty("display_name")
    private String displayName;
    private Link links;
    @JsonProperty("created_on")
    private Date createdOn;
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
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
}
