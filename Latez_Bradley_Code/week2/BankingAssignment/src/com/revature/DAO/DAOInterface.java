package com.revature.DAO;

import com.revature.POJO.User;

public interface DAOInterface {
	
	public User createUser(String username, String password, String
			firstname, String lastname, String email);

}
