package com.mathMaster.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.model.Question;
import com.mathMaster.util.M2SessionFactory;

public class GetAllQuestionsFromAnExamTest {

	@Test
	public void test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		Set<Question> questions = new ExamDAOImpl(session).getExamById(4).getQuestions();
		
		for(Question q : questions){
			System.out.println(q);
		}	
	}
}
