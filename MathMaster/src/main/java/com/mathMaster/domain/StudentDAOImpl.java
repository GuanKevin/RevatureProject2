package com.mathMaster.domain;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
@Repository(value="studentDAO")
public class StudentDAOImpl implements StudentDAO {

	private Session session;
	
	public StudentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDAOImpl(Session session) {
		super();
		this.session = session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}

	public Student getStudentByUsername(String username) {
		Criteria criteria = session.createCriteria(Student.class);
		return 	(Student) criteria.add(Restrictions.eq("userName", username)).uniqueResult();
	}
	/**
	 * Creates a student object and store it into
	 * the database
	 */
	public boolean createStudent(Student student) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(student);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}

	public boolean removeStudent(Student student) {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(student);
			session.flush();
			tx.commit();
			
			return true;
		} catch (Exception e) {
			System.out.println("Error in deleting student from the database");
			e.printStackTrace();
			tx.rollback();
			return false;
		}
	}
}
