/*
 */
package gov.osti.connectors.sourceforge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private String name;
    private String url;
    private String summary;
    @JsonProperty("short_description")
    private String shortDescription;
    private String shortname;

    private Person[] developers;

    private Category categories;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @return the shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * @return the shortname
     */
    public String getShortname() {
        return shortname;
    }

    /**
     * @return the developers
     */
    public Person[] getDevelopers() {
        return developers;
    }

    /**
     * @return the categories
     */
    public Category getCategories() {
        return categories;
    }
}
