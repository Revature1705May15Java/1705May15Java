package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;
import com.ers.servlets.states.SessionState;

public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("state", SessionState.CREATE_REQUEST);
		
		request.getRequestDispatcher("site.ftl").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount = Double.parseDouble(request.getParameter("amount"));
		String purpose = request.getParameter("purpose");
		
		HttpSession session = request.getSession();
		Employee employee = (Employee) session.getAttribute("user");
		
		Request submission = new Request(amount, purpose, employee);
		Service service = new Service();
		submission = service.submitRequest(submission);
		
		// change
		ArrayList<Request> requests = (ArrayList<Request>) session.getAttribute("pendingRequests");
		requests.add(submission);
		session.setAttribute("pendingRequests", requests);
		session.setAttribute("state", SessionState.VIEW_PENDING);
		//after change
		// TODO: Display results
		// TODO: Accept decimal values for reimbursement amount.
		request.getRequestDispatcher("site.ftl").forward(request, response);
	}

}