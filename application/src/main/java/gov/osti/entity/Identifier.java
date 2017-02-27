/*
 */
package gov.osti.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ensornl
 */
@Entity
@Table (name = "IDENTIFIERS")
public class Identifier implements Serializable {
    
    public enum Type {
        DOI,
        URL,
        BRCode,
        AwardNumber,
        Email,
        Other
    }
    public enum RelationType {
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
        IsSourceOf 
    }

    private Long id;
    private Long codeId;
    private Type identifierType;
    private String value;
    private RelationType relationType;

    public Identifier() {
        
    }
    
    public Identifier(Long id, Long codeId, Type idType, String value, RelationType relType) {
        this.id = id;
        this.codeId = codeId;
        this.identifierType = idType;
        this.value = value;
        this.relationType = relType;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the codeId
     */
    public Long getCodeId() {
        return codeId;
    }

    /**
     * @param codeId the codeId to set
     */
    public void setCodeId(Long codeId) {
        this.codeId = codeId;
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
     * @return the value
     */
    @Column (length = 1000)
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
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
