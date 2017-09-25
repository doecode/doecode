# DOECode Abbreviated Metadata Application Profile
# *DRAFT*

## Sponsoring Organization(s)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|org:Role | --  | --  | --  | --  | -- | -- |
| -- | dcterms:contributor | org:Organization | -- | -- | -- | -- |
| -- | skos:prefLabel | "Sponsoring Organization" | 1 - n | dcite:fundingReference | dcite:funderName | 0 - n |
| -- | org:role | org:Role | -- | -- | -- | 

## Availability

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:rights | dctype:Software | Literal | 1 | dcite:rights | Literal | 0 |

## Repository Link/Landing Page

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|schema:codeRepository | dctype:Software | URL/URI | 1 | n/a | n/a | n/a |

## Developer(s)

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:creator | dctype:Software | foaf:Person | 1 - n | dcite:Creator* | dcite:givenName | 1 - n |
||||||dcite:familyName||

## Contributing Organization(s)

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|org:Role | --  | --  | 0 - n | --  | -- | -- |
| -- | dcterms:contributor | org:Organization | -- | dcite:Contributor | dcite:contributorName | 0 |
| -- | skos:prefLabel | "Contributing Organization" | -- | dcite:contributorType | "ProjectMember" | -- |
| -- | org:role | org:Role | -- | -- | -- | 

## Contributor(s)
|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
| dcterms: contributor | dctype: Sofware | foaf: person | 0 - n | dcite: Contributor | dcite: contributorName| 0 |

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

## Software Title

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:title | dctype:Software | Literal | 1 | dcite:title* | Literal | 1 - n |

## Short Title or Acronym

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

## Release Date

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

## Keywords

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|schema:keywords | dctype:Software | Literal | 0 - n | -- | -- | -- |

## Licenses

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:license | dctype:Software | Literal or URI | 1 | dcite:rightsURI | URI of license | 0 |

## Contact

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:contactPoint | dctype:Software | foaf:Person | 1 | dcite:Contributor | dcite:contributorName | 0 - n |

## Additional Contract/Award Numbers

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

## FWP Number
|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 - n | --  | -- | -- |
| -- | adms:schemaAgency | "FWP Number" | -- | dcite:relatedIdentifierType | Literal | 0 - n |
| -- | skos:notation | Literal | -- | dcite:relatedIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Site Accession Number

|Proposed field | Property | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|adms:Identifier | --  | --  | 0 - n | --  | -- | -- |
| -- | adms:schemaAgency | Literal [name of identifier] | -- | dcite:relatedIdentifierType | Literal | 0 - n |
| -- | skos:notation | Literal | -- | dcite:relatedIdentifier | Literal | -- |
| -- | adms:identifier | adms:Identifier | -- | -- | -- | 

## Other Special Requirements

|Proposed field | Property of | Expected Value | OSTI Cardinality | DataCite Field | DataCite Expected Value | Datacite Cardinality |
|:------:|:---------:|:------:|:------:|:------:|:------:|:------:|
|dcterms:requires | dctype:Software | Literal | 0 | -- | -- | -- |

