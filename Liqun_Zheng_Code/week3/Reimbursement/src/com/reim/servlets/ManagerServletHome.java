package com.reim.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reim.pojos.Employee;
import com.reim.pojos.Request;


public class ManagerServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Request> reqs=new ArrayList<Request>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Employee emp = new Employee();
		HttpSession s = request.getSession(true);
		
		emp = (Employee) s.getAttribute("Manager");
		reqs = emp.getEmployee_request();
		String fn = emp.getFn();
		String ln = emp.getLn();
//		System.out.println(fn);
//		System.out.println(ln);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		request.setAttribute("requests", reqs);
//		System.out.println(request.getAttribute("firstname"));
//		System.out.println(request.getAttribute("lastname"));	
		request.getRequestDispatcher("/managerHome.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//s		doGet(request, response);
	}
}
