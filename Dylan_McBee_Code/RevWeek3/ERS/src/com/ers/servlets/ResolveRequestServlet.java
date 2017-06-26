package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;


@WebServlet("/ResolveRequestServlet")
public class ResolveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Employee employee;
       Service service = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String decision = request.getParameter("choice");
		int requestId = Integer.parseInt(request.getParameter("requestId"));
		
		HttpSession session = request.getSession();
		
		
		try{
			employee = (Employee) session.getAttribute("employee");
			int resolverId = employee.getId();
			
			if(decision.equals("approve")){
				service.acceptRequest(requestId, resolverId);
				response.sendRedirect("manhome");
			}
			else if(decision.equals("deny")){
				service.denyRequest(requestId, resolverId);
				response.sendRedirect("manhome");
			}
		}
		catch(NullPointerException npe){
			npe.printStackTrace();
		}
	
	
	}

}