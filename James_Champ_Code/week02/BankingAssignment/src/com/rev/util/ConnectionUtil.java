package com.rev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Add comments.
public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "bank";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, userName, password);
	}
}