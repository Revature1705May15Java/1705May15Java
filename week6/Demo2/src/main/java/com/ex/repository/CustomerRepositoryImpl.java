package com.ex.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ex.model.Customer;

@Repository("CustomerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {
	/* (non-Javadoc)
	 * @see com.ex.repository.CustomerRepository#findAll()
	 */
	int runCounter = 0;
	
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		Customer temp;
		runCounter++;
		System.out.println("Run Counter: " + runCounter);
		for(int i = 0; i < 5; i++){
			temp = new Customer("Random", String.valueOf(i));
			temp.setFirstname("Random");
			temp.setLastname(String.valueOf(i));
			customers.add(temp);
			
			System.out.println(customers.size() + ": " + customers.get(i).getFirstname() + " " + customers.get(i).getLastname());
		}
		System.out.println("Before Exiting: " + customers.get(0).getFirstname());
		return customers;
	}
	
	public String getName(){
		return "MARK YOU CRAZY";
	}
}
