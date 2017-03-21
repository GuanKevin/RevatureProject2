package com.mathMaster.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.util.M2SessionFactory;

public class GetStudentByCourse {
	@Test
	public void getStudent(){
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		CourseDAOImpl cDao = new CourseDAOImpl(session);
		Course c = cDao.getCourseById(2);
		System.out.println(c.getStudents());

	}
}
