# DOECode Web Application

Consists of the "back-end" services and JAX/RS API calls for DOE Code, to be
accessed by the front-end or presentation layer.  This application is targeted
at a non-EE Java container such as Tomcat, using JPA and JAX/RS (Jersey implementation)
for persistence layer and web API implementation.

## API services

GET /services/metadata/{ID}

Retrieves a specified Metadata by its unique ID value, in JSON format.

GET /services/metadata/autopopulate?repo={URL}

Calls the Connector services to attempt to scrape/auto-populate metadata information
if possible by deriving the appropriate repository from the URL.  Empty JSON is
returned if the determination cannot be made or the project does not exist or
is otherwise inaccessible.

POST /services/metadata

Store a given metadata JSON to the DOECode persistence layer in an incomplete or 
pending status.  The resulting JSON information is returned as the JSON object "metadata",
including the generated unique IDs as appropriate if the operation was successful.

POST /services/metadata/submit

Post the metadata to OSTI, attempt to register a DOI if possible, and persist
the information on DOECode.  If workflow validations pass, the JSON will be returned
with appropriate unique identifier information and DOI values posted in the
JSON object "metadata".
