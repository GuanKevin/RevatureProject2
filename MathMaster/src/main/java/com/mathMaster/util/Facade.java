package com.mathMaster.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import com.mathMaster.domain.StudentDAO;
import com.mathMaster.domain.StudentDAOImpl;
import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Student;
import com.mathMaster.model.Teacher;

public class Facade implements AutoCloseable {
	private SessionFactory sf = M2SessionFactory.getSessionFactory();
	private Session session = sf.openSession();
	private TeacherDAO teacherDAO;
	private Teacher teacher;
	private StudentDAO studentDAO;
	private Student student;
	private boolean user; 		// true = teacher, false = student
	
	/**
	 * isTeacher is a boolean variable that takes in true if the user that is trying
	 * to sign in enter the buttons as a teacher, otherwise, it is false and assumed
	 * that the user that is trying to sign in is a student. The user is then verified
	 * by looking for the username in the teacher or student table in the database
	 * and finally, their hashed password is checked with the password entered.
	 * 
	 * @param isTeacher
	 * @param username
	 * @param password
	 */
	public void login(boolean isTeacher, String username, String password) {
		if (username != null && password != null)
			user = isTeacher;
		else
			// TODO User is missing username or password field and need to fill it
			
		if (user) {
			teacherDAO = new TeacherDAOImpl(session);
			teacher = teacherDAO.getTeacherByUserName(username);
			
			if (teacher != null) {
				if (!BCrypt.checkpw(password, teacher.getPassword())) {
					// Gets in here if password entered does not matches the password
					// found in the database that is related to the username
					// TODO Don't allow teacher to login  
				}	
			}
		}
		else {
			studentDAO = new StudentDAOImpl(session);
			student = studentDAO.getStudentByUsername(username);
			
			if (student != null) {
				if (!BCrypt.checkpw(password, student.getPassword())) {
					// Gets in here if password entered does not matches the password
					// found in the database that is related to the username
					// TODO Don't allow teacher to login  
				}
			}
		}
	}
	
	public Teacher getTeacherByUserName(String username) {
		return this.teacherDAO.getTeacherByUserName(username);
	}
	
	/**
	 * TODO
	 * Figure out where all the sessions and the sessionfactory 
	 * should be called
	 */
	public void close() throws Exception {
		sf.close();
		session.close();
	}
}
