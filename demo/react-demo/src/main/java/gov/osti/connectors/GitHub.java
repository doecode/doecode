
package gov.osti.connectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The GitHub metadata scraper class, to acquire the relevant metadata attributes
 * from the GitHub public API.
 * 
 * @author nenso
 */
public class GitHub {
    /** a logger implementation **/
    private static final Logger log = LoggerFactory.getLogger(GitHub.class);
    /** authentication information for accessing GitHub API **/
    private static String API_KEY = "";
    private static String API_USER = "";
    /** GitHub API base URL **/
    private static final String GITHUB_BASE_URL = "https://api.github.com/repos/";
    
    /**
     * Object containing User information from GitHub API.
     */
    private class User {
        private String login ="";
        private Long id;
        @SerializedName("avatar_url")
        private String avatarUrl ="";
        private String type = "";
        @SerializedName("site_admin")
        private Boolean siteAdmin;
        private String name = "";
        private String company ="";
        private String email = "";
        private String bio = "";
        @SerializedName("organizations_url")
        private String organizationsUrl = "";
        @SerializedName("repos_url")
        private String repositoriesUrl = "";
        private String url = "";
        @SerializedName("created_at")
        private Date dateCreated = null;
        @SerializedName("updated_at")
        private Date dateUpdated = null;

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

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the company
         */
        public String getCompany() {
            return company;
        }

        /**
         * @param company the company to set
         */
        public void setCompany(String company) {
            this.company = company;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return the bio
         */
        public String getBio() {
            return bio;
        }

        /**
         * @param bio the bio to set
         */
        public void setBio(String bio) {
            this.bio = bio;
        }

        /**
         * @return the dateCreated
         */
        public Date getDateCreated() {
            return dateCreated;
        }

        /**
         * @param dateCreated the dateCreated to set
         */
        public void setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
        }

        /**
         * @return the dateUpdated
         */
        public Date getDateUpdated() {
            return dateUpdated;
        }

