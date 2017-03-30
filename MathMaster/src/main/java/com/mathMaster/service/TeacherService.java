package com.mathMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mathMaster.model.Teacher;
import com.mathMaster.util.Facade;

@Service
public class TeacherService {
	private Facade facade;

	@Autowired
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public Teacher getTeacherByUserName(String username) {
		return facade.getTeacherByUserName(username);
	}

	public void createTeacher(Teacher teacher) {
		facade.createTeacher(teacher);
	}
	
	public void removeTeacher(Teacher teacher) {
		facade.removeTeacher(teacher);
	}
	
	public Teacher teacherLogin(String username, String password) {
		return facade.teacherLogin(username, password);
	}
}
