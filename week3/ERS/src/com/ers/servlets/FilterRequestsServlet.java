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

public class FilterRequestsServlet extends HttpServlet {
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
		ArrayList<Request> reqs=(ArrayList<Request>)session.getAttribute("requests");
		ArrayList<Request> modreqs=new ArrayList<Request>();
		if(req.getParameter("Pending")!=null){
			for(Request request:reqs){
				if(request.getName().equals("Pending")){
					modreqs.add(request);
				}
			}
		}
		if(req.getParameter("Approved")!=null){
			for(Request request:reqs){
				if(request.getName().equals("Approved")){
					modreqs.add(request);
				}
			}
		}
		if(req.getParameter("Denied")!=null){
			for(Request request:reqs){
				if(request.getName().equals("Denied")){
					modreqs.add(request);
				}
			}
		}
		session.setAttribute("modrequests",modreqs);		
		if(emp!=null&&emp.getIsmanager()==0){
			resp.sendRedirect("home2");
		}else if(emp!=null&&emp.getIsmanager()==1){
			resp.sendRedirect("home");
		}else{
			resp.sendRedirect("logout");
		}
	}

}
