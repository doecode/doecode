/*
 */
package gov.osti.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A non-Person sponsoring entity.
 * 
 * @author ensornl
 */
@Entity
@Table(name="sponsoring_organizations")
public class SponsoringOrganization extends Organization {
    // Award numbers
    private String awardNumbers;

    /**
     * Set of AWARD NUMBERS for this Sponsor
     * @return the awardNumbers
     */
    public String getAwardNumbers() {
        return awardNumbers;
    }

    /**
     * @param awardNumbers the awardNumbers to set
     */
    public void setAwardNumbers(String awardNumbers) {
        this.awardNumbers = awardNumbers;
    }
}
