package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.util.M2SessionFactory;

/**
 * Get a student from the database
 * 
 * @author kevgu
 *
 */
public class GetStudent {

	@Test
	public void GetAStudentFromTheDatabase() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		StudentDAO student = new StudentDAOImpl(session);
		
		System.out.println(student.getStudentByUsername("Student001"));
		
		session.close();
		sf.close();
	}
}
