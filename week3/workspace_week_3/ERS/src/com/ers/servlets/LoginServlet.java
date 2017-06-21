package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojo.User;
import com.ers.service.Service;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Service service = new Service();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pw = request.getParameter("password");
		
		HttpSession session = request.getSession();
		User temp = service.getUserInfo(name);
		if(temp == null){}
		
		
		else if(name.equals("as") && pw.equals("as")){
			
			session.setAttribute("user", temp);
		}
		
		
		
		else {
			session.setAttribute("uname", temp.getUsername());
			session.setAttribute("user", temp);
		}
		// if the user is found (not null, their rank matches (0=employee, 1=manager), and password matches... send them to the corresponding homepage.
		if(temp != null && pw.equals(temp.getPassword())) response.sendRedirect("home");
		else{
			request.setAttribute("login", "fail");
			request.getRequestDispatcher("index.ftl").forward(request, response);
		}
		
		
	}

}
