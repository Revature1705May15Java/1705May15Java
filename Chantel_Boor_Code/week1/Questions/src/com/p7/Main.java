package com.p7;

import java.util.ArrayList;

public class Main
{

	public static void main(String[] args)
	{
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee ("Chantel","Bakery",23));
		employees.add(new Employee ("Bob","Garden",17));
		
		//by name
		Employee temp = employees.get(0);
		CompareName cn = new CompareName();
		
		int comp = cn.compare(employees.get(0), employees.get(1));
		
		if(comp > 0)
		{
			employees.set(0,employees.get(1));
			employees.set(1, temp);
		}
		
		System.out.println("Sort by Name");
		System.out.println(employees.get(0));
		System.out.println(employees.get(1));
		
		
		//by department
		temp = employees.get(0);
		compareDepartment cd = new compareDepartment();
		
		comp = cd.compare(employees.get(0),employees.get(1));
		
		if(comp > 0)
		{
			employees.set(0,employees.get(1));
			employees.set(1, temp);
		}
		
		System.out.println("Sort by Department");
		System.out.println(employees.get(0));
		System.out.println(employees.get(1));
 

	
	//by age
	temp = employees.get(0);
	CompareAge ca = new CompareAge();
	comp = ca.compare(employees.get(0),employees.get(1));
	
	if(comp > 0)
	{
		employees.set(0,employees.get(1));
		employees.set(1, temp);
	}
	
	System.out.println("Sort by Department");
	System.out.println(employees.get(0));
	System.out.println(employees.get(1));

	}
}
