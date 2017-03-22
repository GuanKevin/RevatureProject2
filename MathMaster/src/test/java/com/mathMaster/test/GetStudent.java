package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.util.M2SessionFactory;

/**
 * Get a student back from the database using
 * any fields that are in the student bean
 * 
 * @author kevgu
 *
 */
public class GetStudent {
	private static SessionFactory sf;
	private static Session session;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
	}
	
	@Test
	public void getAStudent() {
		StudentDAO student = new StudentDAOImpl(session);
		
		System.out.println(student.getStudentByUsername("Student004"));
	}

	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
	}
}
