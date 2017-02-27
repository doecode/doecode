/*
 */
package gov.osti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Contributing Organization information.
 * 
 * @author ensornl
 */
@Entity
@Table(name="contributing_organizations")
public class ContributingOrganization extends Organization {
    // each have a Type of contribution
    private Contributor.Type type;

    /**
     * @return the type
     */
    @Enumerated (EnumType.STRING)
    public Contributor.Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Contributor.Type type) {
        this.type = type;
    }
    
    
}
