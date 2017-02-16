/*
 */
package gov.osti.connectors.yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 *
 * @author ensornl
 */
public class Organization {
    @JsonProperty
    private String orgName;

    public Organization() {
        
    }
    
    public Organization(String name) {
        this.orgName = name;
    }
    
    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.orgName);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        return ( o instanceof Organization ) ?
           ((Organization)o).getOrgName().equals(this.getOrgName()) : false;
    }
}
