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
        System.out.println("readProject");
        String result = GitHub.readProject("doecode/doecode");
        System.out.println("Result: " + result);
        
        System.out.println("Result#2: " + GitHub.readProject("doecode/dev-test-repo"));
    }
    
}
