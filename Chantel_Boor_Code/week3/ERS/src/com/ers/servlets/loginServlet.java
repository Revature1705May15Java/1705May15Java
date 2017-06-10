package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String email = request.getParameter("username");
		String pw = request.getParameter("password");
		
		request.setAttribute("login", "-");
		request.setAttribute("name", email);
		request.setAttribute("pass", pw);
		
		Service s = new Service();
		Employee e = new Employee();
		
		
		try
		{
			e = s.login(email,pw);
			
			if(e.getEmployeeId() != 0)
			{
				
				if(e.getIsManager() == 1)
				{
					request.getRequestDispatcher("mHome.ftl").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("eHome.ftl").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("login","fail");
				request.getRequestDispatcher("index.ftl").forward(request, response);
				
			}
		}catch (NullPointerException n)
		{
			n.printStackTrace();
		}
		
		
	}

}
