/*
 */
package gov.osti.connectors.bitbucket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Listings for Team members on BB projects.
 * 
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberList {
    // page length in rows
    @JsonProperty("pagelen")
    private Integer length;
    // set of Users on this page
    @JsonProperty("values")
    private User[] users;
    // the number of Users in total
    private Integer size;
    // the page number, starting at 1
    private Integer page;

    /**
     * @return the length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @return the User records
     */
    public User[] getUsers() {
        return users;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * @return the page
     */
    public Integer getPage() {
        return page;
    }
}
