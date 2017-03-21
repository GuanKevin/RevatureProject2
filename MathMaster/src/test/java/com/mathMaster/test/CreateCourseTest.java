package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.util.M2SessionFactory;

public class CreateCourseTest {

	@Test
	public void createCourse(){
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		CourseDAOImpl dao = new CourseDAOImpl(session);
		TeacherDAOImpl tDao = new TeacherDAOImpl();
		//dao.createCourse(course)
	}
}

