/*
 */
package gov.osti.connectors.sourceforge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class License {
    private String fullpath;
    private String fullname;
    private String shortname;

    /**
     * @return the fullpath
     */
    public String getFullpath() {
        return fullpath;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @return the shortname
     */
    public String getShortname() {
        return shortname;
    }
}
