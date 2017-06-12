package com.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

@WebServlet("/EmpHomeServlet")
public class EmpHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
	Service service = new Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		HttpSession session = request.getSession(true);
		e = (Employee)session.getAttribute("employee");
		request.setAttribute("id", e.getId());
		request.setAttribute("fn", e.getFirstName());
		request.setAttribute("ln", e.getLastName());
		request.setAttribute("email", e.getEmail());
		request.getRequestDispatcher("/emphome.ftl").forward(request, response);
		}catch(NullPointerException npe){
			//request.getRequestDispatcher("index.ftl").forward(request, response);
			response.sendRedirect("index.ftl");
		}
	}


}
