package com.ers.service;

import com.ers.dao.Dao;
import com.ers.dao.ImplDao;
import com.ers.pojo.User;

public class Service {
	static Dao dao = new ImplDao();
	
	public User getUserInfo(String username) {
		User temp = new User();
		
		temp = dao.getUser(username);
		
		return temp;
	}
}
