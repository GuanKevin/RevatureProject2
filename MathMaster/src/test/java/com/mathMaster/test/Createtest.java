package com.mathMaster.test;

import org.junit.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mathMaster.domain.CourseDAO;
import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.ExamDAO;
import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.model.Exam;
import com.mathMaster.util.M2SessionFactory;

public class Createtest {

	@Test
	public void createTest() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		CourseDAO courseDao = new CourseDAOImpl(session);
		Course course = courseDao.getCourseById(1);
				
		ExamDAO testDao = new ExamDAOImpl(session);
		Test test = new Test("Test #1", course);
		
	}
	
}
