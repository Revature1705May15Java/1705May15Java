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

@WebServlet("/Home2Servlet")
public class ManagerHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static User u = new User();
    static Service service = new Service();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		u = (User) session.getAttribute("user");
		
		if(u == null) response.sendRedirect("logout");
		else{	
			u = service.getUserInfo(u.getId()); // updating all request information about the user.

			request.setAttribute("Requests", u.getRequests());		
			request.setAttribute("user", u);
			request.getRequestDispatcher("home").forward(request, response);
		}			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}