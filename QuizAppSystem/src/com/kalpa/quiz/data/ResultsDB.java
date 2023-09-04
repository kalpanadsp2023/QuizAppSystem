package com.kalpa.quiz.data;

import java.util.List;

import com.kalpa.quiz.classes.Results;

public class ResultsDB 
{
	private Results res;

	public ResultsDB() 
	{
		super();
		res = new Results();
	}
	
	public void setTotQuesAttempted(int totQ)
	{
		res.setTotQ(totQ);
	}
	
	public void setTotCorr(int totC)
	{
		res.setTotC(totC);
	}
	
	public void setTotWrg(int totW)
	{
		res.setTotW(totW);
	}
	
	public void setTotSkp(int totS)
	{
		res.setTotS(totS);
	}
	
	public void setGvAns(String gvAns)
	{
		res.getGvAns().add(gvAns);
	}
	
	public void setGvQ(int gvQ)
	{
		res.getGvQ().add(gvQ);
	}
	
	public void setScore(float fSrc)
	{
		res.setTotSrc(fSrc);
	}
	
	public int getTotQuesAttempted()
	{
		return res.getTotQ();
	}
	
	public int getTotCorr()
	{
		return res.getTotC();
	}
	
	public int getTotWrg()
	{
		return res.getTotW();
	}
	
	public int getTotSkp()
	{
		return res.getTotS();
	}
	
	public List<String> getGvAns()
	{
		return res.getGvAns();
	}
	
	public List<Integer> getGvQ()
	{
		return res.getGvQ();
	}
	
	public float getScore()
	{
		return res.getTotSrc();
	}
}
