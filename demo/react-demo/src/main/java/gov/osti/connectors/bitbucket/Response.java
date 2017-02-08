/*
 */
package gov.osti.connectors.bitbucket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * The BitBucket API response information.
 * 
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private String scm;
    private String website;
    @JsonProperty("has_wiki")
    private Boolean hasWiki = false;
    private String name;
    private String language;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("has_issues")
    private Boolean hasIssues = false;
    private User owner;
    @JsonProperty("updated_on")
    private Date updatedOn;
    private Long size;
    private String type;
    private String description;

    /**
     * The Source Code Management strategy or program in use for this Project.
     * @return the scm the SCM used
     */
    public String getScm() {
        return scm;
    }

    /**
     * A project related website
     * @return the website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Whether or not a wiki is present for this Project.
     * 
     * @return the hasWiki
     */
    public Boolean getHasWiki() {
        return hasWiki;
    }

    /**
     * The name of the project.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * The programming language used, if set
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * The full name of the project
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Whether or not there are Issues tracked in this project
     * @return the hasIssues
     */
    public Boolean getHasIssues() {
        return hasIssues;
    }

    /**
     * The base Owner of the project
     * @return the owner's User Object
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Date the project was updated
     * @return the updatedOn
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }

    /**
     * The size of the project
     * @return the size
     */
    public Long getSize() {
        return size;
    }

    /**
     * The type of the project
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * A description of the project
     * @return the description
     */
    public String getDescription() {
        return description;
    }
}
