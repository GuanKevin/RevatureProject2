package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.M2SessionFactory;

/**
 * Insert a teacher into the database 
 * Afterwards, remove the teacher from the database
 * 
 * @author kevgu
 *
 */
public class InsertThenDeleteTeacher {
	private static SessionFactory sf;
	private static Session session;
	private static TeacherDAO teacher;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
		teacher = new TeacherDAOImpl(session);
	}
	
	@Test
	public void insertTeacherIntoDatabase() {	
		/**
		 * Has unique constraint, make sure to change!
		 */
		String username = "Code_Blooded_Test";
		
		/**
		 * JBCrypt hashed password
		 */
		String password = BCrypt.hashpw("welcome1", BCrypt.gensalt(12));
		String firstname = "Jenkin";
		String lastname = "Test";
		
		/**
		 * Has unique constraint, make sure to change!
		 */
		String email = "Code_Blooded_Test@welcome1.com";
		
		if (teacher.createTeacher(new Teacher(
				username,
				password,
				firstname,
				lastname,
				email)))
			System.out.println("Successfully added teacher to the database.");
	}
	
	@Test
	public void deleteTeacherFromDatabase() {
		if (teacher.removeTeacher(teacher.getTeacherByUserName("Code_Blooded_Test")))
			System.out.println("Sucessfully deleted teacher from the database.");
	}
	
	@AfterClass
	public static void closingAllSessions() {
		session.close();
		sf.close();
	}
}
