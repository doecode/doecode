# DOECode Metadata Application Profile
## *DRAFT*

This is a draft application profile for the descriptive metadata properties attached to objects in DOECode. 

Existing vocabularies are reused whenever possible. 

Example: https://www.w3.org/2001/sw/wiki/SKOS/Datasets

## NAMESPACES
DOECode uses the following namespaces:

|Prefix   | Namespace                                   |
|:--------|:-------------------------------------------:|
| adms    | http://www.w3.org/ns/adms#                  |
| cdg     | https://code.gov/#/policy-guide/docs/compliance/inventory-code |
| dcterms | http://purl.org/dc/terms/                   |
| dctype  | http://purl.org/dc/dcmitype/                |
| foaf    | http://xmlns.com/foaf/0.1/                  |
| org     | http://www.w3.org/ns/org#                   |
| osti    | http://example.com/osti/namespace/          |
| rdf     | http://www.w3.org/1999/02/22-rdf-syntax-ns# |
| rdfs    | http://www.w3.org/2000/01/rdf-schema#       |
| schema  | http://schema.org/                          |
| skos    | http://www.w3.org/2004/02/skos/core#        |


## DOMAIN MODEL 
Placeholder for Diagram of DOECode data model:
[Diagram](imagesLocation/image_file_name.png)


## CLASSES

A class is a mechanism defining a group of resources of a particular type. A resource which is a member of a particular class of resources is called an instance of that class. A common convention is to capitalize the names of classes and to write the names of properties in camelCase. Proposed classes for DOECode:

dctype:Software 

org:Organization 

org:Role

adms:Identifier 

foaf:Document 

foaf:Person 

?custom osti:Access class? 


## ELEMENTS
Label: a human-readable label for the metadata field. *This does not correspond to fields in the GUI*

Definition : What this field is for 

Refinement: if applicable, to indicate additional schemes for granularity, clarity

Scheme: if applicable, any controlled vocabs used to populate the field

Property: the RDF value of the metadata element (e.g. dc:title)

Usage: description of how the property should be used

Cardinality: the requirement and number of properties that can exist 

(1 = required and not repeatable, 1 - n, required and repeatable, 0 - 1, optional and not repeatable, 0 - n = optional and repeatable)


| Label      		 | *Product Type*                                                         |
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Declares type of resource                                              |
|Scheme              | n/a                                                                    |
|Property            | dctype:Software                                                        |
|Usage               | will always be dctype:Software unless DOECode extends type submissions |
|Cardinality         | 1                                                                      | 

```json
"@type": "dctype:Software",
```

| Label      		 | *Organization Name*                                                       
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | States name of organization                                            |
|Annotation          | skos:prefLabel, skos:altLabel, skos:notation                           |
|Scheme              | n/a                                                                    |
|Property            | org:Organization                                                       |
|Usage               | It is recommended that SKOS lexical labels should be used to label the Organization. In particular skos:prefLabel for the primary (e.g. legally recognized name), skos:altLabel for alternative names (acronyms, trading names, colloquial names) and skos:notation to denote codes from a code list. |
|Cardinality         | 1 - n                                                                  | 

```json
{
 "@type": "org:Organization",
 "skos:prefLabel": "Oak Ridge National Laboratory",
 "skos:altLabel": "ORNL"
}
```

| Label        	     | *Organizational Role*                                                  | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | States role(s) of organization                                         |
|Annotation	     | skos:prefLabel, skos:altLabel
|Scheme              | n/a  |
|Property            | org:Role |
|Usage               | It is common for roles to be arranged in some taxonomic structure. The normal SKOS lexical properties should be used when labelling the Role. Additional descriptive properties for the Role may be added by extension vocabularies.  |
|Cardinality         | 1 - n                                                                  | 



| Label        		 | *Identifier*                                                           | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Identifier of a given resource                                         |
|Annotation          | skos:notation, adms:schemaAgency, dcterms:created, dcterms:creator     |
|Scheme              |  n/a  |
|Property            | adms:Identifier                                                        |
|Usage               | In RDF this is expressed using the following properties: - the content string should be provided using skos:notation; - use dcterms:creator to link to a class describing the agency that manages the identifier scheme or adms:schemaAgency to provide the name as a literal. Although not part of the ADMS conceptual model, it may be useful to provide further properties to the Identifier class such as dcterms:created to provide the date on which the identifier was issued. |
|Cardinality         | 1 - n                                                                  |

EXAMPLE
```json
"adms:Identifier":
[
 {"adms:schemaAgency": "ORCiD",
  	"skos:notation": "0000-0001-5848-6881"},
 {"adms:schemaAgency": "B&R Code",
	"skos:notation": "NN4003010" },
 {"adms:schemaAgency": "DOE Contract",
 	"skos:notation": "AC05-84OR21400"}
]
```

