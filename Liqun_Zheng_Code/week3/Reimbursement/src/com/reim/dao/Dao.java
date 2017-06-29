package com.reim.dao;

import java.util.ArrayList;

import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.pojos.State_type;


public interface Dao {
	
	//add employee by input first name, last name, username, and password
	public int addEmployee(String fname, String lname, String uname, String pw, int isManager);
	
	//find an employee by username
	public Employee findEmpByUname(String uname);
	
	//update Employee by input first name, last name, username, and password
	public int updateEmployee(int empId, String fname, String lname, String uname, String pw);
	
	//get all employees by input isEmployee to check if result are employees not manager
	public ArrayList<Employee> getAllEmployee(int isEmployee);
	
	//get request by request id
	Request getRequest(int requestId);
	
	//Get all Requests
	public ArrayList<Request> getAllRequests();
	
	//Find Requests by employee id
	public ArrayList<Request> findReqByEmpId(int emp_id);
	
	//add request by input the employee that requested, and the purpose, amount for that new request
	Request addRequest(Employee u, String purpose, double amount);
	
	//Either approve or deny the request by input manager employee object and request id 
	//state type object to set either approve or deny and the note if any.
	public Request appDenReq(Employee emp, int r_id, State_type state, String note);
	
	//find state type object by type id
	public State_type findTypeById(int type_id);
	
	//find state type object by state string
	public State_type findState(String state);
}