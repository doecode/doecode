/*
 */
package gov.osti.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.osti.entity.Contributor;
import gov.osti.entity.Identifier;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Web Service
 *
 * @author ensornl
 */
@Path("types")
public class Types {

    @Context
    private UriInfo context;
    // a Logger
    private static final Logger log = LoggerFactory.getLogger(Types.class);
    // JSON data binder
    private static final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Creates a new instance of TypeService
     */
    public Types() {
    }

    /**
     * Retrieves representation of an instance of gov.osti.services.TypeService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path ("/contributors")
    public Response getContributorTypes() {
        try {
            return Response
                    .ok()
                    .entity(mapper.writeValueAsString(Contributor.Type.values()))
                    .build();
        } catch ( JsonProcessingException e ) {
            log.warn("JSON Error: " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/identifiers")
    public Response getIdentifierTypes() {
        try {
        return Response
                .ok()
                .entity(mapper.writeValueAsString(Identifier.Type.values()))
                .build();
        } catch ( JsonProcessingException e ) {
            log.warn("JSON Error: " + e.getMessage());
            return Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/relations")
    public Response getRelationTypes() {
        try {
            return Response
                    .ok()
                    .entity(mapper.writeValueAsString(Identifier.RelationType.values()))
                    .build();
        } catch ( JsonProcessingException e ) {
            log.warn("JSON Error: " + e.getMessage());
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
