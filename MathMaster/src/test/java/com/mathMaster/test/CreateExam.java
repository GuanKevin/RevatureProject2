package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.model.Exam;
import com.mathMaster.util.M2SessionFactory;

public class CreateExam {
	
	@Test
	public void Test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		CourseDAOImpl courseDao = new CourseDAOImpl(session);
		Exam exam = new Exam("Exam #1", courseDao.getCourseById(2)); 
		
		System.out.println(new ExamDAOImpl(session).createExam(exam));
		
		session.close();
		sf.close();
	}
}
