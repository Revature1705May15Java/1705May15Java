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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("username");
		String pw=req.getParameter("password");
		HttpSession session= req.getSession();
		session.setAttribute("attempt", "");
		if(name!=null&&name!=""&&pw!=null&&pw!=""){
			Employee emp = Service.loginUser(name, pw);
			
			if(emp!=null){
				ArrayList<Request> reqs=new ArrayList<Request>();
				session.setAttribute("employee", emp);
				if(emp.getIsmanager()==1){
					resp.sendRedirect("home");
					reqs=Service.getAllRequests();
					session.setAttribute("requests", reqs);
					session.setAttribute("modrequests", reqs);
				}else if(emp.getIsmanager()==0){
					resp.sendRedirect("home2");
					reqs=Service.getRequests(emp);
					session.setAttribute("requests", reqs);
					session.setAttribute("modrequests", reqs);
				}
			}else{
				session.setAttribute("attempt", "fail");
				req.getRequestDispatcher("index.ftl").forward(req, resp);
			}
		}else{
			req.getRequestDispatcher("index.ftl").forward(req, resp);
		}
	}

}
