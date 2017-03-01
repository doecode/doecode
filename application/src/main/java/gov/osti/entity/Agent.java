package gov.osti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for "Persons" or Agents:  currently parent class for Developers
 * and Contributors.
 * 
 * @author ensornl
 */
@MappedSuperclass
public class Agent implements Serializable {
    private static Logger log = LoggerFactory.getLogger(Agent.class);
    private Long agentId = 0L;
    private Long ownerId;
    private Integer place = 0;
    private String email = "";
    private String affiliations = "";
    private String orcid = "";
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";

    public Agent() {

    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "AGENT_ID")
    @JsonIgnore
    public Long getAgentId() {
        return this.agentId;
    }
    
    public void setAgentId(Long id) {
        this.agentId = id;
    }

    @Column (name="OWNER_ID", nullable = false)
    @JsonIgnore
    public Long getOwnerId() {
        return this.ownerId;
    }
    
    public void setOwnerId(Long id) {
        this.ownerId = id;
    }
    
    public String getFirstName() {
            return firstName;
    }
    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }
    public String getLastName() {
            return lastName;
    }
    public void setLastName(String lastName) {
            this.lastName = lastName;
    }
    public String getMiddleName() {
            return middleName;
    }
    public void setMiddleName(String middleName) {
            this.middleName = middleName;
    }

    @Column (length = 640)
    public String getEmail() {
            return email;
    }
    public void setEmail(String email) {
            this.email = email;
    }

    @Column (length = 1000)
    public String getAffiliations() {
            return affiliations;
    }

    public void setAffiliations(String affiliations) {
            this.affiliations = affiliations;
    }

    public String getOrcid() {
            return orcid;
    }

    public void setOrcid(String orcid) {
            this.orcid = orcid;
    }

    public Integer getPlace() {
            return place;
    }

    public void setPlace(Integer place) {
            this.place = place;
    }
	
}
