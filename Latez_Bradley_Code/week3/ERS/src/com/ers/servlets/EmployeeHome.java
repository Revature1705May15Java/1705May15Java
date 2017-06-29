package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

/**
 * Servlet implementation class EmployeeHome
 */
//@WebServlet("/EmployeeHome")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub






	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HOME SERVLET RUNNING");
		Service sv = new Service();
		Employee e = new Employee();
		
		HttpSession s = request.getSession(true);
		

		String newUn, newPw, newFn, newLn;
		int id;
		ArrayList <Request> rs,mr;
		e = (Employee) s.getAttribute("emp");
		 
		
		newUn = request.getParameter("newun");
		newPw = request.getParameter("newpw");
		newFn = request.getParameter("newfn");
		newLn = request.getParameter("newln");
		id = e.getEid();
		Employee temp = sv.updateEmployee(newUn, newUn, newFn, newLn, id);
		s.setAttribute("emp", temp);
		
		mr = sv.ViewAllRequests();
		rs = sv.viewRequestbyId(id);
		System.out.println("Requests "+rs);
		request.setAttribute("Requests", rs);
		request.setAttribute("allReqs", mr);
		
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("eHome.ftl");
		rd.forward(request, response);
		//s.setAttribute("emp", e);
		;
		//System.out.println(newUn+" "+newPw+" "+newFn+" "+newLn);
		
		
		

	}

}
