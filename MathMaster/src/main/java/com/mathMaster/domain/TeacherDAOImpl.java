package com.mathMaster.domain;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TeacherDAOImpl() {
		super();
	}
	
	/**
	 * Queries the database for a teacher with their unique user-name and
	 * returns the user-name
	 */
	@Transactional
	public Teacher getTeacherByUserName(String username) {
		if (username.isEmpty())
			return null;

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Teacher.class);
		return (Teacher) criteria.add(Restrictions.eq("userName", username)).uniqueResult();
	}

	/**
	 * Gets a teacher object and store the teachers' data into the database
	 */
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean createTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().save(teacher);
		return true;
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean removeTeacher(Teacher teacher) {
		sessionFactory.getCurrentSession().delete(teacher);
		return true;
	}
}
