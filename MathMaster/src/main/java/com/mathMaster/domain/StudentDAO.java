package com.mathMaster.domain;

import com.mathMaster.model.Student;
/**
 * 
 * @author Pier Yos
 */
public interface StudentDAO {
	public Student getStudentByUsername(String username);
	//public String getStudentPassword(int studentId);
}
