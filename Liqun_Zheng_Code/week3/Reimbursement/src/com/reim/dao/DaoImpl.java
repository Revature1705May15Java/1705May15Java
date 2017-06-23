package com.reim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.reim.util.ConnectionFactory;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

import com.reim.pojos.Employee;
import com.reim.pojos.Request;
import com.reim.pojos.State_type;

public class DaoImpl implements Dao {

	//find requests by an employee id
	@Override
	public ArrayList<Request> findReqByEmpId(int emp_id) {
		 ArrayList<Request> requests = new ArrayList<Request>();
		 Dao dao = new DaoImpl();
		 Request req = new Request();
	        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
	            String sql = " select r.request_id, r.requester_id, r.resolver_id, r.note,r.purpose, " +
	            " r.state_id, r.opened, r.closed, r.amount from request r " +
	            " inner join employee e " +
	            " on e.employee_id = r.requester_id " +
	            " where e.employee_id = ? ";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, emp_id);

	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()) {
	               
	            	req.setRequest_id(rs.getInt(1));
	            	req.setRequester_id(rs.getInt(2));
	        
	                req.setResolver_id(rs.getInt(3));
	                req.setNote(rs.getString(4));
	                req.setPurpose(rs.getString(5));
	                req.setState(dao.findTypeById(rs.getInt(6)));
	                req.setOpened(rs.getDate(7));
	                req.setClosed(rs.getDate(8));
	                req.setAmount(rs.getDouble(9));
	                requests.add(req);
	                req = new Request();
	               
	            }
	    
	            return requests;

	        } catch (SQLException e) {
				// TODO Auto-generated catch block
	        	e.printStackTrace();
	        }

	        return null;
	}

	
	//Find the employee by username
	@Override
	public Employee findEmpByUname(String uname) {
		// TODO Auto-generated method stub
		
		Employee temp = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * from Employee where username = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, uname.toLowerCase());
			
			ResultSet emp = ps.executeQuery();
			//id, fn, ln, pw, uname
			temp = new Employee();
			
			//assigned each variable of an employee to temp
			while(emp.next()){
				temp.setEmployee_id(emp.getInt(1));
				temp.setFn(emp.getString(2));
				temp.setLn(emp.getString(3));
				temp.setUname(emp.getString(4));
				temp.setPw(emp.getString(5));
				temp.setIs_manager(emp.getInt(6));
				
			}
