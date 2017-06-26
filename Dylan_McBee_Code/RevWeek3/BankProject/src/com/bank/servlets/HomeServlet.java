package com.bank.servlets;

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


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User u = new User();   
    Service service = new Service();
   
    public HomeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		u = (User)session.getAttribute("user");
		request.setAttribute("fn", u.getFirstName());
		request.setAttribute("ln", u.getLastName());
		ArrayList<Account> accounts = service.getAllAccounts(u.getId());
		
	
		
		
		request.setAttribute("accounts", accounts);
		//request.setAttribute("accountInfo", accountInfo);
		request.getRequestDispatcher("/home.ftl").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}