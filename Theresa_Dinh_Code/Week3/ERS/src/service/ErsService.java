package service;

import java.util.ArrayList;

import dao.ERSDao;
import pojos.Employee;
import pojos.Request;

public class ErsService 
{
	ERSDao dao = new ERSDao(); 
	
	public ErsService()
	{
		super(); 
	}
	
	// allow new Employees to register into the system  
	// with their name, a unique email, and a password 
	// eventually implement check for unique email in service 
	public void registerEmployee(String email, String password, String firstName, String lastName)
	{
		Employee employee = new Employee(); 
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		
		dao.registerEmployee(employee); 
	}
	
	// allow manager to promote or demote Employee to manager in db 
	public void setManager(String email, boolean isManager)
	{
		Employee employee = new Employee();
		employee.setEmail(email);
		
		dao.setManager(employee, isManager);
	}
	
	// retrieves user from their unique email login 
	public Employee getEmployee(Employee employee)
	{
		Employee temp = dao.getEmployee(employee.getEmail());
		if(temp != null)
		{
			return temp; 
		}
		return null; 
	}
	
	public ArrayList<Request> getRequests(String email)
	{
		return dao.getRequests(email); 
	}
	
	public ArrayList<Request> getPendingRequests()
	{
		return dao.getPendingRequests(); 
	}
	
	// allows a manager to approve a Request
	// retrieve request by that id, and mark approver as the 
	// manager's employee id 
	public void approveRequest(int requestId, Employee employee)
	{
		Request request = new Request(); 
		Employee e = dao.getEmployee(employee);
		
		request.setRequestId(requestId);
		request.setApproverId(e.getId());
		
		dao.approveRequest(request);
		return; 
	}
	
	public void denyRequest(int requestId, Employee employee)
	{
		Request request = new Request(); 
		Employee e = dao.getEmployee(employee);
		
		request.setRequestId(requestId);
		request.setApproverId(e.getId());
		
		dao.denyRequest(request);
		return; 
	}
	
	public void submitRequest(double amount, String purpose, String email)
	{
		Request request = new Request(); 
		request.setAmount(amount);
		request.setPurpose(purpose);
		request.setRequesterId((dao.getEmployee(email)).getId()); 
		
		dao.submitRequest(request);
		return;
	}
}
