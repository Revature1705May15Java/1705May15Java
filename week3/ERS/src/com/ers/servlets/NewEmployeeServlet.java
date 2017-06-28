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

public class NewEmployeeServlet extends HttpServlet {
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
		String newempfn=req.getParameter("newempfn");
		String newempln=req.getParameter("newempln");
		String newempemail=req.getParameter("newempemail");
		String newemppw=newempfn+newempln;
		int newempismanager;
		if(req.getParameter("newempismanager")!=null){
			newempismanager=1;
		}else{
			newempismanager=0;
		}
		Service.newEmployee(newempemail,newemppw,newempfn,newempln,newempismanager);
		if(emp!=null&&emp.getIsmanager()==0){
			resp.sendRedirect("home2");
		}else if(emp!=null&&emp.getIsmanager()==1){
			ArrayList<Request> newreqs=Service.getAllRequests();
			session.setAttribute("requests", newreqs);
			session.setAttribute("modrequests", newreqs);
			resp.sendRedirect("home");
		}else{
			resp.sendRedirect("logout");
		}
	}

}