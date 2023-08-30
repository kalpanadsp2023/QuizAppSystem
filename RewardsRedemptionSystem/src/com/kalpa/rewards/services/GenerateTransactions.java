package com.kalpa.rewards.services;

import java.util.Random;
import java.util.TimerTask;

import com.kalpa.rewards.data.Customers;

public class GenerateTransactions extends TimerTask
{
	// Random user, random amount transaction is generated and credited to the user account
	private Customers c;
	private int nUsers;
	public GenerateTransactions(Customers c,int nUsers)
	{
		this.c = c;
		this.nUsers = nUsers;
	}
	
	@Override
	public void run() 
	{
		Random rad = new Random();
		int id = rad.nextInt(nUsers);
		int amt = rad.nextInt(10000, 20000);
		c.updateCustomerPoints("User"+id, amt/100);
	}
}
