# DOECode Abbreviated Metadata Application Profile
# *DRAFT*

## Product Type

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dctype:Software | *properties listed below | -- | 1 | dcite:resourceType* | Literal | 1 |

## Submitting Organization(s)/Site Ownership Code

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|org:Role | --  | --  | --  | --  | -- | -- |
| -- | dcterms:contributor | org:Organization | -- | -- | -- | -- |
| -- | skos:prefLabel | "Submitting Organization" | 1 - n | dcite:Publisher* | Literal | 1 |
| -- | org:role | org:Role | -- | -- | -- | 

## Sponsoring Organization(s)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|org:Role | --  | --  | --  | --  | -- | -- |
| -- | dcterms:contributor | org:Organization | -- | -- | -- | -- |
| -- | skos:prefLabel | "Sponsoring Organization" | 1 - n | dcite:fundingReference | dcite:funderName | 0 - n |
| -- | org:role | org:Role | -- | -- | -- | 

## Open Source (Y/N)

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:rights | dctype:Software | Literal | 1 | dcite:rights | Literal | 0 |

## Repository Link

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|schema:codeRepository | dctype:Software | URL/URI | 1 | n/a | n/a | n/a |

## Distribution/Access Limitation

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|osti:Access | --  | --  | 1 - n  | --  | -- | -- |
| -- | skos:prefLabel | Literal | -- | -- | -- | -- |
| -- | skos:notation | Literal | -- | -- | -- | -- |

## Developer(s)/Creator

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:creator | dctype:Software | foaf:Person | 1 | dcite:Creator* | dcite:givenName | 1 - n |
||||||dcite:familyName||

## Contributing Organization(s)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|org:Role | --  | --  | 1 - n | --  | -- | -- |
| -- | dcterms:contributor | org:Organization | -- | dcite:Contributor | dcite:contributorName | 0 |
| -- | skos:prefLabel | "Contributing Organization" | -- | dcite:contributorType | "ProjectMember" | -- |
| -- | org:role | org:Role | -- | -- | -- | 

## Originating Research Organization(s)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|org:Role | --  | --  | 1 - n | --  | -- | -- |
| -- | dcterms:contributor | org:Organization | -- | dcite:Contributor | dcite:contributorName | 0 |
| -- | skos:prefLabel | "Originating Research Organization" | -- | dcite:contributorType | "HostingInstitution" | -- |
| -- | org:role | org:Role | -- | -- | -- | 

## DOE Award/Contract Number

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 1 - n | --  | -- | -- |
| -- | adms:schemaAgency | "DOE Contract Number" | -- | dcite:funderIdentifierType | Literal | 0 |
| -- | skos:notation | Literal | -- | dcite:funderIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Software Title/Name

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:title | dctype:Software | Literal | 1 | dcite:title* | Literal | 1 - n |

## Acronym

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:??title | dctype:Software | Literal | 0 | -- | -- | -- |

## Digital Object Identifier (DOI)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 | --  | -- | -- |
| -- | adms:schemaAgency | "DOI" | -- | dcite:identifierType | "DOI" | 1 |
| -- | skos:notation | Literal | -- | dcite:Identifier* | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Date of Issuance

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:date | dctype:Software | Date | 1 | dcite:PublicationYear* | Literal | 1 |

## Description/Abstract

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:description | dctype:Software | Literal | 1 | dcite:description | Literal | 0 - n |

## Related Identifiers

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 - n | --  | -- | -- |
| -- | adms:schemaAgency | Literal [name of identifier] | -- | dcite:relatedIdentifierType | Literal | 0 - n |
| -- | skos:notation | Literal | -- | dcite:relatedIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Country of Origin

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:coverage | dctype:Software | Literal | 0 | dcite:GeoLocation | Literal | 0 - n |

## Subject Category Codes

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:subject | dctype:Software | Literal | 0 - n | dcite:subject | Literal | 0 - n |
|adms:identifier | -- | adms:Identifier | -- | -- | -- | -- |

## Keywords

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|schema:keywords | dctype:Software | Literal | 0 - n | -- | -- | -- |

## *Rights*/Licenses/Legal Notices/Disclaimers

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:rights | dctype:Software | Literal | 1 | dcite:rights | Literal | 0 |

## Rights/*Licenses*/Legal Notices/Disclaimers

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:license | dctype:Software | Literal or URI | 1 | dcite:rightsURI | URI of license | 0 |

## Rights/Licenses/*Legal Notices*/Disclaimers

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|osti:legalNotice | dctype:Software | Literal | 1 | -- | -- | -- |

## Rights/Licenses/Legal Notices/*Disclaimers*

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|osti:disclaimer | dctype:Software | Literal | 1 | -- | -- | -- |

## Version

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:hasVersion | dctype:Software | URL/URI | 0 - n | dcite:srelationType | dcite:isNewVersionOf | 0 - n |
|dcterms:isVersionOf | dctype:Software | URL/URI | 0 - n | -- | dcite:isPreviousVersionOf | -- |

## Recipient/Contractor/POC

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:contactPoint | dctype:Software | foaf:Person | 1 | dcite:Contributor | dcite:contributorName | 0 - n |

## Non-DOE Contract Numbers

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 - n | --  | -- | -- |
| -- | adms:schemaAgency | Literal [name of identifier] | -- | dcite:relatedIdentifierType | Literal | 0 - n |
| -- | skos:notation | Literal | -- | dcite:relatedIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## B&R Code(s)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 - n | --  | -- | -- |
| -- | adms:schemaAgency | "B&R Code" | -- | dcite:relatedIdentifierType | Literal | 0 - n |
| -- | skos:notation | Literal | -- | dcite:relatedIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Site Unique Identifier/Site Accession Number

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 - n | --  | -- | -- |
| -- | adms:schemaAgency | Literal [name of identifier] | -- | dcite:relatedIdentifierType | Literal | 0 - n |
| -- | skos:notation | Literal | -- | dcite:relatedIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Operating System

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|schema:operatingSystem | dctype:Software | Literal | 0 | -- | -- | -- |

## Other Special Requirements

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:requires | dctype:Software | Literal | 0 | -- | -- | -- |

## Related/Auxiliary Software

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:requires | dctype:Software | Literal | 0 | -- | -- | -- |

## Documentation/Other Media

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:references | dctype:Software | foaf:Document | 0 | dcite:relationType | dcite:isDocumentedBy | 0 - n |