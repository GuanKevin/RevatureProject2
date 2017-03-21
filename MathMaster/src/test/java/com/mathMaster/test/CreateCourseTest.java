package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.M2SessionFactory;

public class CreateCourseTest {

	@Test
	public void createCourse(){
		SessionFactory sf = M2SessionFactory.getSessionFactory();
		Session session = sf.openSession();
		
		CourseDAOImpl dao = new CourseDAOImpl(session);
		TeacherDAOImpl tDao = new TeacherDAOImpl(session);
		
		Teacher newTeach = tDao.getTeacherByUserName("Code_Blooded_KG");
		
		Course course = new Course();
		course.setTeacher(newTeach);
		course.setSubjectName("Math");
		course.setCourseName("Algebra 101");
		
		System.out.println(dao.createCourse(course));
		session.close();
		sf.close();
		//dao.createCourse(course)
	}
}

