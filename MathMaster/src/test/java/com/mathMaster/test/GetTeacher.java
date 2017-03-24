package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

/**
 * Get a teacher back from the database using
 * any fields that are available in the teacher bean
 * Closes all session and facade when complete
 * 
 * @author kevgu
 *
 */
public class GetTeacher {
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
	public void getATeacher() {		
		System.out.println(facade.getTeacherByUserName("Code_Blooded_KG"));
	}

	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in GetTeacher test.");
			e.printStackTrace();
		}
	}
}
