package com.revature.ers.servlets;

import java.io.IOException;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.ers.pojos.User;
import com.revature.ers.service.ERService;

/**
 * Servlet implementation class SettingsServlet
 */
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/*
	 * This servlet is for a user to view and change his account settings.
	 * It should behave the same for employees and managers:
	 * - GET retrieve the current user's account settings/information
	 * - POST update the current user's account settings/information with any new information provided
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ERService service = new ERService();
    HttpSession session = request.getSession();
    User u = (User) session.getAttribute("user");
    if (u != null) {
      /*
       * retrieve the account settings/information for the current user
       */
      
    } else {
      response.sendRedirect("login");
    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  ERService service = new ERService();
    HttpSession session = request.getSession();
    User u = (User) session.getAttribute("user");
    if (u != null) {
      /*
       * parse request body and (if there is nothing wrong with it) use its contents to update the current user's account settings/information
       */
    } else {
      response.sendRedirect("login");
    }
	}

}
