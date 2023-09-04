package com.kalpa.quiz.services;

import com.kalpa.quiz.data.RolesDB;
import com.kalpa.quiz.services.QuestionsSer;
import com.kalpa.quiz.data.UserDB;
import com.kalpa.quiz.data.QuestionsDB;
import com.kalpa.quiz.data.ResultsDB;

import java.util.Scanner;

public class QuizAppLaunch 
{
	private Scanner scan;
	private RolesDB rdb;
	private RolesSer rs;
	private UserDB udb;
	private UserSer us;
	private QuestionsDB qdb;
	private QuestionsSer qs;
	private ResultsDB rsdb;
		
	public void start() 
	{
		scan = new Scanner(System.in);
		rdb = new RolesDB();
		rs = new RolesSer(rdb,scan);
		udb = new UserDB();
		us = new UserSer(udb,scan);
		qdb = new QuestionsDB();
		rsdb = new ResultsDB();
		qs = new QuestionsSer(qdb, rsdb, udb, us, scan);
		
		rdb.loadRoles();
		udb.loadUsers();
		qdb.loadQuestions();
		
		welcomeMsg();
		rs.chooseRole();
		System.out.println("------------------------------------------------------------------------------------");
		String rSelected = rdb.getRoles().get(rs.getrID() - 1).getRole();
		
		us.login(udb, rSelected);
		System.out.println("------------------------------------------------------------------------------------");
		rs.chooseOp();
		rs.executeOp(rSelected, rs, us, qs);
	}
	
	public void welcomeMsg()
	{
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println(" 				Welcome to Telusko Quiz Application."); 
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	
}
