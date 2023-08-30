package com.kalpa.rewards.classes;

public class CustomerInfo 
{
	private String usrName;
	private String usrPwd;
	private int pts;
	public CustomerInfo(String usrName, String usrPwd) {
		super();
		this.usrName = usrName;
		this.usrPwd = usrPwd;
		this.pts = 0;
	}
	
	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	public int getPts() {
		return pts;
	}
	public void setPts(int pts) {
		this.pts = pts;
	}

	@Override
	public String toString() {
		return "CustomerInfo :\n\tusrName=" + usrName + "\n\tpts=" + pts;
	}
	
}
