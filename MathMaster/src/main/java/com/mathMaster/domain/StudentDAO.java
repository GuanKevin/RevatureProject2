package com.mathMaster.domain;

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
	//public boolean authenticateStudent(Student student, String password);
	/**
	 * Used to create a student and add it to the database
	 * 
	 * @param student
	 */
	public boolean createStudent(Student student);
}
