package com.mathMaster.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.util.M2SessionFactory;

public class AddQuestionTest {

	@Test
	public void test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		new ExamDAOImpl(session).getExamById(4);
		
		session.close();
		sf.close();
	}

}
