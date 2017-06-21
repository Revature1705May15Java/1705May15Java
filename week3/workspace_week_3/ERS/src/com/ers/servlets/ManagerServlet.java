package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.Service;

/**
 * This servlet is handling the creation of a new employee account.
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname = request.getParameter("username").trim();
		String pw = request.getParameter("password").trim();
		String fn = request.getParameter("firstname").trim();
		String ln = request.getParameter("lastname").trim();
		String rankString = request.getParameter("rank");
		int rank;
		if(rankString.equals("manager")) rank = 1;
		else rank = 0;
		
		if(rank != 1) rank = 0;
		
		int test = 0;
		if(!uname.equals("") && !pw.equals("") && !fn.equals("") && !ln.equals("")) test = service.addUser(uname, pw, fn, ln, rank);
		
		if(test == 1) {
			request.setAttribute("createuser", "success");
		} else if(test == 0) {
			request.setAttribute("createuser", "fail");
		}
		request.getRequestDispatcher("home").forward(request, response);
	}
}
