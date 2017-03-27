package com.mathMaster.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.model.Question;
import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

public class GetAllExamQuestions {
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
	public void Test() {		
		Set<Question> list = facade.getExamById(4).getQuestions();
		
		for(Question q: list)
			System.out.println(q);
	}
	
	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in GetAllExamQuestion test.");
			e.printStackTrace();
		}
	}
}
