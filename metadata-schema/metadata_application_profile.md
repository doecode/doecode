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

| Label              | *Availability*                                                      | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Availability of the software.                                     |
|Scheme              | n/a   |
|Property            | osti:availability                                                  |
|Usage               | One of three options: Open Source, Publicly Available Repository; Open Source, No Publicly Available Repository; Closed Source. |
|Cardinality         | 1 |


| Label              | *Repository Link/Landing Page*                                                      | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | URL to the repository where the un-compiled, human readable code and related code is located (SVN, github, CodePlex) or a URL which leads to the landing page of the software.                                     |
|Scheme              | n/a   |
|Property            | schema:codeRepository                                                  |
|Usage               |  |
|Cardinality         | 1 |



| Label        		 | *Developer(s)/Contributor/Contact Point*                                            |
|:-----------------------|:------------------------------------------------------------------|
|Definition              | 
|Scheme                  | n/a
|Property                | foaf:Person
|Annotation              | dcterms:creator, dcterms:contributor, adms:contactPoint, foaf:firstName, foaf:familyName, foaf:mbox_sha1sum |
|Cardinality             | 1 - n                                                         |	

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
|Definition          | States Country of Origin for the software. Default is the United States.                         |
|Scheme              | Getty Thesaurus of Geographic Names,                                   |
|Property            | dcterms:coverage                                                       |
|Usage               | Coverage will typically include spatial location (a place name or geographic co-ordinates), temporal period (a period label, date, or date range) or jurisdiction (such as a named administrative entity). Recommended best practice is to select a value from a controlled vocabulary (for example, the Thesaurus of Geographic Names). Where appropriate, named places or time periods should be used in preference to numeric identifiers such as sets of co-ordinates or date ranges. |	
|Cardinality         | 0 - 1                                                                  |


| Label        		 | *Keywords*                                                          | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Keywords or tags used to describe this content.                        |
|Scheme              | n/a                                                                    |
|Property            | schema:keywords                                                        |
|Usage               | Multiple entries in a keywords list are typically delimited by commas. |
|Cardinality         | 0 - n                                                                  |


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


| Label        		 | *Requirements*                                                         | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | A related resource that is required by the described resource to support its function, delivery, or coherence.                                         |
|Scheme              | n/a                                                                    |
|Property            | dcterms:requires                                                       |
|Usage               | x |
|Cardinality         | 0 - n                                                                  |

| Label        		 | *Short Title or Acronym*                                                   | 
|:-------------------|:-----------------------------------------------------------------------|
|Definition          | Abbreviated title or acronym for the software. |
|Scheme              | n/a                                                                    |
|Property            | osti:acronym                                 |
|Usage               | This field differs from the 'Title' field. The 'Title' field is the full title of the software. |
|Cardinality         | 0                                                                   |