//			if(temp.getUname()!=null){
//			System.out.println("employee: " +temp.toString());
//			}
			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
		
	}

	
	//find state_type by type_id return state_type object
	@Override
	public State_type findTypeById(int type_id) {
		State_type type = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select name from state_type where state_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, type_id);
			ResultSet info = ps.executeQuery();
			//id, fs, ls, state, credit, email
			while(info.next()){
				type = new State_type(type_id, info.getString(1));
			}
			return type;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	
	//add a new request for employee u, pass in add purpose and amount
	@Override
    public Request addRequest(Employee u, String purpose, double amount) {
        Request a = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = " insert into request(requester_id, purpose, amount) "+
            		" values(?, ?, ?) RETURNING request_id INTO ?";

            OraclePreparedStatement ps = (OraclePreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, u.getEmployee_id());
            ps.setString(2, purpose);
            ps.setDouble(3, amount);
            ps.registerReturnParameter(4, OracleTypes.NUMBER);

            int count = ps.executeUpdate();

            if (count > 0) {
                ResultSet rs = ps.getReturnResultSet();


                if (rs.next()) {
                    int newRequestId = rs.getInt(1);


                    a = getRequest(newRequestId);

                }
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

        return a;
    }


	//get request by requestid
	@Override
	public Request getRequest(int requestId) {
		
		
			Request r = null;
			
			try(Connection connect = ConnectionFactory.getInstance().getConnection();){
				String sql = "select * from request r " +
						" inner join state_type s " +
						" on r.state_id = s.STATE_ID " +
						" where r.request_id = ? ";
				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setInt(1, requestId);
				ResultSet info = ps.executeQuery();
				//request_id, requester_id, resolver_id, note, purpose, state_id
				//opened, closed, amount, state_id, name;
				
				if(info.next()){
					r = new Request();
					r.setRequest_id(info.getInt(1));
					r.setRequester_id(info.getInt(2));
					r.setResolver_id(info.getInt(3));
					r.setNote(info.getString(4));
					r.setPurpose(info.getString(5));
					r.setState(new State_type(info.getInt(6),info.getString(11)));
					r.setOpened(info.getDate(7));
					r.setClosed(info.getDate(8));
					r.setAmount(info.getDouble(9));

				}
				
	
				return r;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return r;
		}
	
	
	//update Employee information by employee id, first name, last name, username, and password
	@Override
	public int updateEmployee(int empId, String fname, String lname, String uname, String pw) {
		
		int result = 0;
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "update employee " +
					" set first_name = ?, last_name = ?, " +
					"username = ?, password = ? " +
					" where employee.employee_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, uname.toLowerCase());
			ps.setString(4, pw);
			ps.setInt(5, empId);
			result = ps.executeUpdate();
			//request_id, requester_id, resolver_id, note, purpose, state_id
			//opened, closed, amount, state_id, name;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	
	//get all requests
	@Override
	public ArrayList<Request> getAllRequests(){
		ArrayList<Request> result = null;
		Request r = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * " +
					" from request " +
					" inner join state_type " +
					" on state_type.state_id = request.state_id " + 
					" inner join employee " +
					" on request.requester_id = employee.EMPLOYEE_ID ";
			PreparedStatement ps = connect.prepareStatement(sql);

			ResultSet info = ps.executeQuery();
			//request_id, requester_id, resolver_id, note, purpose, state_id
			//opened, closed, amount, state_id, name;
			result = new ArrayList<Request>();
			while(info.next()){
				r = new Request();
				r.setRequest_id(info.getInt(1));
				r.setRequester_id(info.getInt(2));
				r.setResolver_id(info.getInt(3));
				r.setNote(info.getString(4));
				r.setPurpose(info.getString(5));
				r.setState(new State_type(info.getInt(6),info.getString(11)));
				r.setOpened(info.getDate(7));
				r.setClosed(info.getDate(8));
				r.setAmount(info.getDouble(9));
				r.setRequester_name(info.getString(13) + " " + info.getString(14));
				result.add(r);
				
			}
			
			if(!result.isEmpty()){
				return result;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
	
	//get all Employees
	@Override
	public ArrayList<Employee> getAllEmployee(int isEmployee){
		ArrayList<Employee> result = null;
		Employee emp = null;
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * " +
						" from Employee " +
						" where EMPLOYEE.IS_MANAGER = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, isEmployee);
			ResultSet info = ps.executeQuery();
			//request_id, requester_id, resolver_id, note, purpose, state_id
			//opened, closed, amount, state_id, name;
			result = new ArrayList<Employee>();
			while(info.next()){
				emp = new Employee();
				emp.setEmployee_id(info.getInt(1));
				emp.setFn(info.getString(2));
				emp.setLn(info.getString(3));

				result.add(emp);
				
			}
			
			if(!result.isEmpty()){
				return result;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
	
	//approve request
	@Override
	public Request appDenReq(Employee emp, int r_id, State_type state, String note){
		Request result= null;
		Dao dao = new DaoImpl();
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "update request "+
					" set request.state_id = ?, request.closed = current_date, "+
					"  request.NOTE=?, request.RESOLVER_ID=?" +
					" where request.request_id = ? ";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, state.getState_id());
			ps.setString(2, note);
			ps.setInt(3, emp.getEmployee_id());
			ps.setInt(4, r_id);
			int affect = ps.executeUpdate();
			if(affect == 1){
				result = dao.getRequest(r_id);
				return result;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	// find state_type using state name;
	@Override
	public State_type findState(String state){
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "select * " +
					" from state_type " +
					" where state_type.name = ? ";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, state);
			ResultSet info = ps.executeQuery();
			if(info.next()){
				State_type s = new State_type(
				info.getInt(1), info.getString(2));
				
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public int addEmployee(String fname, String lname, String uname, String pw, int isManager) {
		
		int result = 0;
		
		try(Connection connect = ConnectionFactory.getInstance().getConnection();){
			String sql = "insert into employee(first_name, last_name, username, password, is_manager) "+
					" values(?, ?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, uname.toLowerCase());
			ps.setString(4, pw);
			ps.setInt(5, isManager);
			result = ps.executeUpdate();
			//result = 1 add success, 0 fail.
			if(result ==1){
				return result;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}