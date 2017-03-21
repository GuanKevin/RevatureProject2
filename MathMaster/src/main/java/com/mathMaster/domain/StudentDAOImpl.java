package com.mathMaster.domain;

import java.sql.Connection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
		Query query = session.getNamedQuery("getStudentByUsername");
		query.setString("userName", username);
		return (Student) query.uniqueResult();
	}
}