        /**
         * @param dateUpdated the dateUpdated to set
         */
        public void setDateUpdated(Date dateUpdated) {
            this.dateUpdated = dateUpdated;
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
         * @return the repositoriesUrl
         */
        public String getRepositoriesUrl() {
            return repositoriesUrl;
        }

        /**
         * @param repositoriesUrl the repositoriesUrl to set
         */
        public void setRepositoriesUrl(String repositoriesUrl) {
            this.repositoriesUrl = repositoriesUrl;
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
    }
    
    /**
     * Contains Contributor information from GitHub API.
     */
    private class Contributor {
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
    
    /**
     * Owner information from GitHub API.
     */
    private class Owner {
        private String login = null;
        private Long id = 0L;
        @SerializedName("avatar_url")
        private String avatarUrl = null;
        private String url = null;
        @SerializedName("html_url")
        private String htmlUrl = null;
        @SerializedName("followers_url")
        private String followersUrl = null;
        @SerializedName("following_url")
        private String followingUrl = null;
        @SerializedName("gists_url")
        private String gistsUrl = null;
        @SerializedName("starred_url")
        private String starred_url = null;
        @SerializedName("subscriptions_url")
        private String subscriptionsUrl = null;
        @SerializedName("organizations_url")
        private String organizationsUrl = null;
        @SerializedName("repos_url")
        private String reposUrl = null;
        private String type = null;
        @SerializedName("site_admin")
        private Boolean siteAdmin = false;

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
    
    /**
     * Organization information from GitHub API.
     */
    private class Organization {
        private String login = null;
        private Long id = 0L;
        @SerializedName("avatar_url")
        private String avatarUrl = null;
        private String url = null;
        @SerializedName("html_url")
        private String htmlUrl = null;
        @SerializedName("followers_url")
        private String followersUrl = null;
        @SerializedName("following_url")
        private String followingUrl = null;
        @SerializedName("gists_url")
        private String gistsUrl = null;
        @SerializedName("subscriptions_url")
        private String subscriptionsUrl = null;
        @SerializedName("organizations_url")
        private String organizationsUrl = null;
        @SerializedName("repos_url")
        private String reposUrl = null;
        @SerializedName("events_url")
        private String eventsUrl = null;
        private String type = null;
        @SerializedName("site_admin")
        private Boolean siteAdmin = false;

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
         * @return the eventsUrl
         */
        public String getEventsUrl() {
            return eventsUrl;
        }

        /**
         * @param eventsUrl the eventsUrl to set
         */
        public void setEventsUrl(String eventsUrl) {
            this.eventsUrl = eventsUrl;
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
    
    /**
     * Repository (Project) base information from GitHub API.
     */
    private class Repository {
        /** attributes **/
        private Long id;
        private String name=null;
        @SerializedName("full_name")
        private String fullName = null;
        private Owner owner = null;
        @SerializedName("private")
        private Boolean isPrivate = false;
        @SerializedName("html_url")
        private String htmlUrl = null;
        private String description = null;
        @SerializedName("fork")
        private Boolean isFork = false;
        private String url = null;
        @SerializedName("forks_url")
        private String forksUrl = null;
        @SerializedName("collaborators_url")
        private String collaboratorsUrl = null;
        @SerializedName("teams_url")
        private String teamsUrl = null;
        @SerializedName("hooks_url")
        private String hooksUrl = null;
        @SerializedName("issue_events_url")
        private String issueEventsUrl = null;
        @SerializedName("events_url")
        private String eventsUrl = null;
        @SerializedName("assignees_url")
        private String assigneesUrl = null;
        @SerializedName("branches_url")
        private String branchesUrl = null;
        @SerializedName("tags_url")
        private String tagsUrl = null;
        @SerializedName("blobs_url")
        private String blobsUrl = null;
        @SerializedName("git_tags_url")
        private String gitTagsUrl = null;
        @SerializedName("git_refs_url")
        private String gitReferencesUrl = null;
        @SerializedName("trees_url")
        private String treesUrl = null;
        @SerializedName("statuses_url")
        private String statusesUrl = null;
        @SerializedName("languages_url")
        private String languagesUrl = null;
        @SerializedName("contributors_url")
        private String contributorsUrl = null;
        @SerializedName("commits_url")
        private String commitsUrl = null;
        @SerializedName("comments_url")
        private String commentsUrl = null;
        @SerializedName("archive_url")
        private String archiveUrl = null;
        @SerializedName("downloads_url")
        private String downloadsUrl = null;
        @SerializedName("issues_url")
        private String issuesUrl = null;
        @SerializedName("pulls_url")
        private String pullsUrl = null;
        @SerializedName("notifications_url")
        private String notificationsUrl = null;
        @SerializedName("labels_url")
        private String labelsUrl = null;
        @SerializedName("releases_url")
        private String releasesUrl = null;
        @SerializedName("created_at")
        private Date dateCreated = null;
        @SerializedName("updated_at")
        private Date dateUpdated = null;
        @SerializedName("pushed_at")
        private Date datePushed = null;
        @SerializedName("git_url")
        private String gitUrl = null;
        @SerializedName("ssh_url")
        private String sshUrl = null;
        @SerializedName("clone_url")
        private String cloneUrl = null;
        @SerializedName("svn_url")
        private String svnUrl = null;
        private String homepage = null;
        private Long size = 0L;
        private String language = null;
        @SerializedName("has_issues")
        private Boolean hasIssues = false;
        @SerializedName("has_wiki")
        private Boolean hasWiki = false;
        @SerializedName("has_downloads")
        private Boolean hasDownloads = false;
        @SerializedName("has_pages")
        private Boolean hasPages = false;
        private Integer forks = 0;
        @SerializedName("open_issues_count")
        private Integer openIssuesCount = 0;
        @SerializedName("open_issues")
        private Integer openIssues = 0;
        @SerializedName("default_branch")
        private String defaultBranch = null;
        @SerializedName("network_count")
        private Integer networkCount = 0;
        @SerializedName("subscribers_count")
        private Integer subscribersCount = 0;
        private Organization organization = null;

        /**
         * Get the unique github ID.
         * @return the id the ID
         */
        public Long getId() {
            return id;
        }

        /**
         * Set a unique ID value
         * @param id the id to set
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * Get the repository name.
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * Set a repository name.
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * The Owner information for this repository.
         * 
         * @return the owner information
         */
        public Owner getOwner() {
            return owner;
        }

        /** 
         * Set an Owner reference for this repository.
         * 
         * @param owner the owner to set
         */
        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        /**
         * Whether or not this repository is "private".
         * @return the isPrivate
         */
        public Boolean getIsPrivate() {
            return isPrivate;
        }

        /**
         * @param isPrivate the isPrivate to set
         */
        public void setIsPrivate(Boolean isPrivate) {
            this.isPrivate = isPrivate;
        }

        /**
         * the HTML URL if any.
         * @return the URL to the HTML description/project page
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
         * A description of the github repository project.
         * @return the description
         */
        public String getDescription() {
            return description;
        }

        /**
         * Set a description for the repository.
         * 
         * @param description the description to set
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Has this project been forked?
         * @return true if forked, false if not
         */
        public Boolean getIsFork() {
            return isFork;
        }

        /**
         * Set whether or not this project has been forked.
         * @param isFork set whether or not the project was forked
         */
        public void setIsFork(Boolean isFork) {
            this.isFork = isFork;
        }

        /**
         * The base reference URL for the repository.
         * 
         * @return the url
         */
        public String getUrl() {
            return url;
        }

        /**
         * Set a base reference URL.
         * 
         * @param url the url to set
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * URL for information about project forks, if any
         * @return the forksUrl
         */
        public String getForksUrl() {
            return forksUrl;
        }

        /**
         * @param forksUrl the forksUrl to set
         */
        public void setForksUrl(String forksUrl) {
            this.forksUrl = forksUrl;
        }

        /**
         * URL to API call for retrieving collaborator information for this project.
         * 
         * @return the collaboratorsUrl
         */
        public String getCollaboratorsUrl() {
            return collaboratorsUrl;
        }

        /**
         * @param collaboratorsUrl the collaboratorsUrl to set
         */
        public void setCollaboratorsUrl(String collaboratorsUrl) {
            this.collaboratorsUrl = collaboratorsUrl;
        }

        /**
         * URL to API call referencing team information, if any
         * @return the teamsUrl
         */
        public String getTeamsUrl() {
            return teamsUrl;
        }

        /**
         * @param teamsUrl the teamsUrl to set
         */
        public void setTeamsUrl(String teamsUrl) {
            this.teamsUrl = teamsUrl;
        }

        /**
         * @return the hooksUrl
         */
        public String getHooksUrl() {
            return hooksUrl;
        }

        /**
         * @param hooksUrl the hooksUrl to set
         */
        public void setHooksUrl(String hooksUrl) {
            this.hooksUrl = hooksUrl;
        }

        /**
         * @return the issueEventsUrl
         */
        public String getIssueEventsUrl() {
            return issueEventsUrl;
        }

        /**
         * @param issueEventsUrl the issueEventsUrl to set
         */
        public void setIssueEventsUrl(String issueEventsUrl) {
            this.issueEventsUrl = issueEventsUrl;
        }

        /**
         * @return the eventsUrl
         */
        public String getEventsUrl() {
            return eventsUrl;
        }

        /**
         * @param eventsUrl the eventsUrl to set
         */
        public void setEventsUrl(String eventsUrl) {
            this.eventsUrl = eventsUrl;
        }

        /**
         * @return the assigneesUrl
         */
        public String getAssigneesUrl() {
            return assigneesUrl;
        }

        /**
         * @param assigneesUrl the assigneesUrl to set
         */
        public void setAssigneesUrl(String assigneesUrl) {
            this.assigneesUrl = assigneesUrl;
        }

        /**
         * @return the branchesUrl
         */
        public String getBranchesUrl() {
            return branchesUrl;
        }

        /**
         * @param branchesUrl the branchesUrl to set
         */
        public void setBranchesUrl(String branchesUrl) {
            this.branchesUrl = branchesUrl;
        }

        /**
         * @return the tagsUrl
         */
        public String getTagsUrl() {
            return tagsUrl;
        }

        /**
         * @param tagsUrl the tagsUrl to set
         */
        public void setTagsUrl(String tagsUrl) {
            this.tagsUrl = tagsUrl;
        }

        /**
         * @return the blobsUrl
         */
        public String getBlobsUrl() {
            return blobsUrl;
        }

        /**
         * @param blobsUrl the blobsUrl to set
         */
        public void setBlobsUrl(String blobsUrl) {
            this.blobsUrl = blobsUrl;
        }

        /**
         * @return the gitTagsUrl
         */
        public String getGitTagsUrl() {
            return gitTagsUrl;
        }

        /**
         * @param gitTagsUrl the gitTagsUrl to set
         */
        public void setGitTagsUrl(String gitTagsUrl) {
            this.gitTagsUrl = gitTagsUrl;
        }

        /**
         * @return the gitReferencesUrl
         */
        public String getGitReferencesUrl() {
            return gitReferencesUrl;
        }

        /**
         * @param gitReferencesUrl the gitReferencesUrl to set
         */
        public void setGitReferencesUrl(String gitReferencesUrl) {
            this.gitReferencesUrl = gitReferencesUrl;
        }

        /**
         * @return the treesUrl
         */
        public String getTreesUrl() {
            return treesUrl;
        }

        /**
         * @param treesUrl the treesUrl to set
         */
        public void setTreesUrl(String treesUrl) {
            this.treesUrl = treesUrl;
        }

        /**
         * @return the statusesUrl
         */
        public String getStatusesUrl() {
            return statusesUrl;
        }

        /**
         * @param statusesUrl the statusesUrl to set
         */
        public void setStatusesUrl(String statusesUrl) {
            this.statusesUrl = statusesUrl;
        }

        /**
         * @return the languagesUrl
         */
        public String getLanguagesUrl() {
            return languagesUrl;
        }

        /**
         * @param languagesUrl the languagesUrl to set
         */
        public void setLanguagesUrl(String languagesUrl) {
            this.languagesUrl = languagesUrl;
        }

        /**
         * @return the contributorsUrl
         */
        public String getContributorsUrl() {
            return contributorsUrl;
        }

        /**
         * @param contributorsUrl the contributorsUrl to set
         */
        public void setContributorsUrl(String contributorsUrl) {
            this.contributorsUrl = contributorsUrl;
        }

        /**
         * @return the commitsUrl
         */
        public String getCommitsUrl() {
            return commitsUrl;
        }

        /**
         * @param commitsUrl the commitsUrl to set
         */
        public void setCommitsUrl(String commitsUrl) {
            this.commitsUrl = commitsUrl;
        }

        /**
         * @return the commentsUrl
         */
        public String getCommentsUrl() {
            return commentsUrl;
        }

        /**
         * @param commentsUrl the commentsUrl to set
         */
        public void setCommentsUrl(String commentsUrl) {
            this.commentsUrl = commentsUrl;
        }

        /**
         * @return the archiveUrl
         */
        public String getArchiveUrl() {
            return archiveUrl;
        }

        /**
         * @param archiveUrl the archiveUrl to set
         */
        public void setArchiveUrl(String archiveUrl) {
            this.archiveUrl = archiveUrl;
        }

        /**
         * @return the downloadsUrl
         */
        public String getDownloadsUrl() {
            return downloadsUrl;
        }

        /**
         * @param downloadsUrl the downloadsUrl to set
         */
        public void setDownloadsUrl(String downloadsUrl) {
            this.downloadsUrl = downloadsUrl;
        }

        /**
         * @return the issuesUrl
         */
        public String getIssuesUrl() {
            return issuesUrl;
        }

        /**
         * @param issuesUrl the issuesUrl to set
         */
        public void setIssuesUrl(String issuesUrl) {
            this.issuesUrl = issuesUrl;
        }

        /**
         * @return the pullsUrl
         */
        public String getPullsUrl() {
            return pullsUrl;
        }

        /**
         * @param pullsUrl the pullsUrl to set
         */
        public void setPullsUrl(String pullsUrl) {
            this.pullsUrl = pullsUrl;
        }

        /**
         * @return the notificationsUrl
         */
        public String getNotificationsUrl() {
            return notificationsUrl;
        }

        /**
         * @param notificationsUrl the notificationsUrl to set
         */
        public void setNotificationsUrl(String notificationsUrl) {
            this.notificationsUrl = notificationsUrl;
        }

        /**
         * @return the labelsUrl
         */
        public String getLabelsUrl() {
            return labelsUrl;
        }

        /**
         * @param labelsUrl the labelsUrl to set
         */
        public void setLabelsUrl(String labelsUrl) {
            this.labelsUrl = labelsUrl;
        }

        /**
         * @return the releasesUrl
         */
        public String getReleasesUrl() {
            return releasesUrl;
        }

        /**
         * @param releasesUrl the releasesUrl to set
         */
        public void setReleasesUrl(String releasesUrl) {
            this.releasesUrl = releasesUrl;
        }

        /**
         * @return the dateCreated
         */
        public Date getDateCreated() {
            return dateCreated;
        }

        /**
         * @param dateCreated the dateCreated to set
         */
        public void setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
        }

        /**
         * @return the dateUpdated
         */
        public Date getDateUpdated() {
            return dateUpdated;
        }

        /**
         * @param dateUpdated the dateUpdated to set
         */
        public void setDateUpdated(Date dateUpdated) {
            this.dateUpdated = dateUpdated;
        }

        /**
         * @return the datePushed
         */
        public Date getDatePushed() {
            return datePushed;
        }

        /**
         * @param datePushed the datePushed to set
         */
        public void setDatePushed(Date datePushed) {
            this.datePushed = datePushed;
        }

        /**
         * @return the gitUrl
         */
        public String getGitUrl() {
            return gitUrl;
        }

        /**
         * @param gitUrl the gitUrl to set
         */
        public void setGitUrl(String gitUrl) {
            this.gitUrl = gitUrl;
        }

        /**
         * @return the sshUrl
         */
        public String getSshUrl() {
            return sshUrl;
        }

        /**
         * @param sshUrl the sshUrl to set
         */
        public void setSshUrl(String sshUrl) {
            this.sshUrl = sshUrl;
        }

        /**
         * @return the cloneUrl
         */
        public String getCloneUrl() {
            return cloneUrl;
        }

        /**
         * @param cloneUrl the cloneUrl to set
         */
        public void setCloneUrl(String cloneUrl) {
            this.cloneUrl = cloneUrl;
        }

        /**
         * @return the svnUrl
         */
        public String getSvnUrl() {
            return svnUrl;
        }

        /**
         * @param svnUrl the svnUrl to set
         */
        public void setSvnUrl(String svnUrl) {
            this.svnUrl = svnUrl;
        }

        /**
         * @return the homepage
         */
        public String getHomepage() {
            return homepage;
        }

        /**
         * @param homepage the homepage to set
         */
        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        /**
         * @return the size
         */
        public Long getSize() {
            return size;
        }

        /**
         * @param size the size to set
         */
        public void setSize(Long size) {
            this.size = size;
        }

        /**
         * @return the language
         */
        public String getLanguage() {
            return language;
        }

        /**
         * @param language the language to set
         */
        public void setLanguage(String language) {
            this.language = language;
        }

        /**
         * @return the hasIssues
         */
        public Boolean getHasIssues() {
            return hasIssues;
        }

        /**
         * @param hasIssues the hasIssues to set
         */
        public void setHasIssues(Boolean hasIssues) {
            this.hasIssues = hasIssues;
        }

        /**
         * @return the hasWiki
         */
        public Boolean getHasWiki() {
            return hasWiki;
        }

        /**
         * @param hasWiki the hasWiki to set
         */
        public void setHasWiki(Boolean hasWiki) {
            this.hasWiki = hasWiki;
        }

        /**
         * @return the hasDownloads
         */
        public Boolean getHasDownloads() {
            return hasDownloads;
        }

        /**
         * @param hasDownloads the hasDownloads to set
         */
        public void setHasDownloads(Boolean hasDownloads) {
            this.hasDownloads = hasDownloads;
        }

        /**
         * @return the hasPages
         */
        public Boolean getHasPages() {
            return hasPages;
        }

        /**
         * @param hasPages the hasPages to set
         */
        public void setHasPages(Boolean hasPages) {
            this.hasPages = hasPages;
        }

        /**
         * @return the forks
         */
        public Integer getForks() {
            return forks;
        }

        /**
         * @param forks the forks to set
         */
        public void setForks(Integer forks) {
            this.forks = forks;
        }

        /**
         * @return the openIssuesCount
         */
        public Integer getOpenIssuesCount() {
            return openIssuesCount;
        }

        /**
         * @param openIssuesCount the openIssuesCount to set
         */
        public void setOpenIssuesCount(Integer openIssuesCount) {
            this.openIssuesCount = openIssuesCount;
        }

        /**
         * @return the openIssues
         */
        public Integer getOpenIssues() {
            return openIssues;
        }

        /**
         * @param openIssues the openIssues to set
         */
        public void setOpenIssues(Integer openIssues) {
            this.openIssues = openIssues;
        }

        /**
         * @return the defaultBranch
         */
        public String getDefaultBranch() {
            return defaultBranch;
        }

        /**
         * @param defaultBranch the defaultBranch to set
         */
        public void setDefaultBranch(String defaultBranch) {
            this.defaultBranch = defaultBranch;
        }

        /**
         * @return the networkCount
         */
        public Integer getNetworkCount() {
            return networkCount;
        }

        /**
         * @param networkCount the networkCount to set
         */
        public void setNetworkCount(Integer networkCount) {
            this.networkCount = networkCount;
        }

        /**
         * @return the subscribersCount
         */
        public Integer getSubscribersCount() {
            return subscribersCount;
        }

        /**
         * @param subscribersCount the subscribersCount to set
         */
        public void setSubscribersCount(Integer subscribersCount) {
            this.subscribersCount = subscribersCount;
        }

        /**
         * @return the organization
         */
        public Organization getOrganization() {
            return organization;
        }

        /**
         * @param organization the organization to set
         */
        public void setOrganization(Organization organization) {
            this.organization = organization;
        }

        /**
         * @return the fullName
         */
        public String getFullName() {
            return fullName;
        }

        /**
         * @param fullName the fullName to set
         */
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }
    
    /**
     * Initialize and read the properties for configuration purposes.
     * 
     * Obtains connector authentication information from properties files.
     * 
     * @throws IOException on file IO errors
     */
    public static void init() throws IOException {
        Properties config = new Properties();
        InputStream stream = null;
        
        try { 
            stream = GitHub.class.getClassLoader().getResourceAsStream("github-connector.properties");
            config.load(stream);
            
            API_KEY=config.getProperty("github.apikey");
            API_USER=config.getProperty("github.user");
        } finally {
            if (null!=stream) stream.close(); stream = null;
        }
    }
    
    /**
     * Construct a GET request to the GitHub API.
     * 
     * @param url the base URL to use
     * @return an HttpGet Object to read project information from
     */
    private static HttpGet gitHubAPIGet(String url) {
        HttpGet get = new HttpGet(url);
        // if authenticated, pass basic authentication header information
        // prevents API access limitations if authenticated
        if ( !"".equals(API_USER) ) {
            String authentication = API_USER + ":" + API_KEY;
            byte[] encoded = Base64.encodeBase64(authentication.getBytes(Charset.forName("ISO-8859-1")));
            get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + new String(encoded));
        }
        return get;
    }
    
    /**
     * Obtain the connection-driven metadata elements from GitHub public API
     * requests.
     * 
     * @param name the GitHub project name; in this case, this should be of
     * the form "owner/project" to access the project API
     * @return a JsonElement of the DOECodeMetadata filled in as possible from
     * the API
     */
    public static JsonElement readProject(String name) {
        DOECodeMetadata md = new DOECodeMetadata();
        Gson gson = new Gson();
        
        try {
            // read authentication token information
            GitHub.init();

            // acquire the SourceForge API response as JSON
            HttpGet get = gitHubAPIGet(GITHUB_BASE_URL + name);

            // Convert the JSON into an Object we can handle
            Repository response = 
                     (Repository) gson.fromJson(HttpUtil.fetch(get), Repository.class);

            // parse the relevant response parts into Metadata
            md.setSoftwareTitle(response.getFullName());
            md.setAcronym(response.getName());
            md.setDescription(response.getDescription());

            if (null!=response.getContributorsUrl()) {
                HttpGet contributor_request = gitHubAPIGet(response.getContributorsUrl());
                Contributor[] contributors = gson.fromJson(HttpUtil.fetch(contributor_request), Contributor[].class);

                for ( Contributor contributor : contributors ) {
                    Developer developer = new Developer();
                    if (null!=contributor.getUrl()) {
                        HttpGet user_request = gitHubAPIGet(contributor.getUrl());
                        User user = gson.fromJson(HttpUtil.fetch(user_request), User.class);

                        developer.setEmail(user.getEmail());
                        developer.setAffiliations(user.getCompany());

                        /** if no User name is present, default to the login name;
                         * otherwise attempt to break into first/last name.
                         */
                        if (null==user.getName()) {
                            developer.setFirstName(user.getLogin());
                            developer.setLastName("(undefined)");
                        } else {
                            int lastSpace = user.getName().lastIndexOf(" ");
                            if ( -1==lastSpace ) {
                                developer.setFirstName(user.getName());
                                developer.setLastName("(undefined)");
                            } else {
                                developer.setFirstName(user.getName().substring(0, lastSpace));
                                developer.setLastName(user.getName().substring(lastSpace+1));
                            }
                        }
                        md.add(developer);
                    }
                }
            }
        } catch ( IOException e ) {
            // here's where you'd warn about the IO error
            log.warn("IO Error reading GitHub information: " + e.getMessage());
            log.warn("Read from " + name);
        }
        
        // send back what we have
        return md.toJson();
    }
}
