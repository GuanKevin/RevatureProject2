package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.util.M2SessionFactory;

public class InsertStudent {


	@Test
	public void insertStudentIntoDabase() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		StudentDAO student = new StudentDAOImpl();
		String username = "Student002";
		
		/**
		 * JBCrypt hashed password
		 */
		String password = BCrypt.hashpw("welcome1", BCrypt.gensalt(12));
		String firstname = "Daniel";
		String lastname = "Liu";
		String email = "passwordIs@welcome1.com";
		student.createStudent(new Student(
				username,
				password,
				firstname,
				lastname,
				email), session);
	}
}
