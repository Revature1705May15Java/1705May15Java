package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("customerRepository")
public class CustomerRepoImpl implements CustomerRepo 
{
	/* (non-Javadoc)
	 * @see com.ex.repository.CustomerRepo#findAll()
	 */
	public List<Customer> findAll()
	{
		List<Customer> customers = new ArrayList<Customer>();
		Customer c = new Customer(); 
		c.setFirstName("afda");
		customers.add(c); 
		c = new Customer(); 
		c.setFirstName("bofja");
		customers.add(c);
		
		return customers; 
	}
	
	public String getName()
	{
		return "name"; 
	}
	
	public void timer()
	{
		long startTime = System.currentTimeMillis();
//		long elapsedTime;
				
		double num = Integer.MAX_VALUE;
		for(int i = 0; i < num; i++)
			num += i; 
		
		System.out.println(System.currentTimeMillis() - startTime + 
				" milliseconds"); 
	}
}
