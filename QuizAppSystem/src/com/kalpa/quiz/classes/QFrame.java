package com.kalpa.quiz.classes;

import java.util.List;

public class QFrame
{
	
	private String que;
	private List<String> opts;
	private String ans;
	public QFrame(String que, List<String> opts, String ans) {
		super();
		this.que = que;
		this.opts = opts;
		this.ans = ans;
	}
	public List<String> getOpts() {
		return opts;
	}
	public void setOpts(List<String> opts) {
		this.opts = opts;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
}
