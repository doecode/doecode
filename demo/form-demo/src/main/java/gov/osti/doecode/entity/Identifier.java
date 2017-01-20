/*
 */
package gov.osti.doecode.entity;

import java.util.Objects;

/**
 *
 * @author ensornl
 */
public class Identifier {
    private Long id = 0L;
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

    public boolean isPersisted() {
        return (getId()!=0L);
    }
    
    /**
     * Determine equality based on ID value.
     * 
     * @param o the Object to compare to
     * @return true if the same, false if not
     */
    @Override
    public boolean equals(Object o) {
        if ( o instanceof Identifier ) {
            return Objects.equals(( (Identifier)o).getId(), getId());
        }
        
        return false;
    }

    /**
     * Unique HASH based on the only identifying field we care about.
     * 
     * @return a unique value for this Object
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
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
}
