/*
 */
package gov.osti.connectors.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
    private String login = null;
    private Long id = 0L;
    @JsonProperty("avatar_url")
    private String avatarUrl = null;
    private String url = null;
    @JsonProperty("html_url")
    private String htmlUrl = null;
    @JsonProperty("followers_url")
    private String followersUrl = null;
    @JsonProperty("following_url")
    private String followingUrl = null;
    @JsonProperty("gists_url")
    private String gistsUrl = null;
    @JsonProperty("starred_url")
    private String starred_url = null;
    @JsonProperty("subscriptions_url")
    private String subscriptionsUrl = null;
    @JsonProperty("organizations_url")
    private String organizationsUrl = null;
    @JsonProperty("repos_url")
    private String reposUrl = null;
    private String type = null;
    @JsonProperty("site_admin")
    private Boolean siteAdmin = false;

    public Owner() {

    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl the htmlUrl to set
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * @return the followersUrl
     */
    public String getFollowersUrl() {
        return followersUrl;
    }

    /**
     * @param followersUrl the followersUrl to set
     */
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    /**
     * @return the followingUrl
     */
    public String getFollowingUrl() {
        return followingUrl;
    }

    /**
     * @param followingUrl the followingUrl to set
     */
    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    /**
     * @return the gistsUrl
     */
    public String getGistsUrl() {
        return gistsUrl;
    }

    /**
     * @param gistsUrl the gistsUrl to set
     */
    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    /**
     * @return the starred_url
     */
    public String getStarred_url() {
        return starred_url;
    }

    /**
     * @param starred_url the starred_url to set
     */
    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    /**
     * @return the subscriptionsUrl
     */
    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    /**
     * @param subscriptionsUrl the subscriptionsUrl to set
     */
    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    /**
     * @return the organizationsUrl
     */
    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    /**
     * @param organizationsUrl the organizationsUrl to set
     */
    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    /**
     * @return the reposUrl
     */
    public String getReposUrl() {
        return reposUrl;
    }

    /**
     * @param reposUrl the reposUrl to set
     */
    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the siteAdmin
     */
    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    /**
     * @param siteAdmin the siteAdmin to set
     */
    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }
}