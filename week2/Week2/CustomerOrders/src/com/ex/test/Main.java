package com.ex.test;

import java.util.ArrayList;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Customer;

public class Main {
	
	public static void main(String[] args) {
		DaoImpl dao = new DaoImpl();
//		dao.addOrder(1000,1000);
//		dao.addCustomer("Mark", "W", "TX", 100, "markw@gmail.com");
		dao.updateCustomerFirstName(1000, "herp");
	}
}
