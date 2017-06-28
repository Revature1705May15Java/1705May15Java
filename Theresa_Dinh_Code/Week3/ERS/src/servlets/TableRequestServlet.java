package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.Employee;
import pojos.Request;
import service.ErsService;

/**
 * Servlet implementation class TableRequestServlet
 */
@WebServlet({ "/TableRequestServlet", "/reqtables" })
public class TableRequestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;   
	
    public TableRequestServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
	}

	// creates string for pending tables 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true); 
		String isManager = (String) session.getAttribute("manager"); 
	
		ErsService service = new ErsService(); 

		ServletContext context = request.getServletContext(); 
		
		try(PrintWriter writer =  response.getWriter();)
		{		

			// { "data": [
			String json = ""; 
			json += "{\"data\":[";
			ArrayList<Request> list;
			
			if(isManager.equals("true"))
				list = service.getAllRequests(); 
			else
			{
				Employee e = (Employee)session.getAttribute("employee"); 
				list = service.getRequests(e.getEmail()); 
			}
					
			for(int i = 0; i < list.size(); i++)
			{
                Request r = list.get(i); 
                Employee e = service.getEmployee(r.getRequesterId()); 

                // [ "requestid", "firstName", "lastName", "email", "amount", "date submit", "approve/deny"],
                json += ("[\"" + r.getRequestId() + "\",\"" + e.getFirstName() + "\",\"" + e.getLastName() + 
                        "\",\"" + e.getEmail() + "\",\"" + r.getAmount() + "\",\"" +
                        r.getRequestDate() + "\",\"" + r.getPurpose() + "\",\"");
                switch(r.getStatusId())
                {
                	case 0: 
                		json += "Pending\"]";
                		break;
                	case 1: 
                		json += "Approved\"]"; 
                		break;
                	case 2:
                		json += "Denied\"]"; 
                		break;
                }
                
                if(i == list.size()-1)
                    continue;
                json += (",");
            }
            // ]}
            json += ("]}");
            writer.println(json); 
        }
		catch(IOException e)
		{
			e.printStackTrace();
		}
		context.getNamedDispatcher("HomeServlet"); 
	}
}