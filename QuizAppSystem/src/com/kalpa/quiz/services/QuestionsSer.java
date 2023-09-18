package com.kalpa.quiz.services;

import com.kalpa.quiz.data.IQuestions;
import com.kalpa.quiz.data.IUser;
import com.kalpa.quiz.data.QuestionsMySQL;
import com.kalpa.quiz.data.ResultsDB;
import com.kalpa.quiz.data.UserDB;
import java.util.Map;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.kalpa.quiz.classes.QUnique;
import com.kalpa.quiz.classes.QFrame;
import com.kalpa.quiz.classes.Language;
import com.kalpa.quiz.classes.Complexity;

public class QuestionsSer 
{
	private IQuestions qdb;
	private ResultsDB rsdb;
	private IUser udb;
	private UserSer us;
	private Scanner scan;
	private Language l;
	private Complexity c;
	public QuestionsSer(IQuestions qdb, ResultsDB rsdb, IUser udb, UserSer us, Scanner scan) {
		super();
		this.qdb = qdb;
		this.rsdb = rsdb;
		this.udb = udb;
		this.us  = us;
		this.scan = scan;
	}
	public void startQuiz()
	{
		System.out.println("Please select the language : ");
		Language.listLanguages();
		l = Language.values()[Integer.parseInt(scan.next()) - 1];
		System.out.println("Please select the complexity : ");
		Complexity.listComplexity();
		c = Complexity.values()[Integer.parseInt(scan.next()) - 1];
		startQuestions();
	}
	
	public void startQuestions()
	{
		Map<QUnique, QFrame> mq = (LinkedHashMap)((QuestionsMySQL) qdb).getQ();
		int qNum = 0;
		int iSkp = 0;
		int iCorr = 0;
		int iWrg = 0;
		for(Entry<QUnique, QFrame> e:mq.entrySet())
		{
			if(l.equals(e.getKey().getLg()) &&
					c.equals(e.getKey().getCp()))
			{
				rsdb.setGvQ(e.getKey().getqID());
				qNum++;
				System.out.println("------------------------------------------------------------------------------------");
				System.out.println(qNum + ". "+e.getValue().getQue());
				List<String> it = e.getValue().getOpts();
				for(int i=0; i < it.size(); i++)
				{
					char ch = (char)(i+97);
					System.out.println(ch+". "+it.get(i));
				}
				System.out.println("Want to skip : s");
				System.out.println("Please enter your answer from the choices : ");
				String s = scan.next();
				char ch = s.charAt(0);
				int iAns = (int)ch;
				iAns = iAns - 97;
				if(iAns == (115-97))
				{
					rsdb.setGvAns("Skip");
					rsdb.setTotSkp(++iSkp);
					System.out.println("You selected to skip this question...");
				}
				else
				{
					if(iAns >= 0 && iAns < e.getValue().getOpts().size())
					{
						rsdb.setGvAns(e.getValue().getOpts().get(iAns));
						if(e.getValue().getAns().equals(e.getValue().getOpts().get(iAns)))
							rsdb.setTotCorr(++iCorr);
						else
							rsdb.setTotWrg(++iWrg);
					}
					else
					{
						rsdb.setGvAns("Invalid choice.");
						rsdb.setTotWrg(++iWrg);
					}
				}
				rsdb.setTotQuesAttempted(qNum);
			}
		}
		if(qNum != 0)
		{
			calScore();
			displayResults();
		}
		else
		{
			System.out.println("Sorry...No questions in Quiz App for "+
					l.toString()+" language with "+c.toString()+
					" complexity.Please revisit once the Organizer adds them.");
		}
	}
	public void calScore()
	{
		rsdb.setScore((float)((1*rsdb.getTotCorr())-(0.25*rsdb.getTotWrg())));
	}
	public void displayResults()
	{
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("                                    SCORE CARD");
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("                              Name       : "+us.getUsrName());
		System.out.println("                              Language   : "+l);
		System.out.println("                              Complexity : "+c);
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------");
		displayKey();
		displayScores();
	}
	public void displayKey()
	{
		for(int i=0; i<rsdb.getTotQuesAttempted(); i++)
		{
			Map<QUnique, QFrame> m = ((QuestionsMySQL) qdb).getQ();
			QFrame e = m.get(new QUnique((i+1),l,c));
			System.out.println((i+1)+". "+e.getQue()+"\n\t\tCorrect Ans :"+e.getAns()+"\n\t\tGiven Ans   :"+rsdb.getGvAns().get(i));
		}
	}
	
	public void displayScores()
	{
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("Total no: of questions attempted           :"+rsdb.getTotQuesAttempted());
		System.out.println("Total no: of questions with correct answer :"+rsdb.getTotCorr());
		System.out.println("Total no: of questions skipped             :"+rsdb.getTotSkp());
		System.out.println("Total no: of questions with wrong answer   :"+rsdb.getTotWrg());
		System.out.println("Final score                                :"+rsdb.getScore());
		System.out.println("------------------------------------------------------------------------------------");
	}

}


