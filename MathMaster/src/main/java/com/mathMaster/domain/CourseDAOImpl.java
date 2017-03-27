package com.mathMaster.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.Course;
/**
 * 
 * @author Pier Yos
 */
@Repository(value="courseDAO")
public class CourseDAOImpl implements CourseDAO {
	Session session;
	
	public CourseDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CourseDAOImpl(Session session) {
		this.session = session;
	}
	
	@Autowired
	public void setSession(Session session) {
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
