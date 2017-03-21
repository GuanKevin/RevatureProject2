package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.model.Student;
import com.mathMaster.util.M2SessionFactory;

/**
 * Instead a student into the database
 * Edit any of the variable however you like
 * to add a student to the database
 * 
 * @author kevgu
 *
 */
public class InsertStudent {


	@Test
	public void insertStudentIntoDabase() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		StudentDAO student = new StudentDAOImpl(session);
		
		/**
		 * Has unique constraint, make sure to change
		 */
		String username = "Student004";
		
		/**
		 * JBCrypt hashed password
		 */
		String password = BCrypt.hashpw("welcome1", BCrypt.gensalt(12));
		String firstname = "Denise";
		String lastname = "Montesdeoca";
		
		/**
		 * Has unique constraint, make sure to change
		 */
		String email = "Student004@welcome1.com";
		student.createStudent(new Student(
				username,
				password,
				firstname,
				lastname,
				email));
		
		session.close();
		sf.close();
	}
}
