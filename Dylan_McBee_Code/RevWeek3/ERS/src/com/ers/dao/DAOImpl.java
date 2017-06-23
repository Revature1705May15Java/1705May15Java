package com.ers.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.ers.pojos.Employee;
import com.ers.pojos.Request;
import com.ers.pojos.StateType;
import com.ers.util.ConnectionFactory;

public class DAOImpl implements DAO {

	Employee e = null;

	@Override
	public Employee getEmployee(String email) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			e = new Employee();
			String sql = "select * from employee where email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			// id, email, password, fn, ln, isManager
			while (rs.next()) {
				e.setId(rs.getInt(1));
				e.setEmail(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setFirstName(rs.getString(4));
				e.setLastName(rs.getString(5));
				e.setIsManager(rs.getInt(6));
			}
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {

			String sql = "select * from employee";
			PreparedStatement ps = connection.prepareStatement(sql);

			ResultSet info = ps.executeQuery();

			// id email password fn ln ismanager
			while (info.next()) {
				Employee e = new Employee();
				e.setId(info.getInt(1));
				e.setEmail(info.getString(2));
				e.setPassword(info.getString(3));
				e.setFirstName(info.getString(4));
				e.setLastName(info.getString(5));
				e.setIsManager(info.getInt(6));
				employees.add(e);
			}
			return employees;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Request submitRequest(double amount, String purpose, int requestorId) {
		Request r = new Request();
		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			connection.setAutoCommit(false);
			// Savepoint
			Savepoint s = connection.setSavepoint();

			String sql = "insert into requests(amount, purpose, requestor_id) values(?,?,?)";
			String generatedColumns[] = { "request_id" };
			PreparedStatement ps = connection.prepareStatement(sql, generatedColumns);
			ps.setDouble(1, amount);
			ps.setString(2, purpose);
			ps.setInt(3, requestorId);
			int num = ps.executeUpdate();
			if (num == 1) {
				ResultSet info = ps.getGeneratedKeys();
				if (info.next()) {
					int requestId = info.getInt(1);
					r = getRequestById(requestId);
				}
				System.out.println(num + " row inserted");
			} else {
				System.out.println("error");
				connection.rollback(s);
			}
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Request getRequestById(int id) {
		Request r = new Request();
		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			String sql = "select * from requests where REQUEST_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();

			while (info.next()) {
				r.setRequestId(info.getInt(1));
				int num = info.getInt(2);
				StateType type;
				if (num == 1) {
					type = StateType.PENDING;
				} else if (num == 2) {
					type = StateType.ACCEPTED;
				} else {
					type = StateType.DENIED;
				}
				r.setType(type);
				r.setAmount(info.getDouble(3));
				r.setPurpose(info.getString(4));
				r.setDateRequested(info.getDate(5).toLocalDate());
				r.setRequestorId(info.getInt(6));
				if (info.getDate(7) != null) {
					r.setDateResolved(info.getDate(7).toLocalDate());
				} else {
					r.setDateResolved(null);
				}

				r.setResolverId(info.getInt(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR!");
		}

		return r;
	}

	@Override
	public boolean updateEmployee(int id, String email, String fn, String ln) {
		boolean updated = false;
		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			String sql = "UPDATE EMPLOYEE SET EMAIL = ?, FIRST_NAME = ?, LAST_NAME = ? WHERE EMPLOYEE_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, fn);
			ps.setString(3, ln);
			ps.setInt(4, id);
			int row = ps.executeUpdate();
			if (row == 1) {
				updated = true;
				return updated;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updated;
	}

	@Override
	public ArrayList<Request> getAllRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * from REQUESTS";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Request request = new Request();
				request.setRequestId(rs.getInt(1));
				int state = rs.getInt(2);
				if (state == 1) {
					request.setType(StateType.PENDING);
				} else if (state == 2) {
					request.setType(StateType.ACCEPTED);

				} else {
					request.setType(StateType.DENIED);
				}
				request.setAmount(rs.getDouble(3));
				request.setPurpose(rs.getString(4));
				request.setDateRequested(rs.getDate(5).toLocalDate());
				request.setRequestorId(rs.getInt(6));
				if (rs.getDate(7) != null) {
					request.setDateResolved(rs.getDate(7).toLocalDate());
				} else {
					request.setDateResolved(null);
				}
				request.setResolverId(rs.getInt(8));
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			e = new Employee();
			String sql = "select * from employee where EMPLOYEE_ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			// id, email, password, fn, ln, isManager
			while (rs.next()) {
				e.setId(rs.getInt(1));
				e.setEmail(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setFirstName(rs.getString(4));
				e.setLastName(rs.getString(5));
				e.setIsManager(rs.getInt(6));
			}
			return e;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ArrayList<Request> getPendingRequests() {
		ArrayList<Request> requests = new ArrayList<Request>();

		try (Connection connection = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * from REQUESTS WHERE STATE_ID = 1";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Request request = new Request();
				request.setRequestId(rs.getInt(1));
				int state = rs.getInt(2);
				request.setType(StateType.PENDING);
				request.setAmount(rs.getDouble(3));
				request.setPurpose(rs.getString(4));
				request.setDateRequested(rs.getDate(5).toLocalDate());
				request.setRequestorId(rs.getInt(6));
				if (rs.getDate(7) != null) {
					request.setDateResolved(rs.getDate(7).toLocalDate());
				} else {
					request.setDateResolved(null);
				}
				request.setResolverId(rs.getInt(8));
				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean resolveRequest(int requestId, int stateId, int resolverId) {
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			 String sql = "{call resolve_request(?, ?, ?)}";
			 CallableStatement cs = connect.prepareCall(sql);
			 cs.setInt(1, requestId);
			 cs.setInt(2,stateId);
			 cs.setInt(3,resolverId);
			 int num = cs.executeUpdate();
			 if(num == 1){
				 return true;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public ArrayList<Request> getEmployeeRequests(int empId) {
		ArrayList<Request> requests = new ArrayList<Request>();
		
		// Creates a connection to the database
		try (Connection connect = ConnectionFactory.getInstance().getConnection();) {
			// SQL query for getting all of the employee's requests
			String sql = "SELECT * FROM Requests WHERE requestor_id = ?";
			
			// Creates a PreparedStatement object for sending the SQL statement to the database
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, empId);
			
			// Results from the SQL query
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				Request request = new Request();
				request.setRequestId(info.getInt(1));
				int state = info.getInt(2);
				if (state == 1)
					request.setType(StateType.PENDING);
				else if (state == 2)
					request.setType(StateType.ACCEPTED);
				else
					request.setType(StateType.DENIED);
				request.setAmount(info.getDouble(3));
				request.setPurpose(info.getString(4));
				request.setDateRequested(info.getDate(5).toLocalDate());
				request.setRequestorId(info.getInt(6));
				if (info.getDate(7) != null)
					request.setDateResolved(info.getDate(7).toLocalDate());
				else
					request.setDateResolved(null);
				request.setResolverId(info.getInt(8));

				requests.add(request);
			}
			return requests;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
