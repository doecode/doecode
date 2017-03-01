/*
 */
package gov.osti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Contributing Organization information.
 * @author ensornl
 */
@Entity
public class ContributingOrganization extends Organization {
    // each have a Type of contribution
    private Contributor.Type contributorType;
    
    /**
     * @return the type
     */
    @Enumerated (EnumType.STRING)
    public Contributor.Type getContributorType() {
        return contributorType;
    }

    /**
     * @param type the type to set
     */
    public void setContributorType(Contributor.Type type) {
        this.contributorType = type;
    }
    
    
}
