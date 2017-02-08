
package gov.osti.connectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import gov.osti.connectors.sourceforge.License;
import gov.osti.connectors.sourceforge.Person;
import gov.osti.connectors.sourceforge.Response;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Metadata scraper for SourceForge public API projects.
 * 
 * @author nensor
 */
public class SourceForge {
    // base URL for SourceForge API requests
    private static final String SOURCEFORGE_API_BASEURL = "https://sourceforge.net/rest/p/";
    // the logger implementation
    private static final Logger log = LoggerFactory.getLogger(SourceForge.class);
    
    /**
     * Obtain the relevant Connector-driven information on this named project
     * from SourceForge.
     * 
     * @param name the project name
     * @return a JSON Element defining the relevant metadata read from SourceForge
     * if possible
     */
    public static JsonElement readProject(String name) {
        DOECodeMetadata md = new DOECodeMetadata();
        ObjectMapper mapper = new ObjectMapper();
         
         // acquire the SourceForge API response as JSON
         HttpGet get = new HttpGet(SOURCEFORGE_API_BASEURL + name);

         try {
             // Convert the JSON into an Object we can handle
             Response response = mapper.readValue(HttpUtil.fetch(get), Response.class);

             // parse the relevant response parts into Metadata
             md.setSoftwareTitle(response.getName());
             md.setAcronym(response.getShortname());
             md.setDescription(response.getShortDescription());

             License[] licenses = response.getCategories().getLicense();

             StringBuilder license_text = new StringBuilder();
             for ( License license : licenses ) {
                 license_text.append( (0==license_text.length()) ? "" : ",");
                 license_text.append(license.getFullname());
             }
             md.setLicense(license_text.toString());

             Person[] developers = response.getDevelopers();

             for ( Person developer : developers ) {
                 int space = developer.getName().indexOf(" ");
                 Developer dev = new Developer();
                 if ( -1==space ) {
                     dev.setFirstName(developer.getName());
                 } else {
                     dev.setFirstName(developer.getName().substring(0, space));
                     dev.setLastName(developer.getName().substring(space+1));
                 }
                 md.add(dev);
             }
         } catch ( IOException e ) {
             // here's where we warn log error messages
             log.warn("IO Error reading from SourceForge: " + e.getMessage());
             log.warn("Repository/project: " + name);
         }
         
        return md.toJson();
    }
}
