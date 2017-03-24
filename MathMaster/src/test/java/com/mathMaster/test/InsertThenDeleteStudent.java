package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.model.Student;
import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

/**
 * Insert a student into the database 
 * Afterwards, remove the student from the database
 * Closes all session and facade when complete
 * 
 * @author kevgu
 *
 */
public class InsertThenDeleteStudent {
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

		if (facade.createStudent(new Student(username, password, firstname, lastname, email)))
			System.out.println("Successfully added teacher to the database.");
	}

	@Test
	public void deleteTeacherFromDatabase() {
		if (facade.removeStudent(facade.getStudentByUsername("Student005")))
			System.out.println("Sucessfully deleted student from the database.");
	}

	@AfterClass
	public static void closingAllSession() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in InsertThenDeleteStudent test.");
			e.printStackTrace();
		}
	}
}
