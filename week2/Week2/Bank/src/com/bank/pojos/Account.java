package com.bank.pojos;

import java.sql.Date;
import java.util.ArrayList;

public class Account {
	int id;
	double balance;
	AccountType type;
	Date dateOpened,dateClosed;
	ArrayList<Integer> accountHolders;
	
	public Account(){
		
	}
	
	
	public int getId() {
		return id;
	}
	public Account(int id, double balance, AccountType type, Date dateOpened, Date dateClosed,
			ArrayList<Integer> accountHolders) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.accountHolders = accountHolders;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public Date getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}
	public Date getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}
	public ArrayList<Integer> getAccountHolders() {
		return null;
//		return accountHolders;
	}
	public void setAccountHolders(ArrayList<Integer> accountHolders) {
		this.accountHolders = accountHolders;
	}
	

}
