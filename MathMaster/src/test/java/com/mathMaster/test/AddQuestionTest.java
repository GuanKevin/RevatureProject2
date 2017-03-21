package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.domain.QuestionDAOImpl;
import com.mathMaster.model.Question;
import com.mathMaster.util.M2SessionFactory;

public class AddQuestionTest {

	@Test
	public void test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		Question question = new Question(new ExamDAOImpl(session).getExamById(5), 1, "question3", "right answer","first wrong answer","second wrong answer","third wrong answer");
		
		System.out.println(new QuestionDAOImpl(session).insertQuestion(question));

		session.close();
		sf.close();
	}

}
