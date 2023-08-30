package com.kalpa.rewards.classes;
import com.kalpa.rewards.data.Rewards;

public class RedemInfo
{
	private Rewards rw;
	private int rdCat;
	private int rdSub;
	private int rdUsedPts;
	private String rdCoupon;
	public RedemInfo(int rdCat, int rdSub, int rdUsedPts, String rdCoupon, Rewards rw) {
		super();
		this.rdCat = rdCat;
		this.rdSub = rdSub;
		this.rdUsedPts = rdUsedPts;
		this.rdCoupon = rdCoupon;
		this.rw = rw;
	}
	public int getRdCat() {
		return rdCat;
	}
	public void setRdCat(int rdCat) {
		this.rdCat = rdCat;
	}
	public int getRdSub() {
		return rdSub;
	}
	public void setRdSub(int rdSub) {
		this.rdSub = rdSub;
	}
	public int getRdUsedPts() {
		return rdUsedPts;
	}
	public void setRdUsedPts(int rdUsedPts) {
		this.rdUsedPts = rdUsedPts;
	}
	public String getRdCoupon() {
		return rdCoupon;
	}
	public void setRdCoupon(String rdCoupon) {
		this.rdCoupon = rdCoupon;
	}
	@Override
	public String toString() {
		return "\n\tCategory : " + rw.getRwCat().get(rdCat) + "\n\tSubCategory : " + rw.getRwSub().get(rdSub) + "\n\tUsed Points : " + rdUsedPts + "\n\tCoupon code : " + rdCoupon;
	}
}

