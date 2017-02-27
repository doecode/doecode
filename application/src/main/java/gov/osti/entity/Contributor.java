package gov.osti.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="contributors")
public class Contributor extends Agent {
    /**
     * Static Type of Contributor.  Based on DataCite accepted mapping values.
     */
    public enum Type {
        ContactPerson,
        DataCollector, 
        DataCurator,  
        DataManager,  
        Distributor, 
        Editor, 
        HostingInstitution,
        Producer,
        ProjectLeader,
        ProjectManager, 
        ProjectMember,
        RegistrationAgency,
        RegistrationAuthority,
        RelatedPerson,
        Researcher,
        ResearchGroup,
        RightsHolder,
        Sponsor,
        Supervisor,
        WorkPackageLeader,
        Other 
    }
    
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private Type contributorType;

    @Enumerated (EnumType.STRING)
    public Type getContributorType() {
            return contributorType;
    }

    public void setContributorType(Type contributorType) {
            this.contributorType = contributorType;
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

}
