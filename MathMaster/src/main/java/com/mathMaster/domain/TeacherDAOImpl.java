package com.mathMaster.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.Teacher;

public class TeacherDAOImpl implements TeacherDAO{

	/**
	 * Queries the database for a teacher with 
	 * their unique user-name and returns the user-name
	 */
	public Teacher getTeacherByUserName(String username) {
		
		return null;
	}

	public String getPassword(Teacher teacher) {
		
		return null;
	}

	public void createTeacher(Teacher teacher, Session session) {
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(teacher);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
	}
}
