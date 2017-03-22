package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.M2SessionFactory;

/**
 * Instead a teacher into the database Edit any of the variable however you like
 * to add a teacher to the database
 * 
 * @author kevgu
 *
 */
public class InsertThenDeleteTeacher {
	@Test
	public void insertTeacherIntoDatabase() {	
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		TeacherDAO teacher = new TeacherDAOImpl(session);
		
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
		teacher.createTeacher(new Teacher(
				username,
				password,
				firstname,
				lastname,
				email));
		
		session.close();
		sf.close();
	}
}