| Label              | *Repository Link*                                                      | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | URL to the repository where the un-compiled, human readable code and related code is located (SVN, github, CodePlex).                                      |
|Scheme              | n/a   |
|Property            | schema:codeRepository                                                  |
|Usage               |  |
|Cardinality         | 1 |


| Label              |  Government Wide Reuse                                                 |
|:------------------ |:-----------------------------------------------------------------------|
|Definition          | A value indicating whether or not the project is built for government-wide reuse.|
|Scheme              | Boolean                                                                |
|Property            | cdg:governmentWideReuseProject                                         |
|Usage               | 0: The project is not built for government-wide reuse. 1: The project is built for government-wide reuse. Default value will be 1 unless access limitation field determines otherwise.|
|Cardinality         | 1 |



| Label        		 | *Distribution/Access Limitation*                                   | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | *CREATE CUSTOM SKOS ConceptScheme FOR DOE ACCESS CONCEPTS*            |
|Scheme              | n/a                                                                    |
|Property            | osti:Access                                                        |
|Usage               | x |
|Cardinality         | 1                                                                      |	

| Label        		 | *Developer(s)/Creator/Contributor/Contact Point*                                            |
|:-----------------------|:------------------------------------------------------------------|
|Definition              | 
|Scheme                  | n/a
|Property                | foaf:Person
|Annotation              | dcterms:creator, dcterms:contributor, adms:contactPoint, foaf:firstName, foaf:familyName, foaf:mbox_sha1sum |
|Cardinality             | 1 - n                                                             |	

```json
"dcterms:creator": [
   {
   "@type": "foaf:Person",
   "foaf:firstName": "Nancy",
   "foaf:familyName": "Fancy",
   }
]
```

| Label        		 | *Title*                                                            | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The name given to the resource. Title will be a name by which the resource is formally known. |
|Scheme              | n/a                                                                    |
|Property            | dcterms:title                                                          |
|Usage               | n/a |
|Cardinality         | 1                                                                      |	


