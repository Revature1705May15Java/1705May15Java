package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.model.repository.CustomerRepository;
//aka the DAO layer

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
//	@Autowired //member variable injection
	private CustomerRepository customerRepository;

	//must write constructor for constructor injection
	public CustomerServiceImpl(){}
	
//	@Autowired //constructor injection
	public CustomerServiceImpl(CustomerRepository cr){
		System.out.println("using constructor injection");
		this.customerRepository = cr;
	}
	
	//@Autowired // setter injection
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("doing setter injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	
	
//without spring:	
	//	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
//	
//	public List<Customer> findAll(){
//		return customerRepository.findAll();
//	}

}
