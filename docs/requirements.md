# Requirements for DOE Code

The development of includes a significant requirements management activity to determine the needs of the community. The primary means of gathering requirements is through requirements gathering interviews with teams of individuals that represent different groups in the community. These teams include employees of the Department of Energy and the National Laboratories. Members of the organizations are included on multiple "External Teams," with canonical examples including industry and academic partners. Each team was designed to include four or five members, but practical considerations have resulted in teams of roughly eight to ten members.

Teams are interviewed either in teleconferences or in face-to-face meetings (with preference going to the former) that last for one two to hours. Each interview includes a briefing on the current state of the project and an informal discussion with team members. The teams are specifically questioned about where the current
system - the Energy Science and Technology Software Center (ESTSC) - fails to meet their needs. These "pain points" are explored further in follow up meetings, by email, or by members of the Core, OSTI-Technical, or OSTI-Policy teams. A more rigorous requirements gathering methodology might demand that a formal questionnaire be developed, that no briefing of be presented, or other steps be taken to eliminate bias in the requirements. Given the current state of the market for this type of product and the interest of the community, the DOE Code team elected to forego such additional steps were not warranted at this time. The OSTI-Technical and OSTI-Policy teams meet much more frequently than the others team, gathering at OSTI headquarters every two weeks on average. 

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
| Post-graduates | Post-docs, post-masters and post-bachelors appointees who work with software | No |

## The Prime Directive

The foremost requirement of DOE Code - the project's "Prime Directive" - is to engage the community in the design, development, deployment and other aspects of the project. This also includes outreach at conferences, with site visits or in other places as required. Community engagement is critical to the success of the project.

## Requirements from Technical Discussions and Sources

