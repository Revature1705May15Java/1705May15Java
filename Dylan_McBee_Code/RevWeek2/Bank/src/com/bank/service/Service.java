package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {

	static DAO dao = new DaoImpl();
	public User addUser(String fn, String ln, String uName, String pw){
		User temp = new User();
		temp = dao.getUser(uName);
		if(temp!=null){
			//username exists, prompt user to change username, or login
		}
		else{
			dao.addUser(fn, ln, uName, pw);
		}
			
		return dao.getUser(uName);
	}
	
	public boolean checkUser(String uName){
		boolean exists = true;
		User temp = new User();
		temp = dao.getUser(uName);
		if(temp == null){
			//if user name does not exist, return to front end
			exists = false;
		}
		return exists;
		
	
	}
	
	public boolean checkPassword(String uName, String pw){
		boolean correct = true;
		User temp = new User();
		temp = dao.getUser(uName);
		if(temp.getPw().equals(pw)){
			
		}
		else{
			correct = false;
		}
		return correct;
	}
	
	public User getUser(String uName){
		return dao.getUser(uName);
	}
	
	public Account openAccount(User u, int type_id){
		int userId = u.getId();
		int accountId = dao.openAccount(userId, type_id);
		if(accountId != -1){
			return dao.getAccountById(accountId);
		}
		else{
			return null;
		}
		
	}

	public boolean isUserNameAvailable(String uName) {
		List<User> users = dao.getAllUsers();
		boolean available = true;
		for(User user : users){
			if(uName.equals(user.getuName())){
				available = false;
				break;
			}
		}
		return available;
	}

	public ArrayList<Account> getAllAccounts(int currId) {
		return dao.getAllAccounts(currId);
	}
}
