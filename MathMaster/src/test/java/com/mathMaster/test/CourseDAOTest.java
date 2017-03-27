package com.mathMaster.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mathMaster.model.Course;
import com.mathMaster.util.Facade;
import com.mathMaster.util.M2SessionFactory;

public class CourseDAOTest {
	private static SessionFactory sf;
	private static Session session;
	private static Facade facade;
	
	@BeforeClass
	public static void startUp() {
		sf = M2SessionFactory.getSessionFactory();
		session = sf.openSession();
		facade = new Facade();
	}
	
	@Test
	public void createCourse(){
		Course course = new Course();
		course.setTeacher(facade.getTeacherByUserName("Code_Blooded_KG"));
		course.setSubjectName("History");
		course.setCourseName("American History 101");
		
		System.out.println("createCourse : " + facade.createCourse(course));
	}
	
	@Test
	public void getCourseById(){
		System.out.println("getCourseById : " + facade.getCourseById(2));
	}
	
	@AfterClass
	public static void closeSessions() {
		session.close();
		sf.close();
		
		try {
			facade.close();
		} catch (Exception e) {
			System.out.println("Failed to close facade in GetExamById test.");
			e.printStackTrace();
		}
	}
}
