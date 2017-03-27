package com.mathMaster.domain;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.Course;

/**
 * 
 * @author Pier Yos
 */
@Repository(value = "courseDAO")
public class CourseDAOImpl implements CourseDAO {
	Session session;

	public CourseDAOImpl() {
		super();
	}

	public CourseDAOImpl(Session session) {
		this.session = session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public boolean createCourse(Course course) {
		session.save(course);
		return true;

	}

	public Course getCourseById(int id) {
		return (Course) session.load(Course.class, id);
	}
}
