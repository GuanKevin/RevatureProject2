package com.mathMaster.domain;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
public class StudentDAOImpl implements StudentDAO {
	Session session;
	public StudentDAOImpl(Session session) {
		this.session = session;
	}
	
	public Student getStudentByUsername(String username) {
		Criteria criteria = session.createCriteria(Student.class);
		return 	(Student) criteria.add(Restrictions.eq("userName", username)).uniqueResult();
	}
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
}
