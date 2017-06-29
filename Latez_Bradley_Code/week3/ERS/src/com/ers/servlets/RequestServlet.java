package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String purpose;
		Double amount;
		ArrayList <Request> newReq = new ArrayList();
		Service sv = new Service();
		int requesterid = 0;
		ArrayList <Request> rs, ors, crs;
		
		
		
		HttpSession s = request.getSession(true);
		
		
		Employee e = (Employee) s.getAttribute("emp");
		//System.out.println(e.getEid());
		requesterid = e.getEid();
		
		purpose = request.getParameter("note");
		amount = Double.parseDouble(request.getParameter("amount"));
		//System.out.println(e.getEid());
		sv.makeRequest(amount, purpose, requesterid);
		
		
		
		
		
		rs = sv.viewRequestbyId(requesterid);
		ors = sv.viewOpenRequestById(requesterid);
		crs = sv.viewResolvedById(requesterid);
		
		HttpSession sess = request.getSession(true);
		sess.setAttribute("emp", e);
		sess.setAttribute("empln", e.getLastname());
		sess.setAttribute("Requests", rs);
		sess.setAttribute("OpenReqs", ors);
		sess.setAttribute("ClosedReqs", crs);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("eHome.ftl");
		rd.forward(request, response);
	}

}
