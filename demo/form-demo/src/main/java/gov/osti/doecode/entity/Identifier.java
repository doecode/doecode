/*
 */
package gov.osti.doecode.entity;

/**
 *
 * @author ensornl
 */
public class Identifier {
    private String identifierType = "";
    private String relationType = "";
    private String value = "";

    public static final String[] identifierTypes = {
        "ORCID",
        "Email",
        "DOI",
        "URL",
        "AwardNumber"
    };
    public static final String[] relationTypes = {
        "IsPartOf",
        "Contains",
        "References",
        "Identifies"
    };
    
    /**
     * @return the identifierType
     */
    public String getIdentifierType() {
        return identifierType;
    }

    /**
     * @param identifierType the identifierType to set
     */
    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    /**
     * @return the relationType
     */
    public String getRelationType() {
        return relationType;
    }

    /**
     * @param relationType the relationType to set
     */
    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
}
