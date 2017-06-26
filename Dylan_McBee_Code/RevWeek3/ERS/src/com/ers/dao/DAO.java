package com.ers.dao;

import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;

public interface DAO {

	public Employee getEmployee(String email);
	public ArrayList<Employee> getAllEmployees();
	public Request submitRequest(double amount, String purpose, int requestorId);
	public Request getRequestById(int id);
	public boolean updateEmployee(int id, String email, String fn, String ln);
	public ArrayList<Request> getAllRequests();
	public Employee getEmployeeById(int id);
	public ArrayList<Request> getPendingRequests();
	public boolean resolveRequest(int requestId, int stateId, int resolverId);
	public ArrayList<Request> getEmployeeRequests(int empId);
	
	
}