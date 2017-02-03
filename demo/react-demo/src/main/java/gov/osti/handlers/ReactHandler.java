package gov.osti.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.JsonObject;

import gov.osti.connectors.Connector;
import gov.osti.entity.DOECodeMetadata;
import gov.osti.entity.Developer;
import gov.osti.util.ServletUtil;

public class ReactHandler {


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
		JsonObject responseObject = new JsonObject();
		//DOECodeMetadata md = DOECodeMetadata.lookup(codeId);
		//if (md == null)
		DOECodeMetadata md = new DOECodeMetadata();
		md.setSoftwareTitle("something");
		md.setAcronym("ORNL");
		md.setDescription("Description");
		md.setDevelopers(new ArrayList<Developer>());


		responseObject.add("metadata", md.getJson());
		System.out.println(md.getJson().toString());

		return responseObject.toString();


	}
	
	private static String handleActionAutopopulate(String repositoryUrl) {
		JsonObject responseObject = new JsonObject();
		
		responseObject.add("metadata", Connector.readProject(repositoryUrl));
		return responseObject.toString();
	}

	private static String handleActionSave(BufferedReader reader) throws IOException {
		JsonObject responseObject = new JsonObject();
		DOECodeMetadata md = DOECodeMetadata.parseJson(reader);
		md.save();
		responseObject.add("metadata",md.getJson());


		return responseObject.toString();


	}
}
