# 20170421 Policy Meeting

**Date: April 21, 2017**

**Time: 10:00 a.m. – 10:45 a.m.**

**Agenda:**

1.	Upcoming plans
2.	Demo walk-through

**Proceedings:**

1. The meeting began with giving the Policy team the upcoming plans for the project. First, the developers will be switching focus from the input form to accounts and also to the backend coding for the archival of code. Starting next week, the QA team at OSTI will become involved in testing the form and providing feedback. The project lead will be giving a DOE Code talk at the upcoming STIP meeting. Shortly after this meeting, Policy team members will discuss specific text features for the form such as help text and inline help. 

2. The rest of the meeting was spent with one of the lead developers giving a demo of what has been done for the ingest portion of the “wizard.” The form is not so wizard-like anymore. It is now in accordion-style, where the user isn’t locked-in linearly while filling out different sections of the form. The demo showcased the reactive design that gives early feedback (validation is provided at any given moment while filling out the form). 

   The auto-populate feature and the feature that allows you to save your progress and return to complete at a later time are now working. When a user logs in to their DOE Code account, they will be able to see a list of records that they are currently editing. Taking feedback from the last Policy team meeting, all of the information associated with ‘Award number’ are now located in one place on the form instead of being spread across multiple sections. This led into a conversation about finding specific patterns for B&R code and FWP number, and to regex those. One team member is going to take charge of this effort.  
   
   Next, it was demonstrated that once a user finishes the form and hits ‘Publish & Submit’, a real test DOI was generated instantly. It was suggested at this point to capture a screenshot of the confirmation screen that included the DOI and to work with the Communications team at OSTI to post on Twitter. Also, after a package is submitted, a YAML file will be available for download and editing. It will also be an option for the user to include the file in a specific place in their repository that DOE Code can grab and use to populate metadata. Lastly, there is an option to upload a YAML file at the very beginning of the form for auto-populating.  
   
   A couple of things were pointed out at this time. One was that the team needs to discuss at some point what the DOE Code ID needs to be. Integers would be fine for OSTI only, but it was suggested that universally unique identifiers may be needed if others use it. Also, there was no ‘Access Limitations’ field included in the demo because there was a decision made to take a step back from this for the Alpha. For the Alpha release, everything will be UNL, no CUI.  

**Actions:**

 - Look for specific patterns for B&R code and FWP number and work to Regex those
