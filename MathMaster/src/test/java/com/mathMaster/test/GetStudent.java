package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

/**
 * Get a student back from the database using any 
 * fields that are available in the student bean
 * Closes all session and facade when complete
 * 
 * @author kevgu
 *
 */
public class GetStudent {
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
	public void getAStudent() {
		System.out.println(facade.getStudentByUsername("Student004"));
	}

	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();

		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in GetStudent test.");
			e.printStackTrace();
		}
	}
}
