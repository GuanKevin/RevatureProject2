package com.mathMaster.domain;

import org.hibernate.Session;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
public interface StudentDAO {
	public Student getStudentByUsername(String username);
	//public boolean authenticateStudent(Student student, String password);
	public void createStudent(Student student, Session session);
}