| Label              | *Date*                                                                 |
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A date associated with an event in the life cycle of the resource. Typically, Date will be associated with the creation or availability of the resource.  |
|Scheme              | ISO 8601 [Date and Time Formats, W3C Note, http://www.w3.org/TR/NOTE- datetime]  |
|Property            | dcterms:date, dcterms:created, dcterms:issued, dcterms:modified                                           |
|Usage               | Recommended best practice for encoding the date value is defined in a profile of ISO 8601 [Date and Time Formats, W3C Note, http://www.w3.org/TR/NOTE-datetime] and follows the YYYY-MM-DD format. |	
|Cardinality         | 1 |


| Label        		 | *Description*                                                          | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | An account of the content of the resource. Description may include but is not limited to: an abstract, table of contents, reference to a graphical representation of content or a free-text account of the content. |
|Scheme              | N/A   |
|Property            | dcterms:description                                                    |
|Usage               | Descriptive information can be copied or automatically extracted from the item if there is no abstract or other structured description available. Although the source of the description may be a web page or other structured text with presentation tags, it is generally not good practice to include HTML or other structural tags within the Description element. |
|Cardinality         | 1 |


| Label        		 | *Country of Origin*                                                    | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | States Country of ?  [Author? Submitting org?]                         |
|Scheme              | Getty Thesaurus of Geographic Names,                                   |
|Property            | dcterms:coverage                                                       |
|Usage               | Coverage will typically include spatial location (a place name or geographic co-ordinates), temporal period (a period label, date, or date range) or jurisdiction (such as a named administrative entity). Recommended best practice is to select a value from a controlled vocabulary (for example, the Thesaurus of Geographic Names). Where appropriate, named places or time periods should be used in preference to numeric identifiers such as sets of co-ordinates or date ranges. |	
|Cardinality         | 0 - 1                                                                  |


| Label        		 | *Subjects*                                                             | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The topic of the content of the resource.                              |
|Scheme              | LCSH? International Energy Subject Thesaurus?                          |
|Property            | dcterms:subject                                                        |
|Usage               | Typically, a Subject will be expressed as keywords or key phrases or classification codes that describe the topic of the resource. Recommended best practice is to select a value from a controlled vocabulary or formal classification scheme. |
|Cardinality         | 0 - n                                                                  |	


| Label        		 | *Keywords*                                                          | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Keywords or tags used to describe this content.                        |
|Scheme              | n/a                                                                    |
|Property            | schema:keywords                                                        |
|Usage               | Multiple entries in a keywords list are typically delimited by commas. |
|Cardinality         | 0 - n                                                                  |


| Label        		 | *Rights*                                                               | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Information about rights held in and over the resource. Typically a Rights element will contain a rights management statement for the resource, or reference a service providing such information. Rights information often encompasses Intellectual Property Rights (IPR), Copyright, and various Property Rights.   |
|Scheme              |  n/a  |
|Property            | dcterms:rights                                                         |
|Usage               | The Rights element may be used for either a textual statement (e.g., "Open Source"), or a URL pointing to a rights statement, or a combination, when a brief statement and a more lengthy one are available. |		
|Cardinality         | 1  |




| Label        		 | *License*                                                               | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A legal document giving official permission to do something with the resource.   |
|Scheme              |  n/a  |
|Property            | dcterms:license   |
|Usage               | Recommended best practice is to identify the license using a URI. License is designed to allow the inclusion of specific licensed uses to be specified. An example would be a resource that was available to be used freely but not for reproduction within commercial applications. |	
|Cardinality         | 1 - n |

Example:
```xml
dcterms:license="http://creativecommons.org/licenses/by-nc-nd/2.0/legalcode"
dcterms:license="Licensed for use under Creative Commons Attribution 2.0."
```


| Label              | *Legal Notices*  |
|:-------------------|:--------------------------------------------------------------------------|
|Definition          |  An official legal statement acknowledging sponsorship and/or data rights.  Respective SIACs, or originating sites, issue their own statements as legally appropriate.|
|Property            | osti:legalNotices   |
|Usage               | example: "This computer software has been developed under sponsorship of the U.S. Department of Energy." |	
|Cardinality         | 1 - n |
 


| Label | *Disclaimers* |
|:-------------------|:--------------------------------------------------------------------------|
|Definition          | An official legal statement declaring any additional conditions under which the software is to be distributed apart from those stated in the license.  Respective SIACs, or originating sites, issue their own statements as legally appropriate.  |
|Property            | osti:disclaimers  |
|Usage               | example: "Neither the United States Government nor the United States Department of Energy, nor any of their employees, makes any warranty, express or implied, or assumes any legal liability or responsibility for the accuracy, completeness, or usefulness of any information, apparatus, product, or process disclosed, or represents that its use would not infringe privately owned rights." |
|Cardinality         | 1 - n |



| Label        		 | *Version*                                                              | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The described resource is a version, edition, or adaptation of the referenced resource. Changes in version imply substantive changes in content rather than differences in format.                                           |
|Scheme              | n/a                                                                    |
|Property            | dcterms:hasVersion / dcterms:isVersionOf                               |
|Usage               | Potential use for multiple versions is the standard rdf:Alt container (or rdf:Seq or rdf:Bag) as a blank node containing the ordered or unordered versions |
|Cardinality         | 0 - n  |

Example:
```xml
<dcterms:hasVersion>
<rdf:Alt rdf:about="http://www.github.com/Software">
	<rdf:_1 rdf:resource=“github.com/Version2”>
	<rdf:_2 rdf:resource=“github.com/Version3”>
	<rdf:_3 rdf:resource=“github.com/Version4”>
```


| Label        	     | *Operating System*                                                     | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Operating systems supported (Windows 7, OSX 10.6, Android 1.6).        |
|Scheme              | n/a                                                                    |
|Property            | schema:operatingSystem                                                 |
|Usage               | x |
|Cardinality         | 0 - 1                                                                  |	


| Label              | *Documentation*                                                        | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Class for any type of document related to the software described.      |
|Scheme              | n/a                                                                    |
|Property            | foaf:Document                                                          |
|Usage               | The Document class is loosely defined by W3C. Additional elements may be used to clarify attributes of the document, such as dcterms:title, dcterms:date, etc.  |
|Cardinality         | 0 - n                                                                  |	

Example:
```json
 {
  "@type": "foaf:Document",
  "dcterms:title": "Software Example Technical Documentation"
 }
```

| Label        		 | *Requirements*                                                         | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A related resource that is required by the described resource to support its function, delivery, or coherence.                                         |
|Scheme              | n/a                                                                    |
|Property            | dcterms:requires                                                       |
|Usage               | x |
|Cardinality         | 0 - n                                                                  |

| Label        		 | *Auxiliary software*                                                   | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The described resource is referenced, cited, or otherwise pointed to by the referenced resource, The described resource references, cites, or otherwise points to the referenced resource. |
|Scheme              | URI                                                                    |
|Property            | dcterms:isReferencedBy, dcterms:references                                 |
|Usage               | It is recommended that the value should be a URI. |
|Cardinality         | 0 - n                                                                  |

Example:
```xml
<dc:title>Expressing Simple Dublin Core in RDF/XML</dc:title>
<dcterms:references rdf:resource="http://www.w3.org/TR/REC-rdf-syntax"></dcterms:references>
```   
