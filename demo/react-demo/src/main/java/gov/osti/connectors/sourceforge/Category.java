/*
 */
package gov.osti.connectors.sourceforge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author ensornl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private License[] license;

    /**
     * @return the license
     */
    public License[] getLicense() {
        return license;
    }
}
