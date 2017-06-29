package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.util.ConnectionFactory;

public class DaoImpl implements DAO {

	@Override
	public int addEmployee(String uname, String pw,String fn, String ln, int isManager) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into employee(USERNAME, PW, FIRSTNAME, LASTNAME, ISMANAGER)"
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setInt(5, isManager);
			int num = ps.executeUpdate();
			System.out.println(num+" users added");
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Employee getEmployee(String username) {
		Employee e = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM EMPLOYEE WHERE (username)=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet empinfo = ps.executeQuery();
			while(empinfo.next()){
				e.setUsername(empinfo.getString(1));
				e.setPassword(empinfo.getString(2));
				e.setEid(empinfo.getInt(3));
				e.setFirstname(empinfo.getString(4));
				e.setLastname(empinfo.getString(5));
				e.setIsmanager(empinfo.getInt(6));
			}
			return e;

		} catch (SQLException ex) {
			System.out.println("CAUGHT");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;


	}

	@Override
	public int alterRequest(int Stateid, String note, int requestid, int managerid) {
		// TODO Auto-generated method stub
		Request r = new Request();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE REQUESTS "
					+ "SET STATEID = ?,"
					+ "NOTE= ?,"
					+ "RESOLVERID = ?"
					+ "WHERE RequestID=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Stateid);
			ps.setString(2, note);
			ps.setInt(3, managerid);
			ps.setInt(4, requestid);

			int numRows = ps.executeUpdate();

			System.out.println("Number of rows updated: "+numRows);
			return numRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int request(int amount, String purpose, int requesterid ){
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into requests(Amount, Purpose,Requesterid)VAlues(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setString(2, purpose);
			ps.setInt(3, requesterid);

			int numRows = ps.executeUpdate();

			System.out.println("Number of rows affected: "+numRows);
			return numRows;

		} catch (SQLException e) {
			System.out.println("Caught");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public ArrayList <Employee> viewEmployees() {
		// TODO Auto-generated method stub
		ArrayList<Employee> emps = new ArrayList<Employee>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM EMPLOYEE";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet info = ps.executeQuery();
			
			while(info.next()){
				Employee temp = new Employee();
				temp.setUsername(info.getString(1));
				temp.setPassword(info.getString(2));
				temp.setEid(info.getInt(3));
				temp.setFirstname(info.getString(4));
				temp.setLastname(info.getString(5));
				temp.setIsmanager(info.getInt(6));
				emps.add(temp);
			}
			
			return emps;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Request> viewOpenRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Request> viewClosedRequestsById(int id) {
		ArrayList <Request> req = new ArrayList <Request>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REQUESTS WHERE REQUESTERID=? AND NOT STATEID= ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, 0);

			ResultSet rinfo = ps.executeQuery();
			while(rinfo.next()){
				Request r = new Request();
				r.setStateid(rinfo.getInt(1));
				r.setOpen(rinfo.getDate(2));
				r.setClosed(rinfo.getDate(3));
				r.setAmount(rinfo.getDouble(4));//CHANGE TO DOUBLE
				r.setPurpose(rinfo.getString(5));
				r.setRequestid(rinfo.getInt(6));
				r.setRequesterid(rinfo.getInt(7));
				r.setResolverid(rinfo.getInt(8));
				r.setNote(rinfo.getString(9));
				req.add(r);
			}
			return req;

		} catch (SQLException ex) {
			System.out.println("CAUGHT");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Request> viewAllRequests() {
		ArrayList <Request> req = new ArrayList <Request>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REQUESTS";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet rinfo = ps.executeQuery();
			while(rinfo.next()){
				Request r = new Request();
				r.setStateid(rinfo.getInt(1));
				r.setOpen(rinfo.getDate(2));
				r.setClosed(rinfo.getDate(3));
				r.setAmount(rinfo.getDouble(4));//CHANGE TO DOUBLE
				r.setPurpose(rinfo.getString(5));
				r.setRequestid(rinfo.getInt(6));
				r.setRequesterid(rinfo.getInt(7));
				r.setResolverid(rinfo.getInt(8));
				r.setNote(rinfo.getString(9));
				req.add(r);
			}
			return req;

		} catch (SQLException ex) {
			System.out.println("CAUGHT");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return req;
	}
	

	@Override
	public ArrayList<Request> viewOpenRequestsById(int id) {
		ArrayList <Request> req = new ArrayList <Request>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REQUESTS WHERE REQUESTERID=? AND STATEID=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, 0);

			ResultSet rinfo = ps.executeQuery();
			while(rinfo.next()){
				Request r = new Request();
				r.setStateid(rinfo.getInt(1));
				r.setOpen(rinfo.getDate(2));
				r.setClosed(rinfo.getDate(3));
				r.setAmount(rinfo.getDouble(4));//CHANGE TO DOUBLE
				r.setPurpose(rinfo.getString(5));
				r.setRequestid(rinfo.getInt(6));
				r.setRequesterid(rinfo.getInt(7));
				r.setResolverid(rinfo.getInt(8));
				r.setNote(rinfo.getString(9));
				req.add(r);
			}
			return req;

		} catch (SQLException ex) {
			System.out.println("CAUGHT");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList  <Request> getRequestsById(int id) {
		ArrayList <Request> req = new ArrayList <Request>();
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM REQUESTS WHERE REQUESTERID=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rinfo = ps.executeQuery();
			while(rinfo.next()){
				Request r = new Request();
				r.setStateid(rinfo.getInt(1));
				r.setOpen(rinfo.getDate(2));
				r.setClosed(rinfo.getDate(3));
				r.setAmount(rinfo.getDouble(4));//CHANGE TO DOUBLE
				r.setPurpose(rinfo.getString(5));
				r.setRequestid(rinfo.getInt(6));
				r.setRequesterid(rinfo.getInt(7));
				r.setResolverid(rinfo.getInt(8));
				r.setNote(rinfo.getString(9));
				req.add(r);
			}
			return req;

		} catch (SQLException ex) {
			System.out.println("CAUGHT");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee updateEmployee(String uname, String pw, String fn, String ln, int id) {
		Request r = new Request();
		
		
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE Employee "
					+ "SET USERNAME = ?,"
					+ "PW= ?,"
					+ "FIRSTNAME = ?"
					+ ", LASTNAME =?"
					+ "WHERE EID=?";

			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setInt(5, id);
			int numRows = ps.executeUpdate();

			System.out.println("Number of rows updated: "+numRows);
			return getEmployee(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getEmployee(uname);
	}

	@Override
	public int request(Double amount, String purpose, int requesterid) {
		try(Connection connection = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into requests(Amount, Purpose,Requesterid)VAlues(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, amount);
			ps.setString(2, purpose);
			ps.setInt(3, requesterid);

			int numRows = ps.executeUpdate();

			System.out.println("Number of rows affected: "+numRows);
			return numRows;

		} catch (SQLException e) {
			System.out.println("Caught");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}






}













