package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.UTIL.ConnectionUTIL;

public class DAO {
	
	
	
	
	public String getDepartment(int key){
		
		try (Connection connect = ConnectionUTIL.getConnection();){
		
	
	
			String sql = "SELECT * FROM Department WHERE dept_id =  ?";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, key);
			
			ResultSet rs = ps.executeQuery();
			String dept = null;
			while(rs.next()){
			dept =  rs.getString("dept_name");
			}
			rs.close();
			return dept;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}

}
