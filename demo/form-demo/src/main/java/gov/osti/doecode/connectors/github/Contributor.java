/*
 */
package gov.osti.doecode.connectors.github;

import com.google.gson.annotations.SerializedName;

/**
 * Objects from the "contributor_url" portion of github API response.
 * 
 * @author ensornl
 */
public class Contributor {
    private String login;
    private Long id;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String url;
    private String type;
    @SerializedName("site_admin")
    private boolean siteAdmin;
    private Integer contributions;

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
