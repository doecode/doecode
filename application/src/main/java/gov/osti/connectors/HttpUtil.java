/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import gov.osti.entity.DOECodeMetadata;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Common HTTP-related utilities, such as HttpClient-based web requests for API
 * information.
 * 
 * @author ensornl
 */
public class HttpUtil {
    // logger
    protected static final Logger log = LoggerFactory.getLogger(HttpUtil.class);
    
    // jackson mapper
    protected static final ObjectMapper mapper = new ObjectMapper(new YAMLFactory())
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .setSerializationInclusion(Include.NON_NULL);
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
            // only return if response is OK
            HttpResponse response = hc.execute(get);
            return ( HttpServletResponse.SC_OK==response.getStatusLine().getStatusCode()) ?
                    EntityUtils.toString(response.getEntity()) :
                    "";
        } finally {
            hc.close();
        }
    }
    
    /**
     * Attempt to read URL (file) as a YAML metadata reference.  Returns null
     * if YAML file not found or could not process.
     * 
     * @param url the URL to the file to attempt to read
     * @return JSON representation of the YAML read, or null if not found/invalid
     * @throws IOException on file IO errors
     */
    protected static JsonNode readMetadataYaml(String url) throws IOException {
        try {
            // read the YAML in as a DOECodeMetadata record
            DOECodeMetadata yaml = mapper.readValue(HttpUtil.fetch(new HttpGet(url)), DOECodeMetadata.class);
            return (null==yaml) ? null : yaml.toJson();
        } catch ( IOException e ) {
            // no YAML or illegal format, skip it
            return null;
        }
    }
}
