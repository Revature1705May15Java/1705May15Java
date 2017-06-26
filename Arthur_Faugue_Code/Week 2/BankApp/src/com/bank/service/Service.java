package com.bank.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojo.Account;
import com.bank.pojo.User;

public class Service {
	public static DAO dao = new DaoImpl();
	
	public double updateBalance(Account account, double newbal){
		return dao.updateBalance(account, newbal);
	}
	public int addUser( String fn, String ln, String uname, String pw){
		return dao.addUser(fn, ln, uname, pw);
	}
	public User getUser(String uname, String pw){
		return dao.getUser(uname, pw);
	}
	public User getUser(int id){
		return dao.getUser(id);
	}
	public void addAccount(User u, double bal, int type){
		dao.addAccount(u, bal, type);
	}
	public ArrayList<Account> showAccounts(int uid){
		return dao.showAccounts(uid);
	}
	public boolean closeAccount(Account a){
		return dao.closeAccount(a);
	}
	public int getRecentAccount(){
		//get most recent id to insert into 
		return dao.getRecentAccount();
	}
	public Account getAccount(int aid){
		return dao.getAccount(aid);
	}
	public void updateJoin(User u, int accountId){
		dao.updateJoin(u, accountId);
	}
	public double getBalance(Account account){
		return dao.getBalance(account);
	}
	public ArrayList<User> getAllUserOnAccount(Account a){
		return dao.getAllUserOnAccount(a);
	}
	public boolean addUserToAccount(Account a, int userId) throws SQLIntegrityConstraintViolationException{
		return dao.addUserToAccount(a, userId);
	}
	public boolean checkClosedAccount(Account a){
		return dao.checkClosedAccount(a);
	}

}