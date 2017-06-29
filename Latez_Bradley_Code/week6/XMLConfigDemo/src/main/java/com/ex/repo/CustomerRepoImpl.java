package com.ex.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("customerRepo")
public class CustomerRepoImpl implements CustomerRepo {
	
	
	

	
	
	/* (non-Javadoc)
	 * @see com.ex.repo.CustomerRepo#findAll()
	 */
	public List <Customer> findAll(){
		
		List<Customer> customers = new ArrayList<Customer>();
		Customer c = new Customer();
		c.setFirstname("Greg");
		c.setLastname("Monroe");
		customers.add(c);
		
		c.setFirstname("John");
		c.setLastname("Wall");
		customers.add(c);
		
		c.setFirstname("Lebron");
		c.setLastname("James");

		return customers;
	}

}
