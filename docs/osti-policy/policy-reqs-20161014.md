#20161014 Policy Meeting

**Date: October 14, 2016**

**Time: 1:30 p.m. - 2:30 p.m.**

**Agenda:**

Review metadata fields and capture optional/required fields

**Proceedings:**

The first topic brought up was regarding license information. It was agreed that there should be a license field that should be required. It was suggested to have a dropdown with a curated list of common licenses to choose from or the option to choose to enter their own license. This brought about conversation about setting the OSTI license as the default if they do not choose a license. This is a question to ask the legal team to make sure this wouldn’t be re-licensing or violating copyright. It was noted that it is the general move for other STI to fall under government license and it is up to the user to make sure they are complying with the license. A question was asked whether we would need a license for limited software. The answer was that if we are not distributing that we would not need a license; we would just archive. 

The ‘Publisher’ field was discussed next. It is a required field in DataCite, but was not marked as required for OSTI. It was agreed that it should be required. A suggestion was made that we could make this field freeform, but was argued that this may cause problems with people interpreting it differently. This brought about discussion on what exactly the DataCite definition for ‘Publisher’ was. It was concluded that a team member would ask DataCite for clarification about the publisher field’s definition. Something mentioned here was that software definitions could be confusing. It became evident that a list of definitions for the metadata fields need to be developed and have a document posted to GitHub containing the definitions. 

The topic of copyright was briefly mentioned. It was explained to the team that the contributors hold some amount of copyright and the organization owns most. Blame functions were also explained. The next metadata field reviewed was the ‘Publication Year’ field. The team determined that there needs to be two dates: a submission date and a release date. Talking about different releases brought about the topic of multiple media, which is being handled by the technical team. Essentially, each release will get stamped with dates. On the code side, it will look like a big table, but on the dissemination side, it will appear as a collection record. 

For the ‘Resource Type’ field, this will be software and subsequent mandatory fields will be auto-filled to software. The ‘Subject’ field should be optional and should follow what is already being done with the dropdown list of ~50 subjects to choose from. The ‘Contributor’ field was discussed. If you enter a contributor, the type is required. The controlled list of types on DataCite is meant for data, not software. The project lead and committers will fall under the ‘Creator’ field, while additional contributors will be added under the ‘Contributor’ field. A change in vocabulary may be needed for creators and contributors. The ‘Geolocation’ fields should be removed. 

**Conclusions/Actions:**
 - Work on the metadata spreadsheet, adding more detail, map and change names, definitions, etc.
 - Go through wizard screens and 241.6 to make sure nothing has been missed
