package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;


@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
	Service service = new Service();
	Employee temp = new Employee();
	Request r = new Request();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			e = (Employee)session.getAttribute("employee");
			int id = e.getId();
			Double amount = Double.parseDouble(request.getParameter("amount"));
			String purpose = request.getParameter("purpose");
			request.setAttribute("submit", "-");
			service.submitRequest(amount, purpose, id);
			//request.getRequestDispatcher("emphome.ftl").forward(request, response);

			response.sendRedirect("emphome");

			}catch(NullPointerException npe){
				//request.getRequestDispatcher("index.ftl").forward(request, response);
				response.sendRedirect("emphome");
			}
	}

}
