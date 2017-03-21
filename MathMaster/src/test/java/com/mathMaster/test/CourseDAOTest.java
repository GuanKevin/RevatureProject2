package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.domain.CourseDAOImpl;
import com.mathMaster.domain.TeacherDAOImpl;
import com.mathMaster.model.Course;
import com.mathMaster.model.Teacher;
import com.mathMaster.util.M2SessionFactory;

public class CourseDAOTest {
	static SessionFactory sf;
	Session session;
	
	@BeforeClass
	public static void getSF(){
		sf = M2SessionFactory.getSessionFactory();
	}
	
	@AfterClass
	public static void closeSF(){
		sf.close();
	}
	
	@Before
	public void startSF(){
		this.session = sf.openSession();
	}
	
	@Test
	public void createCourse(){
		CourseDAOImpl dao = new CourseDAOImpl(session);
		TeacherDAOImpl tDao = new TeacherDAOImpl(session);
		
		Teacher newTeach = tDao.getTeacherByUserName("Code_Blooded_KG");
		
		Course course = new Course();
		course.setTeacher(newTeach);
		course.setSubjectName("History");
		course.setCourseName("American History 101");
		
		System.out.println("createCourse : " + dao.createCourse(course));
		session.close();
	}
	
	@Test
	public void getCourseById(){
		CourseDAOImpl dao = new CourseDAOImpl(session);
		System.out.println("getCourseById : " + dao.getCourseById(2));
	}
}
