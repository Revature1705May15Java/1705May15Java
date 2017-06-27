package com.ex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
    	userList.add(new User("Arthur","Faugue"));
    	userList.add(new User("Steve","Steel"));
    	userList.add(new User("Kesnel","Jon"));
    	userList.add(new User("Steel","Mark"));
    	userList.add(new User("Spoon","Spoon"));
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		super.init(config);
	}

	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service");
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//put the userlist into the request and lets freemarker display it in the view
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		
		if(null !=fn && null != ln && !fn.isEmpty() && !ln.isEmpty()){
			synchronized(userList){//makes sure that userList is thread locked, another thread cannot access that data at the same time
				userList.add(new User(fn, ln));
			}
		}
		doGet(request, response);
	}

}