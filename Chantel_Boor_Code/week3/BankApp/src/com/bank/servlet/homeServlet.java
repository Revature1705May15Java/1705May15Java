package com.bank.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;


public class homeServlet extends HttpServlet {
      
	static User u = new User();
	static Service service = new Service();
	
    public homeServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("in home servelet get");
		HttpSession session = request.getSession(true);
		
		Service s = new Service ();
		u = (User)session.getAttribute("user");
		ArrayList <Account> alist = s.getAccount(u);
		
		request.setAttribute("fn", u.getFn());
		request.setAttribute("ln", u.getLn());
		request.setAttribute("accounts",alist);
		request.setAttribute("display", "no");
		
		if(alist.get(0).getId() != 0)
		{
			request.setAttribute("display", "yes");
		}
		
		request.getRequestDispatcher("home.ftl").forward(request, response);
		response.sendRedirect("/home");
	}

}
