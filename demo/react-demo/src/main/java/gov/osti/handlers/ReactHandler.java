package gov.osti.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;

import com.google.gson.JsonObject;

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
		default:
			return null;

		}

	}

	
	private static String handleActionLoad(long codeId) {
		JsonObject responseObject = new JsonObject();
		DOECodeMetadata md = DOECodeMetadata.lookup(codeId);
		if (md == null)
			md = new DOECodeMetadata();
		md.setSoftwareTitle("something");
		md.setAcronym("ORNL");
		md.setDescription("Description");
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Developer d1 = new Developer();
		d1.setFirstName("Thomas");
		d1.setMiddleName("George");
		d1.setLastName("Welsch");
		d1.setEmail("twelsch1998@gmail.com");
		Developer d2 = new Developer();
		d2.setFirstName("Phillip");
		d2.setMiddleName("N/A");
		d2.setLastName("Fulmer");
		d2.setEmail("nextad@utk.edu");
		developers.add(d1);
		developers.add(d2);
		md.setDevelopers(developers);
		
		
		responseObject.add("metadata", md.getJson());
		System.out.println(md.getJson().toString());
		
		return responseObject.toString();
		
		
	}
	
	private static String handleActionSave(BufferedReader reader) throws IOException {
		JsonObject responseObject = new JsonObject();
		DOECodeMetadata md = DOECodeMetadata.parseJson(reader);
		System.out.println("md is" + md);
		md.save();
		responseObject.add("metadata",md.getJson());
		
		
		return responseObject.toString();
		
		
	}
}
