package com.kalpa.quiz.data;

import java.util.ArrayList;
import java.util.List;


import com.kalpa.quiz.classes.Users;


public class UserDB 
{
	private List<Users> users= new ArrayList<Users>();
	public UserDB() 
	{
		super();
	}
	
	public void loadUsers()
	{
		System.out.println("Loading all users from UsersDB.....");
		users.add(new Users(1,"Admin", "Harsh", "admin"));
		
		users.add(new Users(2,"Organizer", "Navin", "navin"));
		users.add(new Users(3,"Organizer", "Hyder", "abbas"));
		
		users.add(new Users(4,"Player", "Kalpana", "kalpana"));
		users.add(new Users(5,"Player", "Lakshmi", "lakshmi"));
		users.add(new Users(6,"Player", "Roopa", "roopa"));
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
}
