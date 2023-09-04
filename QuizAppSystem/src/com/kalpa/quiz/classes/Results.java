package com.kalpa.quiz.classes;

import java.util.List;
import java.util.ArrayList;

public class Results 
{
	private int totQ;
	private int totC;
	private int totW;
	private int totS;
	private float totSrc;
	//List<AnsGiven, CorrAns>
	private List<String> gvAns = new ArrayList<>();
	private List<Integer> gvQ = new ArrayList<>();
	
	public int getTotQ() {
		return totQ;
	}

	public void setTotQ(int totQ) {
		this.totQ = totQ;
	}

	public int getTotC() {
		return totC;
	}

	public void setTotC(int totC) {
		this.totC = totC;
	}

	public int getTotW() {
		return totW;
	}

	public void setTotW(int totW) {
		this.totW = totW;
	}

	public int getTotS() {
		return totS;
	}

	public void setTotS(int totS) {
		this.totS = totS;
	}

	public float getTotSrc() {
		return totSrc;
	}

	public void setTotSrc(float totSrc) {
		this.totSrc = totSrc;
	}

	public List<String> getGvAns() {
		return gvAns;
	}

	public void setGvAns(List<String> gvAns) {
		this.gvAns = gvAns;
	}

	public List<Integer> getGvQ() {
		return gvQ;
	}

	public void setGvQ(List<Integer> gvQ) {
		this.gvQ = gvQ;
	}

}
