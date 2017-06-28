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

public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Employee emp=(Employee)session.getAttribute("employee");
		if(emp==null){
			resp.sendRedirect("logout");
		}
		ArrayList<Request> reqs=new ArrayList<Request>();
		if(emp.getIsmanager()==1){
			reqs=Service.getAllRequests();
		}
		if(emp.getIsmanager()==0){
			reqs=Service.getRequests(emp);
		}
		String	show = req.getParameter("show");
		if (show == null){
		    //no button has been selected
			session.setAttribute("showing", "");
		} else if (show.equals("View Requests")) {
		    //requests button was pressed
			session.setAttribute("showing", "reqs");
		} else if (show.equals("View Employees")) {
		    //employees button was pressed
			session.setAttribute("showing", "emps");
		} else if (show.equals("Add Employee")){
			//new employee button was pressed
			session.setAttribute("showing", "newemp");
		} else if (show.equals("Change Account Information")){
			//edit info button was pressed
			session.setAttribute("showing", "info");
		} else if (show.equals("New Reimbursement Request")){
			//edit info button was pressed
			session.setAttribute("showing", "newreq");
		}else if (show.equals("Revature ERS")){
			//edit info button was pressed
			session.setAttribute("showing", "none");
		}else if (show.equals("Logout")){
			//edit info button was pressed
			session.setAttribute("showing", "logout");
		}
				
		if(session.getAttribute("showing").equals("logout")){
			resp.sendRedirect("logout");
		}else if(emp!=null&&emp.getIsmanager()==0){
			resp.sendRedirect("home2");
		}else if(emp!=null&&emp.getIsmanager()==1){
			resp.sendRedirect("home");
		}else{
			resp.sendRedirect("logout");
		}
	}

}