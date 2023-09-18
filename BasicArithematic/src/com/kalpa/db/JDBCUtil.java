package com.kalpa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil 
{
	static
	{
		//Register the JDBC driver 
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/calcdb";
		String uName = "root";
		String uPwd = "root";
		try 
		{
			return DriverManager.getConnection(url, uName, uPwd);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeResources(ResultSet rs, Statement stmt, Connection conn)throws SQLException
	{
		if(rs != null)
			try 
			{
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		if(stmt != null)
			try 
			{
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		if(conn != null)
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
	}
}
