/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Common HTTP-related utilities, such as HttpClient-based web requests for API
 * information.
 * 
 * @author ensornl
 */
public class HttpUtil {
    /**
     * Retrieve just the String content from a given HttpGet request.
     * 
     * @param get the GET to execute
     * @return String contents of the results
     * @throws IOException on IO errors
     */
    protected static String fetch(HttpGet get) throws IOException {
        // set some reasonable default timeouts
        RequestConfig rc = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
        // create an HTTP client to request through
        CloseableHttpClient hc = 
                HttpClientBuilder
                .create()
                .setDefaultRequestConfig(rc)
                .build();
        
        try {
            return EntityUtils.toString(hc.execute(get).getEntity());
        } finally {
            hc.close();
        }
    }
    
    /**
     * Attempt to read URL (file) as a YAML metadata reference.
     * 
     * @param url the URL to the file to attempt to read
     * @return JSON representation of the YAML read, or null if not found/invalid
     * @throws IOException on file IO errors
     */
    protected static String readMetadataYaml(String url) throws IOException {
        final HttpGet get = new HttpGet(url);
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        MetadataYaml yaml = mapper.readValue(HttpUtil.fetch(get), MetadataYaml.class);
        
        return yaml.toJson();
    }
}
