/*
 */
package gov.osti.connectors.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.osti.connectors.GitHub;
import java.util.Date;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties (ignoreUnknown = true)
public class Repository {
        /** attributes **/
        private Long id;
        private String name=null;
        @JsonProperty("full_name")
        private String fullName = null;
        private Owner owner = null;
        @JsonProperty("private")
        private Boolean isPrivate = false;
        @JsonProperty("html_url")
        private String htmlUrl = null;
        private String description = null;
        @JsonProperty("fork")
        private Boolean isFork = false;
        private String url = null;
        @JsonProperty("forks_url")
        private String forksUrl = null;
        @JsonProperty("collaborators_url")
        private String collaboratorsUrl = null;
        @JsonProperty("teams_url")
        private String teamsUrl = null;
        @JsonProperty("hooks_url")
        private String hooksUrl = null;
        @JsonProperty("issue_events_url")
        private String issueEventsUrl = null;
        @JsonProperty("events_url")
        private String eventsUrl = null;
        @JsonProperty("assignees_url")
        private String assigneesUrl = null;
        @JsonProperty("branches_url")
        private String branchesUrl = null;
        @JsonProperty("tags_url")
        private String tagsUrl = null;
        @JsonProperty("blobs_url")
        private String blobsUrl = null;
        @JsonProperty("git_tags_url")
        private String gitTagsUrl = null;
        @JsonProperty("git_refs_url")
        private String gitReferencesUrl = null;
        @JsonProperty("trees_url")
        private String treesUrl = null;
        @JsonProperty("statuses_url")
        private String statusesUrl = null;
        @JsonProperty("languages_url")
        private String languagesUrl = null;
        @JsonProperty("contributors_url")
        private String contributorsUrl = null;
        @JsonProperty("commits_url")
        private String commitsUrl = null;
        @JsonProperty("comments_url")
        private String commentsUrl = null;
        @JsonProperty("archive_url")
        private String archiveUrl = null;
        @JsonProperty("downloads_url")
        private String downloadsUrl = null;
        @JsonProperty("issues_url")
        private String issuesUrl = null;
        @JsonProperty("pulls_url")
        private String pullsUrl = null;
        @JsonProperty("notifications_url")
        private String notificationsUrl = null;
        @JsonProperty("labels_url")
        private String labelsUrl = null;
        @JsonProperty("releases_url")
        private String releasesUrl = null;
        @JsonProperty("created_at")
        private Date dateCreated = null;
        @JsonProperty("updated_at")
        private Date dateUpdated = null;
        @JsonProperty("pushed_at")
        private Date datePushed = null;
        @JsonProperty("git_url")
        private String gitUrl = null;
        @JsonProperty("ssh_url")
        private String sshUrl = null;
        @JsonProperty("clone_url")
        private String cloneUrl = null;
        @JsonProperty("svn_url")
        private String svnUrl = null;
        private String homepage = null;
        private Long size = 0L;
        private String language = null;
        @JsonProperty("has_issues")
        private Boolean hasIssues = false;
        @JsonProperty("has_wiki")
        private Boolean hasWiki = false;
        @JsonProperty("has_downloads")
        private Boolean hasDownloads = false;
        @JsonProperty("has_pages")
        private Boolean hasPages = false;
        private Integer forks = 0;
        @JsonProperty("open_issues_count")
        private Integer openIssuesCount = 0;
        @JsonProperty("open_issues")
        private Integer openIssues = 0;
        @JsonProperty("default_branch")
        private String defaultBranch = null;
        @JsonProperty("network_count")
        private Integer networkCount = 0;
        @JsonProperty("subscribers_count")
        private Integer subscribersCount = 0;
        private Organization organization = null;
        
        public Repository() {
            
        }

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
