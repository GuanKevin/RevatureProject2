package com.mathMaster.domain;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO{
	private Session session;
	
	public TeacherDAOImpl() {super();}
	
	public TeacherDAOImpl(Session session) {this.session = session;}
	
	/**
	 * Queries the database for a teacher with 
	 * their unique user-name and returns the user-name
	 */
	public Teacher getTeacherByUserName(String username) {
		if (username.isEmpty())
			return null;
		
		Criteria criteria = session.createCriteria(Teacher.class);
		return (Teacher) criteria.add(Restrictions.eq("userName", username)).uniqueResult();
	}

	/**
	 * Return the password of the teacher
	 */
	public String getPassword(Teacher teacher) {
		return teacher.getPassword();
	}

	/**
	 * Create a teacher and store it into the database
	 */
	public void createTeacher(Teacher teacher) {
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(teacher);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
	}
}
