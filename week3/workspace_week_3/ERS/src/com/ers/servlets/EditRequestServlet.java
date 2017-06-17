package com.ers.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojo.Request;
import com.ers.pojo.User;
import com.ers.service.Service;

/**
 * Servlet implementation class EditRequestServlet
 */
@WebServlet("/EditRequestServlet")
public class EditRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		Service service = new Service();
		boolean wasUpdated = false;
		System.out.println("In edit servlet! " + u.toString());
		try{
			if(request.getParameter("delete") != null) { // delete button was pressed, delete request.
				if(service.deleteRequest(Integer.parseInt(request.getParameter("requestid")))) {
					request.setAttribute("reqDelete", "success");
				}
				else{
					request.setAttribute("reqDelete", "fail");
				}
			}
			else { // updating the request.
				Request req = new Request();
				System.out.println(request.getParameter("requestid") + "????");
				req.setId(Integer.parseInt(request.getParameter("requestid")));
				req.setBalance(Double.parseDouble(request.getParameter("amt")));
				req.setPurpose(request.getParameter("purpose"));
				req.setType(request.getParameter("status"));
				
				if(request.getParameter("dateClosed") != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date date = sdf.parse(request.getParameter("dateClosed"));
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					req.setDateClosed(sqlDate);
				}
				
				if(u.getRank() == 1) req.setAdminId(u.getId()); // update this value automatically to the last manager that edited this request.
				req.setAdminNote(request.getParameter("adminNote"));
				
				wasUpdated = service.updateRequestById(req, u);
				if(!wasUpdated) request.setAttribute("reqEdit", "false");
			}
		}
		catch(Exception e){
			request.setAttribute("reqEdit", "false");
			e.printStackTrace();
		}
		finally { // redirect to homepage whether success or fail.
			System.out.println("finally + " + wasUpdated);
			if(u.getRank() == 0) request.getRequestDispatcher("home").forward(request, response); // employee page
			if(u.getRank() == 1) request.getRequestDispatcher("home2").forward(request, response); // manager page
		}
	}

}
