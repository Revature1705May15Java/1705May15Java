package com.ers.test;

import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DAOImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.service.Service;

public class Test {

	public static void main(String[] args) {
		Service s = new Service();
        DAO dao = new DAOImpl();
        Employee e = s.getEmployee("test@test.com");
        //s.addUser("test", "test", "12423545", "12412");
        ArrayList<Employee> emps = s.getAllEmployees();
        System.out.println(emps);
		
		//Request r = s.submitRequest(500.00, "need some dough", 101);
		//Request r2 = dao.getRequestById(21);
		//System.out.println(r2);
        
        //Employee e = s.getEmployee("teste@test.com");
        //int id = e.getId();
        //String email = e.getEmail();
        //String fn = "teste";
        //String ln = "teste";
        //s.updateEmployee(id, email, fn, ln);
        //System.out.println(e.toString());
		//System.out.println(s.getPendingRequests());
        //int resolverId = e.getId();
        //s.acceptRequest(r2, resolverId);
		//ArrayList<Request> requests = s.getEmployeeRequests(101);
		//for(Request request : requests){
			//System.out.println(request.toString());
		//}

	}

}