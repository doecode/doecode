/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ensornl
 */
public class GitHubTest {
    private static final Logger log = LoggerFactory.getLogger(GitHubTest.class);
    
    public GitHubTest() {
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
     * Test of readProject method, of class GitHub.
     */
    @Test
    public void testReadProject() {
        ObjectMapper mapper = new ObjectMapper();
        
        System.out.println("readProject");
        System.out.println("Result: " + 
                mapper.createObjectNode().putPOJO("metadata", GitHub.readProject("doecode/doecode")).toString());
//        System.out.println("Result: " + GitHub.readProject("doecode/doecode"));
    }
    
}
