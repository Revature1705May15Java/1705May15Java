package com.ex.main;

import com.ex.dao.BearDAO;
import com.ex.dao.DaoImpl;
import com.ex.pojos.Bear;
import com.ex.pojos.HoneyPot;

public class MainClass {

	public static void main(String[] args) {
		
//		Person p = new Person("Meme", "Doe");
		DaoImpl dao = new DaoImpl();
//		dao.createPerson(p);
		dao.getPersonById(50);
		//dao.getAllPeople();
		
		BearDAO bearDao = new BearDAO();
		//Bear b = new Bear();
		//HoneyPot hp = new HoneyPot();
		
	}
}