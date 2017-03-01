/*
 */
package gov.osti.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

/**
 * A non-Person sponsoring entity.
 * 
 * @author ensornl
 */
//@Embeddable
//public class SponsoringOrganization implements Serializable {
@Entity 
public class SponsoringOrganization extends Organization {
    // Award numbers
    private List<String> awardNumbers = new ArrayList<>();
    
    /**
     * Set of AWARD NUMBERS for this Sponsor
     * @return the awardNumbers
     */
    @ElementCollection
    @CollectionTable(
            name = "AWARD_NUMBERS",
            joinColumns=@JoinColumn(name="ORG_ID")
    )
    @Column (name="AWARD_NUMBERS")
    public List<String> getAwardNumbers() {
        return awardNumbers;
    }

    /**
     * @param awardNumbers the awardNumbers to set
     */
    public void setAwardNumbers(List<String> awardNumbers) {
        this.awardNumbers = awardNumbers;
    }
}
