package gov.osti.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="metadata")
public class DOECodeMetadata implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(DOECodeMetadata.class.getName());

    // Attributes
    private Long codeId = 0L;
    private String siteOwnershipCode = null;
    private Boolean openSource = null;
    private String  repositoryLink = null;

    // set of Access Limitations (Strings)
    private List<String> accessLimitations = new ArrayList<>();
    
    // Child tables -- persons
    private List<Developer> developers = new ArrayList<>();
    private List<Contributor> contributors = new ArrayList<>();

    //  Child tables -- organizations
    private List<SponsoringOrganization> sponsoringOrganizations = new ArrayList<>();
    private List<ContributingOrganization> contributingOrganizations = new ArrayList<>();
    private List<ResearchOrganization> researchOrganizations = new ArrayList<>();

    // Child table -- identifiers
    private List<Identifier> identifiers = new ArrayList<>();

    private Date dateOfIssuance = null;
    private String softwareTitle = null;
    private String acronym = null;
    private String doi = null;
    private String description = null;
    private String countryOfOrigin = null;
    private String keywords = null;
    private String disclaimers = null;
    private String license = null;
    private String recipientName = null;
    private String recipientEmail = null;
    private String recipientPhone = null;
    private String recipientOrg = null;
    private String siteAccessionNumber = null;
    private String otherSpecialRequirements = null;
    private String relatedSoftware = null;
    // persistence dates
    private Date dateRecordAdded;
    private Date dateRecordUpdated;

    // Jackson object mapper
    private static final ObjectMapper mapper = new ObjectMapper()
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .setSerializationInclusion(Include.NON_NULL);

    //for Gson
    public DOECodeMetadata() {

    }

    /**
     * getJson - Serializes the Metadata Object into a JSON.
     * @return A JsonElement representing the metadata's internal state in JSON
     */
    public JsonNode toJson() {
        return mapper.valueToTree(this);
    }

    /**
     * Parses JSON in the request body of the reader into a DOECodemetadata object.
     * @param reader - A request reader containing JSON in the request body.
     * @return A DOECodeMetadata object representing the data of the JSON in the request body.
     * @throws IOException on JSON parsing errors (IO errors)
     */
    public static DOECodeMetadata parseJson(Reader reader) throws IOException {
        return mapper.readValue(reader, DOECodeMetadata.class);
    }

    /**
     * Primary key for Metadata, the unique identifier value.
     * 
     * @return the unique ID value for this record
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "CODE_ID")
    public Long getCodeId() {
            return codeId;
    }

    public void setCodeId(Long codeId) {
            this.codeId = codeId;
    }

    public String getSiteOwnershipCode() {
            return siteOwnershipCode;
    }
    public void setSiteOwnershipCode(String siteOwnershipCode) {
            this.siteOwnershipCode = siteOwnershipCode;
    }

    public Boolean getOpenSource() {
            return openSource;
    }
    public void setOpenSource(Boolean openSource) {
            this.openSource = openSource;
    }
    public String getRepositoryLink() {
            return repositoryLink;
    }
    public void setRepositoryLink(String repositoryLink) {
            this.repositoryLink = repositoryLink;
    }

    /**
     * Obtain the set of Access Limitation values for this record.
     * @return a List of Access Limitation values
     */
    @ElementCollection
    @CollectionTable(
            name = "ACCESS_LIMITATIONS",
            joinColumns=@JoinColumn(name="CODE_ID")
    )
    @Column (name="ACCESS_LIMITATION")
    public List<String> getAccessLimitations() {
        return this.accessLimitations;
    }
    
    /**
     * Set the Access Limitations for this record.
     * @param limitations a set of Access Limitations to store
     */
    public void setAccessLimitations(List<String> limitations) {
        this.accessLimitations = limitations;
    }
    
    /**
     * Get all the Contributors for this Metadata.
     * @return the Contributor List
     */
//    @ElementCollection
//    @CollectionTable(
//        name="CONTRIBUTORS",
//        joinColumns=@JoinColumn(name="CODE_ID")
//    )
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name="OWNER_ID", referencedColumnName = "CODE_ID")
    public List<Contributor> getContributors() {
        return this.contributors;
    }

    /**
     * Get all the Sponsoring Organizations for this Metadata
     * @return a List of Sponsoring Organizations
     */
