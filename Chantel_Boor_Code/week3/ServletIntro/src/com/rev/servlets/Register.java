package com.rev.servlets;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("userName");
		String password = request.getParameter("pwd");
		String drink = request.getParameter("soda");
		String[] fruit = request.getParameterValues("fruit");
		String icecream = request.getParameter("flavors");
		String[] pizza = request.getParameterValues("top");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div>");
		out.println("<p>UserName: " + username + "</p>");
		out.println("<p>PassWord: " + password + "</p>");
		out.println("<p>Favorite Soda: " + drink + "</p>");
		
		out.println("<p>Fruits:</p>");
		for(int i=0;i<fruit.length;i++)
			out.println(fruit[i]);
		
		out.println("<p>Favorite Flavor: " + icecream + "</p>");
		
		out.println("<p>Pizza Toppings: </p>");
		for(int i=0;i<pizza.length;i++)
			out.println(pizza[i]);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}