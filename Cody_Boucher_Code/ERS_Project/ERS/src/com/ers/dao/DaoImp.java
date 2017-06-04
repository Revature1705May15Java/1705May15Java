package com.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ers.pojos.Employee;
import com.ers.util.ConnectionFactory;

public class DaoImp implements DAO{

	@Override
	public Employee getEmployee(String username) {
		Employee emp = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from employee where username = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				emp.setUsername(info.getString(1));
				emp.setPassword(info.getString(2));
				emp.setId(info.getInt(3));
				emp.setFirstName(info.getString(4));
				emp.setLastName(info.getString(5));
				if(info.getInt(6) == 0) {
					emp.setManager(false);
				}
				else {
					emp.setManager(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = new Employee();
		try(Connection connection = ConnectionFactory.getInstance().getConnection()) {
			String sql = "select * from employee where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while (info.next()) {
				emp.setUsername(info.getString(1));
				emp.setPassword(info.getString(2));
				emp.setId(info.getInt(3));
				emp.setFirstName(info.getString(4));
				emp.setLastName(info.getString(5));
				if(info.getInt(6) == 0) {
					emp.setManager(false);
				}
				else {
					emp.setManager(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