//    @ElementCollection
//    @CollectionTable(
//            name="SPONSORING_ORGANIZATIONS",
//            joinColumns=@JoinColumn(name="CODE_ID")
//    )
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name ="OWNER_ID", referencedColumnName = "CODE_ID")
    public List<SponsoringOrganization> getSponsoringOrganizations() {
        return this.sponsoringOrganizations;
    }

    /**
     * Get all the Contributing Organizations
     * @return the List of Contributing Organizations
     */
//    @ElementCollection
//    @CollectionTable(
//            name="CONTRIBUTING_ORGANIZATIONS",
//            joinColumns=@JoinColumn(name="CODE_ID")
//    )
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "OWNER_ID", referencedColumnName = "CODE_ID")
    public List<ContributingOrganization> getContributingOrganizations() {
        return this.contributingOrganizations;
    }
    
    /**
     * Get all the Research Organizations
     * @return a List of Research Organizations
     */
//    @ElementCollection
//    @CollectionTable(
//            name="RESEARCH_ORGANIZATIONS",
//            joinColumns=@JoinColumn(name="CODE_ID")
//    )
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name="OWNER_ID", referencedColumnName = "CODE_ID")
    public List<ResearchOrganization> getResearchOrganizations() {
        return this.researchOrganizations;
    }

    @Column (length = 1000)
    public String getSoftwareTitle() {
            return softwareTitle;
    }
    public void setSoftwareTitle(String softwareTitle) {
            this.softwareTitle = softwareTitle;
    }
    public String getAcronym() {
            return acronym;
    }
    public void setAcronym(String acronym) {
            this.acronym = acronym;
    }
    public String getDoi() {
            return doi;
    }
    public void setDoi(String doi) {
            this.doi = doi;
    }
    @Column (length = 4000, name = "description")
    public String getDescription() {
            return description;
    }
    public void setDescription(String description) {
            this.description = description;
    }

    public void setIdentifiers(List<Identifier> identifiers) {
        this.identifiers = identifiers;
    }

    @ElementCollection
    @CollectionTable(
            name="IDENTIFIERS",
            joinColumns=@JoinColumn(name="CODE_ID")
    )
    public List<Identifier> getIdentifiers() {
        return this.identifiers;
    }

    public String getCountryOfOrigin() {
            return countryOfOrigin;
    }
    public void setCountryOfOrigin(String countryOfOrigin) {
            this.countryOfOrigin = countryOfOrigin;
    }
    @Column (length = 500)
    public String getKeywords() {
            return keywords;
    }
    public void setKeywords(String keywords) {
            this.keywords = keywords;
    }
    @Column (length = 1000)
    public String getDisclaimers() {
            return disclaimers;
    }
    public void setDisclaimers(String disclaimers) {
            this.disclaimers = disclaimers;
    }
    public String getLicense() {
            return license;
    }
    public void setLicense(String license) {
            this.license = license;
    }

    /**
     * Get all the Developers for this Metadata
     * @return the List of Developers
     */
