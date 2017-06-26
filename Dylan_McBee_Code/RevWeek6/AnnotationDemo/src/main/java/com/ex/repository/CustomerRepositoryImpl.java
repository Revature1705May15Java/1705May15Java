package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("customerRepository")
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
	
	public String getName(){
		return "Dylan";
	}
	
}