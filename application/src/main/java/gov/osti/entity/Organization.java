/*
 */
package gov.osti.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * Superclass for Organization type relations.
 * 
 * @author ensornl
 */
@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Organization implements Serializable {
    // attributes
    private Long organizationId;
    private Long codeId;
    private Integer place = 0;
    private String organizationName;
    private Boolean isDOE = false;
    
    /**
     * @return the organizationName
     */
    @Column (length = 1000)
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * @param organizationName the organizationName to set
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    
    /**
     * @return the isDOE
     */
    public Boolean isDOE() {
        return isDOE;
    }

    /**
     * @param isDOE the isDOE to set
     */
    public void setIsDOE(Boolean isDOE) {
        this.isDOE = isDOE;
    }

    /**
     * @return the organizationId
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId the organizationId to set
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * The link to the DOECodeMetadata master table.
     * 
     * @return the codeId
     */
    @Column (name="codeId", updatable = false, insertable = false)
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
     * @return the place
     */
    public Integer getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(Integer place) {
        this.place = place;
    }
    
}
