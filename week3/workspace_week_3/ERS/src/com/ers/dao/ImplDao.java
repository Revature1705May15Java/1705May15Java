package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.pojo.Request;
import com.ers.pojo.User;
import com.ers.util.ConnectionFactory;

public class ImplDao implements Dao{

	static ArrayList<Request> requests = new ArrayList<Request>();
	static ArrayList<String> stateTypes = getRequestStates();
	
	public String getStateType(int i){
		return stateTypes.get(i);
	}
	
	public boolean deleteRequest(int id){
		String sql = "DELETE FROM requests WHERE requestid = ?";
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	static private ArrayList<String> getRequestStates(){
		ArrayList<String> types = new ArrayList<String>();
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT name FROM statetype ORDER BY stateid";
			
			PreparedStatement ps = connection.prepareStatement(sql);
							 
			ResultSet info = ps.executeQuery();
			
			int i = 0;
			while(info.next()){ // setting request state types for use in other methods.
				types.add(info.getString(1));
				i++;
			}
			
			for(int h = 0; h < types.size(); h++){
				System.out.println("Statetype[" + h + "] = " + types.get(h));
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			for(int i = 0; i < 10; i++){
				types.add("");
			}
		}
		return types;
	}
	
	public boolean updateRequestById(Request req){
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE requests SET amount = ?, purpose = ?, admin_note = ?, resolverid = ?, stateid = ?, date_resolved = ? WHERE requestid = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, req.getBalance());
			ps.setString(2, req.getPurpose());
			ps.setString(3, req.getAdminNote());
			ps.setInt(4, req.getAdminId());
			
			int num = stateTypes.indexOf(req.getType());
			System.out.println("num: " + num + " '" + req.getType() + "'.");
			ps.setInt(5, num);
			
			ps.setDate(6, req.getDateClosed());
			ps.setInt(7, req.getId());
			
			ps.executeUpdate();
 
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean editUser(String editCol, String change, User u) {
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE employee SET " + editCol + " = ? WHERE empid = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, change);
			ps.setInt(2, u.getId());
			
			ps.executeUpdate();
 
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public User getUser(String username) {
		User u = new User();

		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM employee WHERE username = ?";
					
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				u.setUsername(info.getString(1));
				u.setPassword(info.getString(2));
				u.setId(info.getInt(3));
				u.setFn(info.getString(4));
				u.setLn(info.getString(5));
				u.setRank(info.getInt(6));
				u.setRequests(getUserRequests(u.getId()));
			}
			
			if(u.getUsername() != null){}
			else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}

	@Override
	public User getUser(int id) {
		User u = new User();

		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM employee WHERE empid = ?";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet info = ps.executeQuery();
			while(info.next()){ 
				u.setUsername(info.getString(1));
				u.setPassword(info.getString(2));
				u.setId(info.getInt(3));
				u.setFn(info.getString(4));
				u.setLn(info.getString(5));
				u.setRank(info.getInt(6));
				u.setRequests(getUserRequests(u.getId()));
			}
			
			if(u.getUsername() != null){}
			else {
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	
	@Override
	public int addUser(String uname, String pw, String fn, String ln, int emp_rank) {
		int numRowsAffected = 0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "INSERT INTO employee(username,password,firstname,lastname,emp_rank)"
						+ "VALUES (?,?,?,?,?)";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setInt(5, emp_rank);
			
			numRowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numRowsAffected;
	}
	
	public ArrayList<Request> getUserRequests(int id){ 
		requests = new ArrayList<Request>();
		Request temp = new Request();
		User u;
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM requests WHERE empid = ?";
			String sql2 = "SELECT name FROM statetype WHERE stateid = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ResultSet info = ps.executeQuery();
			int i = 0, num = 0;
			while(info.next()){
				
				temp = new Request();
				temp.setId(info.getInt(1));
				temp.setDateOpened(info.getDate(2));
				temp.setDateClosed(info.getDate(3));
				temp.setBalance(info.getDouble(4));
				temp.setPurpose(info.getString(5));
				temp.setRequesterId(info.getInt(6));
				temp.setAdminId(info.getInt(7));
				
				temp.setType(stateTypes.get(info.getInt(8)));
				
				temp.setAdminNote(info.getString(9));
				
				requests.add(i, temp);
				i++;			
			}
			return requests;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.out.println("Prepared Exception... ImplDao 250");
			return null;
		}
	
	}
	
	public ArrayList<Request> getAllRequests(){ 
		requests = new ArrayList<Request>();
		Request temp = new Request();
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM requests";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet info = ps.executeQuery();
			int i = 0;
			while(info.next()){
				
				temp = new Request();
				temp.setId(info.getInt(1));
				temp.setDateOpened(info.getDate(2));
				temp.setDateClosed(info.getDate(3));
				temp.setBalance(info.getDouble(4));
				temp.setPurpose(info.getString(5));
				temp.setRequesterId(info.getInt(6));
				temp.setAdminId(info.getInt(7));
				
				temp.setType(stateTypes.get(info.getInt(8)));
				
				temp.setAdminNote(info.getString(9));
				requests.add(i, temp);
				i++;			
			}
			return requests;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int addRequest(double amt, String purpose, int id) {
		int numRowsAffected = 0;
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "INSERT INTO requests(amount,purpose,empid)"
						+ "VALUES (?,?,?)";
					
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, amt);
			ps.setString(2, purpose);
			ps.setInt(3, id);
			
			numRowsAffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numRowsAffected;
	}

	@Override
	public ArrayList<Request> getRequestsByEmployeeId(int id) {
		ArrayList<Request> list = new ArrayList<Request>();
		Request request = new Request();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM requests WHERE empid = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			int i = 0;
			while(info.next()){
				
				request = new Request();
				request.setId(info.getInt(1));
				request.setDateOpened(info.getDate(2));
				request.setDateClosed(info.getDate(3));
				request.setBalance(info.getInt(4));
				request.setPurpose(info.getString(5));
				request.setRequesterId(6);
				request.setAdminId(info.getInt(7));
				
				request.setType(stateTypes.get(info.getInt(8)));
				
				request.setAdminNote(info.getString(9));
				list.add(i, request);
				i++;			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Request getRequestById(int id) {
		Request request = new Request();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM requests WHERE requestid = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			
			info.next();
			request.setId(info.getInt(1));
			request.setDateOpened(info.getDate(2));
			request.setDateClosed(info.getDate(3));
			request.setBalance(info.getInt(4));
			request.setPurpose(info.getString(5));
			request.setRequesterId(info.getInt(6));
			request.setAdminId(info.getInt(7));
			
			request.setType(stateTypes.get(info.getInt(8)));
			
			request.setAdminNote(info.getString(9));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return request;
	}

}
