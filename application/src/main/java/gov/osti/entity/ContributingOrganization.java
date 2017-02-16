package gov.osti.entity;

public class ContributingOrganization extends Agent{
	private String organizationName = null;
	private String contributorType = null;
	
	public ContributingOrganization() {
		
	}


	public String getOrganizationName() {
		return organizationName;
	}



	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}



	public String getContributorType() {
		return contributorType;
	}

	public void setContributorType(String contributorType) {
		this.contributorType = contributorType;
	}
	
	
	
	
}
