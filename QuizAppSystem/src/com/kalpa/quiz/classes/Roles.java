package com.kalpa.quiz.classes;


public class Roles 
{
	private String role;
	private int id;
	
	public Roles() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int id, String role) 
	{
		super();
		this.role = role;
		this.id = id;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
