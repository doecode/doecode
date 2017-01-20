/*
 */
package gov.osti.doecode.util;

import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author ensornl
 */
public class Fetcher {
    public static String getJsonFrom(HttpGet get) throws IOException {
        StringBuilder b = new StringBuilder();
        CloseableHttpClient hc = HttpClients.createDefault();
        
        String response = EntityUtils.toString(hc.execute(get).getEntity());
        
        return response;
    }
}
