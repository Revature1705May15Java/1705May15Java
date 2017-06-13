package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImp implements DAO
{

	static Logger logger = new Logger();
	
	
	@Override
	public int addUser(String fn, String ln, String email, String pass) 
	{
		
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			String sql = " insert into users (fName, lName, password, email)"
						+ "values (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pass);
			ps.setString(4, email);
			
			int num = ps.executeUpdate();
			
			logger.log(num + " users added");
			
			return num;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public User getUser(String email)
	{
		
		User u = new User();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from users where email = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setEmail(info.getString(5));
			}
			
			if(u.getEmail()!= null)
				logger.log("retrived user by usernam" + u.toString());
			else
			{
				logger.log("Attempted to retrive non-existant user");
				return null;
			}
			
			return u;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ERROR");
		return null;
	}
	
	
	public int getAccountNumber (int id)
	{
		int accounts = 0;
		CallableStatement cs = null;
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			cs = connect.prepareCall("{? = call getAccountNum(?)}");
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setInt(2, id);
			cs.execute();
			accounts = cs.getInt(1);
			
			return accounts;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
		
	}
	
	@Override
	public User getUserByID(int uid)
	{
		User u = new User();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from users where userId = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, uid);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				AccountType t;
				
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setPw(info.getString(4));
				u.setEmail(info.getString(5));
			}
			
			return u;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//gets user ids from account_user  list based on a given account number
	public ArrayList<Integer> getUsersIds (int aid)
	{
		
		ArrayList<Integer> uids= new ArrayList<Integer>();
		Integer i;
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select userID from user_account where accountID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, aid);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				i = info.getInt(1);
					
				uids.add(i);
			}
			
			return  uids;
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Account> getAccount(int id)
	{
		
		ArrayList<Integer> acctids= new ArrayList<Integer>();
		ArrayList<Account> accts = new ArrayList<Account>();
		Integer i;
		Account a;
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select accountID from user_account where userId = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				i = info.getInt(1);
					
				acctids.add(i);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Integer x: acctids)
		{
			try(Connection connect = ConnectionUtil.getConnection();)
			{
				String sql = "select * from account where accountid =?";
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setInt(1, x);
				ResultSet info = ps.executeQuery();
				
				while(info.next())
				{
					a = new Account ();
					AccountType t;
					
					a.setId(info.getInt(1));
					a.setBalance(info.getDouble(2));
					t = getType(info.getInt(3));
					a.setType(t);
					a.setDateOpened(info.getDate(4));
					
					accts.add(a);
					
				}
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return accts;
		
	}
	
	@Override
	public Account getAccountById(int aId) 
	{
		Account a = new Account();
		
		try(Connection connect = ConnectionUtil.getConnection();)
		{
			String sql = "select * from account where accountId = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, aId);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				AccountType t;
				
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				t = getType(info.getInt(3));
				a.setType(t);
				a.setDateOpened(info.getDate(4));
			}
			
			return a;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//gets a type from an entered account
    public AccountType getType (int i)
	{
		AccountType t;
		
		//statement to get type info
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			String sql = "select * from accountType where typeid = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet info = ps.executeQuery();
			
			while(info.next())
			{
				t = new AccountType();
				
				t.setTypeId(info.getInt(1));
				t.setName(info.getString(2));
				
				return t;
			};
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
    
    public void addAccount (User u, int i)
    {
		
    	CallableStatement cs = null;
    	
		//statement to get type info
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			cs = connection.prepareCall("{call createAccount (?,?)}");
			cs.setInt(1, u.getId());
			cs.setInt(2, i);
			cs.execute();
			
			logger.log(" account added");
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void closeAccount (int aid)
    {
    	
    	CallableStatement cs = null;
    	
    	//executes stored procedure that closes the account
    	try(Connection connection = ConnectionUtil.getConnection();)
    	{
		
    		cs = connection.prepareCall("{call closeAccount (?)}");
    		cs.setInt(1, aid);
    		cs.execute();
		
    		logger.log(" account "+ aid + " closed");
			
		
    	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
    	}
    }
	@Override
	public ArrayList<AccountType> getTypes()
	{
		AccountType t;
		ArrayList <AccountType> types = new ArrayList <AccountType>();
		
		
		//statement to get type info
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			String sql = "select * from accountType";
			Statement s = connection.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next())
			{
				t = new AccountType();
				
				t.setTypeId(rs.getInt(1));
				t.setName(rs.getString(2));
				
				types.add(t);
			};
				
			return types;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void addAccountUser (int userId, int acctId)
	{
		
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			String sql = "insert into user_account (userId,accountID)"
						+ "values (?,?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2,acctId);
			
			ps.executeUpdate();
			
			logger.log(userId + " is now a uer of " + acctId);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBalance(Account account) 
	{
		
		try(Connection connection = ConnectionUtil.getConnection();)
		{
			
			String sql = "update account set balance = ? where accountID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2,account.getId());
			
			ps.executeUpdate();
			
			logger.log(account.getId() + "has had its balance updated");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}