package gov.osti.entity;

import java.io.Reader;
import java.util.ArrayList;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class DOECodeMetadata {

	private static final Gson serializer = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).serializeNulls().create();
    //private static final Logger log = Logger.getLogger(DOECodeMetadata.class);
	
	
	private transient Long codeId = null;
	private String siteOwnershipCode = null;
	private Boolean openSource = null; 
	private String  repositoryLink = null; 
	//private DOECodeMetadataLists lists = null;
	private ArrayList<Developer> developers = null;
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
	
	
	public DOECodeMetadata(long codeId) {
		this.lookup(codeId);
	}
	
	//for Gson
	public DOECodeMetadata() {
		
	}
	
	public boolean lookup(long codeId) {
		//implement later
		return true;
	}
	
	public void save() {
		//implement later
	}
	
	public JsonElement getJson() {
		return serializer.toJsonTree(this);
	}
	
	public String getJsonString() {
		return serializer.toJson(this);
	}
	
	public static DOECodeMetadata parseJson(Reader json) {
		return serializer.fromJson(json, DOECodeMetadata.class);

	}
	

	public Long getcodeId() {
		return codeId;
	}

	public void setcodeId(Long codeId) {
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

	public ArrayList<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(ArrayList<Developer> developers) {
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
