package com.mathMaster.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.Course;

/**
 * 
 * @author Pier Yos
 */
@Repository
public class CourseDAOImpl implements CourseDAO {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println(sessionFactory == null);
	}

	public CourseDAOImpl() {
		super();
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean createCourse(Course course) {
		sessionFactory.getCurrentSession().save(course);
		return true;

	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public Course getCourseById(int id) {
		return (Course) sessionFactory.getCurrentSession().load(Course.class, id);
	}
}
