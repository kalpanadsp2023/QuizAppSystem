package com.kalpa.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlQueries 
{
	private PreparedStatement stmt;

	public MySqlQueries(PreparedStatement stmt)
	{
		super();
		this.stmt = stmt;
	}
	
	public void fetchArithematics() throws SQLException
	{
		ResultSet rs;
		try 
		{
			rs = stmt.executeQuery();
			if(rs != null)
			{
				if(rs.isBeforeFirst())
				{
					
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	
}
