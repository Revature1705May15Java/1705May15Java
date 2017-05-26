package com.rev.service;

import com.rev.dao.DAO;
import com.rev.dao.DAOImpl;
import com.rev.pojos.User;

public class Service {
	private static DAO dao = new DAOImpl();
	
	public User addUser(String firstName, String lastName, String password, String email) {
		if(dao.addUser(firstName, lastName, password, email) == 1) {
			User user = dao.getUser(email);
			
			return user;
		}
		
		return null;
	}
	
	public User getUser(String email) {
		// TODO: Set user's accounts
		return dao.getUser(email);
	}
	
	public boolean isEmailUnique(String email) {
		if(dao.getUser(email) == null) {
			return true;
		}
		
		return false;
	}
}
