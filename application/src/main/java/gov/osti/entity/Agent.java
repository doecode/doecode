package gov.osti.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Agent implements Serializable {
    private static Logger log = LoggerFactory.getLogger(Agent.class);
    private Long codeId = 0L;
    private Long agentId = 0L;
	private Integer place = 0;
	private String email = "";
	private String affiliations = null;
	private String orcid = null;
        
	public Agent() {
		
	}
        
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        public Long getAgentId() {
            return agentId;
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

    /**
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
     * @param agentId the agentId to set
     */
    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }
	
}
