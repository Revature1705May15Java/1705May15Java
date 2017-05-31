package com.bank.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.bank.logs.Logger;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;
import com.bank.util.ConnectionUtil;

public class DaoImpl implements DAO {
	static Logger Log = new Logger();
	
	@Override
	public int addUser(String fn, String ln, String uname, String pw){
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "insert into users(first_name, last_name, username, password) "
					+" values(?,?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, uname);
			ps.setString(4, pw);
			int num = ps.executeUpdate();
			Log.log(num +" users added");
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	@Override
	public Account addAccount(int userId, int type_id){
		Account a = null;
		int acc_id;
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "insert into account(type_id) values(?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, type_id);
			int numRowsAffected = ps.executeUpdate();
			acc_id = recentCreated();
			
			System.out.println("Num rows affected: "+numRowsAffected);
			addUserAccount(userId, acc_id);
			
			a = getAccByAccId(acc_id); 
			
			return a;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	@Override
	public void addUserAccount(int userId, int accountId){
		try(Connection connection = ConnectionUtil.getConnection();){
			String sql = "insert into user_account values("+userId+", "+accountId+")";
			Statement statement = connection.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println("Num rows affected: "+numRowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int updateBalance(Account account, double newbal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUser(String uname) {
		// TODO Auto-generated method stub
		User u = new User();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from users where (username)=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname.toLowerCase());
			
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setPw(userinfo.getString(4));
				u.setUname(userinfo.getString(5));				
			}
			//ADD LOGGG!!!
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(int id) {
		
		User u = new User();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from users where u_id=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet userinfo = ps.executeQuery();
			while(userinfo.next()){
				u.setId(userinfo.getInt(1));
				u.setFn(userinfo.getString(2));
				u.setLn(userinfo.getString(3));
				u.setUname(userinfo.getString(4));
				u.setPw(userinfo.getString(5));				
			}
			//ADD LOGGG!!!
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AccountType getTypeName(int typeId){
		AccountType aType=null;  
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select type_name from accounttype where t_id=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, typeId);
			ResultSet info = ps.executeQuery();
			while(info.next()){
				aType = new AccountType(typeId, info.getString(1));				
			}
			
			return aType;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	@Override
	public int recentCreated(){
		int acc_id;
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "{?= call get_recent_accid}";
			CallableStatement cs = connect.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			acc_id=cs.getInt(1);
			
			return acc_id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	@Override
	public Account getAccByAccId(int acc_id ){
		Account a = new Account();
		try(Connection connect = ConnectionUtil.getConnection();){
			String sql = "select * from account where acc_id=?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, acc_id);
			ResultSet info = ps.executeQuery();
			DaoImpl dao = new DaoImpl();
			while(info.next()){
				a.setId(info.getInt(1));
				a.setBalance(info.getDouble(2));
				a.setType_id(info.getInt(3));
				a.setDateOpened(info.getDate(4));
				a.setDateClosed(info.getDate(5));
			}
			
			
			
		}catch (SQLException e){
			
		}
		
		
		return null;
		
	}
	
	@Override
    public ArrayList<Account> getAllAccounts(int currId) {
        ArrayList<Account> userAccounts = new ArrayList<Account>();
        try (Connection connection = ConnectionUtil.getConnection();) {
            String sql = "Select * from account inner join user_account on account.acc_id = user_account.Account_ID and user_account.user_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, currId);
            ResultSet info = ps.executeQuery();

            while (info.next()) {
                Account account = new Account();
                account.setId(info.getInt(1));
                account.setBalance(info.getDouble(2));
                account.setType_id(info.getInt(3));
                account.setDateOpened(info.getDate(4));
                if (info.getDate(5) != null) {
                    account.setDateClosed(info.getDate(5));
                } else {
                    account.setDateClosed(null);
                }
                if(account.getDateClosed() ==null){
                userAccounts.add(account);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userAccounts;
    }

	

}
