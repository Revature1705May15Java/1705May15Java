package com.ex.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String hobby[] = request.getParameterValues("hobby");
		String language[] = request.getParameterValues("language");
		String country = request.getParameter("country");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<div>"
				+ "<p>Username: " + username + "</p>"
				+ "<p>Password: " + password + "</p>"
				+ "<p>Gender: " + gender + "</p>"
				+ "<p>Hobbies: ");
		
		for(int i = 0; i < hobby.length; i++){
			out.print(hobby[i] + " ");
		}
	
		out.println("</p>" + "<p>Country: " + country + "</p>"
				+ "<p>Languages: ");
	
		for(int i = 0; i < language.length; i++){
			out.print(language[i] + " ");
		}	
		
		out.println("</p>"+ "</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
