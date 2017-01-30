/*
 */
package gov.osti.connectors;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.IOException;
import java.util.ArrayList;
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
    
    /**
     * Simple embedded class to get at HREF / URL link reference within another
     * Object.
     */
    private class Href {
        private String href = "";
        
        /**
         * Retrieve the HREF value if present
         * @return the HREF value of a Link
         */
        public String getHref() {
            return href;
        }
    }
    
    /**
     * Define the relevant or interesting Links of Users/Owners.
     */
    private class Link {
        private Href self = null;
        private Href html = null;
        private Href avatar = null;
        private Href following = null;
        private Href followers = null;
        private Href snippets = null;
        private Href repositories = null;
        private Href hooks = null;
        @SerializedName("updated_on")
        private Date updatedOn;

        /**
         * @return the self
         */
        public String getSelf() {
            return (null==self) ? "" : self.getHref();
        }

        /**
         * @return the html
         */
        public String getHtml() {
            return (null==html) ? "" : html.getHref();
        }

        /**
         * @return the avatar
         */
        public String getAvatar() {
            return (null==avatar) ? "" : avatar.getHref();
        }
        
        /**
         * Get the "hooks" URL.
         * @return the hooks URL if present
         */
        public String getHooks() {
            return (null==hooks) ? "" : hooks.getHref();
        }
        
        /**
         * Get the FOLLOWERS URL.
         * @return the URL if present
         */
        public String getFollowers() {
            return (null==followers) ? "" : followers.getHref();
        }
        
        /**
         * Get the FOLLOWING URL
         * @return the URL if present
         */
        public String getFollowing() {
            return (null==following) ? "" : following.getHref();
        }

        /**
         * @return the updatedOn
         */
        public Date getUpdatedOn() {
            return updatedOn;
        }
    }
    
    /**
     * Define the common information for User/Owner API response information.
     */
    private class User {
        private String username;
        private String website;
        @SerializedName("display_name")
        private String displayName;
        private Link links;
        @SerializedName("created_on")
        private Date createdOn;
        private String type;

        /**
         * @return the username
         */
        public String getUsername() {
            return username;
        }

        /**
         * @return the website
         */
        public String getWebsite() {
            return website;
        }

        /**
         * @return the displayName
         */
        public String getDisplayName() {
            return displayName;
        }

        /**
         * @return the links
         */
        public Link getLinks() {
            return links;
        }

        /**
         * @return the createdOn
         */
        public Date getCreatedOn() {
            return createdOn;
        }

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }
    }
    
    /**
     * the base API Response from BitBucket.
     */
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
        private User owner;
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
         * @return the owner's User Object
         */
        public User getOwner() {
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
     * Team member listing from API queries.
     */
    private class MemberList {
        // page length in rows
        @SerializedName("pagelen")
        private Integer length;
        // set of Users on this page
        @SerializedName("values")
        private User[] users;
        // the number of Users in total
        private Integer size;
        // the page number, starting at 1
        private Integer page;

        /**
         * @return the length
         */
        public Integer getLength() {
            return length;
        }

        /**
         * @return the User records
         */
        public User[] getUsers() {
            return users;
        }

        /**
         * @return the size
         */
        public Integer getSize() {
            return size;
        }

        /**
         * @return the page
         */
        public Integer getPage() {
            return page;
        }
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
            
            // glean what information we can from the JSON
            md.setSoftwareTitle(response.getFullName());
            md.setAcronym(response.getName());
            md.setDescription(response.getDescription());
            
            // if the "owner" is type "user", that's the only developer we can get
            // if it's a "team", go fetch team information for developers
            ArrayList<Developer> developers = new ArrayList<>();
            if ( "user".equals(response.getOwner().getType()) ) {
                Developer developer = new Developer();
                String[] nameParts = parseName(response.getOwner().getDisplayName());
                
                developer.setFirstName(nameParts[0]);
                developer.setLastName(nameParts[1]);
                
                developers.add(developer);
            } else if ( "team".equals(response.getOwner().getType()) ) {
                // skip a step, tack on "/members" to get at the member list
                MemberList teamList = gson.fromJson(
                        HttpUtil.fetch(new HttpGet(response.getOwner().getLinks().getSelf() + "/members")), MemberList.class);
                
                User[] users = teamList.getUsers();
                for ( User user : users ) {
                    Developer developer = new Developer();
                    String[] nameParts = parseName(user.getDisplayName());
                    
                    developer.setFirstName(nameParts[0]);
                    developer.setLastName(nameParts[1]);
                    
                    developers.add(developer);
                }
            }
            md.setDevelopers(developers);
            
        } catch ( IOException e ) {
            // warn here
        }
        return md.getJson();
    }
}
