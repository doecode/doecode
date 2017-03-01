/*
 */
package gov.osti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Superclass for Organization type relations.
 * 
 * Extended/implemented by ContributingOrganization, SponsoringOrganization,
 * and ResearchOrganization.
 * 
 * @author ensornl
 */
@MappedSuperclass
public class Organization implements Serializable {
    // primary Key
    private Long orgId = 0L;
    // linked owner ID
    private Long ownerId;
    // attributes
    private Integer place = 0;
    private String organizationName;
    @JsonProperty (value="DOE")
    private boolean isDOE = false;
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name="ORG_ID")
    @JsonIgnore
    public Long getOrgId() {
        return this.orgId;
    }
    
    public void setOrgId(Long id) {
        this.orgId = id;
    }
    
    @Column (name = "OWNER_ID", nullable = false)
    @JsonIgnore
    public Long getOwnerId() {
        return this.ownerId;
    }
    
    public void setOwnerId(Long id) {
        this.ownerId = id;
    }
    
    /**
     * @return the organizationName
     */
    @Column (length = 1000, name = "ORGANIZATION_NAME")
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
    @Column (name="DOE")
    public boolean isDOE() {
        return isDOE;
    }

    /**
     * @param isDOE the isDOE to set
     */
    public void setIsDOE(boolean isDOE) {
        this.isDOE = isDOE;
    }

    /**
     * @return the place
     */
    @Column (name = "PLACE")
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
