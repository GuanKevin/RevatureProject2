package com.mathMaster.domain;

import com.mathMaster.model.Student;

public interface StudentDAO {
	public Student getStudentByUsername(String username);
	//public boolean authenticateStudent(Student student, String password);
	
}
