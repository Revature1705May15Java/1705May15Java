package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController 
{
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser()
	{
		
	}
	
	public void submitRequest()
	{
		
	}
}