//    @ElementCollection
//    @CollectionTable(
//            name="DEVELOPERS",
//            joinColumns=@JoinColumn(name="CODE_ID")
//    )
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name="OWNER_ID", referencedColumnName = "CODE_ID")
    public List<Developer> getDevelopers() {
            return developers;
    }

    /**
     * Add a single Developer to the in-memory items; if place is not set,
     * set it to the end of the current list.
     *
     * @param d the Developer to add
     * @return the Object we just added
     */
    public Developer add(Developer d) {
        if (0==d.getPlace())
            d.setPlace(developers.size()+1);

        developers.add(d);

        return d;
    }

    public ResearchOrganization add(ResearchOrganization o) {
        if (0==o.getPlace())
            o.setPlace(researchOrganizations.size()+1);

        researchOrganizations.add(o);

        return o;
    }

    public SponsoringOrganization add(SponsoringOrganization o) {
        if (0==o.getPlace())
            o.setPlace(sponsoringOrganizations.size()+1);

        sponsoringOrganizations.add(o);

        return o;
    }

    public ContributingOrganization add(ContributingOrganization o) {
        if (0==o.getPlace())
            o.setPlace(contributingOrganizations.size()+1);

        contributingOrganizations.add(o);

        return o;
    }

    public Contributor add(Contributor c) {
        if (0==c.getPlace())
            c.setPlace(contributors.size()+1);

        contributors.add(c);

        return c;
    }

    public void setContributingOrganizations(List<ContributingOrganization> list) {
        Integer place = 0;
        for ( ContributingOrganization o : list ) {
            if (0==o.getPlace())
                o.setPlace(++place);
        }
        this.contributingOrganizations = list;
    }

    public void setResearchOrganizations(List<ResearchOrganization> list) {
        Integer place = 0;
        for ( ResearchOrganization o : list ) {
            if (0==o.getPlace())
                o.setPlace(++place);
        }
        this.researchOrganizations = list;
    }

    public void setSponsoringOrganizations(List<SponsoringOrganization> list) {
        Integer place = 0;
        for ( SponsoringOrganization o : list ) {
            if (0==o.getPlace())
                o.setPlace(++place);
        }
        this.sponsoringOrganizations = list;
    }

    public void setContributors(List<Contributor> list) {
        Integer place = 0;
        for ( Contributor c : list ) {
            if (0==c.getPlace())
                c.setPlace(++place);
        }
        this.contributors = list;
    }

    /**
     * Add entire List at once; make sure to keep Place up to date properly.
     * 
     * @param devlist a List of Developers to set
     */
    public void setDevelopers(List<Developer> devlist) {
        // ensure that place is tracked appropriately
        Integer place = 0;
        for ( Developer d : devlist ) {
            if (0==d.getPlace())
                d.setPlace(++place);
        }
            this.developers = devlist;
    }

    public String getRecipientName() {
            return recipientName;
    }
    public void setRecipientName(String recipientName) {
            this.recipientName = recipientName;
    }
    public String getRecipientEmail() {
            return recipientEmail;
    }
    public void setRecipientEmail(String recipientEmail) {
            this.recipientEmail = recipientEmail;
    }
    public String getRecipientPhone() {
            return recipientPhone;
    }
    public void setRecipientPhone(String recipientPhone) {
            this.recipientPhone = recipientPhone;
    }
    public String getRecipientOrg() {
            return recipientOrg;
    }
    public void setRecipientOrg(String recipientOrg) {
            this.recipientOrg = recipientOrg;
    }

    public String getSiteAccessionNumber() {
            return siteAccessionNumber;
    }
    public void setSiteAccessionNumber(String siteAccessionNumber) {
            this.siteAccessionNumber = siteAccessionNumber;
    }

    public String getOtherSpecialRequirements() {
            return otherSpecialRequirements;
    }
    public void setOtherSpecialRequirements(String otherSpecialRequirements) {
            this.otherSpecialRequirements = otherSpecialRequirements;
    }
    public String getRelatedSoftware() {
            return relatedSoftware;
    }
    public void setRelatedSoftware(String relatedSoftware) {
            this.relatedSoftware = relatedSoftware;
    }
    
    public void setDateOfIssuance(Date date) {
        this.dateOfIssuance = date;
    }
    
    @Column (name="date_of_issuance")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
    public Date getDateOfIssuance() {
        return this.dateOfIssuance;
    }

    public void setDateRecordAdded(Date date) {
        this.dateRecordAdded = date;
    }

    public void setDateRecordAdded() {
        setDateRecordAdded(new Date());
    }

    @Column (name="date_record_added", nullable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'")
    public Date getDateRecordAdded() {
        return dateRecordAdded;
    }

    public void setDateRecordUpdated(Date date) {
        this.dateRecordUpdated = date;
    }

    public void setDateRecordUpdated() {
        setDateRecordUpdated(new Date());
    }

    @Column (name="date_record_updated", nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    @JsonFormat
      (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'")
    public Date getDateRecordUpdated() {
        return dateRecordUpdated;
    }

    /**
     * method to automatically set both date added and updated at persistence time.
     */
    @PrePersist
    void createdAt() {
        setDateRecordAdded();
        setDateRecordUpdated();
    }

    /**
     * Set the date updated prior to update.
     */
    @PreUpdate
    void updatedAt() {
        setDateRecordUpdated();
    }
        
}
