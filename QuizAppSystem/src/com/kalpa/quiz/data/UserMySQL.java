package com.kalpa.quiz.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kalpa.quiz.classes.Users;

public class UserMySQL implements IUser 
{
	private Connection conn;
	private List<Users> users= new ArrayList<Users>();
	public UserMySQL(Connection conn) 
	{
		super();
		this.conn = conn;
	}
	@Override
	public void loadUsers()
	{
		System.out.println("Loading all users from UsersDB.....");
		ResultSet rs = null;
		PreparedStatement sel_users = null;
		
		try 
		{
			sel_users=conn.prepareStatement("SELECT u_id,u_role,u_name,u_pwd FROM Users");
			rs = sel_users.executeQuery();
			while(rs.next())
			{
				users.add(new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			if(rs!=null)
				rs.close();
			if(sel_users!=null)
				sel_users.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		/*
		users.add(new Users(1,"Admin", "Harsh", "admin"));
		
		users.add(new Users(2,"Organizer", "Navin", "navin"));
		users.add(new Users(3,"Organizer", "Hyder", "abbas"));
		
		users.add(new Users(4,"Player", "Kalpana", "kalpana"));
		users.add(new Users(5,"Player", "Lakshmi", "lakshmi"));
		users.add(new Users(6,"Player", "Roopa", "roopa"));
		*/
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
