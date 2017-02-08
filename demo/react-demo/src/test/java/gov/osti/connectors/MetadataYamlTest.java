/*
 */
package gov.osti.connectors;

import gov.osti.connectors.yaml.Identifier;
import gov.osti.connectors.yaml.Person;
import gov.osti.connectors.yaml.Organization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ensornl
 */
public class MetadataYamlTest {
    // the base execution directory for Junit tests
    private static final String basedir = System.getProperty("basedir");
    
    public MetadataYamlTest() {
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
     * Obtain a filesystem path for testing resource files.
     * 
     * @param filename the relative filename to map
     * @return a filesystem path to that file
     */
    private static final String getPathFor(String filename) {
        return basedir + File.separator + "src" + File.separator + "test" + File.separator + filename;
    }
    
    /**
     * Test parsing known YAML file.
     * 
     * @throws Exception on unexpected events
     */
    @Test
    public void testYamlParsing() throws Exception {
        final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        
        MetadataYaml metadata = mapper.readValue(new FileReader(getPathFor("metadata.yml")), MetadataYaml.class);
        
        // assert the known elements
        assertEquals ("Title is wrong", 
                "My fancy software title",
                metadata.getTitle());
        assertEquals ("URL is wrong",
                "https://github.com/doecode/dev-test-repo",
                metadata.getCodeRepository());
        
        assertEquals("Description is wrong", "This is a sample lengthy description.\n" +
"It may span multiple lines, and captures the newlines as part\n" +
"of its description.\n", metadata.getDescription());
        
        System.out.println("Date: " + metadata.getDateCreated());
        
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        assertEquals ("Date created wrong",  
//                "02/07/2017",
//                sdf.format(metadata.getDateCreated()));
        
        List<Organization> submitters = metadata.getSubmittingOrganizations();
        
        assertEquals("There should be 2 organizations.", 2, submitters.size());
        assertTrue  ("ORNL not there", submitters.contains(new Organization("ORNL")));
        assertTrue  ("OSTI not there", submitters.contains(new Organization("OSTI")));
        
        List<Person> developers = metadata.getDevelopers();
        
        assertEquals("Should be 2 developers", 2, developers.size());
        
        for ( Person d : developers ) {
            if ("Neal".equals(d.getFirstName())) {
                assertEquals("family name wrong", "Ensor", d.getFamilyName());
                assertEquals("email wrong", "nensor@gmail.com", d.getEmail());
                assertEquals("based at wrong", "OSTI", d.getBasedAt());
                assertNotNull("Should have an ORCID", d.getOrcID());
                Identifier orcid = d.getOrcID();
                assertEquals("ORCID wrong", "1111222233334444", orcid.getIdentNumber());
            } else if ("Thomas".equals(d.getFirstName())) {
                assertEquals("family name wrong", "Welsch", d.getFamilyName());
                assertEquals("email wrong", "welscht@osti.gov", d.getEmail());
                assertEquals("based at wrong", "OSTI", d.getBasedAt());
                assertNull  ("Should have no ORCID", d.getOrcID());
            } else {
                fail ("Unknown developer: " + d.getFirstName() + " " + d.getFamilyName());
            }
        }
        
        List<String> keywords = metadata.getKeywords();
        
        assertEquals("Should be 3 keywords", 3, keywords.size());
        assertTrue  ("Missing Fancy Hats", keywords.contains("Fancy Hats"));
        assertTrue  ("Missing Portable", keywords.contains("Portable"));
        assertTrue  ("Missing Generic", keywords.contains("Generic"));
        
        Identifier doi = metadata.getDoi();
        
        assertEquals("DOI is wrong", "https://doi.org/10.5072/123456", doi.getIdentNumber());
        assertEquals("DOI scheme is wrong", "DOI", doi.getIdentName());
        
        System.out.println("JSON: " + metadata.toJson());
    }
    
}
