
package gov.osti.connectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Metadata scraper for SourceForge public API projects.
 * 
 * @author nensor
 */
public class SourceForge {
    private static final String SOURCEFORGE_API_BASEURL = "http://sourceforge.com/rest/p/";
    
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
         CloseableHttpClient hc = HttpClients.createDefault();
         Gson gson = new Gson();
         
         try {
             // acquire the SourceForge API response as JSON
             HttpGet get = new HttpGet(SOURCEFORGE_API_BASEURL + name);
             // set some reasonable default connection timeouts
             RequestConfig rc = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
             get.setConfig(rc);
             
             // Convert the JSON into an Object we can handle
             SourceForgeResponse response = 
                     (SourceForgeResponse) gson.fromJson(new InputStreamReader(hc.execute(get).getEntity().getContent()), SourceForgeResponse.class);
             
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
             ArrayList<Developer> devs = new ArrayList<>();
             
             for ( SourceForgeDeveloper developer : developers ) {
                 int space = developer.getName().indexOf(" ");
                 Developer dev = new Developer();
                 if ( -1==space ) {
                     dev.setFirstName(developer.getName());
                 } else {
                     dev.setFirstName(developer.getName().substring(0, space));
                     dev.setLastName(developer.getName().substring(space+1));
                 }
                 devs.add(dev);
             }
             md.setDevelopers(devs);
         } catch ( IOException e ) {
             // warn about failure here
         } finally {
             try {
                 hc.close();
             } catch ( IOException e ) {
                 
             }
         }
         
        return md.getJson();
    }
}
