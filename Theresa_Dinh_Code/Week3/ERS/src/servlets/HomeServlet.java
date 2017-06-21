package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Employee;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet 	// portal hub, directs to other servlets as needed 
{
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true); 
//		
//		Employee employee = (Employee)session.getAttribute("employee"); 	
//		RequestDispatcher rd; 
				
		session.setAttribute("table", "pending-req");
		
//		String choice = (String)session.getAttribute("choice"); 
//		ServletContext context = request.getServletContext(); 
//		
//		switch(choice)
//		{
//			case "pending-req":
//			case "approve-req":
//			case "deny-req":
//			case "all-req":
//			{	
//				context.getNamedDispatcher("TableRequestServlet"); 
//				break;
//			}
//		
//			case "submit-new": 
//			{
//				rd = request.getRequestDispatcher("submission.ftl"); 
//				rd.forward(request, response);
//				context.getNamedDispatcher("RequestServlet"); 
//				break; 
//			}
//			case "update-prof":
//			{
//				rd = request.getRequestDispatcher("profile.ftl"); 
//				rd.forward(request, response);
//				context.getNamedDispatcher("ProfileServlet"); 
//				break; 
//			}
//			case "logout":
//			{
//				rd = request.getRequestDispatcher("logout.ftl"); 
//				rd.forward(request, response);
//				context.getNamedDispatcher("LogoutServlet");
//			}
//		}
	}
}
