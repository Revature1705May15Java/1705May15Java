package test;

import pojos.Employee;
import service.ErsService;

public class Test {

	public static void main(String[] args) 
	{
		ErsService service = new ErsService(); 
		
//		Employee e = new Employee();
//		e.setEmail("ms@email.com");
//		e.setFirstName("Mary");
//		e.setLastName("Sue");
//		e.setPassword("test");
//		
//		service.registerEmployee("ms@email.com", "test", "Mary", "Sue");
//		service.setManager("ms@email.com", true);
//		System.out.println(service.getEmployee(e));
//		service.submitRequest(6.66, "", "ms@email.com");
//		System.out.println(service.getRequests("ms@email.com"));
//		System.out.println(service.getPendingRequests());
//		service.approveRequest(21, e);
//		service.denyRequest(21, e);
		
		Employee e = new Employee();
		e.setEmail("gs@email.com");
		e.setFirstName("Gary");
		e.setLastName("Stu");
		e.setPassword("test");
		
//		service.registerEmployee("gs@email.com", "test", "Gary", "Stu");
//		service.setManager("gs@email.com", true);
//		System.out.println(service.getEmployee(e));
//		service.submitRequest(777, "", "ms@email.com");
//		System.out.println(service.getRequests("gs@email.com"));
//		System.out.println(service.getPendingRequests());
//		service.approveRequest(22, e);
//		service.denyRequest(22, e);
	}

}