Initial requirements for the system were provided by members of the OSTI management and staff after receiving feedback from the community about the ESTSC during special workshops in early 2016. These requirements were summarized in two vision documents: Jay Jay Billings' [whitepaper](core/billings_doecode_whitepaper.pdf) and OSTI Director Brian Hitson's [blog article](https://www.osti.gov/ostiblog/osti-developing-open-source-social-coding-platform-doe-scientific-software). Hitson's blog article is the best reference for a discussion on the reasoning behind the project.

The initial requirements have been reviewed and expanded by the OSTI Technical Requirements team, which is a team of technical experts at OSTI plus Mr. Billings. Many additional requirements have been gathered in technical interviews with staff at the national laboratories. Detailed notes are available in the [technical requirements team folder](https://github.com/doecode/doecode/tree/master/docs/osti-technical). These requirements include, in no particular order, that DOE Code shall
 - archive software repositories, metadata, and associated Scientific and Technical Information (STI) in accord with OSTI's mandate.
 - be [open source](https://github.com/doecode/doecode).
 - link to the original source for the software distribution so long as the link is "live" and provide a backup copy if not.
 - the ability to search software products quickly and easily.
 - connect to common open source repositories and repository services (e.g. - GitHub, Bitbucket, etc.).
 - establish DOE community "groups" or "organizations" in common public services for software (e.g. - a DOE GitHub "organization").
 - connect abstractly to ingest engines and digests/repositories, not through a hard-wired mechanism, such that the product can accommodate back-end changes.
 - support multiple version control repositories.
 - support creating and hosting version control repositories at OSTI.
 - support creating and hosting version control repositories with public services (e.g. - GitHub).
 - handle multiple versions of software releases.
 - automatically populate software metadata fields by gathering information from the repository itself.
 - require accounts and authentication for submission.
 - manage and streamline the submission workflow in support of DOE order 241.4.
 - modify the submission workflow to support submission by researchers with notifications to technical, legal, and STI contacts at the submitting organization.
 - provide process notifications during the submission workflow.
 - support submissions from Labs and Grantees in individual project and batch modes.
 - provide digital upload and download capabilities.
 - allow for tracking "released" codes as well as codes that are in open development but not necessarily "released."
 - link software to projects, people, data, publications, and other elements of STI.
 - provide links "non-standard" types of STI that capture parts of the software development lifecycle including [documents, manuals, examples, charts, forums and other items.](https://github.com/doecode/doecode/blob/master/docs/osti-technical/tech-reqs-20161007.md)
 - integrate common social media elements into the service.
 - provide a web Application Programming Interface (API) to support programmatic access to the service for research, analytics or other purposes.
 - link to Lab or Grantee points of contact for proprietary code distribution.
 - support standard, server-based software activities such as but not necessarily including continuous integration, performance and security analysis, and provisioning on cloud or leadership-class resources.
 - provide the ability to create and manage lists of projects for monitoring purposes.
 - provide an online data analytics dashboard for querying and analyzing the database of software products.
 - support author identification and pseudonyms by cataloging different identification types such as GitHub usernames and ORCID Identification Numbers.
 - separate and specific metrics and analytics reporting capabilities for the research and program management communities
 -	expand social coding platform to include embedding blogging, news feeds, and other social sharing (“Publish to Twitter”) features
 -	IDE (Eclipse and others) Integration
 -	archiving and support for runtime environments
 -	provisioning and experiment integration for code and runtime environment execution
 - have 2-stage verification for entry vs. correctness. Something must be entered in all required fields to show up to be indexed.
 - have license drop down list to match what [GitHub uses](https://github.com/blog/1530-choosing-an-open-source-license). 
 - submitted code(s) must be scanned for vulnerabilities at some point in the submission lifecycle

### Wireframes

The OSTI-Technical requirements team developed a set of [wireframe diagrams]( https://github.com/doecode/doecode/tree/master/docs/osti-technical/wireframes) for DOE Code to investigate requirements that might not otherwise arise in interviews and around the layout of the website itself. This process determined that the DOE Code web portal shall contain the following pages:
 - A home page with search features, system news feed, success stories and other interesting information.
 - An about page that describes the purpose of DOE Code and other information, including its contents and features and how to obtain the source code.
 - A communications page for sharing news and other communications.
 - An account dashboard for users that includes a news feed about their projects, associated projects, and projects of interest.
 - User and author profile pages with contact and account information as well as links to other relevant STI contributions.
 - Account management services for users and administrators.
 - A contact page with information on how to speak to OSTI about the project and service.
 - Online, automated account creation page.
 - An API documentation page.
 - A software profile page for each software product in the database that displays the software metadata stored for that product.

## Requirements from a Policy Perspective

The most important policy requirement is that DOE Code [shall support DOE Order 241.4.](https://www.osti.gov/stip/241.4) In addition, investigations by the OSTI-Policy team have determined that DOE Code shall
 - not charge a cost recovery fee.
 - support updated metadata for 241.4 that reflects modern software development.
 - provide a Metadata Application Profile.
 - provide a mapping that describes the compatibility of DOE Code metadata with common metadata schemas such as DataCite. 
 - support the software license assigned by the copyright holder/originating institution instead of relicensing under an OSTI license.

## Metadata

Detailed information on proposed changes to the metadata schema for DOE 241.4 are available in the [policy requirements team folder](https://github.com/doecode/doecode/tree/master/docs/osti-policy).
 - [Metadata version 1](https://github.com/doecode/doecode/blob/master/docs/osti-policy/MetaData_Software_Fields%2011_14_16.xlsx) - Spreadsheet that shows the list of proposed metadata fields, whether these fields will be mandatory or optional, and additional details about these fields provided in the ‘Notes’ column.
 - [Metadata schema](https://github.com/doecode/doecode/blob/master/metadata-schema/XMLSchema/MetadataSchema.xsd) - a rough draft of an XML schema
 
## Submission Models 
A requirement to create ideal submission models for the three scenarios for types of software submissions were made using UML diagrams. The three types include submission as a grantee, submission as a lab researcher or developer/STI point of contact, batch submissions through the web API. 

![Submission as a grantee](../models/IdealSubmissionProcess-UML%20Diagram/UML-Submit%20New%20Product%20As%20Grantee.jpg) 

![Submission as a lab researcher or developer/STI POC for a new single submission](../models/IdealSubmissionProcess-UML%20Diagram/UML-LabResearcher%20Developer%20STI%20POC_New%20Single%20Submission%20.jpg)

![Lab STI POC submission(s) through the web API](../models/IdealSubmissionProcess-UML%20Diagram/UML-Lab%20STI%20POC%20Submission%20Through%20Web%20API.jpg) 

## Requirements from Communications and Technology Transfer Discussions

Detailed notes from the Communications and Tech Transfer meetings are available in the [team folder]( https://github.com/doecode/doecode/tree/master/docs/comm-techtransfer). Conversations with the Communications and Technology Transfer team have determined that DOE Code shall
-	include a ‘save’ feature while filling out the submission form
-	replace the use of CDs with digital capabilities as much as possible
-	involve lab technical staff to test the product 

## Requirements from meetings with the DOE Code Core Team

Discussions with the Core team have determined that DOE Code shall include the following requirements. Detailed notes are available in the [core team folder]( https://github.com/doecode/doecode/tree/master/docs/core).
-	automate submission process as much as possible to keep a low overhead
-	keep metadata in line with other metadata schemas
-	have visual representation of metadata schema
-	build connectors, i.e. archiving logic/processing, from popular repository software
-	address cyber concerns with open access project that supports OUO material storage

## Requirements from discussions with the DOE-GC Team

Meetings with the DOE-General Counsel team have determined that DOE Code shall include the following requirements. Detailed notes are available in the [DOE-GC team folder]( https://github.com/doecode/doecode/tree/master/docs/doe-gc).
-	become more transparent with awarding offices and sites on software created
-	support the software license assigned by the copyright holder/originating institution instead of relicensing under an OSTI license
-	distribute old codes that are out of commercialization if no longer in use by labs
 
## Requirements from meetings with the Labs-HPC Team

Detailed notes from the Labs-High Performance Computing meetings are available in the [team folder]( https://github.com/doecode/doecode/tree/master/docs/labs-hpc). Discussions with the Labs-HPC team have determined that DOE Code shall
-	keep information/links fresh as open source community moves to other services 
-	support hosting private repositories
-	maintain association with lab specific release numbers

## Requirements from discussions with the Labs-Legal Team

Discussions with the Labs-Legal team have determined that DOE Code shall include the following requirements. Detailed notes are available in the [team folder]( https://github.com/doecode/doecode/tree/master/docs/labs-legal).
-	provide easier accessibility for submission
-	improve searching capabilities
-	be reliable and standardized

## Requirements from meetings with the Labs-STI Managers Team

Detailed notes from the Labs-STI Managers meetings are available in the [stip team folder]( https://github.com/doecode/doecode/tree/master/docs/stip). Conversations with the team have determined that DOE Code shall
-	accept DOIs generated from Zenodo and other sources
-	streamline batch submission for limited software 
-	make submitting a new version easier for closed source software




