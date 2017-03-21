package com.mathMaster.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mathMaster.domain.TeacherDAO;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Teacher;

public class Facade implements AutoCloseable {
	private SessionFactory sf = M2SessionFactory.getSessionFactory();
	private Session session = sf.openSession();
	private TeacherDAO teacherDAO;
	private Teacher teacher;
	private boolean user; //true = teacher, false = student
	
	public void login(boolean isTeacher, String username, String password) {
		if (username != null && password != null)
			user = isTeacher;
		else
			System.out.println("Facade login error!");
			
		if (user) {
			teacherDAO = new TeacherDAOImpl(session);
			teacher = teacherDAO.getTeacherByUserName(username);
			if (teacher != null) {
				if (!teacher.getPassword().equals(password)) {
					//TODO Don't allow teacher to login  
				}	
			}
		}
	}
	
	
	public void close() throws Exception {
		sf.close();
		session.close();
	}
}
