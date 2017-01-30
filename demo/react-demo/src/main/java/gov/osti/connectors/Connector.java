/*
 */
package gov.osti.connectors;

import com.google.gson.JsonElement;
import gov.osti.entity.DOECodeMetadata;

/**
 * Generic Connector to various API sources for metadata information.
 * 
 * @author ensornl
 */
public class Connector {
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
        String safeUrl = (null==url) ? "" : url.trim();
        
        /**
         * Attempt to interpret the URL and access one of the known API 
         * connectors.  Unknown repository URLs will return empty Metadata JSON.
         * 
         * GitHub:  contains github.com, path should be of the form "username/project"
         * SourceForge: contains sourceforge.net, path should be "project"
         * BitBucket: contains bitbucket.org, path is of the form "user/repo-slug"
         */
        if ( safeUrl.contains("gihub.com") ) {
            return GitHub.readProject(safeUrl.substring(safeUrl.indexOf("/")+1));
        } else if ( safeUrl.contains("sourceforge.net") ) {
            return SourceForge.readProject(safeUrl.substring(safeUrl.indexOf("/")+1));
        } else if ( safeUrl.contains("bitbucket.org") ) {
            return BitBucket.readProject(safeUrl.substring(safeUrl.indexOf("/")+1));
        } else {
            return new DOECodeMetadata().getJson();
        }
    }
}
