/*
 */
package gov.osti.connectors;

import com.google.gson.JsonElement;
import gov.osti.entity.DOECodeMetadata;
import java.net.URI;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic Connector to various API sources for metadata information.
 * 
 * @author ensornl
 */
public class Connector {
    // the logger
    private static final Logger log = LoggerFactory.getLogger(Connector.class);
    
    /**
     * Attempt to retrieve metadata information based on the given repository
     * URL.  If recognizable, various connectors will be called to get relevant
     * information from API calls.
     * 
     * @param url the full repository URL to read from
     * @return a JsonElement of DOECodeMetadata information, filled with what
     * information was found if possible.
     */
    public static JsonElement readProject(String url) {
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
                    // get rid of the first slash
                    String path = uri.getPath();
//                    return GitHub.readProject(path.substring(path.indexOf("/")+1));
                } else if (uri.getHost().contains("sourceforge.net")) {
                    // assume SourceForge path is formed by "/projects/project-name"
                    String path = uri.getPath();
                    return SourceForge.readProject(path.substring(path.lastIndexOf("/")+1));
                } else if (uri.getHost().contains("bitbucket.org")) {
                    // skip the slash
                    String path = uri.getPath();
                    return BitBucket.readProject(path.substring(path.indexOf("/")+1));
                }
            }
        } catch ( URISyntaxException e ) {
            // warn that URL is not a valid URI
            log.warn("Not a valid URI: " + url + " message: " + e.getMessage());
        }
        // nothing matched, return empty Object
        return new DOECodeMetadata().toJson();
    }
}
