# API Connectors

These are the currently-supported repositories from which the API will attempt
to pre-populate information it can glean given the project URL.  Currently the
information obtained is somewhat sparse, as this is intended to provoke 
discussion on what elements of metadata we should map to DOECode's schema.

## GitHub

Given the GitHub repository URL, the following information is obtained (provided
the project has such filled-in):
* Software Title ("Full Name")
* Acronym ("Name")
* Description
* Developers Listing ("Contributors")
  * First/Last Name
  * Email
  * Affiliations ("Company") if provided

## SourceForge

From SourceForge's available API, the following is mapped:
* Software Title ("Name")
* Acronym ("Short Name")
* Description
* License (concatenating multiple SF licenses, if provided)
* Developers (first and last name)

## BitBucket

BitBucket API maps elements:
* Software Title ("Full Name")
* Acronym ("Name")
* Developers
  * If a "team" is found, iterate through each team member; if a single user/
    Owner, take that as the sole developer
  * First/Last Name


