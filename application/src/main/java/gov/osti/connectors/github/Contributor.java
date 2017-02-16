/*
 */
package gov.osti.connectors.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains Contributor information from GitHub API.
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contributor {
    private String login;
    private Long id;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String url;
    private String type;
    @JsonProperty("site_admin")
    private boolean siteAdmin;
    private Integer contributions;

    public Contributor() {

    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }


    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the contributions
     */
    public Integer getContributions() {
        return contributions;
    }

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @return the siteAdmin
     */
    public boolean isSiteAdmin() {
        return siteAdmin;
    }
}