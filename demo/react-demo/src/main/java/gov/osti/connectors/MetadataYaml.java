/*
 */
package gov.osti.connectors;

import gov.osti.connectors.yaml.Identifier;
import gov.osti.connectors.yaml.Person;
import gov.osti.connectors.yaml.Organization;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base YAML metadata object for parsing.
 * 
 * @author ensornl
 */
@JsonIgnoreProperties (ignoreUnknown = true)
public class MetadataYaml {
    private static Logger log = LoggerFactory.getLogger(MetadataYaml.class);
    @JsonProperty(required=true)
    private String title;
    @JsonProperty("date")
    private Date dateCreated;
    private String description;
    private String license;
    private int openSourceProject = 0;
    private int governmentWideReuseProject = 0;
    private String codeRepository;
    @JsonProperty ("doeIdentifier")
    private List<Identifier> doeIdentifiers = new ArrayList<>();
    @JsonProperty("developer")
    private List<Person> developers = new ArrayList<>();
    @JsonProperty("submittingOrganization")
    private List<Organization> submittingOrganizations = new ArrayList<>();
    @JsonProperty("sponsoringOrganization")
    private List<Organization> sponsoringOrganizations = new ArrayList<>();
    @JsonProperty("researchOrganization")
    private List<Organization> researchOrganizations = new ArrayList<>();
    
    // optional ones
    private List<String> keywords = new ArrayList<>();
    private Identifier doi;
    @JsonProperty("additionalIdentifier")
    private List<Identifier> additionalIdentifiers = new ArrayList<>();
    @JsonProperty("contributor")
    private List<Person> contributors = new ArrayList<>();
    private String hasVersion;
    private String isVersionOf;
    private Person contactPerson;
    private String requirements;
    private String relatedSoftware;
    private String relatedDocumentation;
    private String countryOfOrigin;
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * @return the openSourceProject
     */
    public int getOpenSourceProject() {
        return openSourceProject;
    }

    /**
     * @param openSourceProject the openSourceProject to set
     */
    public void setOpenSourceProject(int openSourceProject) {
        this.openSourceProject = openSourceProject;
    }

    /**
     * @return the governmentWideReuseProject
     */
    public int getGovernmentWideReuseProject() {
        return governmentWideReuseProject;
    }

    /**
     * @param governmentWideReuseProject the governmentWideReuseProject to set
     */
    public void setGovernmentWideReuseProject(int governmentWideReuseProject) {
        this.governmentWideReuseProject = governmentWideReuseProject;
    }

    /**
     * @return the codeRepository
     */
    public String getCodeRepository() {
        return codeRepository;
    }

    /**
     * @param codeRepository the codeRepository to set
     */
    public void setCodeRepository(String codeRepository) {
        this.codeRepository = codeRepository;
    }

    /**
     * @return the doeIdentifier
     */
    public List<Identifier> getDoeIdentifiers() {
        return doeIdentifiers;
    }

    /**
     * @param doeIdentifier the doeIdentifier to set
     */
    public void setDoeIdentifiers(List<Identifier> doeIdentifier) {
        this.doeIdentifiers = doeIdentifier;
    }

    /**
     * @return the developers
     */
    public List<Person> getDevelopers() {
        return developers;
    }

    /**
     * @param developers the developers to set
     */
    public void setDevelopers(List<Person> developers) {
        this.developers = developers;
    }

    /**
     * @return the submittingOrganization
     */
    public List<Organization> getSubmittingOrganizations() {
        return submittingOrganizations;
    }

    /**
     * @param submittingOrganization the submittingOrganization to set
     */
    public void setSubmittingOrganizations(List<Organization> submittingOrganization) {
        this.submittingOrganizations = submittingOrganization;
    }

    /**
     * @return the sponsoringOrganization
     */
    public List<Organization> getSponsoringOrganizations() {
        return sponsoringOrganizations;
    }

    /**
     * @param sponsoringOrganization the sponsoringOrganization to set
     */
    public void setSponsoringOrganizations(List<Organization> sponsoringOrganization) {
        this.sponsoringOrganizations = sponsoringOrganization;
    }

    /**
     * @return the researchOrganization
     */
    public List<Organization> getResearchOrganizations() {
        return researchOrganizations;
    }

    /**
     * @param researchOrganization the researchOrganization to set
     */
    public void setResearchOrganizations(List<Organization> researchOrganization) {
        this.researchOrganizations = researchOrganization;
    }

    /**
     * @return the keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the doi
     */
    public Identifier getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(Identifier doi) {
        this.doi = doi;
    }

    /**
     * @return the additionalIdentifiers
     */
    public List<Identifier> getAdditionalIdentifiers() {
        return additionalIdentifiers;
    }

    /**
     * @param additionalIdentifiers the additionalIdentifiers to set
     */
    public void setAdditionalIdentifiers(List<Identifier> additionalIdentifiers) {
        this.additionalIdentifiers = additionalIdentifiers;
    }

    /**
     * @return the contributors
     */
    public List<Person> getContributors() {
        return contributors;
    }

    /**
     * @param contributors the contributors to set
     */
    public void setContributors(List<Person> contributors) {
        this.contributors = contributors;
    }

    /**
     * @return the hasVersion
     */
    public String getHasVersion() {
        return hasVersion;
    }

    /**
     * @param hasVersion the hasVersion to set
     */
    public void setHasVersion(String hasVersion) {
        this.hasVersion = hasVersion;
    }

    /**
     * @return the isVersionOf
     */
    public String getIsVersionOf() {
        return isVersionOf;
    }

    /**
     * @param isVersionOf the isVersionOf to set
     */
    public void setIsVersionOf(String isVersionOf) {
        this.isVersionOf = isVersionOf;
    }

    /**
     * @return the contactPerson
     */
    public Person getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contactPerson the contactPerson to set
     */
    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * @return the requirements
     */
    public String getRequirements() {
        return requirements;
    }

    /**
     * @param requirements the requirements to set
     */
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    /**
     * @return the relatedSoftware
     */
    public String getRelatedSoftware() {
        return relatedSoftware;
    }

    /**
     * @param relatedSoftware the relatedSoftware to set
     */
    public void setRelatedSoftware(String relatedSoftware) {
        this.relatedSoftware = relatedSoftware;
    }

    /**
     * @return the relatedDocumentation
     */
    public String getRelatedDocumentation() {
        return relatedDocumentation;
    }

    /**
     * @param relatedDocumentation the relatedDocumentation to set
     */
    public void setRelatedDocumentation(String relatedDocumentation) {
        this.relatedDocumentation = relatedDocumentation;
    }

    /**
     * @return the countryOfOrigin
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * @param countryOfOrigin the countryOfOrigin to set
     */
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
    
    /**
     * Export this Object as JSON.
     * 
     * @return JSON of this Object
     */
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            log.warn("JSON Processing Error: " + ex.getMessage());
            return null;
        }
    }
}
