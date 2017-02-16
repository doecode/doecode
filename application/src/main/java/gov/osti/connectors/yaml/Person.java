/*
 */
package gov.osti.connectors.yaml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Definition of a Person; Contributor, Developer, or Contact
 * @author ensornl
 */
public class Person {
    @JsonProperty ("firstname")
    private String firstName;
    @JsonProperty ("familyname")
    private String familyName;
    private String email;
    private Identifier orcID;
    private String basedAt;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
     * @return the orcID
     */
    public Identifier getOrcID() {
        return orcID;
    }

    /**
     * @param orcID the orcID to set
     */
    public void setOrcID(Identifier orcID) {
        this.orcID = orcID;
    }

    /**
     * @return the basedAt
     */
    public String getBasedAt() {
        return basedAt;
    }

    /**
     * @param basedAt the basedAt to set
     */
    public void setBasedAt(String basedAt) {
        this.basedAt = basedAt;
    }
    
}
