/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.osti.connectors.bitbucket.MemberList;
import gov.osti.connectors.bitbucket.Response;
import gov.osti.connectors.bitbucket.User;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ensornl
 */
public class BitBucket implements ConnectorInterface {
    // base URL for BitBucket API requests
    private static final String BITBUCKET_API_URL="https://api.bitbucket.org/2.0/repositories/";
    // base URL for RAW view requests (suffix with "owner/project/raw/master/metadata.yml")
    private static final String BITBUCKET_RAW_URL="https://bitbucket.org/";
    // a logger
    private static final Logger log = LoggerFactory.getLogger(BitBucket.class);
    
    /**
     * Initialize the Connector
     * @throws IOException on errors
     */
    @Override
    public void init() throws IOException {
        // not required
    }
    
    /**
     * Split a given Name into two parts, assuming it's "first last".  If no
     * space delimiter found, assume the "first name" to be the entire content.
     * 
     * @param in the Name to split
     * @return a first-last String array
     */
    private static String[] parseName(String in) {
        String name = (null==in) ? "" : in.trim();
        int space = name.indexOf(" ");
        
        return (-1==space) ? new String[] { name, "" } :
                new String[] { name.substring(0,space), name.substring(space+1) };
    }
    
    private static String getProjectNameFromUrl(String url) {
        try {
            String safeUrl = (null==url) ? "" : url.trim();
            // err on the side of encryption, if no protocol provided
            URI uri = new URI(
                    !safeUrl.startsWith("http") ?
                            "https://" + safeUrl : 
                            safeUrl);
            
            // protection against bad URL input
            if (null!=uri.getHost()) {
                if (uri.getHost().contains("bitbucket.org")) {
                    // skip the slash
                    String path = uri.getPath();
                    return path.substring(path.indexOf("/")+1);
                }
            }
        } catch ( URISyntaxException e ) {
            // warn that URL is not a valid URI
            log.warn("Not a valid URI: " + url + " message: " + e.getMessage());
        }
        // don't recognize this one
        return null;
    }
    
    /**
     * Read API details from a Project hosted on BitBucket.
     * 
     * @param url the URL to read
     * @return JsonElement of the auto-populated DOECodeMetadata entity
     */
    @Override
    public JsonNode read(String url) {
        DOECodeMetadata md = new DOECodeMetadata();
        ObjectMapper mapper = new ObjectMapper();
        
        String name = getProjectNameFromUrl(url);
        if (null==name)
            return null;
        
        // load the API information
        HttpGet get = new HttpGet(BITBUCKET_API_URL + name);
        
        try {
            // try to get the METADATA YAML first
            JsonNode results = HttpUtil.readMetadataYaml(BITBUCKET_RAW_URL + name + "/raw/master/metadata.yml");

            if (null!=results)
                return results;
            
            Response response = mapper.readValue(HttpUtil.fetch(get), Response.class);
            
            // glean what information we can from the JSON
            md.setSoftwareTitle(response.getFullName());
            md.setAcronym(response.getName());
            md.setDescription(response.getDescription());
            
            // if the "owner" is type "user", that's the only developer we can get
            // if it's a "team", go fetch team information for developers
            if ( "user".equals(response.getOwner().getType()) ) {
                Developer developer = new Developer();
                String[] nameParts = parseName(response.getOwner().getDisplayName());
                
                developer.setFirstName(nameParts[0]);
                developer.setLastName(nameParts[1]);
                
                md.add(developer);
            } else if ( "team".equals(response.getOwner().getType()) ) {
                // skip a step, tack on "/members" to get at the member list
                MemberList teamList = mapper.readValue(
                        HttpUtil.fetch(new HttpGet(response.getOwner().getLinks().getSelf() + "/members")), MemberList.class);
                
                User[] users = teamList.getUsers();
                for ( User user : users ) {
                    Developer developer = new Developer();
                    String[] nameParts = parseName(user.getDisplayName());
                    
                    developer.setFirstName(nameParts[0]);
                    developer.setLastName(nameParts[1]);
                    
                    md.add(developer);
                }
            }
            // send back the metadata we read
            return md.toJson();
        } catch ( IOException e ) {
            // something went wrong
            log.warn("IO Error reading from BitBucket: " + e.getMessage());
            log.warn("Read from " + name);
        }
        // unknown
        return null;
    }
}
