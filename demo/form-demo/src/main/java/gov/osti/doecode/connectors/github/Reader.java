/*
 */
package gov.osti.doecode.connectors.github;

import com.google.gson.Gson;
import gov.osti.doecode.entity.Agent;
import gov.osti.doecode.entity.SoftwareRepository;
import gov.osti.doecode.util.Fetcher;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;

/**
 *
 * @author ensornl
 */
public class Reader {
    private static final String API_USER = System.getProperty("api-user");
    private static final String API_KEY = System.getProperty("api-key");
    
    /** REPOSITORY SAMPLE JSON
     * {
  "id": 62412089,
  "name": "doecode",
  "full_name": "doecode/doecode",
  "owner": {
    "login": "doecode",
    "id": 20195200,
    "avatar_url": "https://avatars.githubusercontent.com/u/20195200?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/doecode",
    "html_url": "https://github.com/doecode",
    "followers_url": "https://api.github.com/users/doecode/followers",
    "following_url": "https://api.github.com/users/doecode/following{/other_user}",
    "gists_url": "https://api.github.com/users/doecode/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/doecode/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/doecode/subscriptions",
    "organizations_url": "https://api.github.com/users/doecode/orgs",
    "repos_url": "https://api.github.com/users/doecode/repos",
    "events_url": "https://api.github.com/users/doecode/events{/privacy}",
    "received_events_url": "https://api.github.com/users/doecode/received_events",
    "type": "Organization",
    "site_admin": false
  },
  "private": false,
  "html_url": "https://github.com/doecode/doecode",
  "description": "Main repo for managing the new DOE Code site from the DOE Office of Scientific and Technical Information (OSTI)",
  "fork": false,
  "url": "https://api.github.com/repos/doecode/doecode",
  "forks_url": "https://api.github.com/repos/doecode/doecode/forks",
  "keys_url": "https://api.github.com/repos/doecode/doecode/keys{/key_id}",
  "collaborators_url": "https://api.github.com/repos/doecode/doecode/collaborators{/collaborator}",
  "teams_url": "https://api.github.com/repos/doecode/doecode/teams",
  "hooks_url": "https://api.github.com/repos/doecode/doecode/hooks",
  "issue_events_url": "https://api.github.com/repos/doecode/doecode/issues/events{/number}",
  "events_url": "https://api.github.com/repos/doecode/doecode/events",
  "assignees_url": "https://api.github.com/repos/doecode/doecode/assignees{/user}",
  "branches_url": "https://api.github.com/repos/doecode/doecode/branches{/branch}",
  "tags_url": "https://api.github.com/repos/doecode/doecode/tags",
  "blobs_url": "https://api.github.com/repos/doecode/doecode/git/blobs{/sha}",
  "git_tags_url": "https://api.github.com/repos/doecode/doecode/git/tags{/sha}",
  "git_refs_url": "https://api.github.com/repos/doecode/doecode/git/refs{/sha}",
  "trees_url": "https://api.github.com/repos/doecode/doecode/git/trees{/sha}",
  "statuses_url": "https://api.github.com/repos/doecode/doecode/statuses/{sha}",
  "languages_url": "https://api.github.com/repos/doecode/doecode/languages",
  "stargazers_url": "https://api.github.com/repos/doecode/doecode/stargazers",
  "contributors_url": "https://api.github.com/repos/doecode/doecode/contributors",
  "subscribers_url": "https://api.github.com/repos/doecode/doecode/subscribers",
  "subscription_url": "https://api.github.com/repos/doecode/doecode/subscription",
  "commits_url": "https://api.github.com/repos/doecode/doecode/commits{/sha}",
  "git_commits_url": "https://api.github.com/repos/doecode/doecode/git/commits{/sha}",
  "comments_url": "https://api.github.com/repos/doecode/doecode/comments{/number}",
  "issue_comment_url": "https://api.github.com/repos/doecode/doecode/issues/comments{/number}",
  "contents_url": "https://api.github.com/repos/doecode/doecode/contents/{+path}",
  "compare_url": "https://api.github.com/repos/doecode/doecode/compare/{base}...{head}",
  "merges_url": "https://api.github.com/repos/doecode/doecode/merges",
  "archive_url": "https://api.github.com/repos/doecode/doecode/{archive_format}{/ref}",
  "downloads_url": "https://api.github.com/repos/doecode/doecode/downloads",
  "issues_url": "https://api.github.com/repos/doecode/doecode/issues{/number}",
  "pulls_url": "https://api.github.com/repos/doecode/doecode/pulls{/number}",
  "milestones_url": "https://api.github.com/repos/doecode/doecode/milestones{/number}",
  "notifications_url": "https://api.github.com/repos/doecode/doecode/notifications{?since,all,participating}",
  "labels_url": "https://api.github.com/repos/doecode/doecode/labels{/name}",
  "releases_url": "https://api.github.com/repos/doecode/doecode/releases{/id}",
  "deployments_url": "https://api.github.com/repos/doecode/doecode/deployments",
  "created_at": "2016-07-01T18:22:03Z",
  "updated_at": "2016-12-06T19:40:14Z",
  "pushed_at": "2017-01-13T17:24:21Z",
  "git_url": "git://github.com/doecode/doecode.git",
  "ssh_url": "git@github.com:doecode/doecode.git",
  "clone_url": "https://github.com/doecode/doecode.git",
  "svn_url": "https://github.com/doecode/doecode",
  "homepage": "https://www.osti.gov/doecode",
  "size": 15567,
  "stargazers_count": 11,
  "watchers_count": 11,
  "language": "Java",
  "has_issues": true,
  "has_downloads": true,
  "has_wiki": true,
  "has_pages": false,
  "forks_count": 12,
  "mirror_url": null,
  "open_issues_count": 41,
  "forks": 12,
  "open_issues": 41,
  "watchers": 11,
  "default_branch": "master",
  "organization": {
    "login": "doecode",
    "id": 20195200,
    "avatar_url": "https://avatars.githubusercontent.com/u/20195200?v=3",
    "gravatar_id": "",
    "url": "https://api.github.com/users/doecode",
    "html_url": "https://github.com/doecode",
    "followers_url": "https://api.github.com/users/doecode/followers",
    "following_url": "https://api.github.com/users/doecode/following{/other_user}",
    "gists_url": "https://api.github.com/users/doecode/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/doecode/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/doecode/subscriptions",
    "organizations_url": "https://api.github.com/users/doecode/orgs",
    "repos_url": "https://api.github.com/users/doecode/repos",
    "events_url": "https://api.github.com/users/doecode/events{/privacy}",
    "received_events_url": "https://api.github.com/users/doecode/received_events",
    "type": "Organization",
    "site_admin": false
  },
  "network_count": 12,
  "subscribers_count": 19
}

     */
    
