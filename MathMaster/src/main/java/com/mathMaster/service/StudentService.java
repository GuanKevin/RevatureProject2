package com.mathMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.Student;
import com.mathMaster.util.Facade;

@Service
public class StudentService {
	private Facade facade;

	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public Student getStudentByUsername(String username) {
		return facade.getStudentByUsername(username);
	}

	public void createStudent(Student student) {
		facade.createStudent(student);
	}

	public void removeStudent(Student student) {
		facade.removeStudent(student);
	}
	
	public Student studentLogin(String username, String password) {
		return facade.studentLogin(username, password);
	}
}
