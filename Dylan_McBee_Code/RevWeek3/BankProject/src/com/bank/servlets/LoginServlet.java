package com.bank.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("userName");
		String pass = request.getParameter("password");

		Service service = new Service();

		try {
			User u = new User();
			boolean isUser = true;
			if (service.checkUser(user) == false) {
				isUser=false;
			} else {
				if (service.checkPassword(user, pass) == false) {
					isUser=false;
				} else {
					u = service.getUser(user);
					isUser = true;
				}
			}
			if (isUser) {
				RequestDispatcher rd = request.getRequestDispatcher("Success.html");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Error.html");
				rd.forward(request, response);
			}
		} catch (NullPointerException npe) {
			npe.printStackTrace();
		}
	};

}
