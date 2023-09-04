package com.kalpa.quiz.classes;

public class Users 
{
	private int id;
	private String role;
	private String uName;
	private String uPwd;
	
	public Users() 
	{
		super();
	}

	public Users(int id, String role, String uName, String uPwd) 
	{
		super();
		this.id = id;
		this.role = role;
		this.uName = uName;
		this.uPwd = uPwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
