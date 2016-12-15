# DOECode Requirements
This directory documents the full set of requirements for the DOECode project. Its structure is broken down into subdirectories for each major component and/or team. 

We are creating many requirements teams to advise us on required feature set of DOE Code. These teams are broken down between DOE, National Laboratory and External Teams.

| Team Name | Description | Assembled |
| --------- | ----------- | --------- |
| Core      | The core group of people tapped by OSTI to provide and analyze requirements | Yes |
| OSTI-Technical | The technical team at OSTI responsible for implementing DOE Code | Yes |
| OSTI-Policy | Policy team at OSTI responsible for DOE Code | Yes |
| DOE-GC | DOE General Counsel | Partially |
| DOE-ASCR | DOE Office of Advanced Scientific Computing Research | No |
| DOE-AT | DOE Applied Technologies Offices | No |
| Labs-Software | Software experts from multiple labs | Partially |
| Labs-Data | Data scientists and consumers from multiple labs | No |
| Labs-Operations | Operational experts from multiple labs | No |
| Labs-HPC | High-Performance Computing researchers from multiple labs | Partially |
| Labs-STI Managers | The current STI managers/Software Points of Contact at each lab | Yes |
| ECP | Representatives of the DOE's Exascale Computing Program | Partially |
| Labs-Commercialization and Technology Transfer | Representatives of multiple laboratories for commercialization and technology transfer. | Partially |
| Labs-Legal | Software or related lawyers from multiple laboratories | Partially |
| University Partners | Representatives of OSTI's University Partners | No |
| Industry Partners | Representatives of OSTI's Industry Partners | No |
| Students | The best and brightest software engineering, computer science and related students in the complex | No |
| Postgraduates | Postdocs, post-masters and post-bachelors appointees who work with software | No |


##Functional Requirements from Technical Discussions
The following requirements describe function requirements of the system that were discovered in interviews with technical stakeholders and/or members of the technical requirements team. Detailed notes are available in the [technical requirements team folder](https://github.com/doecode/doecode/tree/master/docs/osti-technical).
 - Using connectors - "Connections" to ingest engines and digests/repositories should be handled abstractly, not hardwired to backends for any particular vendor.
 - Ability to support multiple repositories
 - Version handling 
 - Auto-population of software metadata using repository links, repository scraping, etc.
 - Account driven submission
 - Details on sending out notifications
 - Repository hosting and creation


##Metadata
The DOE Code team has updated several new requirements for metadata fields for the submission of software. Detailed notes are available in the [policy requirements team folder](https://github.com/doecode/doecode/tree/master/docs/osti-policy).
 - Metadata version 1 - Spreadsheet that shows the list of [proposed metadata fields](https://github.com/doecode/doecode/blob/master/docs/MetaData_Software_Fields%2011_14_16.xlsx), whether these fields will be mandatory or optional, and additional details about these fields provided in the ‘Notes’ column.
 - Creation of a metadata application profile
 - Metadata schema - a rough draft of an XML schema can be found [here](https://github.com/doecode/doecode/blob/master/metadata-schema/XMLSchema/MetadataSchema.xsd)
 
##Submission Models 
A requirement to create ideal submission models for the three scenarios for types of software submissions were made using UML diagrams. The three types include [submission as a grantee]( https://github.com/doecode/doecode/blob/master/models/IdealSubmissionProcess-UML%20Diagram/UML-Submit%20New%20Product%20As%20Grantee.jpg), [submission as a lab researcher or developer/STI POC for a new single submission]( https://github.com/doecode/doecode/blob/master/models/IdealSubmissionProcess-UML%20Diagram/UML-LabResearcher%20Developer%20STI%20POC_New%20Single%20Submission%20.jpg), and [lab STI POC submission(s) through the web API]( https://github.com/doecode/doecode/blob/master/models/IdealSubmissionProcess-UML%20Diagram/UML-Lab%20STI%20POC%20Submission%20Through%20Web%20API.jpg). 

##Wireframes
A requirement to create wireframes to capture the initial concepts and design of various pages of the product was completed by the DOE Code Technical Team. The directory of wireframes can be found [here]( https://github.com/doecode/doecode/tree/master/docs/osti-technical/wireframes). 

##Handling Multiple Media 
The plans for DOECode not only include the ability to link to references (papers, data sets), but also to other documents, manuals, examples, charts, forum links, etc. This would require the system to be able to handle multiple media. The meeting notes for this requirement can be found [here](https://github.com/doecode/doecode/blob/master/docs/osti-technical/tech-reqs-20161007.md). The [whiteboard photo](https://github.com/doecode/doecode/blob/master/docs/osti-technical/20161007%20Meeting%20Photo.jpg) from the meeting is also available. 
