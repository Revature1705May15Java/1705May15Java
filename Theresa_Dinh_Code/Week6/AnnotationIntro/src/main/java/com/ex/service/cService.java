package com.ex.service;

import java.util.List;

import com.ex.model.Customer;

public interface cService {

	List<Customer> findAll();
	void timer(); 
}