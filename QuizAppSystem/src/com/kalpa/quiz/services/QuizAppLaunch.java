package com.kalpa.quiz.services;

import com.kalpa.quiz.data.RolesDB;
import com.kalpa.quiz.data.RolesMySQL;
import com.kalpa.quiz.services.QuestionsSer;
import com.kalpa.quiz.data.UserDB;
import com.kalpa.quiz.data.UserMySQL;
import com.kalpa.quiz.data.IQuestions;
import com.kalpa.quiz.data.IRoles;
import com.kalpa.quiz.data.IUser;
import com.kalpa.quiz.data.QuestionsMySQL;
import com.kalpa.quiz.data.ResultsDB;

import java.sql.Connection;
import java.util.Scanner;

public class QuizAppLaunch 
{
	private Connection conn;
	
	public QuizAppLaunch(Connection conn) 
	{
		super();
		this.conn = conn;
	}

	private Scanner scan;
	private RolesSer rs;
	private UserSer us;
	private QuestionsSer qs;
	
	private ResultsDB rsdb;
	private IRoles rdb;
	private IQuestions qdb;
	private IUser udb;
		
	public void start() 
	{
		scan = new Scanner(System.in);
		//rdb = new RolesDB();
		rdb = new RolesMySQL(conn);
		rs = new RolesSer(rdb,scan);
		//udb = new UserDB();
		udb = new UserMySQL(conn);
		us = new UserSer(udb,scan);
		//qdb = new QuestionsDB();
		qdb = new QuestionsMySQL(conn);
		rsdb = new ResultsDB();
		qs = new QuestionsSer(qdb, rsdb, udb, us, scan);
		
		rdb.loadRoles();
		udb.loadUsers();
		qdb.loadQuestions();
		
		welcomeMsg();
		rs.chooseRole();
		System.out.println("------------------------------------------------------------------------------------");
		String rSelected = ((RolesMySQL) rdb).getRoles().get(rs.getrID() - 1).getRole();
		
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
