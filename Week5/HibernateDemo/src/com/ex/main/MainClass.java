package com.ex.main;

import com.ex.dao.BearDAO;
import com.ex.dao.DaoImpl;
import com.ex.pojos.Bear;
import com.ex.pojos.Cave;
import com.ex.pojos.HoneyPot;
import com.ex.pojos.Person;

public class MainClass {
	
	public static void main(String[] args) {
//		Person p;
//		DaoImpl dao = new DaoImpl();
//		
//		//dao.createPerson(p);
//		
//		//p = dao.getPersonById(1);
//		//System.out.println("hello " + p);
//		
//		
//
//		dao.deleteById(50);
////		p = dao.getPersonById(50);
////		p.setFirstname("Genesis");
////		dao.update(p);
////		
////		List<Person> people = dao.getAllPeople();
////		
////		for(Person x:people){
////			System.out.println(x);
////		}
		
		
		
		BearDAO bearDao = new BearDAO();
	
		bearDao.createBearsDemo();
	}

}
