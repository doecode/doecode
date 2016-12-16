# Requirements for

The development of includes a significant requirements management activity to determine the needs of the community. The primary means of gathering requirements is through requirements gathering interviews with teams of individuals that represent different groups in the community. These teams include employees of the Department of Energy and the National Laboratories. Members of the organizations are included on multiple "External Teams," with canonical examples including industry and academic partners. Each team was designed to include four or five members, but practical considerations have resulted in teams of roughly eight to ten members.

Teams are interviewed either in teleconferences or in face-to-face meetings (with preference going to the former) that last for one two to hours. Each interview includes a briefing on the current state of the project and an informal discussion with team members. The teams are specifically questioned about where the current
system - the Energy Science and Technology Software Center - fails to meet their needs. These "pain points" are explored further in follow up meetings, by email, or by members of the Core, OSTI-Technical, or OSTI-Policy teams. A more rigorous requirements gathering methodology might demand that a formal questionnaire be 
developed, that no briefing of be presented, or other steps be taken to eliminate bias in the requirements. Given the current state of the market for this type of product and the interest of the community, the DOE Code team elected to forego such additional steps were not warranted at this time. 

The full list of DOE Code requirements teams is provided below.

| Team Name | Description | Assembled |
| --------- | ----------- | --------- |
| Core | The core group of people tapped by OSTI to provide and analyze requirements | Yes |
| OSTI-Technical | The technical team at OSTI responsible for implementing DOE Code | Yes |
| OSTI-Policy | Policy team at OSTI responsible for DOE Code | Yes |
| DOE-GC | DOE General Counsel | Partially |
| DOE-ASCR | DOE Office of Advanced Scientific Computing Research | Partially |
| DOE-AT | DOE Applied Technologies Offices | No |
| Labs-Software | Software experts from multiple labs | Yes |
| Labs-Data | Data scientists and consumers from multiple labs | No |
| Labs-Operations | Operational experts from multiple labs | No |
| Labs-HPC | High-Performance Computing researchers from multiple labs | Partially |
| Labs-STI Managers | The current STI managers/Software Points of Contact at each lab | Yes |
| ECP | Representatives of the DOE's Exascale Computing Program | Partially |
| Labs-Commercialization and Technology Transfer | Representatives of multiple laboratories for commercialization and technology transfer. | Yes |
| Labs-Legal | Software or related lawyers from multiple laboratories | Yes |
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
The plans for not only include the ability to link to references (papers, data sets), but also to other documents, manuals, examples, charts, forum links, etc. This would require the system to be able to handle multiple media. The meeting notes for this requirement can be found [here](https://github.com/doecode/doecode/blob/master/docs/osti-technical/tech-reqs-20161007.md). The [whiteboard photo](https://github.com/doecode/doecode/blob/master/docs/osti-technical/20161007%20Meeting%20Photo.jpg) from the meeting is also available. 
