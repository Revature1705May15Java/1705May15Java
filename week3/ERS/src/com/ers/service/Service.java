package com.ers.service;

import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DaoImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public class Service {
	private static boolean isLoggedIn=false;
	private static DAO dao = new DaoImpl();
	public static String[] statenames;
	
	public Service(){
		
	}
	public static Employee loginUser(String email,String password){
		Employee temp=new Employee();
		temp=dao.getEmployee(email);
		if(temp!=null){
			String actualpw=temp.getPassword();
			if(actualpw.equals(password)){
				isLoggedIn=true;
				return temp;
			}else{
				return null;
			}
		}else{
			return null;
		}
		
	}
	public static boolean logoutUser(){
		isLoggedIn=false;
		return isLoggedIn;
	}
	public static Employee newEmployee(String email, String pw, String fn,String ln,int ismanager){
		dao.addEmployee(email, pw, fn, ln, ismanager);
		Employee temp =dao.getEmployee(email);
		return temp;
	}
	public static void getStateNames(){
		statenames=dao.getStateNames();
	}
	public static ArrayList<Request> getRequests(Employee emp){
		ArrayList<Request> reqs=new ArrayList<Request>();
		reqs=dao.getEmployeeRequests(emp.getId());
		reqs=addRequestNames(reqs);
		return reqs;
	}
	public static void newRequest(double amount, String purpose,Employee emp){
		int empid=emp.getId();
		dao.addRequest(amount, purpose, empid);
	}
	public static ArrayList<Request> getAllRequests(){
		ArrayList<Request> reqs=new ArrayList<Request>();
		reqs=dao.getAllRequests();
		reqs=addRequestNames(reqs);
		return reqs;
	}
	public static ArrayList<Request> addRequestNames(ArrayList<Request> reqs){
		getStateNames();
		for(Request req:reqs){
			switch(req.getStateid()){
				case(1):
					req.setName(statenames[0]);
					break;
				case(2):
					req.setName(statenames[1]);
					break;
				case(3):
					req.setName(statenames[2]);
					break;
				default:
					req.setName("Status unknown.");
					break;
			}
		}
		return reqs;
	}

}
