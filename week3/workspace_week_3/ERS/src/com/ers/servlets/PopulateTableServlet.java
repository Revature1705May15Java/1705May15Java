package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojo.User;
import com.ers.service.Service;

@WebServlet("/HomeServlet")
public class PopulateTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static User u = new User();
    static Service service = new Service();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		u = (User) session.getAttribute("user");
		String sortBy = request.getParameter("r");
		
		if(u == null) response.sendRedirect("logout");
		else if(u.getRank() == 0 && sortBy != null && sortBy.equals("closed")){
			request.setAttribute("Requests", service.getAllUserClosedRequests(u));
			request.setAttribute("user", u);
		}
		else if(sortBy != null && sortBy.equals("closed")) {
			request.setAttribute("Requests", service.getAllClosedRequests());
			request.setAttribute("user", u);
		}
		else if(u.getRank() == 0 || (sortBy != null && sortBy.equals("req"))){ // View selected = "My Requests", default for employees.
			System.out.println("Run");
			u = service.getUserInfo(u.getId()); // updating all request information about the user.
			System.out.println("Run2");
			request.setAttribute("Requests", u.getRequests());
			request.setAttribute("user", u);
		}
		else {// The user selected the view "Open Requests, this is also the default."	
			request.setAttribute("Requests", service.getAllOpenRequests());
		}
		if(u.getRank() == 0) request.getRequestDispatcher("/Home.ftl").forward(request, response);
		else if(u.getRank() == 1) request.getRequestDispatcher("/Home2.ftl").forward(request, response);
		else if(u.getRank() == 2) request.getRequestDispatcher("/test.ftl").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}