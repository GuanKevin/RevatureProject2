package com.mathMaster.domain;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO {
	private Session session;

	public TeacherDAOImpl() {
		super();
	}

	public TeacherDAOImpl(Session session) {
		this.session = session;
	}

	/**
	 * Queries the database for a teacher with their unique user-name and
	 * returns the user-name
	 */
	public Teacher getTeacherByUserName(String username) {
		if (username.isEmpty())
			return null;

		Criteria criteria = session.createCriteria(Teacher.class);
		return (Teacher) criteria.add(Restrictions.eq("userName", username)).uniqueResult();
	}

	/**
	 * Gets a teacher object and store the teachers' data into the database
	 */
	public boolean createTeacher(Teacher teacher) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(teacher);
			session.flush();
			tx.commit();
			
			return true;
		} catch (Exception ex) {
			System.out.println("Error in adding new teacher to the database");

			if (tx != null)
				tx.rollback();
			
			return false;
		} finally {
			session.close();
		}
	}

	public boolean removeTeacher(Teacher teacher) {
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(teacher);
			session.flush();
			tx.commit();
			
			return true;
		} catch (Exception ex) {
			System.out.println("Error in deleting teacher from the database");

			if (tx != null)
				tx.rollback();
			
			return false;
		} finally {
			session.close();
		}
	}
}
