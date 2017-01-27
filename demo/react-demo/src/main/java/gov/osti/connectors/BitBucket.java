/*
 */
package gov.osti.connectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import gov.osti.entity.DOECodeMetadata;
import java.io.IOException;
import java.util.Date;
import org.apache.http.client.methods.HttpGet;

/**
 *
 * @author ensornl
 */
public class BitBucket {
    private static final String BITBUCKET_API_URL="https://api.bitbucket.org/2.0/repositories/";
    
    /**
     * {"scm": "git", "website": "", "has_wiki": true, 
     * "name": "chorus-reader", 
     * "links": {"watchers": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/watchers"}, 
     * "branches": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/refs/branches"}, 
     * "tags": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/refs/tags"}, 
     * "commits": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/commits"}, 
     * "clone": [{"href": "https://bitbucket.org/ensorn/chorus-reader.git", "name": "https"}, 
     * {"href": "ssh://git@bitbucket.org/ensorn/chorus-reader.git", "name": "ssh"}], 
     * "self": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader"}, 
     * "html": {"href": "https://bitbucket.org/ensorn/chorus-reader"}, 
     * "avatar": {"href": "https://bitbucket.org/ensorn/chorus-reader/avatar/32/"}, 
     * "hooks": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/hooks"}, 
     * "forks": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/forks"}, 
     * "downloads": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/downloads"}, 
     * "pullrequests": {"href": "https://api.bitbucket.org/2.0/repositories/ensorn/chorus-reader/pullrequests"}}, 
     * "fork_policy": "allow_forks", "uuid": "{01d062fc-1e08-4caa-a666-5811a2059d05}", 
     * "language": "java", "created_on": "2017-01-23T14:52:07.588727+00:00", 
     * "full_name": "ensorn/chorus-reader", "has_issues": true, 
     * "owner": {"username": "ensorn", "display_name": "Neal Ensor", "type": "user", "uuid": "{5db45add-c07a-41ee-80ae-2c23ec61e8ed}", 
     * "links": {"self": {"href": "https://api.bitbucket.org/2.0/users/ensorn"}, 
     * "html": {"href": "https://bitbucket.org/ensorn/"}, 
     * "avatar": {"href": "https://bitbucket.org/account/ensorn/avatar/32/"}}}, 
     * "updated_on": "2017-01-27T17:22:35.423250+00:00", 
     * "size": 33348, "type": "repository", 
     * "slug": "chorus-reader", 
     * "is_private": false, 
     * "description": "Sample bitbucket repository for a standalone JSON project"}
     */
    
    private class Owner {
        private String username;
        @SerializedName("display_name")
        private String displayName;
        private String type;

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @return the displayName
         */
        public String getDisplayName() {
            return displayName;
        }

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }
    }
    
    private class Response {
        private String scm;
        private String website;
        @SerializedName("has_wiki")
        private Boolean hasWiki = false;
        private String name;
        private String language;
        @SerializedName("full_name")
        private String fullName;
        @SerializedName("has_issues")
        private Boolean hasIssues = false;
        private Owner owner;
        @SerializedName("updated_on")
        private Date updatedOn;
        private Long size;
        private String type;
        private String description;

        /**
         * @return the scm
         */
        public String getScm() {
            return scm;
        }

        /**
         * @return the website
         */
        public String getWebsite() {
            return website;
        }

        /**
         * @return the hasWiki
         */
        public Boolean getHasWiki() {
            return hasWiki;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the language
         */
        public String getLanguage() {
            return language;
        }

        /**
         * @return the fullName
         */
        public String getFullName() {
            return fullName;
        }

        /**
         * @return the hasIssues
         */
        public Boolean getHasIssues() {
            return hasIssues;
        }

        /**
         * @return the owner
         */
        public Owner getOwner() {
            return owner;
        }

        /**
         * @return the updatedOn
         */
        public Date getUpdatedOn() {
            return updatedOn;
        }

        /**
         * @return the size
         */
        public Long getSize() {
            return size;
        }

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * @return the description
         */
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * Read API details from a Project hosted on BitBucket.
     * 
     * @param name the Project Name to read from
     * @return JsonElement of the auto-populated DOECodeMetadata entity
     */
    public static JsonElement readProject(String name) {
        DOECodeMetadata md = new DOECodeMetadata();
        Gson gson = new Gson();
        HttpGet get = new HttpGet(BITBUCKET_API_URL + name);
        
        try {
            Response response = gson.fromJson(HttpUtil.fetch(get), Response.class);
            
        } catch ( IOException e ) {
            // warn here
        }
        return md.getJson();
    }
}
