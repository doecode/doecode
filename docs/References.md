# References

Below are a set of references and links which may be useful for developing DOECode, as well as other similar efforts which relate to DOECode.

## Federal Source Code Policy / Code.gov

OMB memorandum M-16-21, the [Federal Source Code Policy](https://sourcecode.cio.gov) (FSC), was released on August 8, 2016 which pushes for openness and reuse of Government custom-developed source code.

### FSC Metadata Schema

The primarily deliverable of the FSC Policy is a Federal wide code inventory, hosted at [Code.gov](https://code.gov). As part of defining the deliverable, a [metadata schema](https://github.com/presidential-innovation-fellows/code-gov-web/blob/master/_draft_content/02_compliance/05-metadata-schema-definition.md) was developed with quite a bit of [public input from interested parties](https://github.com/presidential-innovation-fellows/code-gov-web/issues/41). This schema is fairly light in terms of the data it requires, for instance, compared with the

### FSC Tools

Lawrence Livermore National Laboratory has created a metadata scraping tool for gathering information from various code hosting platforms (currently: GitHub, planned: Bitbucket, GitLab, etc). This tool is available a a free and open source project on GitHub under the name [Scraper](https://github.com/llnl/scraper).

Additionally, GSA is working on [a Code Inventory tool](https://github.com/GSA/codeinventory-github) which takes advantage of a project maintained metadata file (`.codeinventory.yml` or `.codeinventory.json`) for defining the project. This file contains the metadata required as part of the `code.json` schema and converts it into a valid `code.json` file.

## Existing Software Cataloging Efforts

A number of the DOE laboratories and elements provide lists, links and catalogs of their source code projects:

* Lawrence Livermore National Laboratory
  * [Software Catalog](https://software.llnl.gov)
