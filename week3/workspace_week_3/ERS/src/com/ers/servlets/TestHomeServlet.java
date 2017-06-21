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

@WebServlet("/TestServlet")
public class TestHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static User u = new User();
    static Service service = new Service();
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\nTestHomeServlet");
		HttpSession session = request.getSession(true);
		u = (User) session.getAttribute("user");
		
		if(u == null) response.sendRedirect("logout");
		else{	
			u = service.getUserInfo(u.getId()); // updating all request information about the user.
			System.out.println("Requests: " + u.getRequests().size());
			
			request.setAttribute("fn", u.getFn());
			request.setAttribute("ln", u.getLn());
			request.setAttribute("Requests", u.getRequests());		
			request.setAttribute("user", u);
			System.out.println("\n\nManagerHomeServlet 2 \n");
			request.getRequestDispatcher("/test.ftl").forward(request, response);
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