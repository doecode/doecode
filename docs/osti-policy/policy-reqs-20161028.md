#20161028 Policy Meeting

**Date: October 28, 2016**

**Time: 1:30 p.m. - 2:30 p.m.**

**Agenda:**

 1.	Walk through UML models of submission processes 
 2.	Continue to narrow down metadata fields

**Proceedings:**

1.	The first part of the meeting was spent going over the UML models of submission processes for three different cases. This review was to be kept at a high-level and to not get into too much detail. The first model looked at was the submission of a new product as a grantee. One would begin by logging in using DOE Code and creating a new submission (use own repo or create repo). The next step is to provide key IDs. These would be required such as contract number. If the key entered is not valid, this would get marked as incomplete and be saved in DOE Code. The ‘Notify ‘X’ of Status’ step is next, with x being the person logged in. If the key entered is valid, they would complete the submission form. The reviewer in the ‘Notify Reviewer’ step would be dependent upon which sites choose to look at the submissions. At the ‘Final’ node, this is the step where it moves into E-link processing. It differs from the current grantee process in that we are allowing for a saved state inside DOE Code. Team members agreed that this flow makes sense at this level. One concern mentioned was about grantees coming in and never finishing the submission. A suggestion was made to have a set time for the submission to be completed, and if not completed by that time, it would get kicked out. 

    The next model reviewed was the new single submission as a lab researcher/developer/STI POC. These people have E-link accounts and would log in, create the submission, then complete the submission form. They have the same required fields, but can go right into making decisions. If they are not the releasing official, whenever it moves to ‘Notify Reviewer’, the reviewer would be the releasing official. One missing detail is how to tie in DOE code login with E-link login. A suggestion was made to have a check box only for the user admin to check that this is also a DOE Code account. A note made here was that subsequent edits to the software package would happen in E-link. 
    
    The last model to be looked at was the web API submissions. One thought mentioned was that we should not support any other form, such as XML, to upload batch submissions. The user would log in using API. Once the policy team gets all of the metadata fields finished, they will go into each of these submission processes in more detail. 
    
2.	The next portion of the meeting was spent discussing metadata fields, in particular ones that aren’t necessarily required. When talking about fields such as R&D Project IDs and Site Product Number, it became apparent that a table with a controlled vocabulary may make the most sense. It needed to be determined whether these fields were unique enough to keep as its own field. In conclusion, it was decided that what is needed is a suggested list of metadata. We already have the mapping of what fields to map to Datacite. One team member volunteered to create a suggested list of metadata that we know should be collected for DOE Code. A subsequent meeting will be scheduled to review that list and to obtain permission to disseminate that list beyond our borders. We will encourage feedback about the metadata once it is made available. 

**Conclusions/Actions:**

 - Develop list of suggested metadata for review
