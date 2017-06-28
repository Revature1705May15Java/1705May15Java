package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet({ "/LogoutServlet", "/logout" })
public class LogoutServlet extends HttpServlet 		// DONE!!!
{
	private static final long serialVersionUID = 1L;

    public LogoutServlet() 
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
		HttpSession session = request.getSession(false);
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("logout.ftl"); 
		rd.forward(request, response);
//		ServletContext context = request.getServletContext(); 
//		context.getNamedDispatcher("LoginServlet"); 
	}

}