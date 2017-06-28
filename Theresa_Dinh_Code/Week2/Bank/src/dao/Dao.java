package dao;

import pojos.Account;
import pojos.User;

public interface Dao 
{
	public boolean updateBalance(Account account, double newBalance);
	public double viewBalance(Account account); 
	public boolean createAccount(Account account);  
	public boolean deleteAccount(Account account); 
	public User addUser(User newUser); 
	public User addUser(String fn, String ln, String pw, String email); 
	public User getUser(User user); 
	public User getUser(String email); 
}