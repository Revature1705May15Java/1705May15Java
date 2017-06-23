package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired//member variable injection
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
	public String getName(){
		return customerRepository.getName();
	}
	public String needsClass(){
		return ""+this.getClass();
	}
	
}
