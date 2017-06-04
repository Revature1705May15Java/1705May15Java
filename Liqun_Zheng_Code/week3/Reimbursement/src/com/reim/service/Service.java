package com.reim.service;

import java.util.ArrayList;


import com.reim.dao.Dao;
import com.reim.dao.DaoImpl;
import com.reim.pojos.Employee;
import com.reim.pojos.Request;



public class Service {
	
	static Dao dao = new DaoImpl();
	
	//Sign in by username and password return employee 
	//with all requests of this employee
	public Employee Signin(String username, String password){
		Employee temp = dao.findEmpByUname(username);
		ArrayList<Request> reqs = new ArrayList<Request>();
		if(temp.getPw().equals(password)){
			reqs= dao.findReqByEmpId(temp.getEmployee_id());
			temp.setEmployee_request(reqs);
			return temp;
		}
		else
			return null;
	}
}
