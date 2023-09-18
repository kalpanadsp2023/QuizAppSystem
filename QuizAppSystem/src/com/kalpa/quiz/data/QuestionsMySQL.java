package com.kalpa.quiz.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.kalpa.quiz.classes.Complexity;
import com.kalpa.quiz.classes.Language;
import com.kalpa.quiz.classes.QFrame;
import com.kalpa.quiz.classes.QUnique;

public class QuestionsMySQL implements IQuestions
{
	private Connection conn;
	Map<QUnique, QFrame> q = new LinkedHashMap<>();

	public QuestionsMySQL(Connection conn) 
	{
		super();
		this.conn = conn;
	}

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
		for (Language lang : Language.values()) 
		{ 
			loadLangSpecQuestions(lang); 
		}
	}
	
	private void loadLangSpecQuestions(Language lang)
	{
		for (Complexity cmpx : Complexity.values()) 
		{ 
			loadCmpxSpecQuestion(lang, cmpx); 
		}
	}
	
	private void loadCmpxSpecQuestion(Language lang, Complexity cmpx)
	{
		ResultSet rs = null;
		PreparedStatement sel_lang_cmpx = null;
		
		try 
		{
			sel_lang_cmpx=conn.prepareStatement("SELECT q_id,q_que,q_op1,q_op2,q_op3,q_op4,q_ans FROM Questions "
					+ "WHERE q_lang=? AND q_cmpx=? ORDER BY q_id");
			sel_lang_cmpx.setString(1, lang.toString());
			sel_lang_cmpx.setString(2, cmpx.toString());
			rs = sel_lang_cmpx.executeQuery();
			while(rs.next())
			{
				q.put(new QUnique(rs.getInt(1),lang,cmpx), 
						new QFrame(rs.getString(2), new ArrayList<String>
						(Arrays.asList(rs.getString(3),rs.getString(4),
								rs.getString(5),rs.getString(6))), rs.getString(7)));
			}
			if(rs!=null)
				rs.close();
			if(sel_lang_cmpx!=null)
				sel_lang_cmpx.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
