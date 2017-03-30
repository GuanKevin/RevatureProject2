package com.mathMaster.domain;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mathMaster.model.Student;

/**
 * 
 * @author Pier Yos
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public StudentDAOImpl() {
		super();
	}

	@Transactional
	public Student getStudentByUsername(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
		return (Student) criteria.add(Restrictions.eq("userName", username)).uniqueResult();
	}

	/**
	 * Creates a student object and store it into the database
	 */
	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean createStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
		return true;
	}

	@Transactional(rollbackFor=Exception.class, propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public boolean removeStudent(Student student) {

		sessionFactory.getCurrentSession().delete(student);
		return true;

	}
}
