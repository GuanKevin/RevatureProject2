package com.mathMaster.domain;


import org.hibernate.Session;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
public interface StudentDAO {
	/*
	 * Get the Student by user name
	 */
	public Student getStudentByUsername(String username);
	
	/**
	 * Create a student and add it to the database
	 * @param student
	 * @return
	 */
	public boolean createStudent(Student student);
	/**
	 * Delete the student from the database
	 * @param student
	 * @return
	 */
	public boolean removeStudent(Student student);
	public void setSession(Session session);
}
