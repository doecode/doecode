# DOECode Metadata Application Profile
## *DRAFT*

This is a draft application profile for the descriptive metadata properties attached to objects in DOECode. 

Existing vocabularies are reused whenever possible. 

Example:https://www.w3.org/2001/sw/wiki/SKOS/Datasets

## NAMESPACES
DOECode uses the following namespaces:

|Prefix   | Namespace                                   |
|:--------|:-------------------------------------------:|
| adms    | http://www.w3.org/ns/adms#                  |
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
!Diagram of DOECode data model:
[Diagram](imagesLocation/image_file_name.png)


## CLASSES

A class is a mechanism defining a group of resources of a particular type. A resource which is a member of a particular class of resources is called an instance of that class. A common convention is to capitalize the names of classes and to write the names of properties in camelCase. 

dctype:Software 

org:Organization 

adms:Identifier 

foaf:Document 

foaf:Person 

?custom OSTI access class? 


## ELEMENTS
Label: a human-readable label for the metadata field. *This does not correspond to fields in the GUI*

Definition : What this field is for 

Refinement: if applicable, to indicate additional schemes for granularity, clarity

Scheme: if applicable, controlled vocabs used to populate the field

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


| Label      		 | *Organization Name*                                                       
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | States name of organization                                            |
|Refinement          | skos:prefLabel, skos:altLabel, skos:notation                           |
|Scheme              | n/a                                                                    |
|Property            | org:Organization                                                       |
|Usage               | It is recommended that SKOS lexical labels should be used to label the Organization. In particular skos:prefLabel for the primary (e.g. legally recognized name), skos:altLabel for alternative names (acronyms, trading names, colloquial names) and skos:notation to denote codes from a code list. |
|Cardinality         | 1 - n                                                                  | 


| Label        		 | *Organizational Role*                                                  | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | States role(s) of organization                                         |
|Scheme              |   |
|Property            | schema:sponsor ; schema:funder ; schema:owns ; schema:locationCreated  |
|Usage               |   |
|Cardinality         | 1 - n                                                                  | 



| Label        		 | *Identifier*                                                           | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Identifier of a given resource                                         |
|Refinement          | skos:notation, adms:schemaAgency, dcterms:created, dcterms:creator     |
|Scheme              |  n/a  |
|Property            | adms:Identifier                                                        |
|Usage               | In RDF this is expressed using the following properties: - the content string should be provided using skos:notation; - use dcterms:creator to link to a class describing the agency that manages the identifier scheme or adms:schemaAgency to provide the name as a literal. Although not part of the ADMS conceptual model, it may be useful to provide further properties to the Identifier class such as dcterms:created to provide the date on which the identifier was issued. |
|Cardinality         | 1 - n                                                                  |

`EXAMPLE
<adms:Identifier><adms:schemaAgency>ORCiD<skos:notation>123-456-789
	<adms:schemaAgency>B&R Code<skos:notation>WP-1234567-89
`


| Label        		 | *Open Source*                                                          | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Is this different than "rights?"                                       |
|Scheme              | n/a                                                                    |
|Property            | x                                                        |
|Usage               | x |
|Cardinality         | 1                                                                      |


| Label        		 | *Repository Link*                                                      | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Link to the repository where the un-compiled, human readable code and related code is located (SVN, github, CodePlex).                                      |
|Scheme              | n/a   |
|Property            | schema:codeRepository                                                  |
|Usage               |  |
|Cardinality         | 1 |



| Label        		 | *Distribution/Access Limitation*                                       | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | *CREATE CUSTOM SKOS ConceptScheme FOR DOE ACCESS CONCEPTS?             |
|Scheme              | n/a                                                                    |
|Property            | x                                                        |
|Usage               | x |
|Cardinality         | 1                                                                      |	


| Label        		 | *Title*                                                                | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The name given to the resource. Title will be a name by which the resource is formally known. |
|Scheme              | n/a                                                                    |
|Property            | dcterms:title                                                          |
|Usage               | n/a |
|Cardinality         | 1                                                                      |	


