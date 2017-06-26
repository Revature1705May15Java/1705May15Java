package com.ers.service;


import java.time.LocalDate;
import java.util.ArrayList;

import com.ers.dao.DAO;
import com.ers.dao.DAOImpl;
import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.StateType;

public class Service {

	static DAO dao = new DAOImpl();

	public Employee getEmployee(String email) {
		return dao.getEmployee(email);
	}

	public boolean checkEmail(String email) {
		boolean exists = true;
		Employee temp = new Employee();
		temp = dao.getEmployee(email);
		if (temp == null) {
			// if user name does not exist, return to front end
			exists = false;
		}
		return exists;

	}
	public boolean checkPassword(String email, String pw){
		boolean correct = true;
		Employee temp = new Employee();
		temp = dao.getEmployee(email);
		if(temp.getPassword()!=null && temp.getPassword().equals(pw)){
			
		}
		else{
			correct = false;
		}
		return correct;
	}
	public ArrayList<Employee> getAllEmployees(){
		return dao.getAllEmployees();
	}
	public Request submitRequest(double amount, String purpose, int requestorId){
		return dao.submitRequest(amount, purpose, requestorId);
	}
	public Employee updateEmployee(int id, String email, String fn, String ln){
		Employee e = new Employee();
		if(dao.updateEmployee(id, email, fn, ln)){
			e = getEmployeeById(id);
				return e;
		}
		return e;
	}
	public ArrayList<Request> getAllRequests(){
		return dao.getAllRequests();
	}
	public Employee getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}
	public ArrayList<Request> getPendingRequests(){
		return dao.getPendingRequests();
	}
	public boolean acceptRequest(int requestId, int resolverId){
		int stateId = 2;
		
		return dao.resolveRequest(requestId, stateId, resolverId);
	}
	public boolean denyRequest(int requestId, int resolverId){
		int stateId = 3;
		
		return dao.resolveRequest(requestId, stateId, resolverId);
	}
	public boolean isEmailAvailable(String email){
		ArrayList<Employee> employees = dao.getAllEmployees();
		boolean available = true;
		
		for(Employee employee : employees){
			if(email.equals(employee.getEmail())){
				available = false;
				return available;
			}
		}
		return available;
	}
	public ArrayList<Request> getEmployeeRequests(int empId) {
		return dao.getEmployeeRequests(empId);
	}

}