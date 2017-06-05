package com.ex.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter(); // this allows you to write html directly from the servlet
		
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		
		out.println("<h3>Reading query string data using 'String getParameter(String name) method. </h3>");
		out.println("<div>"
				+ "<p>Our first name " + firstname + "</p>"
				+ "<p>Our last name " + lastname + "</p>"
				+ "</div>");
		/*
		 * From here we append parameter values to the end of the url, "url?fn=John&ln=Doe"
		 */
		
		out.println("<h3>Reading QueryString data using Enumeration getParameterNames() method</h3>");
		Enumeration<String> parameters = request.getParameterNames();
		out.println("<div>");
		
		while(parameters.hasMoreElements()){
			String paramName = parameters.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>" + paramName + " : " + paramValue + "</p>");
		}
		out.println("</div>");
		
		
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNameSet = paramMap.keySet();
		
		out.println("<h3> Read QueryString data using Map getParamterMap() method </h3>");
		out.println("<div>");
		for(String paramName : paramNameSet){
			String[] paramValue = paramMap.get(paramName);
			out.println("<p>" + paramName + " : " + paramValue + "</p>");
		}
		out.println("</div>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
