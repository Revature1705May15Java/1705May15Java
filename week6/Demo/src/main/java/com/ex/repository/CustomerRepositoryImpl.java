package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import com.ex.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.ex.repository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		Customer temp;
		
		for(int i = 0; i < 5; i++){
			temp = new Customer("Random", String.valueOf(i));
			temp.setFirstname("Random");
			temp.setLastname(String.valueOf(i));
			customers.add(temp);
			customers.get(i).getLastname();
		}
		
		return customers;
	}
}
