package com.bank.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory
{
	private static Boolean build = true;
	private static ConnectionFactory cf = null;
	
	private ConnectionFactory()
	{
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance ()
	{
		if(build = true)
		{
			cf = new ConnectionFactory();
		}
		
		return cf;
	}
	
	public Connection getConnection ()
	{
		Connection conn = null;
		
		try
		{
			Properties prop = new Properties();
			prop.load(new FileReader("C:/Users/Chantel/my_git_repos/1705May15Java/Chantel_Boor_Code/Week3/BankApp/src/com/bank/util/database.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("usr"),prop.getProperty("pwd"));
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}

}
