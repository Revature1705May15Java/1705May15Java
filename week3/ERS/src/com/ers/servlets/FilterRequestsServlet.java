package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

public class FilterRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Employee emp=(Employee)session.getAttribute("employee");
		
		if(emp==null){
			resp.sendRedirect("logout");
		}
		ArrayList<Request> reqs=new ArrayList<Request>();
		if(emp.getIsmanager()==1){
			reqs=Service.getAllRequests();
		}
		if(emp.getIsmanager()==0){
			reqs=Service.getRequests(emp);
		}
		
		ArrayList<Request> modreqs=new ArrayList<Request>();
		if(req.getParameter("Pending")!=null){
			for(Request request:reqs){
				if(request.getName().equals("Pending")){
					modreqs.add(request);
				}
			}
		}
		if(req.getParameter("Approved")!=null){
			for(Request request:reqs){
				if(request.getName().equals("Approved")){
					modreqs.add(request);
				}
			}
		}
		if(req.getParameter("Denied")!=null){
			for(Request request:reqs){
				if(request.getName().equals("Denied")){
					modreqs.add(request);
				}
			}
		}
		if(req.getParameter("Denied")==null&&req.getParameter("Approved")==null&&req.getParameter("Pending")==null){
			for(Request request:reqs){
				modreqs.add(request);
			}
		}
		String filter=req.getParameter("Filter");
		if(filter!=null&&emp.getIsmanager()==1&&filter.equals("Filter Requests")){
			
			ArrayList<Employee> emps=new ArrayList<Employee>();
			emps=Service.getAllEmployees();
			boolean isonechecked=false;
			for(Employee temp1:emps){
				String boxid=""+temp1.getId()+"c";
				System.out.println(boxid);
				if(req.getParameter(boxid)!=null){
					isonechecked=true;
				}
			}
			if(isonechecked){
				for(Employee temp:emps){
					System.out.println("EMPLOYEEEEEEEEEEEEEEEEEEEEEEEEE        "+temp.getId());
					if(temp.getIsmanager()==0){
						System.out.println("got here");
						String checkboxid=""+temp.getId()+"c";
						String param=(String) req.getParameter(checkboxid);
						System.out.println(checkboxid);
						System.out.println(param);
						if(param==null){
							int id=temp.getId();
							for(int i=modreqs.size()-1;i>-1;i--){
								System.out.println("i: "+i+"requester id: "+modreqs.get(i).getRequesterid()+"current empid:"+id);
								if(modreqs.get(i).getRequesterid()==id){
									System.out.println("removing");
									modreqs.remove(i);
								}
							}
						}
					}
				}
			}
			
		}
		
		session.setAttribute("modrequests",modreqs);		
		if(emp!=null&&emp.getIsmanager()==0){
			resp.sendRedirect("home2");
		}else if(emp!=null&&emp.getIsmanager()==1){
			if(session.getAttribute("showing")=="emps"){
				session.setAttribute("showing", "reqs");
			}
			resp.sendRedirect("home");
		}else{
			resp.sendRedirect("logout");
		}
	}

}