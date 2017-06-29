package com.bank.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {
		static User u = new User();
		static Service service = new Service();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		System.out.println("IN HOME SERVLET GET");
//		HttpSession session = request.getSession(true);
//		u = (User)session.getAttribute("user");
//		
//		request.setAttribute("fn", u.getFn());
//		request.setAttribute("ln", u.getLn());
//		request.getRequestDispatcher("index.html").forward(request, response);
//		System.out.println("p1");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession s = request.getSession(true);
		Service service = new Service();
//		request.setAttribute("login", "-");
		try{
			User isUser = service.Signin(uname, pass);
			if(isUser!=null){
	
				s.setAttribute("user", isUser);
				response.sendRedirect("home");
//				RequestDispatcher rd = request.getRequestDispatcher("home");
//				rd.forward(request, response);
			}
			else{
//				RequestDispatcher rd = request.getRequestDispatcher("Error.html");
//				rd.forward(request, response);
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("login.ftl").forward(request, response);
			}
		}
		catch(NullPointerException npe){
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("login.ftl").forward(request, response);
//			response.sendRedirect("Error.html");
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}