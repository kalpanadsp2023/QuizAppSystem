package com.kalpa.rewards.data;
import com.kalpa.rewards.classes.RedemInfo;

import java.util.Random;
import java.util.HashMap;
import java.util.Map;

import com.kalpa.rewards.classes.CustomerDetails;
import com.kalpa.rewards.classes.CustomerInfo;

public class Customers 
{
	private int nCust;
	Map<String, CustomerDetails> customers = new HashMap<>();
	
	public Customers(int nCust) {
		super();
		this.nCust = nCust;
		loadCustomers();
	}

	public int getnCust() {
		return nCust;
	}

	public void setnCust(int nCust) {
		this.nCust = nCust;
	}

	private void loadCustomers()
	{
		for(int i=0; i<nCust; i++)
		{
			String str = "User"+(i+1);
			CustomerInfo cInfo = new CustomerInfo(str, str.toLowerCase());
			CustomerDetails cDts = new CustomerDetails(cInfo);
			customers.put(str, cDts);
		}
	}
	
	public void printCustomers() 
	{
		System.out.println(customers.entrySet());
	}
	
	public CustomerDetails getCustomerDetails(String user)
	{
		return customers.get(user);
	}
	
	public void updateCustomerPoints(String user, int pts)
	{
		if(customers.containsKey(user))
		{
			CustomerDetails loggedUser = customers.get(user);
			pts = loggedUser.getCust().getPts() + pts;
			loggedUser.getCust().setPts(pts);
			customers.put(user, loggedUser);
		}
		
	}
	
	private String generateCoupon() 
	{
	    int lfLimit = 48; // numeral '0'
	    int rgtLimit = 122; // letter 'z'
	    int strLength = 10;
	    Random random = new Random();

	    String strCoupon = random.ints(lfLimit, rgtLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(strLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return strCoupon;
	}
	
	public String reduceCustomerPoints(String user, int pts)
	{
		String strCoupon = null;
		if(customers.containsKey(user))
		{
			CustomerDetails loggedUser = customers.get(user);
			pts = loggedUser.getCust().getPts() - pts;
			loggedUser.getCust().setPts(pts);
			customers.put(user, loggedUser);
			strCoupon = generateCoupon();
		}
		return strCoupon;
	}
	
	public void addRedemHistory(String user, Integer ctg, Integer subCtg, Integer pts, String strCoupon, Rewards rw)
	{
		if(customers.containsKey(user))
		{
			CustomerDetails loggedUser = customers.get(user);
			
			loggedUser.getRdHist().put(loggedUser.getRdHist().size()+1, 
					new RedemInfo(ctg, subCtg, pts, strCoupon, rw));
		}
	}
}
