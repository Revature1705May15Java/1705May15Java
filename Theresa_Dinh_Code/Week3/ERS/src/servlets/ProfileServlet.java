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
import service.ErsService;


@WebServlet({ "/ProfileServlet", "/profile" })
public class ProfileServlet extends HttpServlet 	// DONE!!!
{
	private static final long serialVersionUID = 1L;
       
    public ProfileServlet() 
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
        Employee employee = (Employee)session.getAttribute("employee");         
        ErsService service = new ErsService(); 

    
        // get updated names from HTML form 
        String firstName = request.getParameter("first-name"); 
        String lastName = request.getParameter("last-name"); 
        
        RequestDispatcher rd; 
        session.setAttribute("profile", "-");

        if(service.updateEmployee(employee, firstName, lastName))
        {
        	session.setAttribute("profile", "pass");
        	rd = request.getRequestDispatcher("profile.ftl");
			rd.forward(request, response);
        }
        else
        {
        	session.setAttribute("profile", "fail");
        	rd = request.getRequestDispatcher("profile.ftl");
			rd.forward(request, response);
        }
	}

}
