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
import com.bank.util.ConnectionFactory;


public class DaoImpl implements DAO {
	static Logger logger = new Logger();

	
	//add user by first name, last name, password, and username;
	@Override
	public int addUser(String fn, String ln, String pw, String uname){
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into users(first_name, last_name, password, username) " +
					"values(?, ?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, pw);
			ps.setString(4, uname);
			
			int num = ps.executeUpdate();
			
			logger.log(num + " users add");
			return num;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return 0;
	}

	//update balance by account id and new balance
	@Override
	public double updateBalance(int accId, double newbal) {
		// TODO Auto-generated method stub
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = " UPDATE account SET balance = ? WHERE acc_id = ? ";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setDouble(1, newbal);
			ps.setInt(2, accId);
			
			int affected = ps.executeUpdate();

			if(affected != 0){
			logger.log("Balance updated to: " + newbal);
			}
			return affected;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return 0;
	}

	//get user by username
	@Override
	public User getUser(String uname) {
		// TODO Auto-generated method stub
		User u = null;
		uname = uname.toLowerCase();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from users where lower(username) = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname.toLowerCase());
			
			ResultSet userinfo = ps.executeQuery();
			//id, fn, ln, pw, uname
			u = new User();
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setUname(userinfo.getString(4));
				u.setPw(userinfo.getString(5));
				
			}
			if(u.getUname()!=null){
			logger.log("Retrieved user by username " + u.toString());}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return u;
	}
	
	//get users by userid
	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		
		User u = new User();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from users where u_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet userinfo = ps.executeQuery();
			//id, fn, ln, pw, uname
			
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setPw(userinfo.getString(4));
				u.setUname(userinfo.getString(5));
			}
			if(u.getUname()!=null){
			logger.log("Retrieved user by user id " + u.toString());}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return null;
	}
	
	
	//add Account by type id and user it belong to
	@Override
	public Account addAccount(User u, int typeId){
		Account a = null;
		int accId;
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO account(type_id) VALUES(?)";

            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, typeId);

            int count = ps.executeUpdate();
            
            DaoImpl dao = new DaoImpl();
            
            accId = dao.recentCreated();
            
            dao.addUserAccount(u.getId(), accId);
            
            a = dao.getAccByAccId(accId);
            a.setAccount_holder(dao.findUserByAccId(accId));
            
            if(count!=0){
            	logger.log("Added Account: " + a.toString());
            }
            return a;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
 
		return a;
	}
	
	//find Account by account id
	@Override
	public Account getAccByAccId(int accId){
		Account a = new Account();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from account where acc_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, accId);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email
			DaoImpl dao = new DaoImpl();
			while(info.next()){
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				a.setType(dao.getTypeName(info.getInt(3)));
				a.setDateOpened(info.getDate(4));
				a.setDateClosed(info.getDate(5));

			}
			
			logger.log("Retrieved Account by accountId " + a.toString());
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		
		return a;
	}
	
	
	//get Type Name from AccountType table by typeId
	@Override
	public AccountType getTypeName(int typeId){
		AccountType accT = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select type_name from accounttype where t_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, typeId);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email
			while(info.next()){
				accT = new AccountType(typeId, info.getString(1));
			}
			logger.log("Retrieved AccountType by typeId " + accT.toString());
			return accT;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		
		return accT;
	}
	
	//regular statement to add user_account right after create an account
	@Override
	public void addUserAccount(int userId, int accountId){
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into user_account values( "+ userId + ", " + accountId + ")";
			Statement statement = connection.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: "+ numRowsAffected);
			logger.log("User_Account inserted UserId: " + userId + " AccountId: " + accountId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
	}
	
	
	 
	//callable statement to get account id that is most recent created
	@Override
	public int recentCreated(){
		int acc_id=0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String addOrder = "	";
			CallableStatement cs = connection.prepareCall(addOrder);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			acc_id = cs.getInt(1);
			logger.log("Retrieved recent created account ID " + acc_id);
			return acc_id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return acc_id;
		
	}
	
	//find all accounts by user id returns ArrayList of accounts
	@Override
	public ArrayList<Account> findAccByUserId(int UserId) {
		 ArrayList<Account> accounts = new ArrayList<Account>();
		 DAO dao = new DaoImpl();
		 Account acc = new Account();
	        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            String sql = " SELECT account.acc_id, account.balance, account.opened, account.closed, accounttype.t_id "+
                    " FROM user_account "+
                    " INNER JOIN users ON user_account.user_id = users.u_id "+
                    " INNER JOIN account ON user_account.account_id = account.acc_id "+
                    " INNER JOIN accounttype ON accounttype.t_id = account.type_id " +
                    " WHERE users.u_Id= ? ";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, UserId);

	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
	               
	            	acc.setId(rs.getInt(1));
	            	acc.setBalance(rs.getDouble(2));
	        
	                acc.setDateOpened(rs.getDate(3));
	        
	                        
	                acc.setDateClosed(rs.getDate(4));
	 
	                acc.setType(dao.getTypeName(rs.getInt(5)));
	     
	                        
	                accounts.add(acc);
	                acc = new Account();
	            }
	            logger.log("Retrieved all accounts by userid " + accounts.toString());
	            return accounts;

	        } catch (SQLException e) {
				// TODO Auto-generated catch block
	        	e.printStackTrace();
				logger.log(e.getSQLState());
	        }

	        return null;
	    }

	
	
	//find all users by account id returns ArrayList of users
	@Override
	public ArrayList<User> findUserByAccId(int accId) {
		// TODO Auto-generated method stub
		ArrayList<User> user = new ArrayList<User>();
		User u = new User();
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql =    " SELECT users.u_id, users.first_name, users.last_name, users.username, users.password " +
                    " FROM user_account " +
                    " INNER JOIN users ON user_account.user_id = users.u_id " +
                    " INNER JOIN account ON user_account.account_id = account.acc_id " +
                    " WHERE account.acc_Id= ? ";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, accId);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email

			while(info.next()){
				u.setId(info.getInt(1));
				u.setFn(info.getString(2));
				u.setLn(info.getString(3));
				u.setUname(info.getString(4));
				u.setPw(info.getString(5));
				user.add(u);
				u= new User();
			}
			logger.log("Retrieved users by accountId " + user.toString());
			return user;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		
		return user;
	}
	
	
	//most recent created User id
	@Override
	public int recentCreatedUser(){
		int user_id=0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String addOrder = "{ ? = call get_recent_userid}";
			CallableStatement cs = connection.prepareCall(addOrder);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			user_id = cs.getInt(1);
			logger.log("Retrieved recent created user ID " + user_id);
			return user_id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return user_id;
	}
	
	//count Accounts by User id
	@Override
	public int coutAccByUserId(int userId){
		int acc=0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "{ ? = call get_num_accounts(?) }";
			CallableStatement cs = connection.prepareCall(sql);
			
			cs.setInt(2, userId);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			acc = cs.getInt(1);
			logger.log("Account number by user ID "+ userId +": is " + acc);
			return acc;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return acc;
	}
	
	//close Account by account id
	@Override
	public boolean closeAccount(int accId){
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			 String sql = "{call close_acc(?)";
			
			CallableStatement cs = connect.prepareCall(sql);
			cs.setInt(1, accId);
			
			int row = cs.executeUpdate();
			if (row == 1)
				return true;
			logger.log("Account deleted: " + accId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(e.getSQLState());
		}
		return false;
	}
	
}