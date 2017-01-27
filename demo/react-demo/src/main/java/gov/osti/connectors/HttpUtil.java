/*
 */
package gov.osti.connectors;

import java.io.IOException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
        CloseableHttpClient hc = HttpClients
                .custom()
                .setHostnameVerifier(new AllowAllHostnameVerifier())
                .setDefaultRequestConfig(rc)
                .build();
        
        try {
            return EntityUtils.toString(hc.execute(get).getEntity());
        } finally {
            hc.close();
        }
    }
}
