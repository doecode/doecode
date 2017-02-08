/*
 */
package gov.osti.connectors.bitbucket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Listing of all relevant Link properties from BB API responses.
 * 
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {
    private Href self = null;
    private Href html = null;
    private Href avatar = null;
    private Href following = null;
    private Href followers = null;
    private Href snippets = null;
    private Href repositories = null;
    private Href hooks = null;
    @JsonProperty("updated_on")
    private Date updatedOn;

    /**
     * @return the self
     */
    public String getSelf() {
        return (null==self) ? "" : self.getHref();
    }

    /**
     * @return the html
     */
    public String getHtml() {
        return (null==html) ? "" : html.getHref();
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return (null==avatar) ? "" : avatar.getHref();
    }

    /**
     * Get the "hooks" URL.
     * @return the hooks URL if present
     */
    public String getHooks() {
        return (null==hooks) ? "" : hooks.getHref();
    }

    /**
     * Get the FOLLOWERS URL.
     * @return the URL if present
     */
    public String getFollowers() {
        return (null==followers) ? "" : followers.getHref();
    }

    /**
     * Get the FOLLOWING URL
     * @return the URL if present
     */
    public String getFollowing() {
        return (null==following) ? "" : following.getHref();
    }

    /**
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    } 
}
