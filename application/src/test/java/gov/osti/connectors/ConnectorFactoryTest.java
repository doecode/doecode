/*
 */
package gov.osti.connectors;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ensornl
 */
public class ConnectorFactoryTest {
    
    public ConnectorFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test the ConnectorFactory instantiation and processing
     * @throws IOException on init errors
     */
    @Test
    public void testReadProject() throws IOException {
        ConnectorFactory factory = ConnectorFactory.getInstance()
                .add(new GitHub())
                .add(new SourceForge())
                .add(new BitBucket())
                .build();
        
        String[] urls = {
            "https://sourceforge.net/projects/desmume",
            "https://github.com/doecode/doecode",
            "github.com/doecode/dev-test-repo",
            "bitbucket.org/ensorn/chorus-reader"
        };
        
        for ( String url : urls ) {
            System.out.println("URL: " + url);
            System.out.println("Result: " + factory.read(url));
        }
    }
    
}
