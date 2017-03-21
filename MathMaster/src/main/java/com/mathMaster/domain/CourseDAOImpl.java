package com.mathMaster.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.Course;
/**
 * 
 * @author Pier Yos
 */
public class CourseDAOImpl implements CourseDAO {
	Session session;
	public CourseDAOImpl(Session session) {
		this.session = session;
	}
	
	public boolean createCourse(Course course) {
		Transaction txn = session.beginTransaction();
		try {
			session.save(course);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		}
	}

	public Course getCourseById(int id) {
		return (Course) session.load(Course.class, id);
	}
}
