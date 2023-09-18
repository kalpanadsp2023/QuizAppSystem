package com.kalpa.quiz.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility 
{
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.cj.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection()
	{
		Connection conn = null;
		try 
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalpa_Quiz","root","root");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeResources(Connection conn)
	{
		try 
		{
			if(conn!=null)
				conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
