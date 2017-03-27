package com.mathMaster.domain;

import org.hibernate.Session;

import com.mathMaster.model.Course;

/**
 * 
 * @author Pier Yos
 */
public interface CourseDAO {
	public boolean createCourse(Course course);
	public Course getCourseById(int id);
	public void setSession(Session session);
}
