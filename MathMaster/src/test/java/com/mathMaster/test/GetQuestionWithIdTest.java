package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.QuestionDAOImpl;
import com.mathMaster.model.Question;
import com.mathMaster.util.M2SessionFactory;

public class GetQuestionWithIdTest {

	@Test
	public void test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		System.out.println(new QuestionDAOImpl(session).getQuestionByQuestionId(1));
	}

}
