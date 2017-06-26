package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

@WebServlet("/EmpHomeServlet")
public class EmpHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
	Service service = new Service();
	String lastName;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		HttpSession session = request.getSession();
		e = (Employee)session.getAttribute("employee");
		if(e.getIsManager()!=0){
			session.invalidate();
			request.getRequestDispatcher("index.ftl").forward(request, response);
		}
		request.setAttribute("id", e.getId());
		request.setAttribute("fn", e.getFirstName());
		request.setAttribute("ln", e.getLastName());
		request.setAttribute("email", e.getEmail());
		ArrayList<Request> requests = service.getEmployeeRequests(e.getId());
		ArrayList<Employee> employees = service.getAllEmployees();
		for(Request r : requests){
			if(r.getResolverId() != 0){
				for(Employee employee : employees){
					if(employee.getId() == r.getResolverId()){
						r.setLastName(employee.getLastName());

					}
				}
			}else{
				r.setLastName("Pending");

				
			}
		}
		request.setAttribute("requests",requests);
		request.getRequestDispatcher("/emphome.ftl").forward(request, response);
		}catch(NullPointerException npe){
			//request.getRequestDispatcher("index.ftl").forward(request, response);
			response.sendRedirect("index.ftl");
		}
	}


}