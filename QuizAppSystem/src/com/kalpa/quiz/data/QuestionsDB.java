package com.kalpa.quiz.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.kalpa.quiz.classes.QFrame;
import com.kalpa.quiz.classes.QUnique;
import com.kalpa.quiz.classes.Language;
import com.kalpa.quiz.classes.Complexity;


public class QuestionsDB implements IQuestions
{
	Map<QUnique, QFrame> q = new LinkedHashMap<>();

	public Map<QUnique, QFrame> getQ() {
		return q;
	}

	public void setQ(Map<QUnique, QFrame> q) {
		this.q = q;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(q);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionsDB other = (QuestionsDB) obj;
		return Objects.equals(q, other.q);
	}

	public void loadQuestions()
	{
		System.out.println("Loading all questions from QuestionsDB.....");
		q.put(new QUnique(1,Language.C,Complexity.EASY), 
				new QFrame("C was invented by : ", 
						new ArrayList<String>(Arrays.asList("Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg")), 
						"Dennis M. Ritchie"));
		q.put(new QUnique(2,Language.C,Complexity.EASY), 
				new QFrame("In which year C was developed? : ", 
						new ArrayList<String>(Arrays.asList("1962","1978","1979","1972")), "1972"));
		q.put(new QUnique(3,Language.C,Complexity.EASY), 
				new QFrame("C language is a successor to which language? : ", 
						new ArrayList<String>(Arrays.asList("Basic","Cobal","CPP","B")), "B"));
		
		q.put(new QUnique(1,Language.C,Complexity.MEDIUM), 
				new QFrame("In which year C was developed? : ", 
						new ArrayList<String>(Arrays.asList("1962","1978","1979","1972")), "1972"));
		q.put(new QUnique(2,Language.C,Complexity.MEDIUM), 
				new QFrame("C language is a successor to which language? : ", 
						new ArrayList<String>(Arrays.asList("Basic","Cobal","CPP","B")), "B"));
		q.put(new QUnique(3,Language.C,Complexity.MEDIUM), 
				new QFrame("C was invented by : ", 
						new ArrayList<String>(Arrays.asList("Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg")), 
						"Dennis M. Ritchie"));
		
		q.put(new QUnique(1,Language.C,Complexity.HARD), 
				new QFrame("C language is a successor to which language? : ", 
						new ArrayList<String>(Arrays.asList("Basic","Cobal","CPP","B")), "B"));
		q.put(new QUnique(2,Language.C,Complexity.HARD), 
				new QFrame("C was invented by : ", 
						new ArrayList<String>(Arrays.asList("Dennis Rechard","Dennis M. Ritchie","Bjarne Stroustrup","Anders Hejlsberg")), 
						"Dennis M. Ritchie"));
		q.put(new QUnique(3,Language.C,Complexity.HARD), 
				new QFrame("In which year C was developed? : ", 
						new ArrayList<String>(Arrays.asList("1962","1978","1979","1972")), "1972"));
		
		q.put(new QUnique(1,Language.JAVA,Complexity.EASY), 
				new QFrame("JDK stands for ____. : ", 
						new ArrayList<String>(Arrays.asList("Java Development kit","Java Deployment kit","Java Script deployment kit","None")), 
						"Java Development kit"));
		
		q.put(new QUnique(1,Language.JAVA,Complexity.MEDIUM), 
				new QFrame("JDK stands for ____. : ", 
						new ArrayList<String>(Arrays.asList("Java Development kit","Java Deployment kit","Java Script deployment kit","None")), 
						"Java Development kit"));
		
		q.put(new QUnique(1,Language.JAVA,Complexity.HARD), 
				new QFrame("JDK stands for ____. : ", 
						new ArrayList<String>(Arrays.asList("Java Development kit","Java Deployment kit","Java Script deployment kit","None")), 
						"Java Development kit"));
		
		
		
	}
}
