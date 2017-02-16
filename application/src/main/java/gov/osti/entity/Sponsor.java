/*
 */
package gov.osti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Sponsoring Agents:  either persons or organizations; contains whether or not
 * DOE, a funder ID if any, and award number(s) as applicable.
 * 
 * @author ensornl
 */
@Entity
@Table (name="sponsors")
public class Sponsor extends Agent {
    private String awardNumbers = "";
    private String funderID = "";
    private Boolean isDOE = false;

    /**
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

    /**
     * @return the funderID
     */
    public String getFunderID() {
        return funderID;
    }

    /**
     * @param funderID the funderID to set
     */
    public void setFunderID(String funderID) {
        this.funderID = funderID;
    }
    
    /**
     * Determine whether or not this is a DOE-based Sponsor.
     * @return true if so, false if not
     */
    @Transient
    public Boolean isDOE() {
        return isDOE;
    }
    
    /**
     * @return the isDOE
     */
    @Column (name="isDOE")
    public Boolean getIsDOE() {
        return isDOE;
    }

    /**
     * @param isDOE the isDOE to set
     */
    public void setIsDOE(Boolean isDOE) {
        this.isDOE = isDOE;
    }
    
}
