package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO 
{
	
	//user methods
	public int addUser(String fn, String ln, String email,String pass);
	
	public User getUser(String email);
	
	public User getUserByID (int uid);
	
	public ArrayList<Integer> getUsersIds (int aid);
	
	
	//account methods
	public void addAccount (User u, int i);
	
	 public void closeAccount (int aid);
	
	public int getAccountNumber (int id);
	
	public ArrayList<Account> getAccount(int id);
	
	public Account getAccountById (int aId);
	
   public AccountType getType (int i);
   
   public ArrayList<AccountType> getTypes ();
	
   public void addAccountUser (int userId, int acctId);
   
   public void updateBalance (Account account);

}