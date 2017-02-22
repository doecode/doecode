# API Connectors

These are the currently-supported repositories from which the API will attempt
to pre-populate information it can glean given the project URL.  Currently the
information obtained is somewhat sparse, as this is intended to provoke 
discussion on what elements of metadata we should map to DOECode's schema.

If any of these sources should have a "metadata.yml" file checked-in on the
master branch, project root level, the Connector will attempt to read from and
parse its information instead of calling various API methods to fill in the
metadata information.

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

# ConnectorFactory instantiation

These connector instances should each implement the ConnectorInterface interface
in order to be added to a ConnectorFactory instantiation.  The interface defines
only two methods:

``` java
  init() throws IOException
```

  Initialize the Connector, if necessary, throwing IOException on errors

``` java
  read(String url)
```

  Attempt to load Metadata information from the given URL, if recognized. If not,
  or unable to do so, return null.

In order to use the Factory, one should acquire an instance, and add each desired Connector to it:

``` java
  ConnectorFactory factory = ConnectorFactory.getInstance()
                             .add(new GitHub())
                             .add(new SourceForge())
                             .build();
```

Simply call the `factory.read(String)` method to obtain any JSON metadata if possible.
Note this may return null if not recognized.
