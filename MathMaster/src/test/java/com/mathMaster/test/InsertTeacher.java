package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.M2SessionFactory;

public class InsertTeacher {

	@Test
	public void insertTeacher() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		TeacherDAO teacher = new TeacherDAOImpl();
		String username = "Code_Blooded_KG";
		
		/**
		 * JBCrypt hashed password
		 */
		String password = BCrypt.hashpw("welcome1", BCrypt.gensalt(12));
		String firstname = "Kevin";
		String lastname = "Guan";
		String email = "passwordIs@welcome1.com";
		teacher.createTeacher(new Teacher(
				username,
				password,
				firstname,
				lastname,
				email), session);
	}
}
