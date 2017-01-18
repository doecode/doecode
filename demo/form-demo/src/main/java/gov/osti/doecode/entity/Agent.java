/*
 */
package gov.osti.doecode.entity;

/**
 *
 * @author ensornl
 */
public class Agent {
    private String firstName = "";
    private String lastName = "";
    private String fullName = "";
    private String agentTypeCode = "";
    private String agentTypeSpecific = "";
    private String email = "";
    private String affiliation = "";
    private String orcid = "";
    private String funderId = "";

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the agentTypeCode
     */
    public String getAgentTypeCode() {
        return agentTypeCode;
    }

    /**
     * @param agentTypeCode the agentTypeCode to set
     */
    public void setAgentTypeCode(String agentTypeCode) {
        this.agentTypeCode = agentTypeCode;
    }

    /**
     * @return the agentTypeSpecific
     */
    public String getAgentTypeSpecific() {
        return agentTypeSpecific;
    }

    /**
     * @param agentTypeSpecific the agentTypeSpecific to set
     */
    public void setAgentTypeSpecific(String agentTypeSpecific) {
        this.agentTypeSpecific = agentTypeSpecific;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the affiliation
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * @param affiliation the affiliation to set
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * @return the orcid
     */
    public String getOrcid() {
        return orcid;
    }

    /**
     * @param orcid the orcid to set
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    /**
     * @return the funderId
     */
    public String getFunderId() {
        return funderId;
    }

    /**
     * @param funderId the funderId to set
     */
    public void setFunderId(String funderId) {
        this.funderId = funderId;
    }
}
