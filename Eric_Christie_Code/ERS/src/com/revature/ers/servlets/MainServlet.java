package com.revature.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
//@WebServlet("/MainServlet")
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	}
	
}
