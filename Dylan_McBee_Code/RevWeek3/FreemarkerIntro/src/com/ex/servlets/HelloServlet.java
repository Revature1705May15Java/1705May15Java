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
    	userList.add(new User("Dylan", "McBee"));
    	userList.add(new User("Eric", "McBee"));
    	userList.add(new User("Bob", "Dole"));
    	userList.add(new User("Jeb", "Bush"));
    	userList.add(new User("BushDid", "Harambe"));
    	
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
		// puts the userlist into the request
		// and lets the freemarker display it in the view
		
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn = request.getParameter("firstName");
		String ln = request.getParameter("lastName");
		
		if(null !=fn && null != ln && !fn.isEmpty() && !ln.isEmpty()){
			synchronized(userList){
				userList.add(new User(fn, ln));
			}
		}
		
		doGet(request, response);
	}

}
