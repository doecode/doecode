/*
 */
package gov.osti.connectors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
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
        // test YAML retrieval and output
        System.out.println("reading dev-test-repo: " + GitHub.readProject("doecode/dev-test-repo").toString());
    }
    
}
