package gov.osti.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gov.osti.database.DBOps;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="metadata")
public class DOECodeMetadata implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(DOECodeMetadata.class.getName());

//	private static final Gson serializer = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    //private static final Logger log = Logger.getLogger(DOECodeMetadata.class);

	private Long codeId = 0L;
	private String siteOwnershipCode = null;
	private Boolean openSource = null;
	private String  repositoryLink = null;
	//private DOECodeMetadataLists lists = null;
	
	private List<Developer> developers = new ArrayList<>();
	/*private ArrayList<Contributor> contributors = null;
	private ArrayList<Sponsor> sponsors = null;
	private ArrayList<ContributingOrganization> contributingOrganizations = null;
	*/

	private String originatingResearchOrganizations = null;
	//private String contractNumber = null; will be included on sponsor agent entity
	private String softwareTitle = null;
	private String acronym = null;
	private String doi = null;
	//private Date date_of_issuance = null;
	private String description = null;
	private String relatedIdentifiers = null;
	private String countryOfOrigin = null;
	//private String subjectCategoryCodes = null; what is this really?
	private String keywords = null;
	private String disclaimers = null;
	private String license = null;
	private String recipientName = null;
	private String recipientEmail = null;
	private String recipientPhone = null;
	private String recipientOrg = null;
	//private String nonDoeContractNumbers = null; will be included on sponsor agent entity
	private String siteAccessionNumber = null;
	private String otherSpecialRequirements = null;
	private String relatedSoftware = null;
	//private String documentation = null; this will be structured in some way tbd per the metadata document
        
        // Jackson object mapper
        private static final ObjectMapper mapper = new ObjectMapper()
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .setSerializationInclusion(Include.NON_NULL);

	//for Gson
	public DOECodeMetadata() {

	}

	/**
	 * lookup- Syntactic sugar for DatabaseOps function. Tries to lookup metadata based off provided codeId.
	 * @param codeId
	 * @return Returns metadata for the code ID or null if none exists
	 */
	public static DOECodeMetadata lookup(long codeId) {
		return DBOps.lookupMetadata(codeId);
	}

	/**
	 * save - Syntactic sugar for DatabaseOps function. Persists the metadata object to memory.
	 */
	public void save() {
		//implement later
                log.info("Saving record to database: " + this.getSoftwareTitle());
		DBOps.saveMetadata(this);
	}

	public static void delete(long codeId) {
		DBOps.deleteMetadata(codeId);
	}

	public void delete() {
		DBOps.deleteMetadata(this.codeId);
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


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
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

	public String getOriginatingResearchOrganizations() {
		return originatingResearchOrganizations;
	}
	public void setOriginatingResearchOrganizations(String originatingResearchOrganizations) {
		this.originatingResearchOrganizations = originatingResearchOrganizations;
	}

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
	public String getRelatedIdentifiers() {
		return relatedIdentifiers;
	}
	public void setRelatedIdentifiers(String relatedIdentifiers) {
		this.relatedIdentifiers = relatedIdentifiers;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
/*	public String getSubjectCategoryCodes() {
		return subjectCategoryCodes;
	}
	public void setSubjectCategoryCodes(String subjectCategoryCodes) {
		this.subjectCategoryCodes = subjectCategoryCodes;
	}*/
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
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

        @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
        @JoinColumn(name="codeId", nullable = false, updatable = false)
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

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
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

	/*
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}*/





}
