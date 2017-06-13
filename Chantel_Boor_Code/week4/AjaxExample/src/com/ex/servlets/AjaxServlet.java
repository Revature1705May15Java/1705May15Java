package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getBetterJSON")
public class AjaxServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		Person jhon = new Person("Jhon",32);
		
		ObjectMapper mapper = new ObjectMapper ();
		String jhonJSON = mapper.writeValueAsString(jhon);
		
		resp.setContentType("appplication/json");
		PrintWriter out = resp.getWriter();
		
		out.write(jhonJSON);
		

	}

	
	
}