    private static HttpGet getGitHubUrl(String url) {
        HttpGet get = new HttpGet(url);
        String authentication = API_USER + ":" + API_KEY;
        byte[] encoded = Base64.encodeBase64(authentication.getBytes(Charset.forName("ISO-8859-1")));
        get.addHeader(HttpHeaders.AUTHORIZATION, "Basic " + new String(encoded));
        return get;
    }
    
    public static SoftwareRepository loadRepository(String project_name) throws IOException {
        long then = System.currentTimeMillis();
        SoftwareRepository repo = new SoftwareRepository();
        Gson gson = new Gson();
        
        Repository repository = gson.fromJson(Fetcher.getJsonFrom(getGitHubUrl("https://api.github.com/repos/" + project_name + "/" + project_name)), Repository.class);
        
        repo.setName(repository.getName());
        repo.setUrl(repository.getUrl());
        repo.setDescription(repository.getDescription());
        repo.setId(repository.getId());
        
        Contributor[] contributors = gson.fromJson(
                Fetcher.getJsonFrom(getGitHubUrl(repository.getContributorsUrl())), Contributor[].class);
        
        for ( Contributor contributor : contributors ) {
            User user = gson.fromJson(Fetcher.getJsonFrom(getGitHubUrl(contributor.getUrl())), User.class);
            Agent agent = new Agent();
            agent.setEmail(user.getEmail());
            agent.setAffiliation(user.getCompany());
            
            /** if no User name is present, default to the login name;
             * otherwise attempt to break into first/last name.
             */
            if (null==user.getName()) {
                agent.setFirstName(user.getLogin());
                agent.setLastName("(undefined)");
            } else {
                int lastSpace = user.getName().lastIndexOf(" ");
                if ( -1==lastSpace ) {
                    agent.setFirstName(user.getName());
                    agent.setLastName("(undefined)");
                } else {
                    agent.setFirstName(user.getName().substring(0, lastSpace));
                    agent.setLastName(user.getName().substring(lastSpace+1));
                }
            }
            repo.addAgent(agent);
        }
        long now = System.currentTimeMillis();
        
        System.out.println("Elapsed: " + (now-then) + " ms.");
        return repo;
    }
}
