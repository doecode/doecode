
package gov.osti.connectors;

import gov.osti.connectors.github.Repository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.osti.connectors.github.Contributor;
import gov.osti.connectors.github.User;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The GitHub metadata scraper class, to acquire the relevant metadata attributes
 * from the GitHub public API.
 * 
 * @author nenso
 */
public class GitHub implements ConnectorInterface {
    /** a logger implementation **/
    private static final Logger log = LoggerFactory.getLogger(GitHub.class);
    /** authentication information for accessing GitHub API **/
    private static String API_KEY = "";
    private static String API_USER = "";
    /** GitHub API base URL **/
    private static final String GITHUB_BASE_URL = "https://api.github.com/repos/";
    /** GitHub base URL for fetching RAW content 
     * paste on owner/repository/branch/filename to obtain a single file reference.
     **/
    private static final String GITHUB_RAW_BASE_URL = "https://raw.githubusercontent.com/";
    
    /**
     * Initialize and read the properties for configuration purposes.
     * 
     * Obtains connector authentication information from properties files.
     * 
     * @throws IOException on file IO errors
     */
    @Override
    public void init() throws IOException {
        Properties config = new Properties();
        InputStream stream = null;
        
        try { 
            stream = GitHub.class.getClassLoader().getResourceAsStream("github-connector.properties");
            config.load(stream);
            
            API_KEY=config.getProperty("github.apikey");
            API_USER=config.getProperty("github.user");
        } finally {
            if (null!=stream) stream.close(); stream = null;
        }
    }
    
    /**
     * Construct a GET request to the GitHub API.
     * 
     * @param url the base URL to use
     * @return an HttpGet Object to read project information from
     */
    private static HttpGet gitHubAPIGet(String url) {
        HttpGet get = new HttpGet(url);
        // if authenticated, pass basic authentication header information
        // prevents API access limitations if authenticated
        if ( !"".equals(API_USER) ) {
            String authentication = API_USER + ":" + API_KEY;
            byte[] encoded = Base64.encodeBase64(authentication.getBytes(Charset.forName("ISO-8859-1")));
            get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + new String(encoded));
        }
        return get;
    }
    
    /**
     * Attempt to identify the PROJECT NAME from the given URL.  
     * 
     * Criteria:  URL host should contain "github.com"; the project is assumed
     * to be the first two components of the PATH, splitting on the slash.  
     * (owner/project)
     * 
     * @param url the URL to process
     * @return the PROJECT NAME if able to parse; null if not, or unrecognized
     * URL
     */
    private static String getProjectFromUrl(String url) {
        try {
            String safeUrl = (null==url) ? "" : url.trim();
            // err on the side of encryption, if no protocol provided
            URI uri = new URI(
                    !safeUrl.startsWith("http") ?
                            "https://" + safeUrl : 
                            safeUrl);
            
            // protection against bad URL input
            if (null!=uri.getHost()) {
                if (uri.getHost().contains("github.com")) {
                    String path = uri.getPath();
                    return path.substring(path.indexOf("/")+1);
                }
            }
        } catch ( URISyntaxException e ) {
            // warn that URL is not a valid URI
            log.warn("Not a valid URI: " + url + " message: " + e.getMessage());
        } catch ( Exception e ) {
            // some unexpected error happened
            log.warn("Unexpected Error from " + url + " message: " + e.getMessage());
        }
        
        return null;
    }
    
    /**
     * Obtain the connection-driven metadata elements from GitHub public API
     * requests.
     * 
     * @param url the URL to process
     * 
     * @return a JsonElement of the DOECodeMetadata filled in as possible from
     * the API
     */
    @Override
    public JsonNode read(String url) {
        DOECodeMetadata md = new DOECodeMetadata();
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // try to identify the NAME of the project
            String name = getProjectFromUrl(url);
            log.info("Project name: " + name);
            if (null==name)
                return null;
            
            // try to get the metadata YAML file first
            JsonNode yaml = HttpUtil.readMetadataYaml(GITHUB_RAW_BASE_URL + name + "/master/metadata.yml");
            // if it's not empty, use that
            if (null!=yaml)
                return yaml;

            // acquire the SourceForge API response as JSON
            HttpGet get = gitHubAPIGet(GITHUB_BASE_URL + name);
            log.info("GET " + get.toString());

            // Convert the JSON into an Object we can handle
            Repository response = 
                    mapper.readValue(HttpUtil.fetch(get), Repository.class);

            // parse the relevant response parts into Metadata
            md.setSoftwareTitle(response.getFullName());
            md.setAcronym(response.getName());
            md.setDescription(response.getDescription());

            if (null!=response.getContributorsUrl()) {
                HttpGet contributor_request = gitHubAPIGet(response.getContributorsUrl());
                Contributor[] contributors = mapper.readValue(HttpUtil.fetch(contributor_request), Contributor[].class);

                for ( Contributor contributor : contributors ) {
                    Developer developer = new Developer();
                    if (null!=contributor.getUrl()) {
                        HttpGet user_request = gitHubAPIGet(contributor.getUrl());
                        User user = mapper.readValue(HttpUtil.fetch(user_request), User.class);

                        developer.setEmail(user.getEmail());
                        developer.setAffiliations(user.getCompany());

                        /** if no User name is present, default to the login name;
                         * otherwise attempt to break into first/last name.
                         */
                        if (null==user.getName()) {
                            developer.setFirstName(user.getLogin());
                            developer.setLastName("(undefined)");
                        } else {
                            int lastSpace = user.getName().lastIndexOf(" ");
                            if ( -1==lastSpace ) {
                                developer.setFirstName(user.getName());
                                developer.setLastName("(undefined)");
                            } else {
                                developer.setFirstName(user.getName().substring(0, lastSpace));
                                developer.setLastName(user.getName().substring(lastSpace+1));
                            }
                        }
                        md.add(developer);
                    }
                }
            }
            return md.toJson();
        } catch ( IOException e ) {
            // here's where you'd warn about the IO error
            log.warn("IO Error reading GitHub information: " + e.getMessage());
            log.warn("Read from " + url);
        }
        // unable to process this one
        return null;
    }
    
}
