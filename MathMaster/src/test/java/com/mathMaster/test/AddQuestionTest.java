package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

public class AddQuestionTest {

	private static SessionFactory sf;
	private static Session session;
	private static Facade facade;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
		facade = new Facade();
	}
	
	@Test
	public void AddQuestionsToATest() {
		facade.getExamById(4);
	}
	
	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in AddQuestionTest test.");
			e.printStackTrace();
		}
	}
}
