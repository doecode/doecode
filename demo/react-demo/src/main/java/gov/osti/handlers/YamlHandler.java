/*
 */
package gov.osti.handlers;

import gov.osti.entity.DOECodeMetadata;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author ensornl
 */
public class YamlHandler {
    /**
     * #Metadata template for DOECode users
#Version: 1.0

#REQUIRED FIELDS

title: #"type the title of your project using quotation marks"
date: #on what date was this code created YYYY-MM-DD
description: | #provide a description of your project
license: #give the URL for your license
openSourceProject: 1 
governmentWideReuseProject: 1
codeRepository: #repo URL

doeIdentifier:
  identName: "DOE Contract Number"
  identNumber: #type in the DOE Contract Number 

#repeat developer field as needed
developer: 
  firstname: #what is the developer's first name
  familyname: #what is the developer's family name
  email: #what is the developer's email  
  orcID: 
    identName: "ORCiD"
    identNumber: #type in the developer's ORCiD, please	
  basedAt: #current primary workplace

submittingOrganization: 
  orgName: #What org is submitting this? Repeat field as needed.
sponsoringOrganization: 
  orgName: #What org funded this project? Repeat field as needed.
researchOrganization: 
  orgName: #What org contributed to this research? Repeat field as needed. 


#OPTIONAL FIELDS

keywords:
  - #type a keyword/phrase that describes your project, e.g. "Earth Sciences"
  - #type another keyword/phrase, e.g. "Groundwater flow"

#repeat contributor field as needed
contributor:
  firstname:
  familyname:
  email:
  orcID:
    identName: "ORCiD"
    identNumber: #type in orcid
  basedAt: #current primary workplace

doi: 
  identName: "DOI"
  identNumber: #enter in the software DOI

#repeat field as needed
additionalIdentifier: 
  identName: #name of the ID type, e.g. "B&R Code"
  identNumber: #the alpha/numeric identifier 
  
countryOfOrigin: #primary location of software development
hasVersion: #url of newer version
isVersionOf: #url of older version
contactPerson: 
requirements: #list any requirements
relatedSoftware: #url of related software repo
relatedDocumentation: #url or uri of related docs
     * 
     */
    /**
     * Process YAML related requests from ServiceRouter.
     * 
     * @param request the HTTP request to process
     * @return the output of such requests
     * @throws IOException on unexpected errors
     */
    public static String handleRequest(HttpServletRequest request) throws IOException {
        String action = request.getParameter("action");
        Long codeId = NumberUtils.toLong(request.getParameter("codeId"), 0);
        
        switch ( action ) {
            case "generate":
                return handleActionGenerate(codeId);
            default:
                return null;
        }
    }
    
    /**
     * Attempt to load a given codeId value, and generate YAML from it.
     * 
     * @param id the ID to read
     * @return null if nothing found, 
     */
    private static String handleActionGenerate(Long id) {
        DOECodeMetadata md = DOECodeMetadata.lookup(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if (null==md) {
            return null;
        }
        
        // generate via template provided
        StringBuilder b = new StringBuilder();
        
        b.append("#Metadata template for DOECode users\n")
         .append("#Version: 1.0\n\n")
         .append("#REQUIRED FIELDS\n");
        
        b.append("title: \"").append(md.getSoftwareTitle()).append("\"\n");
        b.append("date: \"").append(sdf.format(new Date())).append("\"\n");
        b.append("description: ").append(md.getDescription()).append("\n");
        b.append("codeRepository: ").append(md.getRepositoryLink()).append("\n");
        return b.toString();
    }
}
