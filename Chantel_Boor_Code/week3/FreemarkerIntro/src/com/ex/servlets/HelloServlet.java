package com.ex.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojo.User;

///**
// * Servlet implementation class HelloServlet
// */
//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ArrayList<User> userList = new ArrayList<User>();
    
	static{
		userList.add(new User("Genesis", "Bonds"));
		userList.add(new User("test", "test"));
		userList.add(new User("this", "isAPerson"));
		userList.add(new User("hello", "world"));
	}

//	
//	public void init(ServletConfig config) throws ServletException {
//	}
//
//	public void destroy() {
//	}
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// puts the userlist into the request
		// and lets freemarker display it in the view
		
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		
		if(null !=fn && null != ln && !fn.isEmpty() && !ln.isEmpty()){
			synchronized(userList){
				userList.add(new User(fn, ln));
			}
		}
		
		doGet(request, response);
	
	
	}

}