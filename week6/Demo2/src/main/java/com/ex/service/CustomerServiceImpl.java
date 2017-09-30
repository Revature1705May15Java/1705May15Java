package com.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.model.Customer;
import com.ex.repository.CustomerRepository;
import com.ex.repository.CustomerRepositoryImpl;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	//private CustomerRepository cr;
	private CustomerRepository cr = new CustomerRepositoryImpl();
	
	public CustomerServiceImpl(){}
	
	public CustomerServiceImpl(CustomerRepository cr) {
		super();
		this.cr = cr;
	}



	public CustomerRepository getCr() {
		return cr;
	}

	public void setCr(CustomerRepository cr) {
		this.cr = cr;
	}

	public List<Customer> findAll() {
		return cr.findAll();
	}
	
}
