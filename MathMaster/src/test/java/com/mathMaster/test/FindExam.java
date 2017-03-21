package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.util.M2SessionFactory;

public class FindExam {
	
	@Test
	public void Test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		System.out.println(new ExamDAOImpl(session).getExamById(4));
		
		session.close();
		sf.close();
	}
}
