package com.ex.test;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		DaoImpl dao = new DaoImpl();
		
//		dao.addOrder(1015, 10111.00);
	// dao.addCustomer("G", "B", "NY", 590.15, "email@email.com");
		
		Customer temp = dao.getCustomerById(1025);
		System.out.println(temp.toString());
		
		dao.createOrder(temp, 8888.88);

	}

}
