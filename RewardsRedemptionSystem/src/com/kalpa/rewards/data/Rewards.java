package com.kalpa.rewards.data;

import com.kalpa.rewards.classes.RewardsInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Rewards 
{
	Map<RewardsInfo, Integer> rwSet = new HashMap<>();
	Map<Integer, String> rwCat = new HashMap<>();
	Map<Integer, String> rwSub = new HashMap<>();
	
	public Map<RewardsInfo, Integer> getRwSet() {
		return rwSet;
	}
	@Override
	public int hashCode() {
		return Objects.hash(rwSet);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rewards other = (Rewards) obj;
		return Objects.equals(rwSet, other.rwSet);
	}


	public Map<Integer, String> getRwCat() {
		return rwCat;
	}
	public void setRwCat(Map<Integer, String> rwCat) {
		this.rwCat = rwCat;
	}
	public Map<Integer, String> getRwSub() {
		return rwSub;
	}
	public void setRwSub(Map<Integer, String> rwSub) {
		this.rwSub = rwSub;
	}
	public Rewards() 
	{
		super();
		
		rwSet.put(new RewardsInfo(1,101), 10000);
		rwSet.put(new RewardsInfo(1,102), 1000);
		rwSet.put(new RewardsInfo(1,103), 100);
		rwSet.put(new RewardsInfo(1,104), 10);
		rwSet.put(new RewardsInfo(2,201), 10000);
		rwSet.put(new RewardsInfo(2,202), 8000);
		rwSet.put(new RewardsInfo(2,203), 5000);
		rwSet.put(new RewardsInfo(2,204), 10);
		rwSet.put(new RewardsInfo(3,301), 1000);
		rwSet.put(new RewardsInfo(3,302), 500);
		rwSet.put(new RewardsInfo(3,303), 200);
		
		rwCat.put(1, "Electronics");
		rwSub.put(101, "PhoneCoupon(10000pts) - Coupon worth $100 for buying a phone.");
		rwSub.put(102, "HeadPhones(1000pts) - Coupon worth $50 for buying headphones.");
		rwSub.put(103, "Recharge(100pts) - Data recharge Coupon worth $25.");
		rwSub.put(104, "Sim(10pts) - New SIM");
		
		rwCat.put(2, "Travels");
		rwSub.put(201, "1000 miles(10000pts) - Coupon worth to travel 1000 miles by air.");
		rwSub.put(202, "800 miles(8000pts) - Coupon worth to travel 800 miles by metro.");
		rwSub.put(203, "500 miles(5000pts) - Coupon worth to travel 500 miles by bus.");
		rwSub.put(204, "2 days local pass(10pts)");
		
		rwCat.put(3, "Gift Card");
		rwSub.put(301, "Amazon50(1000pts) - Coupon worth $50.");
		rwSub.put(302, "Amazon20(500pts) - Coupon worth $20.");
		rwSub.put(303, "Amazon10(200pts) - Coupon worth $10.");
	}

	public void printRewardsCtg() 
	{
		for(Map.Entry<Integer, String> ctg : rwCat.entrySet())
		{
			System.out.println(ctg.getKey() + " : " + ctg.getValue());
		}
	}
	
	public void printRewardsSubCtg(Integer i)
	{
		for(Map.Entry<Integer, String> subCtg : rwSub.entrySet())
		{
			if(subCtg.getKey()/100 == i.intValue())
			{
				System.out.println(subCtg.getKey()+" : "+subCtg.getValue());
			}
		}
	}
	@Override
	public String toString() {
		return "Rewards : " + rwSet;
	}

}
