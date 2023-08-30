package com.kalpa.rewards.services;
import com.kalpa.rewards.classes.CustomerDetails;
import com.kalpa.rewards.data.Customers;
import com.kalpa.rewards.data.Rewards;
import com.kalpa.rewards.classes.RewardsInfo;
import java.util.Scanner;

public class Redemption 
{
	private CustomerDetails cust;
	private Customers c;
	private Integer ctg;
	private Integer subCtg;
	private Rewards rw;

	public Redemption(CustomerDetails cust, Customers c) 
	{
		super();
		this.cust = cust;
		this.c = c;
		rw = new Rewards();
	}
	
	public void executeRedemption()
	{
		Integer cont = 0;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Choose the cateogry :");
			rw.printRewardsCtg();
			ctg = sc.nextInt();
			System.out.println("---------------------------------------------------------------------------------");
			// Validate the category selected
			// Retrieve the sub category list
			System.out.println("Choose the subcateogry :");
			rw.printRewardsSubCtg(ctg);
			subCtg = sc.nextInt();
			System.out.println("---------------------------------------------------------------------------------");
			RewardsInfo ri = new RewardsInfo(ctg, subCtg);
			int pts = 0;
			if(rw.getRwSet().keySet().contains(ri))
			{
				pts = rw.getRwSet().get(ri);
				if(cust.getCust().getPts() > pts)
				{
					String strCoupon = c.reduceCustomerPoints(cust.getCust().getUsrName(), pts);
					System.out.println("Congratulations... use the coupon code " + strCoupon + "and redem the offer.");
					c.addRedemHistory(cust.getCust().getUsrName(), ctg, subCtg, pts, strCoupon, rw);
				}
				else
					System.out.println("Selected redem offer is not available due to insufficient points.");
			}
			else
				System.out.println("Please select from the redem list.");
			System.out.println("Do you want to continue to redem\n\t\t 1 - Yes\n\t\t 0 - No");
			cont = sc.nextInt();
		}while(cont != 0);
		if(sc != null)
			sc.close();
	}
	
}
