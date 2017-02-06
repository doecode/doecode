package gov.osti.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import gov.osti.handlers.ReactHandler;
import gov.osti.util.ServletUtil;


public class ServiceRouter extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {


		String service = StringUtils.substringAfterLast(request.getRequestURI(), "/");
		PrintWriter writer = response.getWriter();


		switch(service) {
		case "react":
			response.setContentType("application/javascript;charset=UTF-8");
			writer.write(ReactHandler.handleRequest(request));
				
		default:
			return;
		}


	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
