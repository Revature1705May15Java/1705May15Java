package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		// extract paramter values from the url 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter(); 
		
		String firstname = request.getParameter("fn"); 
		String lastname = request.getParameter("ln"); 
		
		/////////////////////////////
		out.println("<h3>reading query string data using string.getparamter(String name) method</h3>"); 
		out.println("<div>"); 
		out.println("<p> First name " + firstname + "</p>");
		out.println("<p> Last name " + lastname + "</p>");
		out.println("</div>");
		Enumeration<String> paramNames = request.getParameterNames(); 
		out.println("<div>");
		while(paramNames.hasMoreElements())
		{
			String paraName = paramNames.nextElement(); 
			String paraValue = request.getParameter(paraName); 
			out.println("<p>" + paraName + ": " + paraValue + "</p>");
		}
		out.println("</div>");
		
		////////////////////
		Map<String, String[]> paramMap = request.getParameterMap(); 
		Set<String> paramNameset = paramMap.keySet(); 
		
		out.println("<h3>reading query string data using string.getParamterMap() method</h3>"); 
		out.println("<div>"); 
		for(String paramName : paramNameset)
		{
			String[] paramValues = paramMap.get(paramName); 
			out.println("<p>" + paramName + ": ");
			for(int i = 0; i < paramValues.length; i++)
			{
				out.println(paramValues[i]);
			}
			out.println("</p>"); 
		}
		out.println("</div>");
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
