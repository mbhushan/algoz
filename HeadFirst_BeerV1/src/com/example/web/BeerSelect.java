package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class BeerSelect extends HttpServlet{
	
	public void doPost( HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Beer selection advice  <br>");
		
		String c = request.getParameter("color");
		out.println("<br>Got beer advice: " + c);
	}
}
