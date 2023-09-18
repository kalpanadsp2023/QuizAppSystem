package com.kalpa.quiz.services;

import java.util.ListIterator;
import java.util.Scanner;

import com.kalpa.quiz.classes.Users;
import com.kalpa.quiz.data.IUser;
import com.kalpa.quiz.data.UserDB;
import com.kalpa.quiz.data.UserMySQL;

public class UserSer 
{
	private IUser udb;
	private Scanner scan;
	private String usrName;
	public static final int MAX_TRIES = 3;
	
	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public UserSer(IUser udb, Scanner scan) 
	{
		super();
		this.udb = udb;
		this.scan = scan;
	}

	public void login(IUser udb, String role)
	{
		String uName;
		String uPwd;
		int currTries = 0;
		do 
		{
			System.out.println(role +" login.");
			System.out.println("Please enter user login : ");
			uName = scan.next();
			System.out.println("Please enter password : ");
			uPwd = scan.next();
			if(validateUser(role, uName, uPwd) > 0)
			{
				usrName = uName;
				System.out.println(uName + " succussfully logged in...");
				break;
			}
			else
				currTries++;
		}while(currTries < MAX_TRIES);
		if(currTries == MAX_TRIES)
		{
			System.out.println("You have reached the maximu tries. Application is exiting.....");
			System.exit(0);
		}
	}
	
	public int validateUser(String role, String uName, String uPwd)
	{
		ListIterator<Users> it = ((UserMySQL) udb).getUsers().listIterator();
		int i = 0;
		while(it.hasNext())
		{
			Users u = it.next();
			if(role.equals(u.getRole()) && uName.equals(u.getuName()) && uPwd.equals(u.getuPwd()))
				return u.getId();
			i++;
		}
		return -1;
	}
}
