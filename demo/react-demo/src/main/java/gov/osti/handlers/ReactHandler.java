package gov.osti.handlers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;


import gov.osti.connectors.Connector;
import gov.osti.entity.DOECodeMetadata;

public class ReactHandler {

    private static final ObjectMapper mapper = new ObjectMapper();

	public static String handleRequest(HttpServletRequest request) throws IOException {

		String action = request.getParameter("action");
		Long osti_id = NumberUtils.toLong(request.getParameter("code_id"), 0);


		switch (action) {

		case "load":
			return handleActionLoad(osti_id);
		case "save":
			return handleActionSave(request.getReader());
		case "autopopulate":
			return handleActionAutopopulate(request.getParameter("repo"));
		default:
			return null;

		}

	}


	private static String handleActionLoad(long codeId) {
            return "";
//		JsonObject responseObject = new JsonObject();
//		//DOECodeMetadata md = DOECodeMetadata.lookup(codeId);
//		//if (md == null)
//		DOECodeMetadata md = new DOECodeMetadata();
//		md.setSoftwareTitle("something");
//		md.setAcronym("ORNL");
//		md.setDescription("Description");
//		md.setDevelopers(new ArrayList<Developer>());
//
//
//		responseObject.add("metadata", md.toJson());
//		System.out.println(md.toJson().toString());
//
//		return responseObject.toString();


	}
	
	private static String handleActionAutopopulate(String repositoryUrl) {
            return mapper.createObjectNode().putPOJO("metadata", Connector.readProject(repositoryUrl)).toString();
	}

	private static String handleActionSave(BufferedReader reader) throws IOException {
            return mapper.createObjectNode().putPOJO("metadata", DOECodeMetadata.parseJson(reader)).toString();
	}
}
