package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

import bankUtil.ConnectionFactory;
import pojos.Account;
import pojos.AccountType;
import pojos.User;

// reads and writes to sql database 

public class BankDao implements Dao
{
	@Override
	public double viewBalance(Account account) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String statement = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNTID = ?";
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setInt(1, account.getId());

			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				return rs.getDouble(1);
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace(); 
		}
		return -0.00;	//how to tell when viewBalance fails
	}

	public Account getAccount(Account account)
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String statement = "SELECT * FROM ACCOUNT WHERE ACCOUNTID = ?"; 
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setInt(1, account.getId());
			
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next())
			{
				// account id, balance, accounttype, opendate, closedate
				Account a = new Account(); 
				a.setId(rs.getInt(1));
				a.setBalance(rs.getDouble(2));
				a.setType(new AccountType(rs.getInt(3)));
				a.setDateOpened(rs.getTimestamp(4));
				a.setDateClosed(rs.getTimestamp(5));
				return a; 
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		}
		return null; 
	}
	
	@Override
	public boolean updateBalance(Account account, double newBalance) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			String statement = "UPDATE ACCOUNT "
					+ "SET BALANCE = ?"
					+ "WHERE ACCOUNTID = ?"; 
			PreparedStatement ps = c.prepareStatement(statement); 
			ps.setDouble(1, newBalance); 
			ps.setInt(2, account.getId());
			
			int rowCheck = ps.executeUpdate(); 
			
			c.commit(); 
			ps.close();
			c.setAutoCommit(true);
			
			if(rowCheck == 1)
				return true;
			else 
				return false; 
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User addUser(String fn, String ln, String pw, String email) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			User temp = new User(fn, ln, pw, email); 
			
			String s = "INSERT INTO USERS (FNAME, LNAME, PASSWORD, EMAIL)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, email);
			
			int rowCheck = ps.executeUpdate(); 
			c.commit();
			ps.close(); 
			c.setAutoCommit(true);
			
//			System.out.println(rowCheck);
			if(rowCheck != 1)
			{
				return null; 
			}
			else
				return temp;
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public User addUser(User newUser) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			String statement = "INSERT INTO USERS (FNAME, LNAME, PASSWORD, EMAIL)"
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setString(1, newUser.getfName());
			ps.setString(2, newUser.getlName());
			ps.setString(3, newUser.getPassword());
			ps.setString(4, newUser.getEmail());
			
			int rowCheck = ps.executeUpdate(); 
			
			c.commit();
			ps.close(); 
			c.setAutoCommit(true);

			if(rowCheck != 1)
			{
				return null; 
			}
			else
				return newUser;
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean createAccount(Account account)
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			String statement = "INSERT INTO ACCOUNT (BALANCE, TYPEID, OPENDATE, CLOSEDATE)"
					+ "VALUES (?, ?, ?, ?)"; 
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setInt(1, account.getId());
			ps.setInt(2, (account.getType()).getId());
			ps.setTimestamp(3, account.getDateOpened());
			ps.setTimestamp(4, null);
			
			int rowCheck = ps.executeUpdate();

			c.commit();
			ps.close(); 
			c.setAutoCommit(true);
			
			if(rowCheck != 1)
				return false; 
			else 
				return true; 
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		}
		return false; 
	}
	
	// only add closeDate without actually deleting record
	@Override
	public boolean deleteAccount(Account account)
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			c.setAutoCommit(false);
			
			Date date = new Date(); 
			Timestamp ts = new Timestamp(date.getTime()); 
			
			String statement = "UPDATE ACCOUNT SET CLOSEDATE = ? WHERE ACCOUNTID = ?"; 
			PreparedStatement ps = c.prepareStatement(statement);
			ps.setTimestamp(1, ts);
			ps.setInt(2, account.getId());
			
			int rowCheck = ps.executeUpdate();
			
			c.commit();
			ps.close();
			c.setAutoCommit(true);
			
			if(rowCheck != 1)
				return false; 
			else 
				return true; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false; 
	}

//	@Override
	public User getUser(int id) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM USERS WHERE USERID = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// userid, fname, lname, password, email
				User u = new User(); 
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2)); 
				u.setlName(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setEmail(rs.getString(5));				
				return u; 
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		} 
		return null;
	}
	
	@Override
	public User getUser(User user) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM USERS WHERE EMAIL = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, user.getEmail());
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// userid, fname, lname, password, email
				User temp = new User(); 
				temp.setId(rs.getInt(1));
				temp.setfName(rs.getString(2)); 
				temp.setlName(rs.getString(3));
				temp.setPassword(rs.getString(4));
				temp.setEmail(rs.getString(5));				
				return temp; 
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public User getUser(String email) 
	{
		try(Connection c = ConnectionFactory.getInstance().getConnection();)
		{
			String s = "SELECT * FROM USERS WHERE EMAIL = ?"; 
			PreparedStatement ps = c.prepareStatement(s);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery(); 
			while(rs.next())
			{
				// userid, fname, lname, password, email
				User u = new User(); 
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2)); 
				u.setlName(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setEmail(rs.getString(5));
				return u; 
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
		} 
		return null;
	}
}