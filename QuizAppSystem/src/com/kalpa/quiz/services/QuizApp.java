
package com.kalpa.quiz.services;

import java.sql.Connection;

import com.kalpa.quiz.data.JDBCUtility;

public class QuizApp 
{
	public static void main(String[] args) 
	{
		Connection conn = JDBCUtility.getDBConnection();
		
		QuizAppLaunch qaLaunch = new QuizAppLaunch(conn);
		qaLaunch.start();
		
		JDBCUtility.closeResources(conn);
	}

}
