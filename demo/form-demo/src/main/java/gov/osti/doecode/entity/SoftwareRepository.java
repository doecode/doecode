/*
 */
package gov.osti.doecode.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ensornl
 */
public class SoftwareRepository {
    private Long id = 0L;
    private String siteOwnershipCode = "";
    private Boolean openSource = false;
    private String acronym = "";
    private String doi = "";
    private String countryCode = "";
    private String subjectCategoryCode = "";
    private String keywords = "";
    private String rights = "";
    private String license = "";
    private String siteAccessionNumber = "";
    private String operatingSystem = "";
    private String otherRequirements = "";
    private String relatedSoftware = "";
    private String documentation = "";
    private String name = "";
    private String url = "";
    private String description = "";
    private List<Agent> agents = new ArrayList<>();
    private List<Identifier> identifiers = new ArrayList<>();

    // faking it
    private Long id_id = 0L;
    private Long agent_id = 0L;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param title the title to set
     */
    public void setName(String title) {
        this.name = title;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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
     * @return the agents
     */
    public List<Agent> getAgents() {
        return agents;
    }

    /**
     * @param agents the agents to set
     */
    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public boolean add(Agent a) {
        if (0==a.getId()) a.setId(++agent_id);
        
        int index = agents.indexOf(a);
        if ( -1==index ) {
            return agents.add(a);
        } else {
            agents.add(index, a);
            return true;
        }
    }
    
    public boolean remove(Agent a) {
        System.out.println("Delete: " + a.getId());
        return agents.remove(a);
    }
    
    public boolean add(Identifier id) {
        if (0==id.getId()) id.setId(++id_id);
        
        int index = identifiers.indexOf(id);
        if ( -1==index ) {
            return identifiers.add(id);
        } else {
            identifiers.add(index, id);
            return true;
        }
    }
    
    public boolean remove(Identifier id) {
        return identifiers.remove(id);
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the siteOwnershipCode
     */
    public String getSiteOwnershipCode() {
        return siteOwnershipCode;
    }

    /**
     * @param siteOwnershipCode the siteOwnershipCode to set
     */
    public void setSiteOwnershipCode(String siteOwnershipCode) {
        this.siteOwnershipCode = siteOwnershipCode;
    }

    /**
     * @return the openSource
     */
    public Boolean getOpenSource() {
        return openSource;
    }

    /**
     * @param openSource the openSource to set
     */
    public void setOpenSource(Boolean openSource) {
        this.openSource = openSource;
    }

    /**
     * @return the acronym
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     * @param acronym the acronym to set
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the subjectCategoryCode
     */
    public String getSubjectCategoryCode() {
        return subjectCategoryCode;
    }

    /**
     * @param subjectCategoryCode the subjectCategoryCode to set
     */
    public void setSubjectCategoryCode(String subjectCategoryCode) {
        this.subjectCategoryCode = subjectCategoryCode;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the rights
     */
    public String getRights() {
        return rights;
    }

    /**
     * @param rights the rights to set
     */
    public void setRights(String rights) {
        this.rights = rights;
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
     * @return the siteAccessionNumber
     */
    public String getSiteAccessionNumber() {
        return siteAccessionNumber;
    }

    /**
     * @param siteAccessionNumber the siteAccessionNumber to set
     */
    public void setSiteAccessionNumber(String siteAccessionNumber) {
        this.siteAccessionNumber = siteAccessionNumber;
    }

    /**
     * @return the operatingSystem
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * @param operatingSystem the operatingSystem to set
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * @return the otherRequirements
     */
    public String getOtherRequirements() {
        return otherRequirements;
    }

    /**
     * @param otherRequirements the otherRequirements to set
     */
    public void setOtherRequirements(String otherRequirements) {
        this.otherRequirements = otherRequirements;
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
     * @return the documentation
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * @param documentation the documentation to set
     */
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    /**
     * @return the identifiers
     */
    public List<Identifier> getIdentifiers() {
        return identifiers;
    }

    /**
     * @param identifiers the identifiers to set
     */
    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }
    
}
