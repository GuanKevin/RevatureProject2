package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

/**
 * Grabs all the students in the specified course
 * Closes all sessions and facade after completion
 * 
 * @authors Pier, kevgu
 *
 */
public class GetExamById {
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
	public void GetAnExamByTheInputId() {
		System.out.println(facade.getCourseById(2).getStudents());
	}
	
	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in GetExamById test.");
			e.printStackTrace();
		}
	}
}
