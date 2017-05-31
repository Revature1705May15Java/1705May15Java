package com.bank.pojos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.util.ConnectionUtil;

public class Account {
	int id;
	double balance;
	int type_id;
	public Account() {
		super();
	}

	public Account(int id, double balance, int type_id, Date dateOpened, Date dateClosed,
			ArrayList<User> account_holders) {
		super();
		this.id = id;
		this.balance = balance;
		this.type_id = type_id;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.account_holders = account_holders;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type_id=" + type_id + ", dateOpened=" + dateOpened
				+ ", dateClosed=" + dateClosed + ", account_holders=" + account_holders + "]";
	}

	public int getId() {
		return id;
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

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
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

	public ArrayList<User> getAccount_holders() {
		return account_holders;
	}

	public void setAccount_holders(ArrayList<User> account_holders) {
		this.account_holders = account_holders;
	}
	
	public Account getAccountById(int id){
		Account a = new Account();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from Account where acc_id=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				a.setId(userinfo.getInt(1));
				a.setBalance(userinfo.getDouble(2));
				a.setType_id(userinfo.getInt(3));
				a.setDateOpened(userinfo.getDate(4));
				a.setDateClosed(userinfo.getDate(5));			
			}
			//ADD LOGGG!!!
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}
	
	Date dateOpened, dateClosed;
	
	ArrayList <User> account_holders;
	
	
}
