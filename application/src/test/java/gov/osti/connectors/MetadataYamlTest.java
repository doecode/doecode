/*
 */
package gov.osti.connectors;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import gov.osti.connectors.yaml.Identifier;
import gov.osti.connectors.yaml.Person;
import gov.osti.connectors.yaml.Organization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import java.io.File;
import java.io.FileReader;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ensornl
 */
public class MetadataYamlTest {
    // the base execution directory for Junit tests
    private static final String basedir = System.getProperty("basedir");
    // logger
    private static final Logger log = LoggerFactory.getLogger(MetadataYamlTest.class);
    
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
     * Test YAML-to-DOECodeMetadata translation.
     * 
     * @throws Exception on unexpected errors
     */
    @Test
    public void testYamlToMetadata() throws Exception {
        final ObjectMapper mapper = 
                new ObjectMapper(new YAMLFactory())
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .setSerializationInclusion(Include.NON_NULL);
        
        DOECodeMetadata metadata = mapper.readValue(new FileReader(getPathFor("metadata1.yml")), DOECodeMetadata.class);
        
        assertNotNull("Metadata parsing failed!", metadata);
        
        assertEquals("Repo URL wrong", "https://github.com/doecode/dev-test-repo", metadata.getRepositoryLink());
        
        List<Developer> developers = metadata.getDevelopers();
        assertEquals("Wrong number of developers", 4, developers.size());
        
        for ( Developer d : developers ) {
            if ("Jay Jay".equals(d.getFirstName())) {
                assertEquals("Last name wrong", "Billings", d.getLastName());
                assertEquals("Affiliations wrong", "Oak Ridge National Laboratory", d.getAffiliations());
                assertEquals("place is wrong", new Integer(1), d.getPlace());
            } else if ("Knight".equals(d.getLastName())) {
                assertEquals("First name wrong", "Katie", d.getFirstName());
                assertEquals("Email wrong", "knight.kathryn@gmail.com", d.getEmail());
                assertEquals("Affiliations wrong", "Oak Ridge National Laboratory", d.getAffiliations());
                assertEquals("Place is wrong", new Integer(2), d.getPlace());
            } else if ("Ensor".equals(d.getLastName())) {
                assertEquals("First name wrong", "Neal", d.getFirstName());
                assertEquals("email wrong", "ensorn@osti.gov", d.getEmail());
                assertEquals("Place is wrong", new Integer(3), d.getPlace());
            } else if ("Welsch".equals(d.getLastName())) {
                assertEquals("First name wrong", "Thomas", d.getFirstName());
                assertEquals("Affiliation wrong", "Information International Associates (Contractor to DOE)", d.getAffiliations());
                assertEquals("email wrong", "welscht@osti.gov", d.getEmail());
                assertEquals("place is wrong", new Integer(4), d.getPlace());
            } else {
                fail ("Unknown developer found: " + d.getLastName());
            }
        }
        assertEquals("research organizations wrong", "OSTI, ORNL", metadata.getOriginatingResearchOrganizations());
        assertEquals("title is wrong", "Sample development and testing repository for DOECode", metadata.getSoftwareTitle());
        assertEquals("Acronym wrong", "dev-test-repo", metadata.getAcronym());
        assertEquals("DOI wrong", "10.5072/23892", metadata.getDoi());
        assertEquals("Description wrong", "An example testing repository for submissions of YAML and other associated testing projects related to the development of DOECode.\n",
                metadata.getDescription());
        assertEquals("RI wrong", "related identifier", metadata.getRelatedIdentifiers());
        assertEquals("Keywords wrong", "software, DOECode, hosting repositories", metadata.getKeywords());
        assertEquals("disclaimers wrong", "open source", metadata.getDisclaimers());
        assertEquals("recipient name wrong", "Neal Ensor", metadata.getRecipientName());
        assertEquals("recipient email wrong", "ensorn@osti.gov", metadata.getRecipientEmail());
        assertEquals("recipient phone wrong", "865-576-1295", metadata.getRecipientPhone());
        assertEquals("recipient org wrong", "DOE OSTI", metadata.getRecipientOrg());
        assertEquals("Accession number wrong", "384983", metadata.getSiteAccessionNumber());
        assertEquals("other requirements wrong", "none", metadata.getOtherSpecialRequirements());
        assertEquals("related software wrong", "linux, github, bitbucket", metadata.getRelatedSoftware());
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
        
    }
    
}
