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
 * Servlet implementation class EditInfoServlet
 */
@WebServlet("/EditInfoServlet")
public class EditInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new Service();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Service service = new Service();
		System.out.println(u.toString());
		int passTest = 0;
		try{
			String temp = request.getParameter("newusername");
			if(temp != null && temp != "") {
				u.setUsername(temp);
			}
			
			temp = request.getParameter("newpw");
			if(temp.equals(request.getParameter("newpw2")) && u.getPassword().equals(request.getParameter("oldpw"))){
				u.setPassword(temp); // If the original password matches the database and both new password fields match each other, change the password.
			} else if(request.getParameter("oldpw").equals("") && request.getParameter("newpw").equals("") && request.getParameter("newpw2").equals("")){} //If all passwords are null they do not wish to edit. Do nothing.
			else {
				request.setAttribute("editing", "pwfail");
				passTest = 1;
			}
			
			temp = request.getParameter("newfn");
			if(!temp.equals("")) u.setFn(temp);
			
			temp = request.getParameter("newln");
			if(!temp.equals("")) u.setLn(temp);
			
			service.editUser(u);
			session.removeAttribute("user");
			session.setAttribute("user", u);
			
			if(passTest == 0) request.setAttribute("editing", "success");
		}
		catch(Exception e){
			request.setAttribute("editing", "fail");
		}
		finally {
			request.getRequestDispatcher("home").forward(request, response);
		}
	}

}
