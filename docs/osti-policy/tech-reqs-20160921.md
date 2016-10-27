#20160921 Meeting - Metadata Schema Review
**Date: September 21, 2016**

**Time: 10:00 a.m.-11:00 a.m.**

Agenda:
  1. Review of DataCite Metadata
  2. Review of OSTI Metadata

Proceedings:
  1. The software metadata information was reviewed, paying specific attention to the different DataCite tables. Team members discussed different DataCite properties and sub-properties, and whether they appeared to be mandatory, optional, or strongly recommended. After going through the tables, it became evident that some confusing elements needed to be re-worked.
  
    Looking at some of the requirements listed in the DataCite tables led to discussions about specific properties, thereby resulting in determinations of elements to be used for these properties. The site code would be used for the ‘Publisher’ property. The ORCID number and ORCID would be used for the ‘nameIdentifier’ and ‘nameIdentifierScheme’ properties, respectively. For the 'ResourceType' property, a default text to ‘Software’ would be used with a 16-24 character limit to alter the default to include more specifics if needed, with the second mandatory sub-property to be set to ‘Software’. 
  2. The required fields for OSTI metadata were reviewed, and decisions made on whether certain fields should remain a requirement, be changed to optional, or be eliminated completely. Suggestions were made to add in optional text fields for various legacy items and to include a Reference Data section to incorporate items such as documents (papers, data), examples, and tutorials to be added by URLs or uploads. It became apparent after further discussions that multiple media capabilities may be needed in E-link, and that the data structures underneath are designed to handle this. 
  
Conclusions/Actions:
  
- Review and make changes to DataCite Metadata document and plan to merge with OSTI metadata
  
- Edit required fields for OSTI metadata
