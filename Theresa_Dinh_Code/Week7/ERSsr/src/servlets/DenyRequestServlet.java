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

/**
 * Servlet implementation class DenyRequestServlet
 */
@WebServlet("/DenyRequestServlet")
public class DenyRequestServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DenyRequestServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true); 
		Employee e = (Employee)session.getAttribute("employee");
		
		int id = Integer.parseInt(request.getParameter("reqid"));
		ErsService service = new ErsService(); 
		RequestDispatcher rd; 
		
		if(service.denyRequest(id, e))
		{
			session.setAttribute("deny", "pass");
        	rd = request.getRequestDispatcher("manager.ftl");
			rd.forward(request, response);
		}
		else
		{
			session.setAttribute("deny", "fail");
        	rd = request.getRequestDispatcher("manager.ftl");
			rd.forward(request, response);
		}
	}

}