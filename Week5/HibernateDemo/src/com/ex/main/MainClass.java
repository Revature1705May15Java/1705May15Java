package com.ex.main;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Person;

public class MainClass {
	
	public static void main(String[] args) {
		Person p = new Person(1, "Genesis", "Bonds");
		DaoImpl dao = new DaoImpl();
		
		dao.createPerson(p);
	}

}
