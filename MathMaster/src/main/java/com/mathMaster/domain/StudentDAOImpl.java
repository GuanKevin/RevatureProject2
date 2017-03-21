package com.mathMaster.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
public class StudentDAOImpl implements StudentDAO {

	public Student getStudentByUsername(String username) {
		return null;
	}

	public void createStudent(Student student, Session session) {
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(student);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}		
	}

}
