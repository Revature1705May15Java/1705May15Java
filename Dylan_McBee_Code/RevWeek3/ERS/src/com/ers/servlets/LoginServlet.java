package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String myContextParam = request.getSession().getServletContext().getInitParameter("myParam");
		String name = request.getParameter("userName");
		String pw = request.getParameter("password");
		//out.println(myContextParam + " " + name + " " + pw);
		if(name.equals("admin")){
			out.println("A boss");
		}
		else{
			out.println("not a boss");
		}
	}

}
