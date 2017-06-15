package com.revature.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.RequestState;
import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
   * Requests that must be handled:
   * get the data for the table (employee or manager)
   * (maybe - server-side data pagination) get more data for the table (employee or manager)
   * get the account settings for a user (employee or manager)
   * update the account settings for a user (employee or manager)
   * (maybe) promote a user to manager (manager)
   * create a new request (employee)
   * approve or deny a request (manager)
   */
	
	/*
	 * - server needs to be keeping track of request/response times for each user that is logged in,
	 *   that way, information about new reimbursement requests can be regularly sent to an active user 
	 * 
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ERService service = new ERService();
    HttpSession session = request.getSession();
    if (((User) session.getAttribute("user")) != null) {
      /*
       * employees and managers get forwarded to the main.ftl page, and FreeMarker determines what content they see
       */
      ArrayList<RequestState> states = service.getRequestStates();
      for (RequestState s: states) {
        request.setAttribute(s.getName(), s);
      }
      request.getRequestDispatcher("main.ftl").forward(request, response);
    } else {
      /*
       * if there is no current user stored in the session, redirect to (login or logout ?) page
       */
      response.sendRedirect("login");
//      response.sendRedirect("logout");
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response); 
	}
	
}
