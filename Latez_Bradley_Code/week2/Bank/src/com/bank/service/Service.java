package com.bank.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class Service {
	
	static DAO dao = new DaoImpl();
	
	
	
	public User addUser(String fn, String ln, String uname, String pw){
		User temp = new User();
		temp = dao.getUser(uname);
		if(temp!=null){
			//username found
			System.out.println("USER FOUND! Try again!");
			return null;
			
		}
		else{
			dao.addUser(fn, ln, uname, pw);
		}
		return dao.getUser(uname);
		
	}
	
	public User getUser(String uname){
		User temp = new User();
		temp = dao.getUser(uname);
		return temp;
	}
	
	public User getbyUserId(int i){
		User t = new User();
		t = dao.getUser(i);
		return t;
		
	}
	
	public Account addAccount(int userId, int type_id){
		Account a = new Account();
		
		a = dao.addAccount(userId, type_id);
		
		return a;
		
	}
	
	public ArrayList <Account> getallAccounts(int curid){
		ArrayList <Account>a;
		a = dao.getAllAccounts(curid);
		return a;
	}
	
	
	
	
	

}
