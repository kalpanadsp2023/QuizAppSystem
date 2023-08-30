package com.kalpa.rewards.classes;

import java.util.Objects;

public class RewardsInfo 
{
	private Integer ctg;
	private Integer subCtg;
	
	public int getCtg() {
		return ctg;
	}
	public void setCtg(Integer ctg) {
		this.ctg = ctg;
	}
	public Integer getSubCtg() {
		return subCtg;
	}
	public void setSubCtg(Integer subCtg) {
		this.subCtg = subCtg;
	}
	public RewardsInfo(Integer ctg, Integer subCtg) {
		super();
		this.ctg = ctg;
		this.subCtg = subCtg;
	}
	@Override
	public String toString() {
		return "RewardsInfo [ctg=" + ctg + ", subCtg=" + subCtg + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ctg, subCtg);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RewardsInfo other = (RewardsInfo) obj;
		return Objects.equals(ctg, other.ctg) && Objects.equals(subCtg, other.subCtg);
	}
	
}
