package com.mathMaster.domain;

import org.hibernate.SessionFactory;

import com.mathMaster.model.Course;

/**
 * 
 * @author Pier Yos
 */
public interface CourseDAO {
	public boolean createCourse(Course course);
	public Course getCourseById(int id);
	public void setSessionFactory(SessionFactory sessionFactory);
}
