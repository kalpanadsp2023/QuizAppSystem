package com.kalpa.rewards.classes;

import java.util.HashMap;
import java.util.Map;

public class CustomerDetails 
{
	private CustomerInfo cust;
	private Map<Integer, RedemInfo> rdHist = new HashMap<>();
	public CustomerDetails(CustomerInfo cust) {
		super();
		this.cust = cust;
	}
	public CustomerInfo getCust() {
		return cust;
	}
	public void setCust(CustomerInfo cust) {
		this.cust = cust;
	}
	public Map<Integer, RedemInfo> getRdHist() {
		return rdHist;
	}
	public void setRdHist(Map<Integer, RedemInfo> rdHist) {
		this.rdHist = rdHist;
	}
	@Override
	public String toString() {
		return  cust + "\nRedem History :\n\t" + rdHist;
	}
}