| Label        		 | *Date*                                                          | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A date associated with an event in the life cycle of the resource. Typically, Date will be associated with the creation or availability of the resource.  |
|Scheme              | ISO 8601 [Date and Time Formats, W3C Note, http://www.w3.org/TR/NOTE- datetime]  |
|Property            | dcterms:date                                                     |
|Usage               | Recommended best practice for encoding the date value is defined in a profile of ISO 8601 [Date and Time Formats, W3C Note, http://www.w3.org/TR/NOTE-datetime] and follows the YYYY-MM-DD format. |	
|Cardinality         | 1 |


| Label        		 | *Description*                                                          | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | An account of the content of the resource. Description may include but is not limited to: an abstract, table of contents, reference to a graphical representation of content or a free-text account of the content.                                         |
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
|Cardinality         | 1 |


| Label        		 | *Subjects*                                                             | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The topic of the content of the resource.                              |
|Scheme              | LCSH? International Energy Subject Thesaurus?                          |
|Property            | dcterms:subject                                                        |
|Usage               | Typically, a Subject will be expressed as keywords or key phrases or classification codes that describe the topic of the resource. Recommended best practice is to select a value from a controlled vocabulary or formal classification scheme. |
|Cardinality         | 1 - n                                                                  |	


| Label        		 | *Rights*                                                               | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Information about rights held in and over the resource. Typically a Rights element will contain a rights management statement for the resource, or reference a service providing such information. Rights information often encompasses Intellectual Property Rights (IPR), Copyright, and various Property Rights.   |
|Scheme              |  n/a  |
|Property            | dcterms:rights                                                         |
|Usage               | The Rights element may be used for either a textual statement or a URL pointing to a rights statement, or a combination, when a brief statement and a more lengthy one are available. |		
|Cardinality         | 1  |

| Label        		 | *License*                                                               | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A legal document giving official permission to do something with the resource.   |
|Scheme              |  n/a  |
|Property            | dcterms:license   
|Refines 			 | dcterms:rights                                                      |
|Usage               | Recommended best practice is to identify the license using a URI. License is designed to allow the inclusion of specific licensed uses to be specified. An example would be a resource that was available to be used freely but not for reproduction within commercial applications. |	
|Cardinality         | 0 - 1 |

`Examples:
license="http://creativecommons.org/licenses/by-nc-nd/2.0/legalcode"
license="Licensed for use under Creative Commons Attribution 2.0."
`

| Label        		 | *Version*                                                              | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | The described resource is a version, edition, or adaptation of the referenced resource. Changes in version imply substantive changes in content rather than differences in format.                                           |
|Scheme              | n/a                                                                    |
|Property            | dcterms:hasVersion / dcterms:isVersionOf                               |
|Usage               | Potential use for multiple versions is the standard rdf:Alt container (or rdf:Seq or rdf:Bag) as a blank node containing the ordered or unordered versions |
|Cardinality         | 1 - n  |

`EXAMPLE
 <dcterms:hasVersion>   
  <rdf:Alt rdf:about="http://www.github.com/Software">      
  <rdf:_1 rdf:resource=“github.com/Version2”>     
  <rdf:_2 rdf:resource=“github.com/Version3”>     
  <rdf:_3 rdf:resource=“github.com/Version4”>   
`	


| Label        		 | *Operating System*                                                     | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Operating systems supported (Windows 7, OSX 10.6, Android 1.6).        |
|Scheme              | n/a                                                                    |
|Property            | schema:operatingSystem                                                 |
|Usage               | x |
|Cardinality         | 1                                                                      |	


| Label        		 | *Documentation*                                                        | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Class for any type of document related to the software described.      |
|Scheme              | n/a                                                                    |
|Property            | foaf:Document                                                          |
|Usage               | The Document class is loosely defined by W3C. Additional elements may be used to clarify attributes of the document.  |
|Cardinality         | 0 - n                                                                  |	

`
Example:
<foaf:Document rdfs:resource"pointer-to-file-location">
	<dcterms:title>"Software Example Technical Documentation"</>
	<skos:related rdfs:resource="http://github.com/ExampleSoftware"</>
	<adms:Identifier><adms:schemaAgency>ISBN<skos:notation>97654321234</>
	<skos:relatedHasPart rdfs:resource="pointer-to-any-related-docs"</>
</foaf:Document>
`


| Label        		 | *Requirements*                                                         | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A related resource that is required by the described resource to support its function, delivery, or coherence.                                         |
|Scheme              | n/a                                                                    |
|Property            | dcterms:requires                                                       |
|Usage               | x |
|Cardinality         | 0 - n                                                                  |

| Label        		 | *Auxiliary software*                                                   | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | X                                           |
|Scheme              | n/a                                                                    |
|Property            | x                                                        |
|Usage               | x |
|Cardinality         | 0 - n                                                                  |


   
