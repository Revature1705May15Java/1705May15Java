package com.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepo;
import com.ex.repository.CustomerRepoImpl;


@Service("customerService")
public class CustomerService implements cService 
{
	private CustomerRepo customerRepository = new CustomerRepoImpl(); 
	
	public CustomerService() 
	{

	}
	
	public CustomerService(CustomerRepo customerRepository) 
	{
		super();
		this.customerRepository = customerRepository;
	}


	/* (non-Javadoc)
	 * @see com.ex.service.Service#findAll()
	 */
	public List<Customer> findAll()
	{
		return customerRepository.findAll(); 
	}

	public void setCustomerRepository(CustomerRepo customerRepository) 
	{
		this.customerRepository = customerRepository;
	}

	public void timer()
	{
		customerRepository.timer(); 
	}
}
