/*
 */
package gov.osti.connectors;

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
public class SourceForgeTest {
    private static final Logger log = LoggerFactory.getLogger(SourceForgeTest.class);
    
    public SourceForgeTest() {
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
     * Test of readProject method, of class SourceForge.
     */
    @Test
    public void testReadProject() {
        System.out.println("readProject");
        System.out.println("Result: " + SourceForge.readProject("desmume"));
    }
    
}
