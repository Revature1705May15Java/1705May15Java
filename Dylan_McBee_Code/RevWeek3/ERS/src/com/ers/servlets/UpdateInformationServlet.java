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


@WebServlet("/UpdateInformationServlet")
public class UpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee e = new Employee();
	Service service = new Service();
	Employee temp = new Employee();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			HttpSession session = request.getSession();
			e = (Employee)session.getAttribute("employee");
			int id = e.getId();
			String fn = request.getParameter("firstname");
			String ln = request.getParameter("lastname");
			String email = request.getParameter("email");
			request.setAttribute("update", "-");
			if(e.getEmail().equals(email)){
			temp = service.updateEmployee(id, email, fn, ln);
			}
			else if(service.isEmailAvailable(email)){
				temp = service.updateEmployee(id, email, fn, ln);
				
			}
			else{
				request.setAttribute("update", "fail");
				request.getRequestDispatcher("/emphome.ftl").forward(request, response);
			}
			//request.getRequestDispatcher("emphome.ftl").forward(request, response);
			session.setAttribute("employee", temp);
			if(temp.getIsManager() == 1){
				response.sendRedirect("manhome");
			}else{
				response.sendRedirect("emphome");

			}
			
			
			}catch(NullPointerException npe){
				//request.getRequestDispatcher("index.ftl").forward(request, response);
				response.sendRedirect("emphome");
			}
		}
	}


