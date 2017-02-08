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
public class BitBucketTest {
    
    public BitBucketTest() {
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
     * Test of readProject method, of class BitBucket.
     */
    @Test
    public void testReadProject() {
        System.out.println("readProject");
        JsonElement result = BitBucket.readProject("ensorn/chorus-reader");
        System.out.println("Result: " + result.toString());
    }
    
}
