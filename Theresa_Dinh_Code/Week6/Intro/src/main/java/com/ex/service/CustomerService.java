package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepo;
//import com.ex.repository.CustomerRepoImpl;

public class CustomerService implements Service 
{
	private CustomerRepo customerRepository; 
	
	public CustomerService() 
	{
		super();
	}
	
	public CustomerService(CustomerRepo customerRepository) 
	{
		super();
		this.customerRepository = customerRepository;
	}

//	public CustomerService(CustomerRepoImpl repo) {
//		super();
//		this.customerRepository = repo;
//	}

	/* (non-Javadoc)
	 * @see com.ex.service.Service#findAll()
	 */
	public List<Customer> findAll()
	{
		return customerRepository.findAll(); 
	}

	public void setCustomerRepository(CustomerRepo repo) 
	{
		this.customerRepository = repo;
	}
	
	
}
