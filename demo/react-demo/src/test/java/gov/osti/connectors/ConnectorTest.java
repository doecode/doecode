/*
 */
package gov.osti.connectors;

import com.google.gson.JsonElement;
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
public class ConnectorTest {
    
    public ConnectorTest() {
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
     * Test of readProject method, of class Connector.
     */
    @Test
    public void testReadProject() {
        System.out.println("Sourceforge URL: https://sourceforge.net/projects/desmume");
        JsonElement result = Connector.readProject("https://sourceforge.net/projects/desmume");
        System.out.println("Result: " + result.toString());
        
        System.out.println("GitHub: https://github.com/doecode/doecode");
        result = Connector.readProject("https://github.com/doecode/doecode");
        System.out.println("Result: " + result.toString());
        
        System.out.println("BitBucket: https://bitbucket.org/ensorn/chorus-reader");
        result = Connector.readProject("https://bitbucket.org/ensorn/chorus-reader");
        System.out.println("Result: " + result.toString());
        
        System.out.println("BB raw: bitbucket.org/ensorn/chorus-reader");
        result = Connector.readProject("bitbucket.org/ensorn/chorus-reader");
        System.out.println("Result: " + result.toString());
    }
    
}
