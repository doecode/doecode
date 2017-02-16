/*
 */
package gov.osti.connectors.yaml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ensornl
 */
public class Identifier {
    @JsonProperty
    private String identName;
    @JsonProperty
    private String identNumber;

    /**
     * @return the identName
     */
    public String getIdentName() {
        return identName;
    }

    /**
     * @param identName the identName to set
     */
    public void setIdentName(String identName) {
        this.identName = identName;
    }

    /**
     * @return the identNumber
     */
    public String getIdentNumber() {
        return identNumber;
    }

    /**
     * @param identNumber the identNumber to set
     */
    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }
}
