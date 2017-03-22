package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.util.M2SessionFactory;

/**
 * Get a teacher back from the database using
 * any fields that are in the teacher bean
 * 
 * @author kevgu
 *
 */
public class GetTeacher {
	private static SessionFactory sf;
	private static Session session;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
	}
	
	@Test
	public void getATeacher() {
		TeacherDAO teacher = new TeacherDAOImpl(session);
		
		System.out.println(teacher.getTeacherByUserName("Code_Blooded_KG"));
	}

	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
	}
}
