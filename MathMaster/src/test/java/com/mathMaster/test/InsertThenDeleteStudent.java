package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.model.Student;
import com.mathMaster.util.M2SessionFactory;

/**
 * Insert a student into the database 
 * Afterwards, remove the student from the database
 * 
 * @author kevgu
 *
 */
public class InsertThenDeleteStudent {
	private static SessionFactory sf;
	private static Session session;
	private static StudentDAO student;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
		student = new StudentDAOImpl(session);
	}

	@Test
	public void insertTeacherIntoDatabase() {	
		/**
		 * Has unique constraint, make sure to change!
		 */
		String username = "Student005";
		
		/**
		 * JBCrypt hashed password
		 */
		String password = BCrypt.hashpw("welcome1", BCrypt.gensalt(12));
		String firstname = "Jenkin";
		String lastname = "Test";
		
		/**
		 * Has unique constraint, make sure to change!
		 */
		String email = "Student005@welcome1.com";
		
		if (student.createStudent(new Student(
				username,
				password,
				firstname,
				lastname,
				email)))
			System.out.println("Successfully added teacher to the database.");
	}
	
	@Test
	public void deleteTeacherFromDatabase() {
		if (student.removeStudent(student.getStudentByUsername("Student005")))
			System.out.println("Sucessfully deleted student from the database.");
	}
	
	@AfterClass
	public static void closingAllSessions() {
		session.close();
		sf.close();
	}
}
