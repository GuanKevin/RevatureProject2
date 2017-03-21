package com.mathMaster.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.ExamDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.model.Question;
import com.mathMaster.util.M2SessionFactory;

public class GetAllExamQuestions {
	@Test
	public void Test() {
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		CourseDAOImpl courseDao = new CourseDAOImpl(session);
		Course course = courseDao.getCourseById(2); 
		
		Set<Question> list = new ExamDAOImpl(session).getExamById(4).getQuestions();
		
		for(Question q:list){
			System.out.println(q);
		}
		
		session.close();
		sf.close();
	}
}
