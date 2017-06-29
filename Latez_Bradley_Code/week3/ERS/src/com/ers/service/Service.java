package com.ers.service;


import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public class Service {
	static DAO dao = new DaoImpl();
	
	public Employee addUser(String uname, String pw, String fn, String ln, int isManager ){
		
		Employee temp = new Employee();
		temp = dao.getEmployee(uname);
		if(temp!=null){
			dao.addEmployee(uname, pw, fn, ln, isManager);
			//username found     
			System.out.println("USER FOUND! Try again!");
			return null;	
		}
		else{
			
		}
		return dao.getEmployee(uname);
		
	}
	
	public Employee login(String uname, String pw){

		Employee currEmp = dao.getEmployee(uname);
		if(pw.equals(currEmp.getPassword())){
			System.out.println("Welcome "+currEmp.getFirstname());
			return currEmp;
		
	}
		return currEmp;
	
		
	}
	
	public Employee getEmployee(String uname){

		Employee temp = dao.getEmployee(uname);
		System.out.println(temp.getFirstname());
		System.out.println(temp.getLastname());
		System.out.println(temp.getEid());
		System.out.println(temp.getPassword());
		
		return temp;
	}
	
	
	
	public int makeRequest1(Double amount, String purpose, int requesterid){
		
		return dao.request(amount, purpose, requesterid);
		
		
	}
	
	public ArrayList <Request> viewRequestbyId(int id){
		return dao.getRequestsById(id);
	}
	
	public ArrayList <Request> viewResolvedById(int id){
		return dao.viewClosedRequestsById(id);
	}
	
	public ArrayList <Request> viewOpenRequestById(int id){
		return dao.viewOpenRequestsById(id);
	}
	
	public Employee updateEmployee(String uname, String pw, String fn, String ln, int id){
		Employee updatedEmp = dao.updateEmployee(uname, pw, fn, ln, id);
		return updatedEmp;
	}

	public void makeRequest(Double amount, String purpose, int requesterid) {
		dao.request(amount, purpose, requesterid);
		
	}
	
	public void approvedeny(int Stateid, String note, int requestid, int managerid){
		dao.alterRequest(Stateid, note, requestid, managerid);
	}
	
	public ArrayList <Request> ViewAllRequests(){
		return dao.viewAllRequests();
	}
	
	public ArrayList <Employee> ViewAllEmployees(){
		return dao.viewEmployees();
	}
}
