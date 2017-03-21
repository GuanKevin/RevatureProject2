package com.mathMaster.domain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
public class StudentDAOImpl implements StudentDAO {
	private Session session;
	
	public StudentDAOImpl() {}
	
	public StudentDAOImpl(Session session) {
		super();
		this.session = session;
	}

	public Student getStudentByUsername(String username) {
		return null;
	}

	/**
	 * Creates a student object and store it into
	 * the database
	 */
	public void createStudent(Student student) {
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(student);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}	
	}

}
