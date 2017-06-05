package com.bank.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pojos.UserTwo;

///**
// * Servlet implementation class HelloServlet
// */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static ArrayList<UserTwo> userList = new ArrayList<UserTwo>();
	
	static{
		userList.add(new UserTwo("Lei", "Raion"));
		userList.add(new UserTwo("Kiba", "Raion"));
		userList.add(new UserTwo("James", "Bond"));
		userList.add(new UserTwo("Jason", "Bourne"));
		userList.add(new UserTwo("The", "Dude"));
	}
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	// Service is called each time you are making a request
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("services");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Puts the userlist into the request and 
		// lets freemarker display it in the view.
		
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/index.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn = request.getParameter("firstname");
		String ln = request.getParameter("lastname");
		
		if(fn != null && ln != null && !fn.isEmpty() &&  !ln.isEmpty()){
			synchronized(userList){ // acquiring a lock on this userList 
				userList.add(new UserTwo(fn, ln));
			}
		}
		
		doGet(request, response); //updating the user list  and forwarding it.
		
	}

}
