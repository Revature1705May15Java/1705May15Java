package com.bank.service;

import com.bank.dao.Dao;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

import java.util.ArrayList;

public class Service {

	private static final int MAX_ACCOUNTS = 6;
	static Dao dao = new DaoImpl();

	public User addUser(String fName, String lName, String password, String email) {
		//TODO: ensure unique email
		User newUser = null;
		
		if (dao.addUser(fName, lName, password, email)) {
			newUser = dao.getUser(email);
		}
		
		return newUser;
	}
	
	public User login(String email, String password) {
		User possibleUser = dao.getUser(email);
		User result = null;
		
		if (possibleUser != null && possibleUser.getPassword().equals(password) && possibleUser.getEmail().equals(email)) {
			result = possibleUser;
		}
		
		return result;
	}

	public ArrayList<Account> getAccounts(User u) {
		return dao.getAccountsForUser(u);
	}

	public ArrayList<AccountType> getAccountTypes() {
		return dao.getAccountTypes();
	}

	public Account addAccount(User u, int typeId) {
		Account a = null;
	    int numAccounts = dao.getNumOfAccounts(u);

	    if (numAccounts <= MAX_ACCOUNTS) {
			a = dao.addAccount(u, typeId);
		}

		return a;
	}
}
