package com.ex.service;

import java.util.List;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;
import com.ex.repository.CustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	public void setCustomerRepository(CustomerRepository cr) {
		this.customerRepository = cr;
	}
	public CustomerServiceImpl(){
		
	}

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	public List<Customer> findAll(){
		System.out.println("in service layer");
		return customerRepository.findAll();
	}
	
}
