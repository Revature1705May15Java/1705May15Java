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

/**
 * Servlet implementation class ServletHome
 */
//@WebServlet("/ServletHome")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Account> accs=new ArrayList<Account>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		User u = new User();
		HttpSession s = request.getSession(true);
		
		u = (User) s.getAttribute("user");
		accs = u.getUserAccounts();
		String fn = u.getFn();
		String ln = u.getLn();
//		System.out.println(fn);
//		System.out.println(ln);
		request.setAttribute("firstname", fn);
		request.setAttribute("lastname", ln);
		request.setAttribute("accounts", accs);
//		System.out.println(request.getAttribute("firstname"));
//		System.out.println(request.getAttribute("lastname"));	
		request.getRequestDispatcher("/home.ftl").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//s		doGet(request, response);
	}

}