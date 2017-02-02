
package gov.osti.connectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
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
     * Define the SourceForge "developer" information
     */
    private class SourceForgeDeveloper {
        private String name;
        private String url;
        private String username;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }
    }
    
    /**
     * Define the SourceForge license information
     */
    private class SourceForgeLicense {
        private String fullpath;
        private String fullname;
        private String shortname;

        /**
         * @return the fullpath
         */
        public String getFullpath() {
            return fullpath;
        }

        /**
         * @return the fullname
         */
        public String getFullname() {
            return fullname;
        }

        /**
         * @return the shortname
         */
        public String getShortname() {
            return shortname;
        }
    }
    
    /**
     * The SourceForge Category information (contains license references)
     */
    private class SourceForgeCategory {
        private SourceForgeLicense[] license;

        /**
         * @return the license
         */
        public SourceForgeLicense[] getLicense() {
            return license;
        }
    }
    
    /**
     * The SourceForge public API response object.
     */
    private class SourceForgeResponse {
        private String name;
        private String url;
        private String summary;
        @SerializedName("short_description")
        private String shortDescription;
        private String shortname;
        
        private SourceForgeDeveloper[] developers;
        
        private SourceForgeCategory categories;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @return the summary
         */
        public String getSummary() {
            return summary;
        }

        /**
         * @return the shortDescription
         */
        public String getShortDescription() {
            return shortDescription;
        }

        /**
         * @return the shortname
         */
        public String getShortname() {
            return shortname;
        }

        /**
         * @return the developers
         */
        public SourceForgeDeveloper[] getDevelopers() {
            return developers;
        }

        /**
         * @return the categories
         */
        public SourceForgeCategory getCategories() {
            return categories;
        }
    }
    
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
        Gson gson = new Gson();
         
         // acquire the SourceForge API response as JSON
         HttpGet get = new HttpGet(SOURCEFORGE_API_BASEURL + name);

         try {
             // Convert the JSON into an Object we can handle
             SourceForgeResponse response = 
                     (SourceForgeResponse) gson.fromJson(HttpUtil.fetch(get), SourceForgeResponse.class);

             // parse the relevant response parts into Metadata
             md.setSoftwareTitle(response.getName());
             md.setAcronym(response.getShortname());
             md.setDescription(response.getShortDescription());

             SourceForgeLicense[] licenses = response.getCategories().getLicense();

             StringBuilder license_text = new StringBuilder();
             for ( SourceForgeLicense license : licenses ) {
                 license_text.append( (0==license_text.length()) ? "" : ",");
                 license_text.append(license.getFullname());
             }
             md.setLicense(license_text.toString());

             SourceForgeDeveloper[] developers = response.getDevelopers();

             for ( SourceForgeDeveloper developer : developers ) {
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
         
        return md.getJson();
    }
}
