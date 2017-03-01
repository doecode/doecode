/*
 */
package gov.osti.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * A Generic Identifier for metadata; includes Related Identifiers, BR Codes, etc.
 * 
 * @author ensornl
 */
@Embeddable
public class Identifier implements Serializable {
    /**
     * Enumeration of valid Types for an Identifier.
     */
    public enum Type implements Serializable {
        DOI,
        URL,
        BRCode,
        AwardNumber,
        Email,
        Other;
        
        public String getName() {
            return this.name();
        }
    }
    /**
     * Enumeration of valid Relationship Types for Identifier.
     */
    public enum RelationType implements Serializable {
        IsCitedBy,
        Cites, 
        IsSupplementTo,
        IsSupplementedBy,
        IsContinuedBy, 
        Continues, 
        HasMetadata, 
        IsMetadataFor, 
        IsNewVersionOf, 
        IsPreviousVersionOf, 
        IsPartOf, 
        HasPart, 
        IsReferencedBy,
        References, 
        IsDocumentedBy, 
        Documents, 
        IsCompiledBy, 
        Compiles, 
        IsVariantFormOf, 
        IsOriginalFormOf, 
        IsIdenticalTo, 
        IsReviewedBy, 
        Reviews, 
        IsDerivedFrom, 
        IsSourceOf;
        
        public String getName() {
            return this.name();
        }
    }

    // the specific Type of the Identifier
    private Type identifierType;
    // optional String description of this Identifier
    private String description;
    // the value of the Identifier
    private String identifierValue;
    // the Relationship Type (if any) for this Identifier
    private RelationType relationType;

    public Identifier() {
        
    }
    
    public Identifier(Type idType, String value, RelationType relType) {
        this.identifierType = idType;
        this.identifierValue = value;
        this.relationType = relType;
    }
    
    
    /**
     * @return the type
     */
    @Enumerated (EnumType.STRING)
    public Type getIdentifierType() {
        return identifierType;
    }

    /**
     * @param type the type to set
     */
    public void setIdentifierType(Type type) {
        this.identifierType = type;
    }
    
    /**
     * Get the Description for this Identifier
     * @return the Description
     */
    @Column (length = 500, name="DESCRIPTION")
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Add a description (optional) for this Identifier
     * @param d the Description to use
     */
    public void setDescription(String d) {
        this.description = d;
    }

    /**
     * @return the value
     */
    @Column (length = 1000)
    public String getIdentifierValue() {
        return identifierValue;
    }

    /**
     * @param value the value to set
     */
    public void setIdentifierValue(String value) {
        this.identifierValue = value;
    }

    /**
     * @return the relation
     */
    @Enumerated (EnumType.STRING)
    public RelationType getRelationType() {
        return relationType;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelationType(RelationType relation) {
        this.relationType = relation;
    }
    
}
