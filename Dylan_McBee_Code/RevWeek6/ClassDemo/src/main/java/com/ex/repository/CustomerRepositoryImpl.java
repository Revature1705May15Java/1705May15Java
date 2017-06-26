package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import com.ex.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.ex.respository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		Customer c = new Customer();
		c.setFirstName("Dylan");
		c.setLastName("McBee");
		customers.add(c);
		return customers;
	}
	
}